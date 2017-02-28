package be.kdg.Dots.View.Pause;

import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.View.Spel.SpelView;
import be.kdg.Dots.View.Spel.SpelViewPresenter;
import be.kdg.Dots.View.Start.StartView;
import be.kdg.Dots.View.Start.StartViewPresenter;
import javafx.event.ActionEvent;
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

                StartView startview = new StartView();
                StartViewPresenter startviewpresenter = new StartViewPresenter(model, startview);
                view.getScene().setRoot(startview);
                startview.getScene().getWindow().sizeToScene();

                //huidige spelview nog sluiten
            }
        });

        view.getBtnRestart().setOnAction(new EventHandler<ActionEvent>() {

            //eerst andere dingen sluiten
          @Override
            public void handle(ActionEvent event) {
                SpelView spelView = new SpelView();
                SpelViewPresenter spelViewPresenter = new SpelViewPresenter(model,spelView);
                view.getScene().setRoot(spelView);
                spelView.getScene().getWindow().sizeToScene();

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
