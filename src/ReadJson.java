import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
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

import javax.swing.*;


// Program for print data in JSON format.
public class ReadJson {

    public JFrame mainframe;

    public JLabel url, allies;
    public int currentCharIndex = 0;
    private JTextField t1;
    private JTextField t2;
    private JMenuBar mb;
    public JTextArea Results;
    public String keyword = "breed";
    public String link = "https://dog.ceo/";


    public ReadJson(){
        createAndShowGUI();
    }
    public void createAndShowGUI() {

        // Create the basic frame
        mainframe = new JFrame("Layout Demo");
        mainframe.setLayout(new BorderLayout());
        t1 = new JTextField("Name: First and Last");


        // Create a top panel
        JPanel top = new JPanel();

        // Create a middle-left panel
        JPanel left = new JPanel();

        // Create a center panel
        JPanel center = new JPanel(new BorderLayout());

        // Create a middle-right panel
        JPanel right = new JPanel();

        // Create a bottom panel
        JPanel bottom = new JPanel();





        // Show the Frame
        mainframe.pack();
        mainframe.setSize(800, 700);
        createComponents();
        mainframe.setVisible(true);
        System.out.println(mainframe);
    }

    public void createComponents() {

        url = new JLabel("name");
        allies = new JLabel("allies");
        layout();
        mainframe.setVisible(true);

        //  createComponents();
    }

    public void layout() {

        mainframe.add(url);
        JButton AcceptButton = new JButton("Accept");
        JButton RejectButton = new JButton("Reject");
        AcceptButton.setActionCommand("Accept");
        RejectButton.setActionCommand("Reject");

        mainframe.add(AcceptButton);
        mainframe.add(RejectButton);
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
        pull();

    }

    public static void pull() throws ParseException {
        String output = "abc";
        String totlaJson = "";
        try {

            URL url = new URL("https://dog.ceo/api/breed/affenpinscher/images/random");
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
    }
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            System.out.println(t1.getText());
            link = t1.getText();
            keyword = t2.getText();

            //  scroll.add(Results);
            // mainFrame.add(scroll, BorderLayout.CENTER);
        }
    }
}


//if(keyword.contains("href=")){




















