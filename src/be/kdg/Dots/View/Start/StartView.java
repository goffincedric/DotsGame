package be.kdg.Dots.View.Start;

import be.kdg.Dots.View.View;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 13:41
 */
public class StartView extends View {
    private Button btnStart;
    private Image imgStart;
    private ImageView imageView;


    public StartView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        imgStart = new Image("be/kdg/Dots/View/Images/Start/Play.png");
        imageView = new ImageView(imgStart);
        btnStart = new Button("", imageView);
    }

    private void layoutNodes(){
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);

        setCenter(btnStart);
    }

    public Button getStartButton() {
        return btnStart;
    }
}
