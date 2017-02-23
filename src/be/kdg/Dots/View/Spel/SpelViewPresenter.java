package be.kdg.Dots.View.Spel;


import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.Model.DotsException;
import be.kdg.Dots.Model.Kleuren;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

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
                        model.getLijn().addDot(model.getDotUitSpeelveld(view.getDotsGrid().getRowIndex(node).intValue(), view.getDotsGrid().getColumnIndex(node).intValue()));

                        Kleuren kleur = model.getLijn().getLijn().get(0).getKleur();
                        view.getButtonFromBtns(view.getDotsGrid().getColumnIndex(node).intValue(), view.getDotsGrid().getRowIndex(node).intValue()).setStyle("-fx-background-color: antiquewhite");


                    } catch (DotsException e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                        alert.showAndWait();
                    }
                }
            });
        }
    }

    private void updateView() {
        for (int i = 0; i < model.getSpeelveld().length; i++) {
            for (int j = 0; j < model.getSpeelveld().length; j++) {
                Kleuren kleur = model.getDotUitSpeelveld(i, j).getKleur();
                view.getButtonFromBtns(j, i).setStyle(String.format("-fx-background-color: rgb(%d, %d, %d)", kleur.getRed(), kleur.getGreen(), kleur.getBlue()));
            }
        }
        
        /*for (Button[] buttons : view.getBtns()) {
            for (Button button : buttons) {
                button.setStyle(String.format("-fx-background-color: rgb(%d, %d, %d)", model.));
            }
        }*/

        view.getScore().setText(String.valueOf(model.getSpeler().getScore()));
        view.getLevel().setText(String.valueOf(model.getLevel().getGamelevel()));
        view.getTargetScore().setText(String.valueOf( model.getLevel().getTargetScore()));
        view.getLblSpelerNaam().setText(String.valueOf(model.getSpeler().getNaam()));
    }

    public void addWindowEventHandlers() {


    }

}
