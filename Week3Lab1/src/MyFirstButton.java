import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class MyFirstButton {
    int i=1;
    @FXML
    private Button clickMe;

    private TextField txtfield;

    @FXML
    void addClicks(ActionEvent event) {
        txtfield.setText(""+i++);
    }

}


