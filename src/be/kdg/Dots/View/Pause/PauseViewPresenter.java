package be.kdg.Dots.View.Pause;

import be.kdg.Dots.Model.Dots;
import javafx.scene.layout.BorderPane;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 22:21
 */
public class PauseViewPresenter {
    private Dots model;
    private PauseView view;

    public PauseViewPresenter(Dots model, PauseView view) {
        this.model = model;
        this.view = view;

        addEventHandlers();
        updateView();
    }

    private void addEventHandlers(){

    }

    private void updateView() {

    }
}
