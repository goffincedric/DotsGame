package be.kdg.Dots.View.End;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 6/02/2017 13:41
 */
public class EndView extends VBox {

    private Label lblNewHighScore;
    private Label lblLevelTekst;
    private Label lblScoreTekst;
    private Label lblHuidigLevel;
    private Label lblHuidigeScore;

    private Button btnHome;
    private Button btnRestart;

    private HBox levelBox;
    private HBox scoreBox;
    private HBox buttonBox;

    private ImageView imgHome;
    private ImageView imgRestart;

    public EndView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        imgHome = new ImageView(new Image("be/kdg/Dots/images/Home.png"));
        imgRestart = new ImageView(new Image("be/kdg/Dots/images/Restart.png"));

        lblNewHighScore = new Label("####");
        lblLevelTekst = new Label("Level: ");
        lblScoreTekst = new Label("Score: ");
        lblHuidigLevel = new Label("##");
        lblHuidigeScore = new Label("###");
        btnHome = new Button();
        btnRestart = new Button();
        levelBox = new HBox();
        scoreBox = new HBox();
        buttonBox = new HBox();
    }

    private void layoutNodes() {
        this.setStyle("-fx-font: 16px Consolas; -fx-background-color: ghostwhite;");
        this.setMinSize(500, 500);

        levelBox.getChildren().addAll(lblLevelTekst, lblHuidigLevel);
        scoreBox.getChildren().addAll(lblScoreTekst, lblHuidigeScore);
        buttonBox.getChildren().addAll(btnHome, btnRestart);

        lblNewHighScore.setAlignment(Pos.CENTER);
        lblNewHighScore.setStyle("-fx-text-alignment: center");

        lblScoreTekst.setAlignment(Pos.CENTER);
        levelBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        scoreBox.setAlignment(Pos.CENTER);

        this.getChildren().addAll(lblNewHighScore, levelBox, scoreBox, buttonBox);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(15);

        //imageView Home
        imgHome.setFitHeight(100);
        imgHome.setFitWidth(100);
        imgHome.setPreserveRatio(true);

        //imageView Restart
        imgRestart.setFitHeight(100);
        imgRestart.setFitWidth(100);
        imgRestart.setPreserveRatio(true);

        //btnHome
        btnHome.setGraphic(imgHome);
        btnHome.setPrefSize(100, 100);

        //btnRestart
        btnRestart.setGraphic(imgRestart);
        btnRestart.setPrefSize(100, 100);

        //buttonBox
        buttonBox.setSpacing(15);
    }

    public Button getBtnHome() {
        return btnHome;
    }

    public Button getBtnRestart() {
        return btnRestart;
    }

    public Label getLblNewHighScore() {
        return lblNewHighScore;
    }

    public Label getLblHuidigLevel() {
        return lblHuidigLevel;
    }

    public Label getLblHuidigeScore() {
        return lblHuidigeScore;
    }
}
