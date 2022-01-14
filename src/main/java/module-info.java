module com.example.flyhigh {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.flyhigh to javafx.fxml;
    exports com.example.flyhigh;
}