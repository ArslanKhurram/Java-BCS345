import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class Interface {

    @FXML
    private TextField txtField;

    @FXML
    private Button button3;

    @FXML
    private Button button2;

    @FXML
    private Button button1;

    @FXML
    void buttonInput(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        txtField.setText(txtField.getText() + value);
    }


}
