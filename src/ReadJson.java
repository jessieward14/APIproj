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

    public JFrame frame;
    public JLabel url, allies;
    public int currentCharIndex = 0;


    public void createAndShowGUI() {

        // Create the basic frame
        frame = new JFrame("Layout Demo");

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
        frame.pack();
        frame.setSize(800, 700);
        frame.setLayout(new GridLayout(4, 1));
        createComponents();
        frame.setVisible(true);
    }

    public void createComponents() {

        url = new JLabel("name");
        allies = new JLabel("allies");
        layout();
        frame.setVisible(true);

        //  createComponents();
    }

    public void layout() {

        frame.add(url);
        frame.add(allies);
        JButton nextButton = new JButton("Next");
        JButton previousButton = new JButton("Previous");
        nextButton.setActionCommand("Next");
        previousButton.setActionCommand("Previous");

        frame.add(nextButton);
        frame.add(previousButton);
        frame.setVisible(true);


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











            System.out.println(dog);

            
           // System.out.println(dog.get("name"));






          //  JSONArray dog = (JSONArray) dog.get("allies");
          //  System.out.println(dog.get(0));






            try {

                String name = (String) jsonObject.get("name");

                org.json.simple.JSONArray msg = (org.json.simple.JSONArray) jsonObject.get("films");
                int n = msg.size(); //(msg).length();
                for (int i = 0; i < n; ++i) {
                    String test = (String) msg.get(i);
                    System.out.println(test);
                    // System.out.println(person.getInt("key"));
                }
                String nam = (String) jsonObject.get("height");
                System.out.println(name);


            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



















