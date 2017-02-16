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
    private Button btnStart;
    private ImageView imageView;


    public StartView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        imageView = new ImageView(new Image("be/kdg/Dots/View/images/Start/Play.png"));
        btnStart = new Button("", imageView);
    }

    private void layoutNodes() {
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);

        setCenter(btnStart);
    }

    public Button getStartButton() {
        return btnStart;
    }
}
