package be.kdg.Dots.View;

import be.kdg.Dots.Model.Dots;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 22:21
 */
public class DotsPresenter {
    private Dots model;
    private SpelView view;

    public DotsPresenter(Dots model, SpelView view) {
        this.model = model;
        this.view = view;

        addEventHandlers();
        updateView();
    }

    private void addEventHandlers(){

    }

    private void updateView() {

    }
}
