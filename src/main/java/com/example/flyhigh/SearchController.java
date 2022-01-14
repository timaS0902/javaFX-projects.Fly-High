package com.example.flyhigh;

import com.example.flyhigh.animations.Shake;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchController extends FlyHighController{

    @FXML
    private Button backHomeBtn;

    @FXML
    private DatePicker datapicker;

    @FXML
    private TableColumn<Flight, String> dateFromColumn;

    @FXML
    private TableColumn<Flight, String> dateWhereColumn;

    @FXML
    private TableColumn<Flight, String> fromFlightColumn;

    @FXML
    private TextField fromf;

    @FXML
    private TableColumn<Flight, String> iataFromColumn;

    @FXML
    private TableColumn<Flight, String> iataWhereColumn;

    @FXML
    private TextField idflight;

    @FXML
    private Button nextBookingBtn;

    @FXML
    private TableView<Flight> tableFlight;

    @FXML
    private TableColumn<Flight, Integer> price;

    @FXML
    private TableColumn<Flight, String> whereFlightColumn;

    @FXML
    private TextField wheref;

    ObservableList<Flight> oblist = FXCollections.observableArrayList();

    @FXML
    void initialize()
    {
        showData();     //method to show data | right now is not working |

        nextBookingBtn.setOnAction(actionEvent ->
        {
            String id = idflight.getText().trim();      //delete spaces
            if(!id.equals(""))
            {
                nextBookingBtn.getScene().getWindow().hide();
                openNewScene("Booking-view.fxml");      //go to "booking" window
            }
            else
            {
                Shake idEmpty = new Shake(idflight);            //animation
                idEmpty.playAnim();
            }
        });

        backHomeBtn.setOnAction(actionEvent ->
        {
            backHomeBtn.getScene().getWindow().hide();
            openNewScene("FlyHigh-view.fxml");      // go to "main" window
        });
    }

    private void showData()         //method that will show data
    {
        try{
            DatabaseHandler dbHandler = new DatabaseHandler();
            Connection conn = dbHandler.getDbConnection();
            ResultSet result = conn.createStatement().executeQuery("select * from flight");

            while(result.next())
            {
                oblist.add(new Flight(result.getString("from_flight"), result.getString("where_flight"),
                        result.getString("iso_code_from"), result.getString("iso_code_where"),
                        result.getString("time_flight_from"), result.getString("time_flight_where"),
                        result.getString("price_ticket")));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        fromFlightColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("from_flight"));
        iataFromColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("iso_code_from"));
        whereFlightColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("where_flight"));
        iataWhereColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("iso_code_where"));
        dateFromColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("time_flight_from"));
        dateWhereColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("time_flight_where"));
        price.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("price_ticket"));

        tableFlight.setItems(oblist);
    }

    public void initData(UserFlight flight) //future improvement | this method will take data from "FlyHighController" and
    {                                       //                   | paste it in fromf and wheref to sort at once
        fromf.setText(flight.getFrom_field());
        wheref.setText(flight.getWhere_field());
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
