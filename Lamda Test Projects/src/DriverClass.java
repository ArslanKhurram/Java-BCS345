import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DriverClass extends Application {
    int count =0;
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Click Me");

        btn.setOnAction(new EventHandler<ActionEvent>() { //anonymous class so we can update text on button
            @Override
            public void handle(ActionEvent event) {
                btn.setText("Click me" + count++);
            }
        });


        Group g=new Group(btn);
        Scene sn= new Scene(g,500,500);
        primaryStage.setScene(sn);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
