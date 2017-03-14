package be.kdg.Dots.View.Setting;

import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.Model.Level;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;

import static be.kdg.Dots.Model.Level.Moeilijkheid.*;

/**
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 9/03/2017 10:49
 */
public class SettingViewPresenter {
    private Dots model;
    private SettingView view;
    private Button result;
    private Level.Moeilijkheid moeilijkheid;


    public SettingViewPresenter(Dots model, SettingView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getBtnHome().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Window stage = view.getBtnHome().getScene().getWindow();
                stage.hide();
            }
        });


        view.getBtnEasy().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.getLevel().setMoeilijkheidsgraad(Level.Moeilijkheid.EASY);
            }
        });


        view.getBtnNormal().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.getLevel().setMoeilijkheidsgraad(Level.Moeilijkheid.NORMAL);
            }
        });

        view.getBtnMedium().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.getLevel().setMoeilijkheidsgraad(Level.Moeilijkheid.MEDIUM);
            }
        });

        view.getBtnHard().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.getLevel().setMoeilijkheidsgraad(Level.Moeilijkheid.HARD);
            }
        });

        view.getBtnExtreem().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.getLevel().setMoeilijkheidsgraad(Level.Moeilijkheid.EXTREEM);
            }
        });
    }

    private void updateView() {
    }

    public Button getResult() {
        return result;
    }

    public Level.Moeilijkheid getMoeilijkheid() {
        return moeilijkheid;
    }
}
