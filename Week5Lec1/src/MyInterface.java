import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyInterface extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent rootGroup = FXMLLoader.load(getClass().getResource("Interface.fxml"));

        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(rootGroup));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}