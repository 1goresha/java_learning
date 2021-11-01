package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imageHome;

    @FXML
    void initialize() {
        assert imageHome != null : "fx:id=\"imageHome\" was not injected: check your FXML file 'home.fxml'.";

    }
}
