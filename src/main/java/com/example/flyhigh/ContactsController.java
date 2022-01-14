package com.example.flyhigh;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ContactsController {

    @FXML
    private Button backHomebtn;

    @FXML
    private TextField emailContact;

    @FXML
    private TextField messageContact;

    @FXML
    private TextField nameContact;

    @FXML
    private Button submitbtn;

    @FXML
    void initialize()
    {
        backHomebtn.setOnAction(actionEvent ->
        {
            backHomebtn.getScene().getWindow().hide();      //to hide this scene
            openNewScene("FlyHigh-view.fxml");      //open main window

        });
        submitbtn.setOnAction(actionEvent -> {

            String name = nameContact.getText();
            String email = emailContact.getText();
            String message = messageContact.getText();
            String[] contactname = {"Name: " + name, "Email: " + email,"Message: " + message};     //array that will take
                                                                                                  //data to contact us
            for (int i = 0; i < contactname.length; i++) {          //loop to show this message in console
                System.out.println(contactname[i]);
            }
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
