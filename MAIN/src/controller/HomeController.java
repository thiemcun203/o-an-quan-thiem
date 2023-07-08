package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

    @FXML
    private Button btnExit;

    @FXML
    private Button btnHelp;

    @FXML
    private Button btnPlay;

    @FXML
    private void initialize() {
        btnPlay.setOnAction(event -> {
            System.out.println("Play button pressed");
        });
        
    }

}

