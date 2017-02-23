package be.kdg.Dots.View.Start;

import be.kdg.Dots.Model.Dots;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 22:21
 */
public class StartViewPresenter{
    private Dots model;
    private StartView view;

    public StartViewPresenter(Dots model, StartView view) {
        this.model = model;
        this.view = view;

        addEventHandlers();
        updateView();
    }

    private void addEventHandlers(){

        //Naar spelview
        //spel (timer) pas starten na dat promt is ingevult
        TextInputDialog dialogNaam = new TextInputDialog();
        dialogNaam.setTitle("Speler");
        dialogNaam.setContentText("Please enter your name: ");

        Optional<String> result = dialogNaam.showAndWait();
        if(result.isPresent()){
        model.getSpeler().setNaam(result.get());
        }
    }

    private void updateView() {

    }

    public void addWindowEventHandlers() {

    }
}
