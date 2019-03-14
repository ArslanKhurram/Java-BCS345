import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FirstGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text hello = new Text(200,100, "Hello World");


        //triangle
        Line ln1 = new Line(50,50,100,100);
        Line ln2 = new Line(50,50,50,100);
        Line ln3 = new Line(50,100,100,100);


            Rectangle rect1 = new Rectangle(50, 100, 50, 100);


//        Button b1 = new Button("Click Me");
//        Button b2 = new Button("Don't Click Me");

        Group grp = new Group(hello,ln1,ln2,ln3,rect1);
        Scene sn = new Scene(grp,400,300, Color.LAWNGREEN);


        primaryStage.setTitle("First JavaFX Program");
        primaryStage.setScene(sn);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



//1. make a class
//2. write extends Appl then pick the javaFX option
//3. click the error and select auto implementation
//4. make main
//5. launch(args) in main


//look at slide 8 for coordinate system
//top left is (0,0)