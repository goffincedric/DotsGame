package be.kdg.Dots.View.Spel;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * De spelview, hier draait heel het spel, dit is de spelomgeving. De gebruiker speelt in deze view door middel van de vierkantjes in het grid te selecteren.
 *
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 6/02/2017 13:40
 */
public class SpelView extends GridPane {
    private Button[][] btns = new Button[7][7];
    private Button btnPause;
    private Button btnEnd;

    private Label lblScoreTekst;
    private Label lblScore;
    private Label lblTargetScoreTekst;
    private Label lblTargetScore;
    private Label lblLevel;
    private Label lblTimerTekst;
    private Label lblTimer;
    private Label lblSpelerNaam;

    private GridPane dotsGrid;
    private GridPane topLeft;
    private VBox topRight;
    private VBox bottomRight;
    private HBox levelBox;

    public SpelView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        initBtnsArray();
        this.lblSpelerNaam = new Label("########");
        this.lblScore = new Label("###");
        this.lblScoreTekst = new Label("Score");
        this.lblTargetScore = new Label("###");
        this.lblTargetScoreTekst = new Label("Target score");
        this.lblLevel = new Label("##");
        this.lblTimerTekst = new Label("Timer:");
        this.lblTimer = new Label("45");

        this.btnPause = new Button("Pause");
        this.btnEnd = new Button("End");

        this.dotsGrid = new GridPane();
        this.topLeft = new GridPane();
        this.topRight = new VBox();
        this.bottomRight = new VBox();
        this.levelBox = new HBox();
    }

    private void layoutNodes() {
        this.setStyle("-fx-background-color: ghostwhite;");
        topLeft.setStyle(" -fx-font: 22px Consolas;");
        topRight.setStyle("-fx-font: 22px Consolas;");
        lblTimer.setStyle("-fx-font: 22px Consolas;");
        lblTimerTekst.setStyle("-fx-font: 22px Consolas;");
        this.setMinSize(750, 750);
        this.setVgap(10);
        this.setHgap(10);
        this.setStyle("");

        //grid
        this.add(topLeft, 0, 0);
        this.add(getGrid(), 0, 1);
        this.add(topRight, 1, 0);
        this.add(bottomRight, 1, 1);
        //this.setGridLinesVisible(true);
        this.setAlignment(Pos.CENTER);

        //topleft hbox
        this.topLeft.add(lblScoreTekst, 0, 0);
        this.topLeft.add(lblTargetScoreTekst, 1, 0);
        this.topLeft.add(lblScore, 0, 1);
        this.topLeft.add(lblTargetScore, 1, 1);
        this.topLeft.setHgap(10);
        this.topLeft.setVgap(10);

        //topRight
        this.levelBox.getChildren().addAll(lblLevel);
        this.topRight.getChildren().addAll(lblSpelerNaam, levelBox);

        //bottomRight
        this.bottomRight.getChildren().addAll(lblTimerTekst, lblTimer, btnPause, btnEnd);
        this.bottomRight.setAlignment(Pos.BASELINE_CENTER);
        this.bottomRight.setSpacing(10);
        bottomRight.setPadding(new Insets(200, 0, 0, 0));
        this.btnPause.setPrefSize(80, 50);
        this.btnPause.setMinSize(btnPause.getPrefWidth(), btnPause.getPrefHeight());
        this.btnEnd.setMinSize(btnPause.getPrefWidth(), btnPause.getPrefHeight());

        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
                GridPane.setMargin(btns[i][j], new Insets(5));
                btns[i][j].setPrefSize(70, 70);
            }
        }
    }

    /**
     * Hier worden de buttons uit de btnsArray toegevoegd aan de gridpane.
     *
     * @return Het gridpain met de dots wordt gereturnd zodat deze kan uitgeprint worden.
     */
    Pane getGrid() {
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
                dotsGrid.add(btns[i][j], i, j);
            }
        }
        return dotsGrid;
    }

    /**
     * Hier wordt de array met 49 buttons geïnitilaiseerd. 7 verticaal en 7 horizontaal.
     */
    private void initBtnsArray() {
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
                btns[i][j] = new Button();
            }
        }
    }

    Button getButtonFromBtns(int rij, int kolom) {
        return btns[rij][kolom];
    }

    GridPane getDotsGrid() {
        return dotsGrid;
    }

    Label getLblScore() {
        return lblScore;
    }

    Label getLblTargetScore() {
        return lblTargetScore;
    }

    Label getLblLevel() {
        return lblLevel;
    }

    Label getLblSpelerNaam() {
        return lblSpelerNaam;
    }

    Button getBtnPause() {
        return btnPause;
    }

    Button getBtnEnd() {
        return btnEnd;
    }

    Label getLblTimer() {
        return lblTimer;
    }

    public void movesLayout() {

    }

    public void infinityLayout() {
        lblTargetScoreTekst.setVisible(false);
        lblTargetScore.setVisible(false);
        lblLevel.setVisible(false);
        lblTimerTekst.setVisible(false);
        lblTimer.setVisible(false);
    }
}

