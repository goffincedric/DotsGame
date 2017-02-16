package be.kdg;

import be.kdg.Dots.Model.Dots;
import be.kdg.Dots.Model.Level;
import be.kdg.Dots.Model.Lijn;
import be.kdg.Dots.Model.Speler;
import be.kdg.Dots.View.Spel.SpelView;
import be.kdg.Dots.View.Spel.SpelViewPresenter;
import be.kdg.Dots.View.Start.StartView;
import be.kdg.Dots.View.Start.StartViewPresenter;
import be.kdg.DotsConsole.MainConsole;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:36
 */
public class Main extends Application {
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

                primaryStage.setTitle("Dots");
                primaryStage.setScene(new Scene(view));
                primaryStage.show();
                primaryStage.setResizable(false);

                break;
            default:
                System.out.println("Foute invoer, als straf krijg je de console versie:)");
                break;

        }

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
/*Vervangen door 'in presenter oproepen naar een 'setRoot methode'
    public void navigateTo(String naamView) {
        switch (naamView) {
            case "Spel":
                SpelView view = new SpelView();
                SpelViewPresenter presenter = new SpelViewPresenter(model, view);


                break;
            case "Start":

                break;
            case "Pauze":

                break;
            case "End":

                break;

        }

    }
    */
}
