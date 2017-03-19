package be.kdg.Dots.View.Start;

import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.Model.Score;
import be.kdg.Dots.View.Help.HelpView;
import be.kdg.Dots.View.Help.HelpViewPresenter;
import be.kdg.Dots.View.Setting.SettingView;
import be.kdg.Dots.View.Setting.SettingViewPresenter;
import be.kdg.Dots.View.Spel.SpelView;
import be.kdg.Dots.View.Spel.SpelViewPresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Deze presenter zorgt voor de samenwerking tussen het model en de Startview.
 * @author Cédric Goffin & Thomas Verhoeven
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
                List<String> choices = new ArrayList<>();
                choices.add("Classic mode");
                choices.add("Moves mode");
                choices.add("Infinity mode");

                ChoiceDialog<String> dialog = new ChoiceDialog<>("Classic mode", choices);
                dialog.setTitle("Spelmodus");
                dialog.setHeaderText("Kies een spelmodus");
                dialog.setContentText("Kies de spelmodus die je wil spelen:");

                Optional<String> result = dialog.showAndWait();

                if (result.isPresent()){
                    switch (result.get()) {
                        case "Classic mode":
                            try {
                                model.setSpelModus(Dots.SpelModus.Classic);

                                SpelView spelview = new SpelView();
                                SpelViewPresenter spelviewpresenter = new SpelViewPresenter(model, spelview);
                                view.getScene().setRoot(spelview);
                                spelview.getScene().getWindow().sizeToScene();
                                spelviewpresenter.addWindowEventHandlers();
                            } catch (NullPointerException e) {
                                event.consume();
                            } catch (Exception e) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION, e.getMessage());
                                alert.show();
                            }
                            break;
                        case  "Moves mode":
                            Alert movesAlert = new Alert(Alert.AlertType.INFORMATION);
                            movesAlert.setTitle("Coming soon");
                            movesAlert.setHeaderText("Moves mode is nog niet beschikbaar");
                            movesAlert.getButtonTypes().clear();
                            movesAlert.getButtonTypes().add(ButtonType.OK);
                            movesAlert.show();
                            break;
                        case "Infinity mode":
                            Alert infinityAlert = new Alert(Alert.AlertType.INFORMATION);
                            infinityAlert.setTitle("Coming soon");
                            infinityAlert.setHeaderText("Infinity mode is nog niet beschikbaar");
                            infinityAlert.getButtonTypes().clear();
                            infinityAlert.getButtonTypes().add(ButtonType.OK);
                            infinityAlert.show();
                            break;
                    }
                } else {
                    event.consume();
                }
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

        view.getBtnHighScores().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Score.HighScoreManager hm = new Score.HighScoreManager();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Highscores TOP 10");
                alert.setHeaderText("Dit zijn de top 10 spelers");
                alert.setContentText(hm.getHighscoreString());
                alert.getDialogPane().setStyle("-fx-font-family: 'Lucida Console'");
                alert.setWidth(200);
                alert.show();
            }
        });

        view.getBtnSettings().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SettingView settingView = new SettingView();
                SettingViewPresenter settingViewPresenter = new SettingViewPresenter(model, settingView);
                Stage settingStage = new Stage();
                settingStage.getIcons().add(new Image("be/kdg/Dots/Images/Logo.png"));
                settingStage.setTitle("Dots");
                settingStage.initOwner(view.getScene().getWindow());
                settingStage.initModality(Modality.APPLICATION_MODAL);
                settingStage.setScene(new Scene(settingView));
                settingStage.showAndWait();
            }
        });
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

    private void updateView() {

    }

    private void startNieuwSpel() {
        try {
            SpelView spelview = new SpelView();
            SpelViewPresenter spelviewpresenter = new SpelViewPresenter(model, spelview);
            view.getScene().setRoot(spelview);
            spelview.getScene().getWindow().sizeToScene();
            spelviewpresenter.addWindowEventHandlers();
        } catch (NullPointerException e) {

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, e.getMessage());
            alert.show();
        }
    }
}
