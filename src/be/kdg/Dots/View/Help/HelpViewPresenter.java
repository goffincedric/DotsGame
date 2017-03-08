package be.kdg.Dots.View.Help;

import be.kdg.Dots.Model.Dots;
import javafx.scene.web.WebEngine;

/**
 * @author Cédric Goffin
 * @version 1.0 8/03/2017 11:21
 */
public class HelpViewPresenter {
    private Dots model;
    private HelpView view;
    private WebEngine engine;

    public HelpViewPresenter(Dots model, HelpView view) {
        this.model = model;
        this.view = view;
        this.engine = new WebEngine();
        addEventHandlers();
    }

    private void addEventHandlers() {
    }

    private void updateView() {

    }
}
