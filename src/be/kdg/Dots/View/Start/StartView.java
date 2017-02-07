package be.kdg.Dots.View.Start;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 13:41
 */
public class StartView extends BorderPane {
    private Button startButton;
    private Image logoImage;


    public StartView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes(){
        this.startButton = new Button("", new ImageView(new Image("be/kdg/Dots/View/Images/Start/Play.png")));
    }

    private void layoutNodes(){

    }
}
