package be.kdg;

import be.kdg.Dots.Dots;
import be.kdg.DotsConsole.DotsConsole;
import be.kdg.DotsConsole.MainConsole;
import com.sun.org.apache.xpath.internal.Arg;
import com.sun.tracing.dtrace.ArgsAttributes;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import jdk.nashorn.internal.runtime.regexp.joni.constants.Arguments;

import java.util.Scanner;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:36
 */
public class Main extends Application{
    private Button[][] btns = new Button[7][7];

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
                Dots dotsGrafic = new Dots();


                break;
            default:
                System.out.println("Foute invoer, als straf krijg je de console versie 3:)");

        }

        /*
            Dots rooster opbouw code
         */

    }
/*
        initBtnsArray();
        Group root = new Group();
        root.getChildren().add(getGrid());
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Dots");
        primaryStage.setScene(scene);


        for(int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
                GridPane.setMargin(btns[i][j], new Insets(5));
                btns[i][j].setStyle(" -fx-background-color: #000000, linear-gradient(#7ebcea, #2f4b8f), linear-gradient(#426ab7, #263e75), linear-gradient(#395cab, #223768); -fx-background-insets: 0,1,2,3; -fx-background-radius: 3,2,2,2; -fx-padding: 12 30 12 30;");
            }
        }
        primaryStage.show();

    }

    private Pane getGrid() {


        GridPane gridPane = new GridPane();
        for(int i = 0; i < btns.length; i++) {
            for(int j= 0; j < btns[i].length;j++){
                gridPane.add(btns[i][j],i,j);
            }

        }
        return gridPane;
    }

    private void initBtnsArray() {
        for(int i = 0; i < btns.length; i++) {
            for(int j= 0; j < btns[i].length;j++){
                btns[i][j] = new Button();
            }

        }
    }*/

    public static void main(String[] args) {
        Application.launch(args);
    }

}
