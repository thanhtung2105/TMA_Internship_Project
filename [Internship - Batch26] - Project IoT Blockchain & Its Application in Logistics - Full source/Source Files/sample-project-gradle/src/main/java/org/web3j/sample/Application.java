package org.web3j.sample;


import java.awt.Color;
import java.awt.Font;
import java.io.FileWriter;
//import org.json.simple.*;
import javax.swing.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * A simple web3j application that demonstrates a number of core features of
 * web3j:
 *
 * <ol>
 * <li>Connecting to a node on the Ethereum network</li>
 * <li>Loading an Ethereum wallet file</li>
 * <li>Sending Ether from one address to another</li>
 * <li>Deploying a smart contract to the network</li>
 * <li>Reading a value from the deployed smart contract</li>
 * <li>Updating a value in the deployed smart contract</li>
 * <li>Viewing an event logged by the smart contract</li>
 * </ol>
 *
 * <p>
 * To run this demo, you will need to provide:
 *
 * <ol>
 * <li>Ethereum client (or node) endpoint. The simplest thing to do is
 * <a href="https://infura.io/register.html">request a free access token from
 * Infura</a></li>
 * <li>A wallet file. This can be generated using the web3j
 * <a href="https://docs.web3j.io/command_line.html">command line tools</a></li>
 * <li>Some Ether. This can be requested from the
 * <a href="https://www.rinkeby.io/#faucet">Rinkeby Faucet</a></li>
 * </ol>
 *
 * <p>
 * For further background information, refer to the project README.
 */

public class Application {
        private static JFrame frame;
        private static JLabel barcode, proc_name, proc_origin, proc_quality;
        private static JTextField barcodeInput, proc_nameInput, proc_originInput, proc_qualityInput;
        // private static JMenuBar proc_qualityChoosing;
        // private static JMenu quality;
        // private static JMenuItem quality1, quality2, quality3;
        private static JButton button;
        private static int width, labelsize;
        private static int i = 0;


        public static void main(String[] args) throws Exception {

            //phan thiet ke giao dien cho GUI
                frame = new JFrame("Input Product Information");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(frame);
                frame.setSize(360, 500);
                frame.getContentPane().setBackground(Color.WHITE);
                frame.setLayout(null);
                frame.setVisible(true);
                frame.setResizable(false);
                width = 320;
                labelsize = 200;
                // Objects:
                // #barcode:
                barcode = new JLabel("<html><font color='red'>#barcode:</font><html>");
                frame.add(barcode);
                barcode.setBounds(10, 10, labelsize, 20);
                barcode.setVisible(true);

                barcodeInput = new JTextField();
                frame.add(barcodeInput);
                barcodeInput.setBounds(10, barcode.getY() + barcode.getHeight() + 10, width, 30);
                barcodeInput.setOpaque(true);
                barcodeInput.setVisible(true);

                // Name:
                proc_name = new JLabel("<html><font color='blue'>Product name:</font><html>");
                frame.add(proc_name);
                proc_name.setBounds(10, barcodeInput.getY() + barcodeInput.getHeight() + 20, labelsize, 20);
                proc_name.setVisible(true);

                proc_nameInput = new JTextField();
                frame.add(proc_nameInput);
                proc_nameInput.setBounds(10, proc_name.getY() + proc_name.getHeight() + 10, width, 30);
                proc_nameInput.setOpaque(true);
                proc_nameInput.setVisible(true);

                // Origin:
                proc_origin = new JLabel("<html><font color='blue'>Origin:</font><html>");
                frame.add(proc_origin);
                proc_origin.setBounds(10, proc_nameInput.getY() + proc_nameInput.getHeight() + 20, labelsize, 20);
                proc_origin.setVisible(true);

                proc_originInput = new JTextField();
                frame.add(proc_originInput);
                proc_originInput.setBounds(10, proc_origin.getY() + proc_origin.getHeight() + 10, width, 30);
                proc_originInput.setOpaque(true);
                proc_originInput.setVisible(true);

                // Quality - Menu Items
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
                 * proc_qualityChoosing = new JMenuBar();
                 * frame.setJMenuBar(proc_qualityChoosing);
                 * 
                 * proc_qualityChoosing.setBounds(10, proc_quality.getY() +
                 * proc_quality.getHeight() + 10, 200, 28); quality = new JMenu("Quality Menu");
                 * quality.setMnemonic(KeyEvent.VK_A); quality.getAccessibleContext().
                 * setAccessibleDescription("The only menu in this program that has menu items"
                 * ); proc_qualityChoosing.add(quality);
                 * 
                 * quality1 = new JMenuItem("New - Good", KeyEvent.VK_T);
                 * quality1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.
                 * ALT_MASK)); quality1.getAccessibleContext().
                 * setAccessibleDescription("This doesn't really do anything");
                 * quality.add(quality1);
                 * 
                 * quality2 = new JMenuItem("Second Hand - Good", KeyEvent.VK_B);
                 * quality2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.
                 * ALT_MASK)); quality2.getAccessibleContext().
                 * setAccessibleDescription("This doesn't really do anything");
                 * quality.add(quality2);
                 * 
                 * quality3 = new JMenuItem("Old - Average", KeyEvent.VK_D);
                 * quality3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,ActionEvent.
                 * ALT_MASK)); quality3.getAccessibleContext().
                 * setAccessibleDescription("This doesn't really do anything");
                 * quality.add(quality3);
                 * 
                 */
                // Button
                button = new JButton("Send Transaction");
                button.setFont(new Font("Arial", Font.BOLD, 18));
                button.setBackground(Color.CYAN);
                frame.add(button);
                button.setBounds(70, proc_quality.getY() + 90, 200, 50);
                button.setVisible(true);

                // Xu ly su kien bam nut "Save Infomation"
                button.addActionListener(e -> {
                        // JSON Objects:
                        /*
                        // output is json file
                         * JSONObject OutPutDetail = new JSONObject();
                         * OutPutDetail.put("Barcode",barcodeInput.getText());
                         * OutPutDetail.put("Product name",proc_nameInput.getText());
                         * OutPutDetail.put("Origin",proc_originInput.getText());
                         * OutPutDetail.put("Quality",proc_qualityInput.getText());
                         * OutPutDetail.put("Status",""); OutPutDetail.put("Location","");
                         * 
                         * JSONObject OutPutJSONObject = new JSONObject();
                         * OutPutJSONObject.put("Product",OutPutDetail);
                         * 
                         * //Add to JSONList: JSONArray proc_LIST = new JSONArray();
                         * proc_LIST.add(OutPutJSONObject);
                         * 
                         * //Write JSON file: try (FileWriter file = new FileWriter("Product_"+ ++i
                         * +".json")) {
                         * 
                         * file.write(proc_LIST.toJSONString()); file.flush();
                         * 
                         * } catch (IOException ex) { ex.printStackTrace(); }
                         */
                        // Write information in one file JSON:
                        BigInteger barcode = new BigInteger(barcodeInput.getText());
                        String name = proc_nameInput.getText();
                        String origin = proc_originInput.getText();
                        String quality = proc_qualityInput.getText();

                        /*
                         * List<String> list = Arrays.asList(barcode, name, origin); Path file =
                         * Paths.get("Product_" + i++ + ".json");
                         * 
                         * try { Files.write(file, list, StandardCharsets.UTF_8); } catch (IOException
                         * ex) { ex.printStackTrace(); }
                         * 
                         * barcodeInput.setText(""); proc_nameInput.setText("");
                         * proc_originInput.setText("");
                         */

                        barcodeInput.setText("");
                        proc_nameInput.setText("");
                        proc_originInput.setText("");
                        proc_qualityInput.setText("");
                        try {
                                new contractHandle().inputInfo(barcode, name, origin, quality);
                        } catch (Exception ex) {
                                ex.printStackTrace();
                        }
                });
                ImageIcon img = new ImageIcon("src/resources/image001.png");
                frame.setIconImage(img.getImage());
                JLabel logo = new JLabel();
                frame.add(logo);
                logo.setBounds(240, 405, 110, 50);
                logo.setIcon(img);
                // new Application().run();
        }
}
