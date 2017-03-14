package be.kdg.Dots.View.Setting;

import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.Model.Level;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Window;

/**
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 9/03/2017 10:49
 */
public class SettingViewPresenter {
    private Dots model;
    private SettingView view;
    private Button result;
    private Level.Moeilijkheid moeilijkheid;
    private Boolean sound = false;


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
                view.getBtnEasy().setStyle("-fx-base:#7FFF00");
            }
        });

        view.getBtnNormal().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.getLevel().setMoeilijkheidsgraad(Level.Moeilijkheid.NORMAL);
                view.getBtnNormal().setStyle("-fx-base:#7FFF00");
            }
        });

        view.getBtnMedium().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.getLevel().setMoeilijkheidsgraad(Level.Moeilijkheid.MEDIUM);
                view.getBtnMedium().setStyle("-fx-base:#7FFF00");
            }
        });

        view.getBtnHard().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.getLevel().setMoeilijkheidsgraad(Level.Moeilijkheid.HARD);
                view.getBtnHard().setStyle("-fx-base:#7FFF00");
            }
        });

        view.getBtnExtreem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.getLevel().setMoeilijkheidsgraad(Level.Moeilijkheid.EXTREEM);
                view.getBtnExtreem().setStyle("-fx-base:#7FFF00");
            }
        });

        view.getBtnSound().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sound = !sound;
                if (sound) {
                    view.getBtnSound().setGraphic(view.getImgSoundOn());
                    sound = true;
                    model.setSound(true);
                } else {
                    view.getBtnSound().setGraphic(view.getImgSoundOff());
                    sound = false;
                    model.setSound(false);

                }

            }
        });
    }

    private void updateView() {
    }

}
