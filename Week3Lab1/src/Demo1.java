import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Demo1 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent rootGroup = FXMLLoader.load(getClass().getResource("GUI_View.fxml"));

        Scene mainScene = new Scene(rootGroup);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
