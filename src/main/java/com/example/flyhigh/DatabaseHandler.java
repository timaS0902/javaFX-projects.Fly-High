package com.example.flyhigh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs{
    Connection dbConnection;        //connection with database

    public Connection getDbConnection() throws ClassNotFoundException, SQLException
    {

        String connectionString ="jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;        //connection with DB
                                                                                                //using configs
        Class.forName("com.mysql.cj.jdbc.Driver");              //driver manager class

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void userData(User user)                 //method that will add data to table "booking" using configs
    {
        String insert = "INSERT " + Const.BOOKING_TABLE + "(" + Const.BOOKING_FIRSTNAME + "," + Const.BOOKING_MIDDLE2NAME +
                "," + Const.BOOKING_LASTNAME + "," + Const.BOOKING_PASSPORT1CHAR + "," + Const.BOOKING_PASSPORT2NUM +
                "," + Const.BOOKING_EMAIL + ")" + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);        //prepared statement, parametrized operator
            prSt.setString(1, user.getFirstName());                        //set data to table
            prSt.setString(2, user.getMiddleName());
            prSt.setString(3, user.getLastName());
            prSt.setString(4, user.getCharPass());
            prSt.setString(5, user.getNumPass());
            prSt.setString(6, user.getEmailAddress());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
