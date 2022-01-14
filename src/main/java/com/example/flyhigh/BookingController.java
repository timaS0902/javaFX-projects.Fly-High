package com.example.flyhigh;

import com.example.flyhigh.animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class BookingController {

    @FXML
    private Button addNewBtn;

    @FXML
    private Button backbtn;

    @FXML
    private TextField charPassportField;

    @FXML
    private Button clearBtn;

    @FXML
    private TextField emailAdress_field;

    @FXML
    private TextField first_name_field;

    @FXML
    private TextField last_name_field;

    @FXML
    private TextField middle_name_field;

    @FXML
    private TextField numPassportField;

    @FXML
    private Button registerBtn;

    @FXML
    void initialize()
    {
        registerBtn.setOnAction(actionEvent ->
        {
            sighUpNewUser();                //method that will create new user in mysql database
            registerBtn.getScene().getWindow().hide();
            openNewScene("Success-view.fxml");
        });

        addNewBtn.setOnAction(actionEvent ->
        {
            sighUpNewUser();
            Shake addbtn = new Shake(addNewBtn);        //animation if text field are empty
            addbtn.playAnim();
        });

        clearBtn.setOnAction(actionEvent ->     //clean text from text field
        {
            first_name_field.clear();
            middle_name_field.clear();
            last_name_field.clear();
            charPassportField.clear();
            numPassportField.clear();
            emailAdress_field.clear();
        });

        backbtn.setOnAction(actionEvent ->
        {
            backbtn.getScene().getWindow().hide();      //to hide this scene
            openNewScene("Search-view.fxml");       //open search scene
        });
    }

    private void sighUpNewUser() {

        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = first_name_field.getText().trim();       //delete spaces, we see if text field are empty
        String middleName = middle_name_field.getText().trim();
        String lastName = last_name_field.getText().trim();
        String charPass = charPassportField.getText().trim();
        String numPass = numPassportField.getText().trim();
        String emailAddress = emailAdress_field.getText().trim();

        if(!firstName.equals("") && !middleName.equals("") && !lastName.equals("") && !charPass.equals("") &&
                !numPass.equals("") && !emailAddress.equals(""))        //condition if text field are not empty
        {
            firstName = first_name_field.getText();         //get text method to take date from text field
            middleName = middle_name_field.getText();
            lastName = last_name_field.getText();
            charPass = charPassportField.getText();
            numPass = numPassportField.getText();
            emailAddress = emailAdress_field.getText();

            User user = new User(firstName, middleName, lastName, charPass, numPass, emailAddress);     //object that will

            dbHandler.userData(user);       //goes to database mysql "booking" table
        }
        else
        {
            if (firstName.equals(""))
            {
                Shake firstEmpty = new Shake(first_name_field);        //animation if text field are empty
                firstEmpty.playAnim();
            }
            else if(middleName.equals(""))
            {
                Shake secondEmpty = new Shake(middle_name_field);
                secondEmpty.playAnim();
            }
            else if(lastName.equals(""))
            {
                Shake thirdEmpty = new Shake(last_name_field);
                thirdEmpty.playAnim();
            }
            else if(charPass.equals(""))
            {
                Shake charEmpty = new Shake(charPassportField);
                charEmpty.playAnim();
            }
            else if(numPass.equals(""))
            {
                Shake numEmpty = new Shake(numPassportField);
                numEmpty.playAnim();
            }
            else
            {
                Shake emailEmpty = new Shake(emailAdress_field);
                emailEmpty.playAnim();
                System.out.println("Error! Fields are empty.");
            }
        }
    }

    private void openNewScene(String window)            //method that will open new window
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
