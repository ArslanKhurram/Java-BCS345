//Arslan Khurram
//Calculator HW4
//BCS345
//Made: 02/22/19

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

//Code for processing functionality of Calculator
public class Interface {

    @FXML
    private Button equalButton;
    @FXML
    private Button plusButton;
    @FXML
    private Button divideButton;
    @FXML
    private Button clearButton;
    @FXML
    private TextField answerTxtField;
    @FXML
    private TextField txtField;

    //readInput is (ON ACTION) for all Numbers
    //this reads which number is pressed and outputs onto text field
    @FXML
    void readInput(ActionEvent event) {
        //value will hold the text value of button
        String value = ((Button) event.getSource()).getText();
        txtField.setText(txtField.getText() + value);

        //clears all text fields when the CLR button is pressed
        if (event.getSource() == clearButton) {
            txtField.setText("");
            answerTxtField.setText("");
            operation = "";
            firstTime = true;
        }
    }

    //hold number inputted before operation
    Long number1;
    //holds the value of operation (+ or /)
    String operation = "";
    //used in loop if user decides to keep dividing number
    private boolean firstTime = true;
    //holds initial divisor
    long divider = 0;

    //reads key input
    @FXML
    void keyTyped(KeyEvent event) {
        //when "ERROR" is displayed on text field and you start typing again
        //both text fields will clear for the new input
        if(txtField.getText().equals("Error")) {
            txtField.setText("");
            answerTxtField.setText("");
        }
        //gets character value of key pressed
        String character = event.getCharacter();
        //converts character to ASCII Value
        int ascii = (int) character.charAt(0);

        //checks for key 1-9,+,/,=,del,backspace
        if (ascii >= 48 && ascii <= 57) {
            txtField.setText(txtField.getText() + character);
        } else if (ascii == 43) {
            plusButton.fire();
        } else if (ascii == 47) {
            divideButton.fire();
        } else if (ascii == 61 || ascii == 13) {
            equalButton.fire();
        } else if (ascii == 127) {
            clearButton.fire();
        }
        //used for backspace
        else if (ascii == 8){
            //holds text
            String back = txtField.getText();
            //gets length of string
            int length = back.length();
            //if length = 0 then nothing happens because there is nothing in text field
            if(length == 0)
                ;
            //back is converted to a new string using (substring) and the length is decreased by 1
            else
            txtField.setText(back.substring(0,length-1));
        }
    }

    //sets current number in text field to number1 when (+ or / is pressed)
    @FXML
    void operation(ActionEvent event) {
        //get the (+ or /) symbol
        String value = ((Button) event.getSource()).getText();

        if (event.getSource() == plusButton || event.getSource() == divideButton) {
            //set (+ or /) to operation for other method
            operation = value;
            number1 = Long.parseLong(txtField.getText());
            txtField.setText("");
            //set number1 and operation to top text field
            answerTxtField.setText(number1 + " " + value);
        }
    }

    //calculates sum or quotient
    @FXML
    void equal(ActionEvent event) {
        //when operation = + then code will compile
        if (operation.equals("+")) {
            //calculate sum
            long ans = number1 + Long.parseLong(txtField.getText());
            txtField.setText(String.valueOf(ans));
            answerTxtField.setText("");
            firstTime = true;
        }
        //when operation = / then code will compile
        if (operation.equals("/")) {
            //if user divides by 0 then "ERROR" will display
            if (Integer.parseInt(txtField.getText()) == 0) {
                txtField.setText("Error");
                answerTxtField.setText("");
            }
            //calculate quotient
            else {
                //loop for first time number is divided
                if (firstTime) {
                    //set denominator to divider
                    divider = Long.parseLong(txtField.getText());
                    long ans = (number1 / Long.parseLong(txtField.getText()));
                    txtField.setText(String.valueOf(ans));
                    answerTxtField.setText("");
                    //set to false if user decides to press equal and divide by same number again
                    //the else loop will then compile
                    firstTime = false;
                } else {
                    //divide number by previous denominator
                    long ans = (Long.parseLong(txtField.getText()) / divider);
                    txtField.setText(String.valueOf(ans));
                }
            }
        }
    }
}


