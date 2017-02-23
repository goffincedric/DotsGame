package be.kdg.Dots.View.Start;

import be.kdg.Dots.Model.Dots;


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

    }

    private void updateView() {

    }

    public void addWindowEventHandlers() {

    }
}
