package be.kdg;

import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.View.Start.StartView;
import be.kdg.Dots.View.Start.StartViewPresenter;
import javafx.application.Application;
import javafx.scene.Scene;
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
        primaryStage.show();
        primaryStage.toFront();

        /*Scanner k = new Scanner(System.in);
        System.out.printf("Kies een versie:\nConsole: 1\nGrafisch: 2\n\nGeef uw keuze in: ");

        switch (k.nextInt()) {
            case 1:
                MainConsole dotsConsole = new MainConsole();

                dotsConsole.main(new String[]{""});
                break;
            case 2:
                model = new Dots();
                StartView view = new StartView();
                StartViewPresenter presenter = new StartViewPresenter(model, view);
                Scene scene = new Scene(view);
                scene.getStylesheets().add("stylesheets/css.css");
                primaryStage.setTitle("Dots");
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                presenter.addWindowEventHandlers();
                primaryStage.show();
                primaryStage.toFront();

                break;
            default:
                System.out.println("Foute invoer, als straf krijg je de console versie:)");
                break;

        }*/


    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
