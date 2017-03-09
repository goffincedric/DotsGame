package be.kdg.Dots.View.Spel;


import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.Model.DotsException;
import be.kdg.Dots.Model.Kleuren;
import be.kdg.Dots.Model.Score;
import be.kdg.Dots.View.End.EndView;
import be.kdg.Dots.View.End.EndViewPresenter;
import be.kdg.Dots.View.Pause.PauseView;
import be.kdg.Dots.View.Pause.PauseViewPresenter;
import be.kdg.Dots.View.Start.StartView;
import be.kdg.Dots.View.Start.StartViewPresenter;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.util.Optional;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 22:21
 */
public class SpelViewPresenter {
    private Dots model;
    private SpelView view;
    TextInputDialog dialogNaam;
    Alert alert;

    private Timeline stopwatchTimeline;

    public SpelViewPresenter(Dots model, SpelView view) {
        this.model = model;
        this.view = view;

        dialogNaam = new TextInputDialog();

        boolean naamIngegeven;
        do {
            naamIngegeven = false;
            dialogNaam.setTitle("Speler");
            dialogNaam.setContentText("Please enter your name: ");

            Optional<String> result = dialogNaam.showAndWait();

            if (result.isPresent()) {
                if (!result.get().isEmpty()) {
                    this.model.getSpeler().setNaam(result.get());
                    naamIngegeven = true;
                }
            } else if (!result.isPresent()) {
                StartView startview = new StartView();
                StartViewPresenter startviewpresenter = new StartViewPresenter(model, startview);
                view.getScene().setRoot(startview);
                startview.getScene().getWindow().sizeToScene();
            }
        } while (!naamIngegeven);

        setupTimelineBasis();
        stopwatchTimeline.play();
        addEventHandlers();

        updateView();
    }

    private void addEventHandlers() {
        dialogNaam.getEditor().lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if ((newValue.intValue() > oldValue.intValue()) && (newValue.intValue() > 20)) {
                    dialogNaam.getEditor().setText(dialogNaam.getEditor().getText().substring(0, 20));
                }
            }
        });

        stopwatchTimeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                endStatus();
            }
        });
        updateView();

        for (Node node : view.getDotsGrid().getChildren()) {
            node.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        model.getLijn().addDot(model.getDotUitSpeelveld(view.getDotsGrid().getRowIndex(node), view.getDotsGrid().getColumnIndex(node)));

                        Kleuren kleur = model.getLijn().getLijn().get(0).getKleur();
                        view.getButtonFromBtns(view.getDotsGrid().getColumnIndex(node), view.getDotsGrid().getRowIndex(node)).setStyle(
                                String.format("-fx-effect: dropshadow(three-pass-box, darkgray, 2, 2, 0, 0); -fx-background-color: rgb(%d, %d, %d)", kleur.getRed(), kleur.getGreen(), kleur.getBlue())
                        );
                    } catch (DotsException e) {
                        if (!model.getLijn().getHeeftToegevoegd()) {
                            Kleuren kleur = model.getDotUitSpeelveld(view.getDotsGrid().getRowIndex(node), view.getDotsGrid().getColumnIndex(node)).getKleur();
                            view.getButtonFromBtns(view.getDotsGrid().getColumnIndex(node), view.getDotsGrid().getRowIndex(node)).setStyle(
                                    String.format("-fx-background-color: rgb(%d, %d, %d)", kleur.getRed(), kleur.getGreen(), kleur.getBlue())
                            );
                        }
                        alert = new Alert(Alert.AlertType.INFORMATION, e.getMessage(), ButtonType.OK);
                        alert.showAndWait();
                    }
                }
            });
        }

        view.setOnKeyReleased(new EventHandler<KeyEvent>() {
            //om lijn te submitten
            final KeyCombination KeySpace = new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN);
            final KeyCombination KeyControlT = new KeyCodeCombination(KeyCode.T, KeyCombination.CONTROL_DOWN);

            @Override
            public void handle(KeyEvent event) {
                if (KeySpace.match(event)) {
                    if (model.getLijn().getAantalDots() < 2) {
                        alert = new Alert(Alert.AlertType.ERROR, "Lijn moet minstens 2 dots bevatten!", ButtonType.OK);
                        alert.showAndWait();
                    } else {
                    /* verwijdert gebruikte dots*/
                        model.vervangGebruikteDots();

                    /* berekent score*/
                        model.getSpeler().setGameScore(model.getSpeler().getGameScore() + model.getLijn().getAantalDots());
                        model.getSpeler().addPuntenTotaalScore(model.getLijn().getAantalDots());

                    /* maak lijn leeg */
                        model.maakLijnLeeg();

                    /* vernieuw spelview */
                        updateView();
                    }
                } else if (KeyControlT.match(event)) {
                    endStatus();
                }
            }
        });

        view.getPause().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stopwatchTimeline.stop();

                PauseView pauseview = new PauseView();
                PauseViewPresenter pauseviewpresenter = new PauseViewPresenter(model, pauseview);
                Stage pauseStage = new Stage();
                pauseStage.initOwner(view.getScene().getWindow());
                pauseStage.initModality(Modality.APPLICATION_MODAL);
                pauseStage.setScene(new Scene(pauseview));
                pauseStage.showAndWait();

                if (pauseviewpresenter.getResult() == null) {
                    stopwatchTimeline.play();
                } else if(pauseviewpresenter.getResult().equals(pauseview.getBtnContinue())) {
                    stopwatchTimeline.play();
                } else if (pauseviewpresenter.getResult().equals(pauseview.getBtnRestart())) {
                    resetSpel();
                } else if (pauseviewpresenter.getResult().equals(pauseview.getBtnHome())) {
                    StartView startview = new StartView();
                    StartViewPresenter startviewpresenter = new StartViewPresenter(model, startview);
                    view.getScene().setRoot(startview);
                    startview.getScene().getWindow().sizeToScene();
                }
            }
        });

        view.getEnd().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EndView endview = new EndView();
                EndViewPresenter endViewPresenter = new EndViewPresenter(model, endview);
                Stage endStage = new Stage();
                endStage.initOwner(view.getScene().getWindow());
                endStage.initModality(Modality.APPLICATION_MODAL);
                endStage.setScene(new Scene(endview));
                endStage.showAndWait();

                if (endViewPresenter.getResult() == null) {

                } else if (endViewPresenter.getResult().equals(endview.getBtnRestart())) {
                    resetSpel();
                } else if (endViewPresenter.getResult().equals(endview.getBtnHome())) {
                    StartView startView = new StartView();
                    StartViewPresenter startViewPresenter = new StartViewPresenter(model, startView);
                    Stage startStage = new Stage();
                    startStage.setScene(new Scene(startView));
                    startViewPresenter.addWindowEventHandlers();
                    startStage.show();
                    view.getEnd().getScene().getWindow().hide();
                    startStage.toFront();
                }

                //score manager
                Score.HighScoreManager hm = new Score.HighScoreManager();
                hm.addScore(model.getSpeler().getNaam(), model.getSpeler().getTotaalScore(), model.getLevel().getGamelevel());
            }
        });


    }

    private void updateView() {
        /*if (stopwatchTimeline.getStatus().equals(Animation.Status.STOPPED)) {
            endStatus();
        }*/

        for (int i = 0; i < model.getSpeelveld().length; i++) {
            for (int j = 0; j < model.getSpeelveld().length; j++) {
                Kleuren kleur = model.getDotUitSpeelveld(i, j).getKleur();
                view.getButtonFromBtns(j, i).setStyle(String.format("-fx-background-color: rgb(%d, %d, %d)", kleur.getRed(), kleur.getGreen(), kleur.getBlue()));
            }
        }

        view.getScore().setText(String.valueOf(model.getSpeler().getGameScore()));
        String tekst = "Level  " + model.getLevel().getGamelevel();
        view.getLevel().setText(tekst);
        view.getTargetScore().setText(String.valueOf(model.getLevel().getTargetScore()));
        view.getLblSpelerNaam().setText(String.valueOf(model.getSpeler().getNaam()));
    }

    public void addWindowEventHandlers() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Hierdoor stop je het spel zonder te saven!");
                alert.setContentText("Wil je dit zeker?");
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

    private void setupTimelineBasis() {
        stopwatchTimeline = new Timeline(new KeyFrame(Duration.millis(this.model.getTickDurationMillis()), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (model.getSeconds() == 0) {
                    endStatus();
                } else {
                    model.tick();
                    view.getLblTimer().setText(String.format("%02d", (model.getSeconds())));
                }
            }
        }));
        stopwatchTimeline.setCycleCount(Animation.INDEFINITE);
    }

    private void endStatus() {
        if (model.getSpeler().getGameScore() >= model.getLevel().getTargetScore()) {
            model.resetTimer();
            model.getLevel().nextLevel();
            model.resetSpel();
            model.getSpeler().addPuntenTotaalScore(model.getSpeler().getGameScore());
            model.getSpeler().setGameScore(0);
            view.getLevel().setText(String.valueOf(model.getLevel().getGamelevel()));
            view.getScore().setText(String.valueOf(model.getSpeler().getGameScore()));

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Next Level");
            alert.setHeaderText("Je gaat naar level " + model.getLevel().getGamelevel());
            alert.getButtonTypes().clear();
            alert.getButtonTypes().add(ButtonType.OK);
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION, stopwatchTimeline.getStatus().name());
            alert2.show();
            alert.showAndWait();

            stopwatchTimeline.stop();
            stopwatchTimeline.play();

            updateView();
        } else {
            endGame();
        }
    }

    private void endGame() {
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Einde spel");
        alert.setHeaderText("Je hebt de targetscore niet bereikt, je spel wordt afgesloten");
        alert.getButtonTypes().clear();
        alert.getButtonTypes().add(ButtonType.OK);
        alert.showAndWait();

        //Endview tonen
        EndView endview = new EndView();
        EndViewPresenter endViewPresenter = new EndViewPresenter(model, endview);
        Stage endStage = new Stage();
        endStage.initOwner(view.getScene().getWindow());
        endStage.initModality(Modality.APPLICATION_MODAL);
        endStage.setScene(new Scene(endview));
        endStage.showAndWait();

        if (endViewPresenter.getResult() == null) {

        } else if (endViewPresenter.getResult().equals(endview.getBtnRestart())) {
            resetSpel();
        } else if (endViewPresenter.getResult().equals(endview.getBtnHome())) {
            StartView startView = new StartView();
            StartViewPresenter startViewPresenter = new StartViewPresenter(model, startView);
            Stage startStage = new Stage();
            startStage.setScene(new Scene(startView));
            startViewPresenter.addWindowEventHandlers();
            startStage.show();
            view.getEnd().getScene().getWindow().hide();
            startStage.toFront();
        }
        //score manager
        Score.HighScoreManager hm = new Score.HighScoreManager();
        hm.addScore(model.getSpeler().getNaam(), model.getSpeler().getTotaalScore(), model.getLevel().getGamelevel());
    }

    private void resetSpel() {
        stopwatchTimeline.stop();

        SpelView nieuwView = new SpelView();
        SpelViewPresenter nieuwPresenter = new SpelViewPresenter(new Dots(), nieuwView);

        view.getScene().setRoot(nieuwView);
    }
}
