import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


// video to load jar
//https://www.youtube.com/watch?v=QAJ09o3Xl_0

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import javax.swing.*;



// Program for print data in JSON format.
public class ReadJson {
    //implements ActionListener
    public JFrame mainframe;
    public BufferStrategy bufferStrategy;
    public JTextField url;
    public JLabel label;
    public JLabel label2;
    public JLabel  allies;
    public String dogurl;
    public int currentCharIndex = 0;
    private JTextField t1;
    private JLabel imageLabel;
    private JPanel imagePanel;
    private JPanel searchPanel;
    public JPanel panel;
    public JPanel centerpanel;
    public JPanel panel1;
    private JTextField t2;
    private JMenuBar mb;
    public JTextArea Results;
    public String keyword = "breed";
    public String link = "https://dog.ceo/";
    private int WIDTH = 800;
    private int HEIGHT = 700;
     JComboBox<String> cb;


    public ReadJson() {
        createAndShowGUI();
    }

    public void createAndShowGUI() {


        panel1 = new JPanel();
        centerpanel = new JPanel();
        label = new JLabel("");
        label2 = new JLabel("       Welcome to Jessie's dog walking app!");
//label2.();

        JLabel lbl = new JLabel("Select one of the possible breed choices and click OK");
        lbl.setVisible(true);
        t1 = new JTextField("                           Name: First and Last");

        mainframe = new JFrame("Dog Walking Profile");
        mainframe.setSize(WIDTH, HEIGHT);
        mainframe.setLayout(new BorderLayout());
        centerpanel.setLayout(new GridLayout(2, 2));
        panel1.add(lbl);
        centerpanel.add(t1);
        centerpanel.add(label2);
        centerpanel.add(label);

        mainframe.add(centerpanel, BorderLayout.CENTER);
        //mainframe.add(label, BorderLayout.CENTER);

        String[] choices = {"Bulldog", "Australian", "Collie", "Chihuahua", "Cockapoo", "Dalmatian", "Labradoodle", "Labrador", "Pitbull", "Retriever"};


       cb  = new JComboBox<String>(choices);



        cb.setVisible(true);
        panel1.add(cb);

        JButton btn = new JButton("OK");
        //panel1.add(btn);

        // Create the basic frame


        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        imagePanel = new JPanel();


        // Create a top panel
        //JPanel top = new JPanel();

        // Create a middle-left panel
        //JPanel left = new JPanel();

        // Create a center panel
        //JPanel center = new JPanel(new BorderLayout());

        // Create a middle-right panel
        //JPanel right = new JPanel();

        // Create a bottom panel
        //JPanel bottom = new JPanel();


        mainframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });


        // Show the Frame
        //   mainframe.pack();
        // mainframe.setSize(800, 700);
        createComponents();
        //mainframe.add(t1);
        mainframe.setVisible(true);
        System.out.println(mainframe);
    }

    public void createComponents() {

        url = new JTextField("name");
        allies = new JLabel("allies");
        layout();
        mainframe.setVisible(true);

        //  createComponents();
    }

    public void layout() {

       // mainframe.add(url);

        JButton AcceptButton = new JButton("Accept");
        JButton RejectButton = new JButton("Reject");
        JButton btn = new JButton("0k");
        AcceptButton.setActionCommand("Accept");
        RejectButton.setActionCommand("Reject");
        btn.setActionCommand("Ok");
        AcceptButton.addActionListener(new ButtonClickListener());
        RejectButton.addActionListener(new ButtonClickListener());
        btn.addActionListener(new ButtonClickListener());
        panel.add(AcceptButton);
        panel.add(RejectButton);
        mainframe.add(panel, BorderLayout.SOUTH);
        mainframe.add(panel1, BorderLayout.NORTH);
        panel1.add(btn);
        //mainframe.add(AcceptButton);
        // mainframe.add(RejectButton);
        mainframe.setVisible(true);



    }

    public static void main(String args[]) throws ParseException {
        // In java JSONObject is used to create JSON object
        // which is a subclass of java.util.HashMap.

        JSONObject file = new JSONObject();
        file.put("Full Name", "Ritu Sharma");
        file.put("Roll No.", new Integer(1704310046));
        file.put("Tution Fees", new Double(65400));


        // To print in JSON format.
        System.out.print(file.get("Tution Fees"));

        ReadJson read = new ReadJson();
     //   read.pull();

    }

    public  void pull(String dogbreed) throws ParseException {
        String output = "abc";
        String totlaJson = "";
        try {

            URL url = new URL("https://dog.ceo/api/breed/" +dogbreed.toLowerCase()+"/images/random");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");


            if (conn.getResponseCode() != 200) {

                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                totlaJson += output;

            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();
        //System.out.println(str);
        org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) parser.parse(totlaJson);
        System.out.println(jsonObject);

        try {

            String dog = (String) jsonObject.get("message");


//chat gtp api - heres photo of dog heres breed - give me description of dog for dog walking app


            System.out.println(dog);

            dogurl = dog;

            int beginIndex = dog.indexOf("breeds/");//begin equals href
            String chop = dog.substring(beginIndex + 7);
            int endIndex = (chop.indexOf("/"));
            //int finish = chop.indexOf("\'");
            //System.out.println(endIndex);
            String chip = (chop.substring(0, endIndex));


            //System.out.println(chop);
            System.out.println(chip);
            //System.out.println(endIndex+finish);

            // System.out.println(dog.get("name"));


            //  JSONArray dog = (JSONArray) dog.get("allies");
            //  System.out.println(dog.get(0));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            addImage();
        }catch (IOException e){
            System.out.println("ioe error");
        }
    }
    private void addImage() throws IOException {
        try {
            String path = "";
            if (!t1.getText().contains("http")) {
                path = "https://i.pinimg.com/originals/07/16/ba/0716ba54fe3b77b3a5b0b16c7bc33389.png";
            } else {
                path = t1.getText();
                if (path.contains("url")) {
                    path = path.substring(path.indexOf("http"));
                }
            }


            URL url = new URL(dogurl);
            BufferedImage ErrorImage = ImageIO.read(new File("Error.jpg"));
            BufferedImage inputImageBuff = ImageIO.read(url.openStream());
            // weiYing =

            ImageIcon inputImage;
            if (inputImageBuff != null) {
                inputImage = new ImageIcon(inputImageBuff.getScaledInstance(350, 300, Image.SCALE_SMOOTH));
                // = new JLabel();
                if (inputImage != null) {
                    imageLabel = new JLabel(inputImage);
                } else {
                    imageLabel = new JLabel(new ImageIcon(ErrorImage.getScaledInstance(350, 300, Image.SCALE_SMOOTH)));

                }
                imagePanel.removeAll();
                imagePanel.add(imageLabel);
                centerpanel.add(imagePanel, BorderLayout.CENTER);

            } else {
                imageLabel = new JLabel(new ImageIcon(ErrorImage.getScaledInstance(350, 300, Image.SCALE_SMOOTH)));

            }

        } catch (IOException e) {
            System.out.println(e);
            System.out.println("happiness");
            BufferedImage ErrorImage = ImageIO.read(new File("Error.png"));
            JLabel imageLabel = new JLabel(new ImageIcon(ErrorImage.getScaledInstance(350, 300, Image.SCALE_SMOOTH)));

            imagePanel.removeAll();
            imagePanel.add(imageLabel);
            mainframe.add(imagePanel);

        }
        mainframe.setVisible(true);

    }

        private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            System.out.println(t1.getText());
            link = t1.getText();
           // keyword = t2.getText();

            //  scroll.add(Results);
            // mainFrame.add(scroll, BorderLayout.CENTER);


            if (command.equals("Accept")) {
               // statusLabel.setText("New Client Added!");
                System.out.print("New Client Added!");
                label.setText("                             New Client Added!");

            }
            if (command.equals("Reject")) {
               // statusLabel.setText("Client Declined!");
                System.out.print("Client Declined!");
                label.setText("                             Client Declined!");
            }
            if (command.equals("Ok")) {
                // statusLabel.setText("Client Declined!");
                System.out.print("Ok");
                label.setText("                                       Ok");
                System.out.println(cb.getSelectedItem());
                try {
                    pull((String)cb.getSelectedItem());
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
                    /*else if (command.equals("Blue")) {
                statusLabel.setText("Blue Button clicked.");
            } else if (command.equals("Green")) {
                statusLabel.setText("Green Button clicked.");
            } else {
                statusLabel.setText("Erase Button clicked.");
            }*/
        }
    }

}





//if(keyword.contains("href=")){




















