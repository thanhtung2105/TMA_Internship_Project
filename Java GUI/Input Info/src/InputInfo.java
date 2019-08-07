import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.IOException;

public class InputInfo {

    private static JFrame frame;
    private static JLabel barcode, proc_name, proc_origin, proc_quality;
    private static JTextField barcodeInput, proc_nameInput, proc_originInput;
    private static JMenuBar proc_qualityChoosing;
    private static JMenu quality1, quality2, quality3;
    private static JButton button;

    private static int width, labelsize;
    private static int i = 0;

    public static void main(String[] args) {
        frame = new JFrame("Input Product Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(frame);
        frame.setSize(360, 380);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setResizable(false);
        width = 320;
        labelsize = 200;
        
        //Objects: 
        //#barcode:
        barcode = new JLabel("#barcode:");
        frame.add(barcode);
        barcode.setBounds(10, 10, labelsize, 20);
        barcode.setVisible(true);

        barcodeInput = new JTextField();
        frame.add(barcodeInput);
        barcodeInput.setBounds(10, barcode.getY() + barcode.getHeight() + 10, width, 30);
        barcodeInput.setOpaque(true);
        barcodeInput.setVisible(true);
        
        //Name:
        proc_name = new JLabel("Product name:");
        frame.add(proc_name);
        proc_name.setBounds(10, barcodeInput.getY() + barcodeInput.getHeight() + 20, labelsize, 20);
        proc_name.setVisible(true);
        

        proc_nameInput = new JTextField();
        frame.add(proc_nameInput);
        proc_nameInput.setBounds(10, proc_name.getY() + proc_name.getHeight() + 10, width, 30);
        proc_nameInput.setOpaque(true);
        proc_nameInput.setVisible(true);
       
        
        //Origin:
        proc_origin = new JLabel("Origin:");
        frame.add(proc_origin);
        proc_origin.setBounds(10, proc_nameInput.getY() + proc_nameInput.getHeight() + 20, labelsize, 20);
        proc_origin.setVisible(true);
      
        
        proc_originInput = new JTextField();
        frame.add(proc_originInput);
        proc_originInput.setBounds(10, proc_origin.getY() + proc_origin.getHeight() + 10, width, 30);
        proc_originInput.setOpaque(true);
        proc_originInput.setVisible(true);
        
        
        //Quality:
        proc_qualityChoosing = new JMenuBar();
        quality1 = new JMenu("A Menu");
        quality1.setMnemonic(KeyEvent.VK_A);
        quality1.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        proc_qualityChoosing.add(quality1);
        
        //Button
        button = new JButton("Save Information");
        frame.add(button);
        button.setBounds(70, proc_originInput.getY() + proc_originInput.getHeight() + 30, 200, 50);
        button.setVisible(true);
        button.addActionListener(e -> {
            
            //JSON Objects:
            JSONObject OutPutDetail = new JSONObject();
            
            OutPutDetail.put("Barcode",barcodeInput.getText());
            OutPutDetail.put("Product name",proc_nameInput.getText());
            OutPutDetail.put("Origin",proc_originInput.getText());
            OutPutDetail.put("Quality","");
            OutPutDetail.put("Status","");
            OutPutDetail.put("Location","");
            
            JSONObject OutPutJSONObject = new JSONObject();
            OutPutJSONObject.put("Product",OutPutDetail);
            
            //Add to JSONList:
            JSONArray proc_LIST = new JSONArray();
            proc_LIST.add(OutPutJSONObject);
            
            //Write JSON file:
            try (FileWriter file = new FileWriter("Product_"+ ++i +".json")) {
 
            file.write(proc_LIST.toJSONString());
            file.flush();
 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            
        /*    String barcode = "#barcode: " + barcodeInput.getText();
            String name = "Product name: " + proc_nameInput.getText();
            String origin = "Origin:" + proc_originInput.getText();
            
            List<String> list = Arrays.asList(barcode, name, origin);
            Path file = Paths.get("Product_" + i++ + ".json");
            
            try {
                Files.write(file, list, StandardCharsets.UTF_8);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            barcodeInput.setText("");
            proc_nameInput.setText("");
            proc_originInput.setText("");  */
            
            barcodeInput.setText("");
            proc_nameInput.setText("");
            proc_originInput.setText("");
        });
    }
}