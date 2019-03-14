//***********************************************************
//File: Interface.java
//Purpose: Handel processing for gradebook app
//Written By: Arslan Khurram
//IDE: Intellij IDEA
//***********************************************************

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//***********************************************************
//Class: Interface
//Purpose: Main method
//***********************************************************
public class Interface {

    @FXML
    private MenuItem menuOpenFile;

    @FXML
    private TextArea fileOutputTxtField;

    @FXML
    private TextArea avgOutputTxtField;

    @FXML
    private Button btnCalcAverage;

    @FXML
    private Tab tab_Average;

    @FXML
    private Tab tab_FileSource;


    private String[] line = new String[40]; //Used for file data
    private int count=0;//for array elements and loop
    private int studentNum; //number for students
    private boolean start=true; //test case for reopening files

//***********************************************************
//Function: loadData(ActionEvent event)
//Purpose: user picks a CSV file from file chooser,
//         data from file is read into an array and outputted
//***********************************************************
    @FXML
    void loadData(ActionEvent event) throws IOException {
        //create file chooser object
        FileChooser openFile = new FileChooser();
        openFile.setTitle("File Explorer");
        //add filter so only "CSV" files appear in FileChooser
        openFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files", "*.csv"));
        //create a file object and set path equal to file chosen by user
        File file = openFile.showOpenDialog(new Stage());
        if (file != null) {
            //set all array elements to null if user opens another file in the same session
            //loop will run if start=false (line 90)
            if(!start){
                for(int i = 0;i<line.length;i++){
                    if(line.equals(null))//line read = null it breaks;
                        break;
                    else //the previous value are overwritten
                        line[i] = null;
                    count=0; //reset count for while loop (line 84)
                    start=true;
                }
            }
            //Scanner will read file data
            Scanner data = new Scanner(file);
            //if file has a value then it will be outputted to text area
            while (data.hasNext()) {
                    line[count] = data.nextLine();
                    count++;
            }
        }
        fileOutputTxtField.clear();
        avgOutputTxtField.clear();
        studentNum=1;
        //set start to false so the clear statement will run if user opens another file
        start=false;
        //output grades for corresponding student
        for (int i = 0; i < count; i++) {
            fileOutputTxtField.setText(fileOutputTxtField.getText()+"Student " + studentNum + ":\t" + line[i] + "\n");
            studentNum++;
        }
    }

//***********************************************************
//Function: showAverage(ActionEvent event)
//Purpose: calculate average of each student
//***********************************************************
    @FXML
    void showAverage(ActionEvent event) {
        if (event.getSource() == btnCalcAverage) {
            avgOutputTxtField.clear();
            studentNum = 1;
        }
        double average;
        int x = 0;
        //count is the number elements in line
        //loop will run until last element of array = count
        while (x != count) {
            int total = 0;
            //remove commas from data
            String[] tokens = line[x].split(",");
            //for-each loop to get total of current line element
            for (String str : tokens)
                total += Integer.parseInt(str);
            average = (double) total / tokens.length;
            //store average in student array
            avgOutputTxtField.appendText("Student " + studentNum + ":\t" + average + "\n");
            x++;
            studentNum++;
        }
    }
//***********************************************************
//Function: aboutMe(ActionEvent event)
//Purpose: Display information about developer
//***********************************************************
    @FXML
    void aboutMe(ActionEvent event) throws IOException {
        Pane p = new Pane();
        p.setPrefSize(550,200);
        TextArea txtAreaAboutMe = new TextArea();
        //set id for css styling
        txtAreaAboutMe.setId("txtArea-AboutMe");
        //txtAreaAboutMe.setMaxSize(500,200);
        txtAreaAboutMe.setPrefSize(550,200);
        txtAreaAboutMe.wrapTextProperty().set(true);
        txtAreaAboutMe.setText("My name is Arslan and I am the developer of this application. " +
                                "\nI am currently taking a course on Java, we were tasked to " +
                                "create this application to help Dr. Harrison view student " +
                                "scores and calculate their averages. ");
        txtAreaAboutMe.setEditable(false);
        Group group = new Group(p);
        group.getChildren().add(txtAreaAboutMe);
        Stage stage = new Stage();
        stage.setTitle("About Me");
        Scene scene = new Scene(group);
        scene.getStylesheets().add("txtAreaStyle.css");
        stage.setMaxWidth(550); stage.setMaxHeight(200);stage.setScene(scene);
        stage.show();
    }
//***********************************************************
//Function: clearScreen(ActionEvent event)
//Purpose:  clear text area of selected tab
//***********************************************************
    @FXML
    void clearScreen(ActionEvent event) {
        if(tab_FileSource.isSelected())
            fileOutputTxtField.clear();
        if(tab_Average.isSelected())
            avgOutputTxtField.clear();
    }

//***********************************************************
//Function: close(ActionEvent event)
//Purpose:  exit from application
//***********************************************************
    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }
}
