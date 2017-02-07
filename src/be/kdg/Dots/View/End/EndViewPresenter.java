package be.kdg.Dots.View.End;

import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.View.End.EndView;
import be.kdg.Dots.View.Presenter;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 22:21
 */
public class EndViewPresenter extends Presenter{
    private Dots model;
    private EndView view;

    public EndViewPresenter(Dots model, EndView view) {
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
