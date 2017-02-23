package be.kdg.Dots.View.Pause;

import be.kdg.Dots.Model.Dots;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Window;

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

    private void addEventHandlers() {
        view.getBtnHome().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Window stage = view.getBtnHome().getScene().getWindow();
                stage.hide();


            }
        });

    }

    private void updateView() {
        view.getLblScore().setText(String.valueOf(model.getSpeler().getScore()));
        view.getLblLevel().setText(String.valueOf(model.getLevel().getGamelevel()));
    }

    public void addWindowEventHandlers() {

    }
}
