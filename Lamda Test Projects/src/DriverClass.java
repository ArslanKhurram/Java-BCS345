import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DriverClass extends Application {
    int count =0;
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Click Me");

        btn.setOnAction(event -> {btn.setText("Click Me" + count++);}); //using lambda


        Group g=new Group(btn);
        Scene sn= new Scene(g,500,500);
        primaryStage.setScene(sn);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
