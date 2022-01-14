package com.example.flyhigh;

public class User {                 //constructor, getter setter for data table booking
    private String firstName;
    private String middleName;
    private String lastName;
    private String charPass;
    private String numPass;
    private String emailAddress;

    public User(String firstName, String middleName, String lastName, String charPass, String numPass, String emailAddress) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.charPass = charPass;
        this.numPass = numPass;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCharPass() {
        return charPass;
    }

    public void setCharPass(String charPass) {
        this.charPass = charPass;
    }

    public String getNumPass() {
        return numPass;
    }

    public void setNumPass(String numPass) {
        this.numPass = numPass;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
