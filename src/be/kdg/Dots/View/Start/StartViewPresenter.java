package be.kdg.Dots.View.Start;

import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.View.Spel.SpelView;
import be.kdg.Dots.View.Spel.SpelViewPresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;



/**
 * @author Cédric Goffin
 * @version 1.0 6/02/2017 22:21
 */
public class StartViewPresenter {
    private Dots model;
    private StartView view;

    public StartViewPresenter(Dots model, StartView view) {
        this.model = model;
        this.view = view;

        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getBtnStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SpelView spelview = new SpelView();
                SpelViewPresenter spelviewpresenter = new SpelViewPresenter(model, spelview);
                view.getScene().setRoot(spelview);
                spelview.getScene().getWindow().sizeToScene();
            }
        });
        //Naar spelview
        //spel (timer) pas starten na dat promt is ingevult

    }

    private void updateView() {

    }

    public void addWindowEventHandlers() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Hierdoor stop je het spel!");
                alert.setContentText("Ben je zeker dat je wilt afsluiten?");
                alert.setTitle("Opgelet!");
                alert.getButtonTypes().clear();
                ButtonType neen = new ButtonType("Neen");
                ButtonType ja = new ButtonType("Ja");
                alert.getButtonTypes().addAll(neen, ja);
                alert.showAndWait();
                if (alert.getResult() == null || alert.getResult().equals(neen)) {

                    event.consume();

                }
            }
        });
    }
}
