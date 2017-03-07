package be.kdg.Dots.View.End;

import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.View.Start.StartView;
import be.kdg.Dots.View.Start.StartViewPresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * @author Cédric Goffin
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
    }

    public void addWindowEventHandlers() {

    }

    public Button getResult() {
        return result;
    }
}
