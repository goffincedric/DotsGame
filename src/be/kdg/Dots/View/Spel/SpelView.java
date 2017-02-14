package be.kdg.Dots.View.Spel;

import com.sun.javafx.font.freetype.HBGlyphLayout;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 13:40
 */
public class SpelView extends BorderPane {
    private Button[][] btns = new Button[7][7];
    private BorderPane veld;
    private BorderPane dotsfield;
    private BorderPane links;
    private BorderPane rechts;
    private Label scoreTekst;
    private Label score;
    private Label targetScoreTekst;
    private Label targetScore;
    private Label levelTekst;
    private Label Level;
    private Label timerTekst;
    private Label timer;
    private Button pause;
    private BorderPane scorebox;

    public SpelView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        initBtnsArray();


        this.score = new Label();
        this.scoreTekst = new Label("Score");
        this.targetScore = new Label();
        this.targetScoreTekst = new Label("Target score");

        this.veld = new BorderPane();
        dotsfield = new BorderPane();
        links = new BorderPane();
        rechts = new BorderPane();
        scorebox = new BorderPane();

        scorebox.setLeft(scoreTekst);
        scorebox.setRight(targetScoreTekst);

        this.setLeft(links);
        this.setRight(rechts);
        links.setTop(scorebox);
        links.setBottom(dotsfield);


        //this.setBottom(dotsfield);
        dotsfield.setCenter(getGrid());
    }

    private void layoutNodes() {











        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
                GridPane.setMargin(btns[i][j], new Insets(5));
                /// btns[i][j].setStyle(" -fx-background-color: #000000, linear-gradient(#7ebcea, #2f4b8f), linear-gradient(#426ab7, #263e75), linear-gradient(#395cab, #223768); -fx-background-insets: 0,1,2,3; -fx-background-radius: 3,2,2,2; -fx-padding: 12 30 12 30;");
                btns[i][j].setPrefSize(70, 70);
            }
        }
    }

    private Pane getGrid() {
        GridPane gridPane = new GridPane();
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
                gridPane.add(btns[i][j], i, j);
            }
        }
        return gridPane;
    }

    private void initBtnsArray() {
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
                btns[i][j] = new Button();
            }

        }
    }
}
