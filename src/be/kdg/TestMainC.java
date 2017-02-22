package be.kdg;

import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.View.Spel.SpelView;
import be.kdg.Dots.View.Spel.SpelViewPresenter;
import be.kdg.DotsConsole.MainConsole;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:36
 */
public class TestMainC extends Application {
    private Dots model;

    @Override
    public void start(Stage primaryStage) {
        Scanner k = new Scanner(System.in);
        System.out.printf("Kies een versie:\nConsole: 1\nGrafisch: 2\n\nGeef uw keuze in: ");

        switch (k.nextInt()) {
            case 1:
                MainConsole dotsConsole = new MainConsole();

                dotsConsole.main(new String[]{""});
                break;
            case 2:
                model = new Dots();
                SpelView view = new SpelView();
                SpelViewPresenter presenter = new SpelViewPresenter(model, view);
                Scene scene = new Scene(view);
                scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Gloria+Hallelujah");
                primaryStage.setTitle("Dots");
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.show();
                primaryStage.toFront();
                break;
            default:
                System.out.println("Foute invoer, als straf krijg je de console versie:)");
                break;

        }

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
