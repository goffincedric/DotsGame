package be.kdg.Dots.View.Spel;

import be.kdg.Dots.Model.Score;
import com.sun.javafx.font.freetype.HBGlyphLayout;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 13:40
 */
public class SpelView extends GridPane {
    private Button[][] btns = new Button[7][7];
    private Button pause;

    private ImageView imageView;

    private Label scoreTekst;
    private Label score;
    private Label targetScoreTekst;
    private Label targetScore;
    private Label levelTekst;
    private Label level;
    private Label timerTekst;
    private Label timer;

    private GridPane dotsGrid;
    private GridPane topLeft;
    private HBox topRight;
    private VBox bottomRight;

    public SpelView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        initBtnsArray();

        this.score = new Label("###");
        this.scoreTekst = new Label("Score");
        this.targetScore = new Label("###");
        this.targetScoreTekst = new Label("Target score");
        this.levelTekst = new Label("Level  ");
        this.level = new Label("##");
        this.timerTekst = new Label("Timer (in seconden):");
        this.timer = new Label("##");

        this.pause = new Button("Pause");

        this.dotsGrid = new GridPane();
        this.topLeft = new GridPane();
        this.topRight = new HBox();
        this.bottomRight = new VBox();

    }

    private void layoutNodes() {

        this.setStyle("-fx-background-color: ghostwhite");

        //grid
        this.add(topLeft,0,0);
        this.add(getGrid(),0,1);
        this.add(topRight,1,0);
        this.add(bottomRight,1,1);
        this.setGridLinesVisible(true);
        this.setAlignment(Pos.CENTER);

        //topleft hbox
        this.topLeft.add(scoreTekst,0,0);
        this.topLeft.add(targetScoreTekst,1,0);
        this.topLeft.add(score,0,1);
        this.topLeft.add(targetScore,1,1);

        //topRight
        this.topRight.getChildren().addAll(levelTekst, level);

        //bottomRight
        this.bottomRight.getChildren().addAll(timerTekst, timer, pause);
        this.pause.setPrefSize(80,50);

        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
                GridPane.setMargin(btns[i][j], new Insets(5));
                btns[i][j].setPrefSize(70, 70);
            }
        }
    }

    Pane getGrid() {
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
                dotsGrid.add(btns[i][j], i, j);
            }
        }

        return dotsGrid;
    }

    private void initBtnsArray() {
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
                btns[i][j] = new Button();
            }
        }
    }

    Button[][] getBtns() {
        return btns;
    }

    public Button getButtonFromBtns(int rij, int kolom) {
        return btns[rij][kolom];
    }

    public GridPane getDotsGrid() {
        return dotsGrid;
    }


}
