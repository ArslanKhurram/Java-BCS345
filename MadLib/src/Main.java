import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent rootGroup = FXMLLoader.load(getClass().getResource("interface.fxml"));
        primaryStage.setScene(new Scene(rootGroup));
        primaryStage.setTitle("Mad Lib");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
