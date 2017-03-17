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
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.net.URISyntaxException;
import java.util.Optional;

/**
 * Deze presenter zorgt voor de samenwerking tussen het model en de Spelview.
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 6/02/2017 22:21
 */

public class SpelViewPresenter {
    private Dots model;
    private SpelView view;
    TextInputDialog dialogNaam;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private Timeline stopwatchTimeline;

    public SpelViewPresenter(Dots model, SpelView view) {
        this.model = model;
        this.view = view;
        dialogNaam = new TextInputDialog();

        boolean naamIngegeven;
        do {
            naamIngegeven = false;
            dialogNaam.setTitle("Speler");
            dialogNaam.setHeaderText("Geef uw naam in: ");

            Optional<String> result = dialogNaam.showAndWait();

            if (result.isPresent()) {
                if (!result.get().isEmpty()) {
                    this.model.getSpeler().setNaam(result.get());
                    naamIngegeven = true;
                }
            } else if (!result.isPresent()) {
                StartView startView = new StartView();
                StartViewPresenter startViewPresenter = new StartViewPresenter(new Dots(), startView);
                view.getScene().setRoot(startView);
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


        for (Node node : view.getDotsGrid().getChildren()) {
            node.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        model.getLijn().addDot(model.getDotUitSpeelveld(view.getDotsGrid().getRowIndex(node), view.getDotsGrid().getColumnIndex(node)));

                        Kleuren kleur = model.getLijn().getLijn().get(0).getKleur();
                        view.getButtonFromBtns(view.getDotsGrid().getColumnIndex(node), view.getDotsGrid().getRowIndex(node)).setStyle(
                                String.format("-fx-effect: dropshadow(three-pass-box, black, 3, 3, 0, 0); -fx-background-color: rgb(%d, %d, %d)", kleur.getRed(), kleur.getGreen(), kleur.getBlue())
                        );

                        view.setStyle(String.format("-fx-background-color: rgba(%d, %d, %d, 0.3); -fx-transition: 0.5s;", kleur.getRed(), kleur.getGreen(), kleur.getBlue()));
                    } catch (DotsException e) {
                        if (!model.getLijn().getHeeftToegevoegd()) {
                            Kleuren kleur = model.getDotUitSpeelveld(view.getDotsGrid().getRowIndex(node), view.getDotsGrid().getColumnIndex(node)).getKleur();
                            view.getButtonFromBtns(view.getDotsGrid().getColumnIndex(node), view.getDotsGrid().getRowIndex(node)).setStyle(
                                    String.format("-fx-background-color: rgb(%d, %d, %d)", kleur.getRed(), kleur.getGreen(), kleur.getBlue())
                            );
                        }
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Fout");
                        alert.setHeaderText(e.getMessage());
                        alert.getButtonTypes().clear();
                        alert.getButtonTypes().add(ButtonType.OK);
                        alert.showAndWait();
                    }
                }
            });
        }

        view.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    if (model.getLijn().getAantalDots() < 2) {

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Fout");
                        alert.setHeaderText("Lijn moet minstens 2 dots bevatten!");
                        alert.getButtonTypes().clear();
                        alert.getButtonTypes().add(ButtonType.OK);
                        alert.showAndWait();
                    } else {
                        if (model.getSound()) {
                            try {
                            String musicFile = getClass().getResource("sound.mp3").toURI().toString();
                            Media media = new Media(musicFile);
                            MediaPlayer mediaPlayer = new MediaPlayer(media);

                            mediaPlayer.setStartTime(Duration.ZERO);
                            mediaPlayer.seek(Duration.ZERO);
                            mediaPlayer.play();
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                        }

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
                }

            }
        });


        view.getBtnPause().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stopwatchTimeline.stop();

                PauseView pauseview = new PauseView();
                PauseViewPresenter pauseviewpresenter = new PauseViewPresenter(model, pauseview);
                Stage pauseStage = new Stage();
                pauseStage.getIcons().add(new Image("be/kdg/Dots/Images/Logo.png"));
                pauseStage.setTitle("Dots");
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
                    StartView startView = new StartView();
                    StartViewPresenter startViewPresenter = new StartViewPresenter(new Dots(), startView);
                    Stage startStage = new Stage();
                    startStage.setTitle("Dots");
                    startStage.getIcons().add(new Image("be/kdg/Dots/Images/Logo.png"));
                    startStage.setScene(new Scene(startView));
                    startViewPresenter.addWindowEventHandlers();
                    startStage.show();
                    view.getBtnEnd().getScene().getWindow().hide();
                    startStage.toFront();
                }
            }
        });

        view.getBtnEnd().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stopwatchTimeline.stop();
                endGame();
            }
        });
    }

    private void updateView() {
        for (int i = 0; i < model.getSpeelveld().length; i++) {
            for (int j = 0; j < model.getSpeelveld().length; j++) {
                Kleuren kleur = model.getDotUitSpeelveld(i, j).getKleur();
                view.getButtonFromBtns(j, i).setStyle(String.format("-fx-background-color: rgb(%d, %d, %d)", kleur.getRed(), kleur.getGreen(), kleur.getBlue()));
            }
        }

        view.getLblScore().setText(String.valueOf(model.getSpeler().getGameScore()));
        String tekst = "Level  " + model.getLevel().getGamelevel();
        view.getLblLevel().setText(tekst);
        view.getLblTargetScore().setText(String.valueOf(model.getLevel().getTargetScore()));
        view.getLblSpelerNaam().setText(String.valueOf(model.getSpeler().getNaam()));
        view.getLblTimer().setText(String.format("%02d", model.getSeconds()));
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

    /**
     * Hier wordt de timeline op gebouwd.
     * Waneer de timer afloopt zal naar de methode endStatus() gegaan worden.
     */
    private void setupTimelineBasis() {
        stopwatchTimeline = new Timeline(new KeyFrame(Duration.millis(this.model.getTickDurationMillis()), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (model.getSeconds() != 0) {
                    if (!alert.isShowing()) {
                        model.tick();
                    }
                    view.getLblTimer().setText(String.format("%02d", model.getSeconds()));
                } else {
                    endStatus();
                }
            }
        }));
        stopwatchTimeline.setCycleCount(Animation.INDEFINITE);
    }

    /**
     * Als de timer afloopt wordt deze methode opgeroepen.
     * Er wordt gekeken of je de targetscore van jouw level bereikt hebt.
     * Als dit zo is worden je gebruikte dots verwijderd, je gamescore wordt toevoegd aan je totaalscore.
     * En de timer wordt gereset. Je zal naar het volgende level gaan.
     */
    private void endStatus() {
        stopwatchTimeline.stop();
        if (model.getSpeler().getGameScore() >= model.getLevel().getTargetScore()) {
            if (model.getLijn().getLijn().size() >= 2) {
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

            model.resetTimer();
            model.getLevel().nextLevel();
            model.resetSpel();
            model.getSpeler().setGameScore(0);
            view.getLblLevel().setText(String.valueOf(model.getLevel().getGamelevel()));
            view.getLblScore().setText(String.valueOf(model.getSpeler().getGameScore()));

            alert.setTitle("Next Level");
            alert.setHeaderText("Je gaat naar level " + model.getLevel().getGamelevel());
            alert.getButtonTypes().clear();
            alert.getButtonTypes().add(ButtonType.OK);
            alert.show();

            stopwatchTimeline.play();

            updateView();
        } else {
            endGame();
        }
    }

    /**
     * Hier in deze methode wordt de EndView opgeroepen.
     * Ook wordt highscore bepaald. Waneer je in de top 10 komt wordt je plaats getoont samen met je score en behaaldlevel.
     */
    private void endGame() {
        //Endview tonen
        EndView endview = new EndView();
        EndViewPresenter endViewPresenter = new EndViewPresenter(model, endview);
        Stage endStage = new Stage();
        endStage.getIcons().add(new Image("be/kdg/Dots/Images/Logo.png"));
        endStage.setTitle("Dots");
        endStage.initOwner(view.getScene().getWindow());
        endStage.initModality(Modality.APPLICATION_MODAL);
        endStage.setScene(new Scene(endview));
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                endStage.showAndWait();
                if (endViewPresenter.getResult() == null) {
                    newStartView();
                } else if (endViewPresenter.getResult().equals(endview.getBtnRestart())) {
                    resetSpel();
                } else if (endViewPresenter.getResult().equals(endview.getBtnHome())) {
                    newStartView();
                }
                //score manager
                Score.HighScoreManager hm = new Score.HighScoreManager();
                hm.addScore(model.getSpeler().getNaam(), model.getSpeler().getTotaalScore(), model.getLevel().getGamelevel());
            }
        });

    }


    /**
     * In deze methode wordt er een nieuwe StartView gemaakt wanneer deze wordt opgeroepen.
     */
    private void newStartView() {
        StartView startView = new StartView();
        StartViewPresenter startViewPresenter = new StartViewPresenter(new Dots(), startView);
        Stage startStage = new Stage();
        startStage.getIcons().add(new Image("be/kdg/Dots/Images/Logo.png"));
        startStage.setTitle("Dots");
        startStage.setScene(new Scene(startView));
        startViewPresenter.addWindowEventHandlers();
        startStage.show();
        view.getBtnEnd().getScene().getWindow().hide();
        startStage.toFront();
    }

    /**
     * Wanneer je het spel opnieuw laat starten wordt er een nieuwe spelview gemaakt die de oude vervangt.
     */
    private void resetSpel() {
        stopwatchTimeline.stop();
        SpelView nieuwView = new SpelView();
        SpelViewPresenter nieuwPresenter = new SpelViewPresenter(new Dots(), nieuwView);
        view.getScene().setRoot(nieuwView);
    }
}
