package be.kdg.Dots.View.Pause;

import be.kdg.Dots.Model.Dots;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Window;

/**
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 6/02/2017 22:21
 */
public class PauseViewPresenter {
    private Dots model;
    private PauseView view;
    private Button result;

    public PauseViewPresenter(Dots model, PauseView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getBtnContinue().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Window stage = view.getBtnHome().getScene().getWindow();
                stage.hide();
            }
        });

        view.getBtnHome().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result = view.getBtnHome();
                view.getBtnHome().getScene().getWindow().hide();
            }
        });

        view.getBtnRestart().setOnAction(new EventHandler<ActionEvent>() {
            //eerst andere dingen sluiten
            @Override
            public void handle(ActionEvent event) {
                result = view.getBtnRestart();
                view.getBtnRestart().getScene().getWindow().hide();
            }
        });

    }

    private void updateView() {
        view.getLblScore().setText(String.valueOf(model.getSpeler().getTotaalScore()));
        view.getLblLevel().setText(String.valueOf(model.getLevel().getGamelevel()));
    }

    public void addWindowEventHandlers() {

    }

    public Button getResult() {
        return result;
    }
}
