package be.kdg.Dots.View.Setting;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * @author Thomas Verhoeven
 * @version 1.0 9/03/2017 10:49
 */
public class SettingView extends VBox{



    Button btnEasy;
    Button btnNormal;
    Button btnMedium;
    Button btnHard;
    Button btnExtreem;
    Button btnHome;

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
        btnHome = new Button("Home");

    }

    private void layoutNodes() {
        this.setMinSize(750, 750);
        this.setStyle("-fx-background-color: ghostwhite; -fx-font-size: 16; -fx-font-family: 'Ubuntu', sans-serif;");

        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(btnEasy,btnNormal,btnMedium, btnHard,btnExtreem, btnHome);
        this.setSpacing(15);

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
}