package be.kdg.Dots.View.Spel;


import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.Model.DotsException;
import be.kdg.Dots.Model.Kleuren;
import be.kdg.Dots.View.End.EndView;
import be.kdg.Dots.View.End.EndViewPresenter;
import be.kdg.Dots.View.Pause.PauseView;
import be.kdg.Dots.View.Pause.PauseViewPresenter;
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

import java.util.Optional;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 22:21
 */
public class SpelViewPresenter {
    private Dots model;
    private SpelView view;

    public SpelViewPresenter(Dots model, SpelView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers(){
        TextInputDialog dialogNaam = new TextInputDialog();
        dialogNaam.setTitle("Speler");
        dialogNaam.setContentText("Please enter your name: ");

        Optional<String> result = dialogNaam.showAndWait();
        if(result.isPresent()){
            model.getSpeler().setNaam(result.get());
        }

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
                        Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                        alert.showAndWait();
                    }
                }
            });
        }
        //pauze view openen

        view.setOnKeyReleased(new EventHandler<KeyEvent>() {
        final KeyCombination KeyShiftD = new KeyCodeCombination(KeyCode.D,KeyCombination.CONTROL_DOWN);
            @Override
            public void handle(KeyEvent event) {
                if (KeyShiftD.match(event)) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("ADD SCORE");
                    alert.setHeaderText("het werkt");
                    alert.getButtonTypes().clear();
                    alert.getButtonTypes().add(ButtonType.CLOSE);
                    alert.showAndWait();
                }
            }
        });

        view.getPause().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PauseView pauseview = new PauseView();
                PauseViewPresenter pauseviewpresenter = new PauseViewPresenter(model, pauseview);
                Stage pauseStage = new Stage();
                pauseStage.initOwner(view.getScene().getWindow());
                pauseStage.initModality(Modality.APPLICATION_MODAL);
                pauseStage.setScene(new Scene(pauseview));
                pauseStage.showAndWait();
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

        view.getScore().setText(String.valueOf(model.getSpeler().getScore()));
        String tekst = "Level  " + model.getLevel().getGamelevel();
        view.getLevel().setText(tekst);
        view.getTargetScore().setText(String.valueOf( model.getLevel().getTargetScore()));
        view.getLblSpelerNaam().setText(String.valueOf(model.getSpeler().getNaam()));
    }



    public void addWindowEventHandlers() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Hierdoor stop je het spel zonder te saven!");
                alert.setContentText("Wil je dit zeker?");
                alert.setTitle("Opgelet!");
                alert.getButtonTypes().clear();
                ButtonType neen = new ButtonType("Neen");
                ButtonType ja = new ButtonType("Ja");
                alert.getButtonTypes().addAll(neen, ja);
                alert.showAndWait();
                if (alert.getResult() == null || alert.getResult().equals(neen)) {
                    event.consume();
                }
            }
        });

    }


}
