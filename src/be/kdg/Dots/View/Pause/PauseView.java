package be.kdg.Dots.View.Pause;

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
public class PauseView extends VBox {

    private Label lblPaused;
    private Label lblScoreTekst;
    private Label lblLevelTekst;
    private Label lblScore;
    private Label lblLevel;
    private Button btnContinue;
    private Button btnRestart;
    private Button btnHome;

    private HBox buttonBox;
    private VBox scoreBox;
    private VBox levelBox;
    private HBox midBox;

    public PauseView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        lblPaused = new Label("Game Paused");
        lblScoreTekst = new Label("Score:");
        lblLevelTekst = new Label("Level:");
        lblScore = new Label("####");
        lblLevel = new Label("##");
        btnContinue = new Button();
        btnRestart = new Button();
        btnHome = new Button();

        buttonBox = new HBox();
        scoreBox = new VBox();
        levelBox = new VBox();
        midBox = new HBox();


    }

    private void layoutNodes() {
        this.setStyle("-fx-background-color: ghostwhite");

        buttonBox.getChildren().addAll(btnContinue, btnRestart, btnHome);
        scoreBox.getChildren().addAll(lblScoreTekst, lblScore);
        levelBox.getChildren().addAll(lblLevelTekst, lblLevel);
        midBox.getChildren().addAll(scoreBox, levelBox);

        this.getChildren().addAll(midBox, buttonBox);
        this.setAlignment(Pos.CENTER);

        buttonBox.setAlignment(Pos.CENTER);
        midBox.setAlignment(Pos.CENTER);

    }
}
