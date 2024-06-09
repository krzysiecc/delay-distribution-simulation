package org.dds.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class EntrySceneController {

    @FXML
    private void switchToMainScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("MainScene.fxml")));
        Stage primaryStage = (Stage) ( (javafx.scene.Node) event.getSource() ).getScene().getWindow();
        primaryStage.setScene(new Scene(root));
    }

}
