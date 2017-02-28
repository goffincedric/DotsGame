package be.kdg.Dots.View.End;

import be.kdg.Dots.Model.Dots;

/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 22:21
 */
public class EndViewPresenter {
    private Dots model;
    private EndView view;

    public EndViewPresenter(Dots model, EndView view) {
        this.model = model;
        this.view = view;

        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {

    }

    private void updateView() {
        view.getLblHuidigeScore().setText(String.valueOf(model.getSpeler().getTotaalScore()));
        view.getLblHuidigLevel().setText(String.valueOf(model.getLevel().getGamelevel()));
    }

    public void addWindowEventHandlers() {


    }
}
