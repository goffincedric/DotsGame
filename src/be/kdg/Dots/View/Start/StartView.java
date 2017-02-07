package be.kdg.Dots.View.Start;

import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 13:41
 */
public class StartView extends BorderPane {
    private Button btnStart;
    private ToggleButton tbtnStart;
    private Image imgStart;
    private ImageView imageView;


    public StartView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes(){
        this.imgStart = new Image("be/kdg/Dots/View/Images/Start/Play.png");
        imageView = new ImageView(imgStart);
        this.btnStart = new Button("");
    }

    private void layoutNodes(){
        imageView.fitWidthProperty().bind(btnStart.widthProperty());
        this.btnStart.setGraphic(imageView);
        this.setCenter(btnStart);
    }

    public Button getStartButton() {
        return btnStart;
    }
}
