package be.kdg;

import be.kdg.Dots.Model.Dots;
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
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) {
        Scanner k = new Scanner(System.in);
        System.out.printf("Kies een versie:\nConsole: 1\nGrafisch: 2\n\nGeef uw keuze in: ");

        switch (k.nextInt()) {
            case 1:
                MainConsole dotsConsole = new MainConsole();

                dotsConsole.main(new String[] {""});

                break;
            case 2:
                Dots model = new Dots();
                StartView view = new StartView();

                StartViewPresenter presenter = new StartViewPresenter(model, view);

                primaryStage.setTitle("Dots");
                primaryStage.setScene(new Scene(view));
                primaryStage.show();
                break;
            default:
                System.out.println("Foute invoer, als straf krijg je de console versie 3:)");

        }

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void navigateToStart() {

    }

}
