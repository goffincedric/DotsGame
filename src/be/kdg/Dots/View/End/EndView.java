package be.kdg.Dots.View.End;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 13:41
 */
public class EndView extends BorderPane {


    private Label newHighScore;
    private Label levelTekst;
    private Label scoreTekst;
    private Label huidigLevel;
    private Label huidigeScore;

    private Button btnHome;
    private Button btnRestart;

    private HBox levelBox;
    private HBox scoreBox;
    private HBox buttonBox;
    private VBox bottomBox;

    public EndView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        newHighScore = new Label("10000");
        levelTekst = new Label("Level: ");
        scoreTekst = new Label("Score: ");
        huidigLevel = new Label("10");
        huidigeScore = new Label("250");
        btnHome = new Button("Home");
        btnRestart = new Button("Restart");
        levelBox = new HBox();
        scoreBox = new HBox();
        buttonBox = new HBox();
        bottomBox = new VBox();

    }

    private void layoutNodes() {

        levelBox.getChildren().addAll(levelTekst, huidigLevel);
        scoreBox.getChildren().addAll(scoreTekst, huidigeScore);
        buttonBox.getChildren().addAll(btnHome, btnRestart);
        bottomBox.getChildren().addAll(levelBox,scoreTekst, buttonBox);

        
        newHighScore.setAlignment(Pos.CENTER);
        levelBox.setAlignment(Pos.CENTER);
        scoreTekst.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        bottomBox.setAlignment(Pos.CENTER);

        this.setTop(newHighScore);
        this.setBottom(bottomBox);


    }
}
