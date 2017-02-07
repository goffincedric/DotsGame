package be.kdg.Dots.View.Spel;

import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.View.Presenter;
import be.kdg.Dots.View.Spel.SpelView;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 22:21
 */
public class SpelViewPresenter extends Presenter{
    private Dots model;
    private SpelView view;

    public SpelViewPresenter(Dots model, SpelView view) {
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
