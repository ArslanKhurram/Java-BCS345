//***********************************************************
//File: Main.java
//Purpose: Main class
//Written By: Arslan Khurram
//IDE: Intellij IDEA
//***********************************************************

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent rootGroup = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));

        primaryStage.setTitle("Grade Portal");
        primaryStage.setScene(new Scene(rootGroup));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
