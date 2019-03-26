//***********************************************************
//File: mabLib_Interface.java
//Purpose: Handel processing for Mad Lib app
//Written By: Arslan Khurram
//IDE: Intellij IDEA
//***********************************************************


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//***********************************************************
//Class: madLib_Interface
//Purpose: Main method
//***********************************************************
public class mabLib_Interface {

    @FXML
    private TextField txtNumber;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtFriendsLast;

    @FXML
    private TextField txtNoun;

    @FXML
    private TextField txtVerb;

    @FXML
    private TextField txtNoun2;

    @FXML
    private TextField txtVerb_ing;

    @FXML
    private TextField txtExclamation;

    @FXML
    private TextField txtFemale;

    @FXML
    private TextField txtMale;

    @FXML
    private TextField txtVerb2;

    @FXML
    private TextField txtVerb_ing2;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextArea txtAreaStory;

    @FXML
    private AnchorPane storyPane;

    private int test = 0;
    File file = new File("src/input.txt");

//***********************************************************
//Class: getData()
//Purpose: Write all answers into a file
//***********************************************************
    private void getData() throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(txtNumber.getText());
        writer.write("\n" + txtNumber.getText());
        writer.write("\n" + txtLastName.getText());
        writer.write("\n" + txtFriendsLast.getText());
        writer.write("\n" + txtNoun.getText());
        writer.write("\n" + txtVerb.getText());
        writer.write("\n" + txtNoun2.getText());
        writer.write("\n" + txtVerb_ing.getText());
        writer.write("\n" + txtNoun2.getText());
        writer.write("\n" + txtExclamation.getText());
        writer.write("\n" + txtFemale.getText());
        writer.write("\n" + txtMale.getText());
        writer.write("\n" + txtNoun2.getText());
        writer.write("\n" + txtVerb2.getText());
        writer.write("\n" + txtNoun2.getText());
        writer.write("\n" + txtVerb_ing2.getText());
        writer.write("\n" + txtLastName.getText());
        writer.write("\n" + txtLastName.getText());
        writer.write("\n" + txtLastName.getText());
        writer.write("\n" + txtLastName.getText());

        writer.close();
    }

//***********************************************************
//Class: createStory(ActionEvent event)
//Purpose: Switch to story scene
//***********************************************************
    @FXML
    void createStory(ActionEvent event) throws IOException {
        //reset test value for if statement in showStory
        test = 0;
        //run getData method to store answers into file
        getData();
        //load the story fxml into an anchor pane
        AnchorPane pane = FXMLLoader.load(getClass().getResource("madLib_Story.fxml"));
        //replace the current anchor pane with the new
        rootPane.getChildren().setAll(pane);
    }

//***********************************************************
//Class: newStory(ActionEvent event)
//Purpose: Switch to questions scene
//***********************************************************
    @FXML
    void newStory(ActionEvent event) throws IOException {
        //load the story fxml into an anchor pane
        AnchorPane pane = FXMLLoader.load(getClass().getResource("interface.fxml"));
        //replace the current anchor pane with the new
        storyPane.getChildren().setAll(pane);
    }

//***********************************************************
//Class: showStory(ActionEvent event)
//Purpose: Show generated story when scene opens
//***********************************************************
    @FXML
    void showStory(MouseEvent event) throws FileNotFoundException {

        Scanner scan = new Scanner(file);
        //test case so loop only runs once
        if (test == 0) {
            //increment test so loop condition will only run once
            test++;
            try {
                while (scan.hasNext()) {
                    txtAreaStory.setText("Only four minutes left, and the score was tied " + scan.nextLine() + " to " +
                            scan.nextLine() + ".\"Get in there, " + scan.nextLine() + "!\" cried Coach " + scan.nextLine() +
                            "\" I'm counting on you to help us win the game.\" \n\nI grabbed my lucky " + scan.nextLine() +
                            " and " + scan.nextLine() + " onto the field. What luck. I got the " + scan.nextLine() +
                            " right away and raced past three opponents. The crowd was " + scan.nextLine() + ". I kicked the " +
                            scan.nextLine() + " right at the goal. \"" + scan.nextLine() + ",\" I missed! The crowd became " +
                            "silent. I spotted " + scan.nextLine() + " and " + scan.nextLine() + " in the " +
                            "stands looking very disappointed.\n\n" + "The other team had the " + scan.nextLine() + " with only " +
                            "two minutes left -- that is until I intercepted it! I " + scan.nextLine() + " towards the goal " +
                            "and smashed the " + scan.nextLine() + " right into the net. \"Goooooal!\" screamed the announcer.\n\n" +
                            "The crowd was " + scan.nextLine() + " wildly. \"Hooray for " + scan.nextLine() + "! " + scan.nextLine() + "! " +
                            scan.nextLine() + "! " + scan.nextLine() + "! " + "!\"\n\n" + "Then my alarm clock woke me up for school.");
                }
            } catch (Exception e) {
                txtAreaStory.setText("\t\t\t\t\tPlease Fill All Fields in Previous Window");
            }
            scan.close();
        }
    }

//***********************************************************
//Class: close(ActionEvent event)
//Purpose: Exit App
//***********************************************************
    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

//***********************************************************
//Class: createStory(ActionEvent event)
//Purpose: Clear all answer fields
//***********************************************************
    @FXML
    void clear(ActionEvent event) {
        txtNumber.clear();
        txtLastName.clear();
        txtFriendsLast.clear();
        txtNoun.clear();
        txtVerb.clear();
        txtNoun2.clear();
        txtVerb_ing.clear();
        txtExclamation.clear();
        txtFemale.clear();
        txtMale.clear();
        txtVerb2.clear();
        txtVerb_ing2.clear();
    }
}

//http://www.eduplace.com/tales/content/wwt_010.html