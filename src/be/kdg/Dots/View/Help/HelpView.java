package be.kdg.Dots.View.Help;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;

/**
 * @author Cédric Goffin
 * @version 1.0 8/03/2017 11:21
 */

public class HelpView extends BorderPane {
    private WebView webView;
    private Button btnHome;
    private ImageView home;

    public HelpView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.webView = new WebView();
        this.btnHome = new Button();
        this.home = new ImageView(new Image("be/kdg/Dots/View/images/Home.png"));
    }

    private void layoutNodes() {
        this.setTop(webView);
        this.setCenter(btnHome);
        btnHome.setPrefSize(50, 50);
        home.setFitHeight(50);
        home.setFitWidth(50);
        home.setPreserveRatio(true);

        btnHome.setGraphic(home);
    }

    public Button getBtnHome() {
        return btnHome;
    }

    public WebView getWebView() {
        return webView;
    }
}
