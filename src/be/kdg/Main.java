package be.kdg;

import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.View.Start.StartView;
import be.kdg.Dots.View.Start.StartViewPresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 5/02/2017 14:36
 */
public class Main extends Application {
    private Dots model;


    @Override
    public void start(Stage primaryStage) {
        model = new Dots();
        StartView view = new StartView();
        StartViewPresenter presenter = new StartViewPresenter(model, view);
        Scene scene = new Scene(view);
        primaryStage.setTitle("Dots");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        presenter.addWindowEventHandlers();
        primaryStage.getIcons().add(new Image("be/kdg/Dots/images/Logo.png"));
        primaryStage.toFront();
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
