package be.kdg.Dots.View.Start;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 13:41
 */
public class StartView extends BorderPane {
    private Button btnStart;
    private ImageView play;
    private ImageView logo;
    private ImageView trophy;
    private ImageView help;
    private Button btnHighScores;
    private Button btnHelp;
    private Label dots;
    private HBox footer;
    private VBox topbox;

    public StartView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        trophy = new ImageView(new Image("be/kdg/Dots/View/images/trophy.gif"));
        logo = new ImageView(new Image("be/kdg/Dots/View/images/Logo.png"));
        play = new ImageView(new Image("be/kdg/Dots/View/images/Play.png"));
        help = new ImageView(new Image("be/kdg/Dots/View/images/help.png"));
        btnHelp = new Button();
        btnHighScores = new Button();
        btnStart = new Button();
        dots = new Label("DOTS");

        footer = new HBox();
        topbox = new VBox();
    }

    private void layoutNodes() {
        this.setMinSize(750,750);
        this.setStyle("-fx-background-color: ghostwhite");
        this.setPadding(new Insets(25,0,15,0));

        dots.setAlignment(Pos.CENTER);
        dots.setStyle("-fx-font-family: 'Gloria Hallelujah', cursive; -fx-font-size:60");

        btnStart.setGraphic(play);
        btnStart.setPrefSize(100, 100);
        //btnStart.setStyle("-fx-background-color: #C70039");
        play.setFitHeight(100);
        play.setFitWidth(100);
        play.setPreserveRatio(true);

        btnHighScores.setGraphic(trophy);
        btnHighScores.setPrefSize(50,50);
        trophy.setFitHeight(50);
        trophy.setFitWidth(50);
        trophy.setPreserveRatio(true);

        btnHelp.setGraphic(help);
        btnHelp.setPrefSize(50,50);
        help.setFitHeight(50);
        help.setFitWidth(50);
        trophy.setPreserveRatio(true);

        logo.setFitHeight(200);
        logo.setFitWidth(200);
        logo.setPreserveRatio(true);


        footer.getChildren().addAll(btnHighScores, btnHelp);
        footer.setAlignment(Pos.CENTER);
        footer.setSpacing(650);

        topbox.getChildren().addAll(dots,logo, btnStart);
        topbox.setAlignment(Pos.CENTER);
        topbox.setSpacing(30.0);


        setTop(topbox);

        setBottom(footer);
    }


}
