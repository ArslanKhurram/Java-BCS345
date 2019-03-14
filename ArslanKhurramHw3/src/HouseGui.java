import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
Arslan Khurram
Homework 3
Java 345
*/
public class HouseGui extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Text signText = new Text("Arslan's House");
        signText.setFont(Font.font("Ariel",FontWeight.BOLD,11.5));
        signText.setX(310);
        signText.setY(245);

        //Rectangle Objects
        Rectangle topRect = new Rectangle(0,0,700,280);
        Rectangle bottomRect = new Rectangle(0,280,700,370);
        Rectangle body = new Rectangle(100,150,500,400);
        Rectangle topOfColumn = new Rectangle(100,150,500,30);
        Rectangle sign = new Rectangle(308,220,84,45);

        Rectangle bottomColumnPc1 = new Rectangle(100,495,68,6);
        Rectangle bottomColumnPc2 = new Rectangle(532,495,68,6);

        Rectangle door1 = new Rectangle(173,350,70, 145);
        Rectangle door2 = new Rectangle(315,315,70, 180);
        Rectangle door3 = new Rectangle(457,350,70, 145);

        //Rectangle Color
        topRect.setFill(Color.LIGHTBLUE);
        bottomRect.setFill(Color.FORESTGREEN);
        body.setFill(Color.DARKRED); body.setStroke(Color.BLACK);
        topOfColumn.setFill(Color.WHITESMOKE); topOfColumn.setStroke(Color.BLACK);
        sign.setFill(Color.LIGHTSLATEGRAY); sign.setStroke(Color.BLACK);
        bottomColumnPc1.setFill(Color.LIGHTGRAY); bottomColumnPc1.setStroke(Color.BLACK);
        bottomColumnPc2.setFill(Color.LIGHTGRAY); bottomColumnPc2.setStroke(Color.BLACK);
        door1.setFill(Color.WHITESMOKE); door1.setStroke(Color.BLACK);
        door2.setFill(Color.WHITESMOKE); door2.setStroke(Color.BLACK);
        door3.setFill(Color.WHITESMOKE); door3.setStroke(Color.BLACK);

        //windows
        Rectangle[] windows = new Rectangle[26];

        int windowValue = 26;
        int windowY = 460,windowY2 = 460,windowY3 = 460;
        for(int i=0;i<windowValue;i++)
        {
           if(i<6){
            windows[i] = new Rectangle(183,windowY,20,30);i++;
            windows[i] = new Rectangle(210,windowY,20,30);
            windowY-=35;}
           if(i>=6 && i < 8){
               windows[i] = new Rectangle(183,windowY+5,20,20);i++;
               windows[i] = new Rectangle(210,windowY+5,20,20);
               windowY-=35;}
            if(i>=8 && i<16){
                windows[i] = new Rectangle(325,windowY2,20,30);i++;
                windows[i] = new Rectangle(355,windowY2,20,30);
                windowY2-=35;}
            if(i>=16 && i < 18){
                windows[i] = new Rectangle(325,windowY+5,20,20);i++;
                windows[i] = new Rectangle(355,windowY+5,20,20);
                windowY2-=35;}
            if(i>=18 && i<24){
                windows[i] = new Rectangle(468,windowY3,20,30);i++;
                windows[i] = new Rectangle(497,windowY3,20,30);
                windowY3-=35;}
            if(i>=24 && i < 26){
                windows[i] = new Rectangle(468,windowY3+5,20,20);i++;
                windows[i] = new Rectangle(497,windowY3+5,20,20);
                windowY3-=35;}
        }

        //Stairs
        Rectangle[] stairs = new Rectangle[11];
        Group stairGroup = new Group();
        int stairX = 168;
        int stairY = 495;
        int stairW = 365;
        for(int i=1;i<11;i++)
        {
            stairs[i] = new Rectangle(stairX,stairY,stairW,10);
            stairX-=15;
            stairY+=10;
            stairW+=30;

            stairs[i].setFill(Color.LIGHTGRAY);
            stairs[i].setStroke(Color.BLACK);
            stairGroup.getChildren().add(stairs[i]);

        }

        //Bottom Column
        Rectangle[] bottomOfColumn = new Rectangle[4];
        Group bottomColumn = new Group();
        bottomOfColumn[0] = new Rectangle(108,480,60,15);
        bottomOfColumn[1] = new Rectangle(249.6,480,60,15);
        bottomOfColumn[2] = new Rectangle(391.2,480,60,15);
        bottomOfColumn[3] = new Rectangle(533,480,60,15);

        //Bottom Column Color
        for(int i=0;i<4;i++)
        {
            bottomOfColumn[i].setFill(Color.WHITE);
            bottomOfColumn[i].setStroke(Color.BLACK);
            bottomColumn.getChildren().add(bottomOfColumn[i]);

        }

        //Columns
        Rectangle[] column = new Rectangle[4];
        Group columnGroup = new Group();
        double r_xValue = 115;
        for(int i=0;i<4;i++)
        {
            column[i] = new Rectangle(r_xValue,180,45,300);//256.6,301.6       398.2      diff  96.6      half  48.3     half 24.15    half 12
            if(i<3){r_xValue+=141.6;}
            else r_xValue=540;

            column[i].setFill(Color.WHITE);
            column[i].setStroke(Color.BLACK);
            columnGroup.getChildren().add(column[i]);
        }

        //Triangle
        Polygon roof = new Polygon();
        roof.getPoints().addAll(350.0,0.0,50.0,150.0,650.0,150.0);
        roof.setFill(Color.WHITE); //set color
        roof.setStroke(Color.BLACK); //outline

        //Circle
        double c_CenterX = 115;
        Circle[] columnCircle = new Circle[8];
        Group columnCircleGroup = new Group();
        for (int i = 0; i < 8; i++) {
            columnCircle[i] = new Circle(c_CenterX, 195, 15);
            if (i == 0 || i == 2 || i == 4 || i == 6) { c_CenterX += 45; }
            if (i == 1|| i == 3 || i == 5) { c_CenterX += 96.6; }
            if (i == 7) { c_CenterX = 585; }

            columnCircle[i].setFill(Color.WHITE);
            columnCircle[i].setStroke(Color.BLACK);
            columnCircleGroup.getChildren().add(columnCircle[i]);

        }

        //Puts all windows into one group
        Group windowGroup = new Group();
        for(int i=0;i<windowValue;i++)
        {
            windowGroup.getChildren().add(windows[i]);
        }

        //Default Group
        Group rootGroup = new Group(topRect,bottomRect,body,topOfColumn,roof,sign,signText,bottomColumnPc1,
                bottomColumnPc2,door1,door2,door3);

        //add groups to root group
        rootGroup.getChildren().add(windowGroup);
        rootGroup.getChildren().add(stairGroup);
        rootGroup.getChildren().add(columnGroup);
        rootGroup.getChildren().add(columnCircleGroup);
        rootGroup.getChildren().add(bottomColumn);

        Scene s1 = new Scene(rootGroup,700,650); //w 350.....h 325

        primaryStage.setTitle("House Picture");
        primaryStage.setScene(s1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
