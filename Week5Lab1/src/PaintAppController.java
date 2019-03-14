import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PaintAppController {

    String shape = "Blank";
    double x0, y0, xE, yE;

    @FXML
    private Button btnLine;

    @FXML
    private Button btnRect;

    @FXML
    private Button btnOval;

    @FXML
    private Slider pickWidth;

    @FXML
    private ColorPicker pickColor;

    @FXML
    private Canvas myDrawingCanvas;

    @FXML
    void selectShape(ActionEvent event) {
        switch (((Button) event.getSource()).getText()) {
            case "Line":
                shape = "LINE";
                break;
            case "Rect":
                shape = "RECT";
                break;
            case "Oval":
                shape = "OVAL";
                break;
        }
    }


    @FXML
    void startDrawing(MouseEvent event) {
        x0 = event.getX();
        y0 = event.getY();
    }

    @FXML
    void finishDrawing(MouseEvent event) {
        xE = event.getX();
        yE = event.getY();
        GraphicsContext gc = myDrawingCanvas.getGraphicsContext2D();
        if (shape.equals("LINE")) {
            gc.setLineWidth(pickWidth.getValue());
            gc.setStroke(pickColor.getValue());
            gc.strokeLine(x0, y0, xE, yE);
        } else if (shape.equals("RECT")) {
            gc.setFill(pickColor.getValue());
            gc.fillRect(xE > x0 ? x0 : xE, yE > y0 ? y0 : yE, Math.abs(xE - x0), Math.abs(yE - y0));
        }
        else if (shape.equals("OVAL")) {
            gc.setFill(pickColor.getValue());
            gc.fillOval(xE > x0 ? x0 : xE, yE > y0 ? y0 : yE, Math.abs(xE - x0), Math.abs(yE - y0));
        }
    }

    @FXML
    void openFile(ActionEvent event) {
        FileChooser file = new FileChooser();
        file.setTitle("Open");
        file.showOpenDialog(new Stage());

        Image img = new Image(String.valueOf(file));
        ImageView imgv = new ImageView(img);



    }@FXML
    void closeFile(ActionEvent event) {
        System.exit(0);
    }

}
