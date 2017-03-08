package be.kdg.Dots.View.Help;

import be.kdg.Dots.Model.Dots;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;

/**
 * @author Cédric Goffin
 * @version 1.0 8/03/2017 11:21
 */

public class HelpViewPresenter {
    private Dots model;
    private HelpView view;
    private WebEngine engine;
    private Button result;

    public HelpViewPresenter(Dots model, HelpView view) {
        this.model = model;
        this.view = view;
        this.engine = new WebEngine();
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBtnHome().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result = view.getBtnHome();
                view.getScene().getWindow().hide();
            }
        });
    }

    private void updateView() {
        view.getWebView();
    }

    public Button getResult() {
        return result;
    }
}
