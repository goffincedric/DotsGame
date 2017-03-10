package be.kdg.Dots.View.Help;

import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.View.Start.StartView;
import be.kdg.Dots.View.Start.StartViewPresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 8/03/2017 11:21
 */

public class HelpViewPresenter {
    private Dots model;
    private HelpView view;

    public HelpViewPresenter(Dots model, HelpView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getBtnHome().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StartView startView = new StartView();
                StartViewPresenter startViewPresenter = new StartViewPresenter(model, startView);
                view.getScene().setRoot(startView);
                startView.getScene().getWindow().sizeToScene();
            }
        });
    }

    private void updateView() {
        view.getWebView().getEngine().load(getClass().getResource("Help/Help.html").toExternalForm());
    }
}
