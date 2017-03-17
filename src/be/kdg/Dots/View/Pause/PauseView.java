package be.kdg.Dots.View.Pause;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * De PauseView wordt opgeroepen wanneer de gebruiker het spel pauseert door op de pause-knop te drukken. Hier wordt zijn huidig level en huidige score getoont.
 * Hij krijgt ook de mogelijkheid om het spel te stoppen, te hervatten of om opnieuw te starten.
 * @author Cédric Goffin & Thomas Verhoeven
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

    private ImageView imgContinue;
    private ImageView imgRestart;
    private ImageView imgHome;


    public PauseView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        imgContinue = new ImageView(new Image("be/kdg/Dots/Images/Play.png"));
        imgHome = new ImageView(new Image("be/kdg/Dots/Images/Home.png"));
        imgRestart = new ImageView(new Image("be/kdg/Dots/Images/Restart.png"));

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
        this.setMinSize(400, 400);

        this.setStyle("-fx-background-color: ghostwhite; -fx-font: 16px Consolas;");

        buttonBox.getChildren().addAll(btnContinue, btnRestart, btnHome);
        scoreBox.getChildren().addAll(lblScoreTekst, lblScore);
        levelBox.getChildren().addAll(lblLevelTekst, lblLevel);
        midBox.getChildren().addAll(scoreBox, levelBox);

        scoreBox.setPadding(new Insets(10));
        levelBox.setPadding(new Insets(10));

        buttonBox.setSpacing(15);

        this.getChildren().addAll(lblPaused, midBox, buttonBox);
        this.setAlignment(Pos.CENTER);

        buttonBox.setAlignment(Pos.CENTER);
        midBox.setAlignment(Pos.CENTER);

        //imageView Continue
        imgContinue.setFitHeight(100);
        imgContinue.setFitWidth(100);
        imgContinue.setPreserveRatio(true);

        //btnContinue

        btnContinue.setGraphic(imgContinue);
        btnContinue.setPrefSize(100, 100);

        //imageView Home
        imgHome.setFitWidth(100);
        imgHome.setFitHeight(100);
        imgHome.setPreserveRatio(true);

        //btnHome

        btnHome.setGraphic(imgHome);
        btnHome.setPrefSize(100, 100);

        //imageView Restart
        imgRestart.setFitHeight(100);
        imgRestart.setFitWidth(100);
        imgRestart.setPreserveRatio(true);

        //btnRestart
        btnRestart.setGraphic(imgRestart);
        btnRestart.setPrefSize(100, 100);

    }

    public Label getLblScore() {
        return lblScore;
    }

    public Label getLblLevel() {
        return lblLevel;
    }

    public Button getBtnContinue() {
        return btnContinue;
    }

    public Button getBtnRestart() {
        return btnRestart;
    }

    public Button getBtnHome() {
        return btnHome;
    }

}


