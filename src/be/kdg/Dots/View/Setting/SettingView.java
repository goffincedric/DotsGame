package be.kdg.Dots.View.Setting;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * In de settingsview worden enkele regelbare settings getoont. Zoals de moeilijk, of de mogelijkheid tot het gebruiken van geluid tijdens het spel, dit gebeurd allemaal via knoppen.
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 9/03/2017 10:49
 */
public class SettingView extends VBox{
    Button btnEasy;
    Button btnNormal;
    Button btnMedium;
    Button btnHard;
    Button btnExtreem;
    Button btnHome;
    Button btnSound;

    Label lblSettings;

    ImageView imgHome;
    ImageView imgSoundOff;
    ImageView imgSoundOn;

    public SettingView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        btnEasy = new Button("EASY");
        btnNormal = new Button("NORMAL");
        btnMedium = new Button("MEDIUM");
        btnHard = new Button("HARD");
        btnExtreem = new Button("EXTREEM");
        btnHome = new Button();
        btnSound = new Button();
        imgHome = new ImageView(new Image("be/kdg/Dots/Images/Home.png"));
        imgSoundOff = new ImageView(new Image("be/kdg/Dots/Images/Mute.png"));
        imgSoundOn = new ImageView(new Image("be/kdg/Dots/Images/Soundon.png"));

        lblSettings = new Label("Settings");
    }

    private void layoutNodes() {
        this.setMinSize(750, 750);
        this.setStyle("-fx-background-color: ghostwhite; -fx-font-size: 16;");
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(lblSettings);
        this.getChildren().add(btnEasy);
        this.getChildren().add(btnNormal);
        this.getChildren().add(btnMedium);
        this.getChildren().add(btnHard);
        this.getChildren().add(btnExtreem);
        this.getChildren().add(btnSound);
        this.getChildren().add(btnHome);
        this.setSpacing(20);

        lblSettings.setStyle("-fx-font: 40px Consolas;");
        lblSettings.setTextFill(Color.BLACK);
        btnHome.setGraphic(imgHome);
        btnSound.setGraphic(imgSoundOff);

        imgSoundOn.setFitHeight(50);
        imgSoundOn.setFitWidth(50);
        imgSoundOn.setPreserveRatio(true);

        imgSoundOff.setFitHeight(50);
        imgSoundOff.setFitWidth(50);
        imgSoundOff.setPreserveRatio(true);

        imgHome.setFitHeight(100);
        imgHome.setFitWidth(100);
        imgHome.setPreserveRatio(true);
    }

    public Button getBtnEasy() {
        return btnEasy;
    }

    public Button getBtnNormal() {
        return btnNormal;
    }

    public Button getBtnMedium() {
        return btnMedium;
    }

    public Button getBtnHard() {
        return btnHard;
    }

    public Button getBtnExtreem() {
        return btnExtreem;
    }

    public Button getBtnHome() {
        return btnHome;
    }

    public Button getBtnSound() {
        return btnSound;
    }

    public ImageView getImgSoundOff() {
        return imgSoundOff;
    }

    public ImageView getImgSoundOn() {
        return imgSoundOn;
    }
}
