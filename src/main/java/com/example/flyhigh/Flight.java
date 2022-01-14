package com.example.flyhigh;

public class Flight {           //constructor, getter and setter for flight table
    String fromFlightColumn, whereFlightColumn, iataFromColumn, iataWhereColumn, dateFromColumn, dateWhereColumn, price;

    public Flight(String fromFlightColumn, String whereFlightColumn, String iataFromColumn, String iataWhereColumn, String dateFromColumn, String dateWhereColumn, String price) {
        this.fromFlightColumn = fromFlightColumn;
        this.whereFlightColumn = whereFlightColumn;
        this.iataFromColumn = iataFromColumn;
        this.iataWhereColumn = iataWhereColumn;
        this.dateFromColumn = dateFromColumn;
        this.dateWhereColumn = dateWhereColumn;
        this.price = price;
    }

    public Flight() {

    }

    public String getFromFlightColumn() {
        return fromFlightColumn;
    }

    public void setFromFlightColumn(String fromFlightColumn) {
        this.fromFlightColumn = fromFlightColumn;
    }

    public String getWhereFlightColumn() {
        return whereFlightColumn;
    }

    public void setWhereFlightColumn(String whereFlightColumn) {
        this.whereFlightColumn = whereFlightColumn;
    }

    public String getIataFromColumn() {
        return iataFromColumn;
    }

    public void setIataFromColumn(String iataFromColumn) {
        this.iataFromColumn = iataFromColumn;
    }

    public String getIataWhereColumn() {
        return iataWhereColumn;
    }

    public void setIataWhereColumn(String iataWhereColumn) {
        this.iataWhereColumn = iataWhereColumn;
    }

    public String getDateFromColumn() {
        return dateFromColumn;
    }

    public void setDateFromColumn(String dateFromColumn) {
        this.dateFromColumn = dateFromColumn;
    }

    public String getDateWhereColumn() {
        return dateWhereColumn;
    }

    public void setDateWhereColumn(String dateWhereColumn) {
        this.dateWhereColumn = dateWhereColumn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
