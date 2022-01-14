package com.example.flyhigh;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SuccessController {

    @FXML
    private Button contactsBtn;

    @FXML
    private Button menuBtn;

    @FXML
    void initialize()
    {
        menuBtn.setOnAction(actionEvent ->
        {
            menuBtn.getScene().getWindow().hide();
            openNewScene("FlyHigh-view.fxml");
        });

        contactsBtn.setOnAction(event -> {
            contactsBtn.getScene().getWindow().hide();
            openNewScene("Contacts-view.fxml");
        });
    }

    private void openNewScene(String window)        //method that will open new window
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
