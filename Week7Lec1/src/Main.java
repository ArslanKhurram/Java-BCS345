import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle rect = new Rectangle(200,200,80,80);
        rect.setFill(Color.BLUE);
        Button btn = new Button("Submit");
        btn.setLayoutX(200);
        btn.setLayoutY(200);

        Image img = new Image("Picture.jpg");
        ImageView imgview = new ImageView(img);

        BoxBlur bb = new BoxBlur();


        btn.setOnAction(e->{DropShadow ds = new DropShadow();

            File soundFile = new File("src/guitar.wav");
            Media media = new Media(soundFile.toURI().toString());
            MediaPlayer player = new MediaPlayer(media);
            player.setAutoPlay(true);

            ds.setOffsetX(10);
            ds.setOffsetY(10);
            imgview.setEffect(ds);
            imgview.setEffect(bb);

            TranslateTransition ttrans = new TranslateTransition(new Duration(3000),imgview);
            RotateTransition rtrans = new RotateTransition(new Duration(3000),imgview);
            rtrans.setFromAngle(0);
            rtrans.setToAngle(360);
            ttrans.setFromX(imgview.getX());
            ttrans.setFromY(imgview.getY());
            ttrans.setToX(300);
            ttrans.setToY(200);
            ttrans.play();
            rtrans.play();});

        Group g = new Group(imgview,btn);
        Scene s = new Scene(g,600,600);
        btn.setId("submit-btnID");
        s.getStylesheets().add("Style.css");
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}