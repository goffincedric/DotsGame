package be.kdg.Dots.View.Help;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;

/**
 * @author Cédric Goffin
 * @version 1.0 8/03/2017 11:21
 */
public class HelpView extends BorderPane {
    private WebView webView;
    private Button btnHome;

    public HelpView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.webView = new WebView();
    }

    private void layoutNodes() {
        this.setTop(webView);
        this.setLeft(btnHome);
    }

    public Button getBtnHome() {
        return btnHome;
    }

    public WebView getWebView() {
        return webView;
    }
}
