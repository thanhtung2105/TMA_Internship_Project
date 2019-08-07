import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.IOException;
import jdk.nashorn.internal.objects.NativeDebug;

public class InputInfo {

    private static JFrame frame;
    private static JLabel barcode, proc_name, proc_origin, proc_quality;
    private static JTextField barcodeInput, proc_nameInput, proc_originInput, proc_qualityInput;
//    private static JMenuBar proc_qualityChoosing;
//    private static JMenu quality;
//    private static JMenuItem quality1, quality2, quality3;
    private static JButton button;

    private static int width, labelsize;
    private static int i = 0;

    public static void main(String[] args) {
        frame = new JFrame("Input Product Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(frame);
        frame.setSize(360, 450);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        width = 320;
        labelsize = 200;
        
        //Objects: 
        //#barcode:
        barcode = new JLabel("<html><font color='red'>#barcode:</font><html>");
        frame.add(barcode);
        barcode.setBounds(10, 10, labelsize, 20);
        barcode.setVisible(true);

        barcodeInput = new JTextField();
        frame.add(barcodeInput);
        barcodeInput.setBounds(10, barcode.getY() + barcode.getHeight() + 10, width, 30);
        barcodeInput.setOpaque(true);
        barcodeInput.setVisible(true);
        
        //Name:
        proc_name = new JLabel("<html><font color='blue'>Product name:</font><html>");
        frame.add(proc_name);
        proc_name.setBounds(10, barcodeInput.getY() + barcodeInput.getHeight() + 20, labelsize, 20);
        proc_name.setVisible(true);
        

        proc_nameInput = new JTextField();
        frame.add(proc_nameInput);
        proc_nameInput.setBounds(10, proc_name.getY() + proc_name.getHeight() + 10, width, 30);
        proc_nameInput.setOpaque(true);
        proc_nameInput.setVisible(true);
       
        
        //Origin:
        proc_origin = new JLabel("<html><font color='blue'>Origin:</font><html>");
        frame.add(proc_origin);
        proc_origin.setBounds(10, proc_nameInput.getY() + proc_nameInput.getHeight() + 20, labelsize, 20);
        proc_origin.setVisible(true);
      
        
        proc_originInput = new JTextField();
        frame.add(proc_originInput);
        proc_originInput.setBounds(10, proc_origin.getY() + proc_origin.getHeight() + 10, width, 30);
        proc_originInput.setOpaque(true);
        proc_originInput.setVisible(true);
        
        
        //Quality  -  Menu Items
        proc_quality = new JLabel("<html><font color='orange'>Quality Status:</font><html>");
        frame.add(proc_quality);
        proc_quality.setBounds(10, proc_originInput.getY() + proc_origin.getHeight() + 30, labelsize, 20);
        proc_quality.setVisible(true);
        
        proc_qualityInput = new JTextField();
        frame.add(proc_qualityInput);
        proc_qualityInput.setBounds(10, proc_quality.getY() + proc_quality.getHeight() + 10, width, 30);
        proc_qualityInput.setOpaque(true);
        proc_qualityInput.setVisible(true);
        
        /*
        proc_qualityChoosing = new JMenuBar();
        frame.setJMenuBar(proc_qualityChoosing);
        
        proc_qualityChoosing.setBounds(10, proc_quality.getY() + proc_quality.getHeight() + 10, 200, 28);
        quality = new JMenu("Quality Menu");
        quality.setMnemonic(KeyEvent.VK_A);
        quality.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        proc_qualityChoosing.add(quality);
        
        quality1 = new JMenuItem("New - Good", KeyEvent.VK_T);
        quality1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.ALT_MASK));
        quality1.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        quality.add(quality1);
        
        quality2 = new JMenuItem("Second Hand - Good", KeyEvent.VK_B);
        quality2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.ALT_MASK));
        quality2.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        quality.add(quality2);
        
        quality3 = new JMenuItem("Old - Average", KeyEvent.VK_D);
        quality3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,ActionEvent.ALT_MASK));
        quality3.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        quality.add(quality3);
        
        */
        //Button
        button = new JButton("Save Information");
        button.setFont(new Font("Arial", Font.BOLD,20));
        button.setBackground(Color.CYAN);
        frame.add(button);
        button.setBounds(70, proc_quality.getY() + 90, 200, 50);
        button.setVisible(true);
        button.addActionListener(e -> {
            //JSON Objects:
            JSONObject OutPutDetail = new JSONObject();
            
            OutPutDetail.put("Barcode",barcodeInput.getText());
            OutPutDetail.put("Product name",proc_nameInput.getText());
            OutPutDetail.put("Origin",proc_originInput.getText());
            OutPutDetail.put("Quality",proc_qualityInput.getText());
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
            
        /*    
            // Write information in one file JSON:
            String barcode = "#barcode: " + barcodeInput.getText();
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
            proc_qualityInput.setText("");
        });
        
        ImageIcon img = new ImageIcon("src/Images/image001.png");
        frame.setIconImage(img.getImage());
    }
}