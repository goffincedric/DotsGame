package be.kdg.Dots.View.Start;

import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.Model.Score;
import be.kdg.Dots.View.Help.HelpView;
import be.kdg.Dots.View.Help.HelpViewPresenter;
import be.kdg.Dots.View.Spel.SpelView;
import be.kdg.Dots.View.Spel.SpelViewPresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 22:21
 */
public class StartViewPresenter {
    private Dots model;
    private StartView view;

    public StartViewPresenter(Dots model, StartView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getBtnStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SpelView spelview = new SpelView();
                SpelViewPresenter spelviewpresenter = new SpelViewPresenter(model, spelview);
                view.getScene().setRoot(spelview);
                spelview.getScene().getWindow().sizeToScene();
            }
        });

        view.getBtnHelp().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HelpView helpView = new HelpView();
                HelpViewPresenter helpViewPresenter = new HelpViewPresenter(model, helpView);
                view.getScene().setRoot(helpView);
                helpView.getScene().getWindow().sizeToScene();

            }
        });
        //Naar spelview
        //spel (timer) pas starten na dat promt is ingevult

        view.getBtnHighScores().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Score.HighScoreManager hm = new Score.HighScoreManager();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Highscores TOP 10");
                alert.setHeaderText("Dit zijn de top 10 speler");
                alert.setContentText(hm.getHighscoreString());
                alert.showAndWait();
            }
        });
    }

    private void updateView() {

    }

    public void addWindowEventHandlers() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Hierdoor stop je het spel!");
                alert.setContentText("Ben je zeker dat je wilt afsluiten?");
                alert.setTitle("Opgelet!");
                alert.getButtonTypes().clear();
                ButtonType ja = new ButtonType("Ja");
                ButtonType neen = new ButtonType("Neen");
                alert.getButtonTypes().addAll(ja, neen);
                alert.showAndWait();
                if (alert.getResult() == null || alert.getResult().equals(neen)) {
                    event.consume();
                }
            }
        });
    }
}
