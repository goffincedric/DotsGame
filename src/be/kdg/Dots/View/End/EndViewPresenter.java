package be.kdg.Dots.View.End;

import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.Model.Score;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Deze presenter zorgt voor de samenwerking tussen het model en de EndView.
 * Hier worden de scores, level en eventuele highscores getoont.
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 6/02/2017 22:21
 */

public class EndViewPresenter {
    private Dots model;
    private EndView view;
    private Button result;

    public EndViewPresenter(Dots model, EndView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }


    private void addEventHandlers() {
        view.getBtnRestart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result = view.getBtnRestart();
                view.getBtnRestart().getScene().getWindow().hide();
            }
        });

        view.getBtnHome().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result = view.getBtnHome();
                view.getBtnHome().getScene().getWindow().hide();
            }
        });
    }

    private void updateView() {
        view.getLblHuidigeScore().setText(String.valueOf(model.getSpeler().getTotaalScore()));
        view.getLblHuidigLevel().setText(String.valueOf(model.getLevel().getGamelevel()));

        Score.HighScoreManager hm = new Score.HighScoreManager();
        int newHighscore = hm.isNewHighscore(model.getSpeler().getTotaalScore());

        if(newHighscore <=10){
            view.getLblNewHighScore().setText("!!!New Highscore!!!" + "\n" + "U staat op plaats " + newHighscore + " in de Top 10\n");
        }else{
            view.getLblNewHighScore().setText("U heeft niet genoeg punten om in de top 10 te staan.");
        }
    }

    public Button getResult() {
        return result;
    }
}
