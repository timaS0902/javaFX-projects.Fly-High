package com.example.flyhigh;

import com.example.flyhigh.animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class FlyHighController {

    @FXML
    private Button clearBtn;

    @FXML
    private Button contactsBtn;

    @FXML
    private DatePicker dateOfFly_picker;

    @FXML
    private TextField from_field;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField where_field;

    @FXML
    private Button flightsbtn;

    @FXML
    void initialize() {
        flightsbtn.setOnAction(actionEvent ->           //this button will show all flights without from and where fields
        {
            flightsbtn.getScene().getWindow().hide();       //hide this window
            openNewScene("Search-view.fxml");       //open new window search
        });

        dateOfFly_picker.setOnAction(actionEvent ->
        {
            LocalDate time = dateOfFly_picker.getValue();       //data picker of flight
            System.out.println(time);
        });

        searchBtn.setOnAction(event ->
        {
            searchBtn();                //method that will see if text field empty and then go to search window
        });

        contactsBtn.setOnAction(event -> {
            contactsBtn.getScene().getWindow().hide();
            openNewScene("Contacts-view.fxml");
        });

        clearBtn.setOnAction(actionEvent -> {
            from_field.clear();         //clear text fields
            where_field.clear();
        });
    }

    private void loginUser(String fromField, String whereField) {
    }

    private void searchBtn()
    {
        String fromField = from_field.getText().trim();         //delete space
        String whereField = where_field.getText().trim();
        //we see if from and where field are empty
        if (!fromField.equals("") && !whereField.equals("")) {      //condition if text field are empty
            loginUser(fromField, whereField);

            sortData();
            searchBtn.getScene().getWindow().hide();
            openNewScene("Search-view.fxml");           //go to search window

        } else if (fromField.equals(""))
        {
            Shake fromEmpty = new Shake(from_field);            //animation
            fromEmpty.playAnim();
        } else
        {
            Shake whereEmpty = new Shake(where_field);          //animation if where field is empty
            whereEmpty.playAnim();
        }
    }

    public void sortData()      //future improvement | data in array "dataFlight" will sort data in table in "SearchController"
    {
        String from = from_field.getText();
        String where = where_field.getText();
        String date = String.valueOf(dateOfFly_picker.getValue());
        String[] dataFlight = {from, where, date};

        for (String s : dataFlight) {
            System.out.println(s);
        }
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

