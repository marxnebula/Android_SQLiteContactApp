package com.dorfing.mysqliteexample;

/*
 * Class for storing the contact information.  Information includes
 * a ID, Name, and Phone Number.
 */
public class Contact {

    // Id
    private int _id;

    // Name
    private String _name;

    // Phone Number
    private String _phone_number;


    // Empty constructor
    public Contact() {

    }

    // Constructor with id, name, and phone number
    public Contact(int id, String name, String _phone_number){

        // Set the id, name, and phone number
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
    }

    // Constructor with no id
    public Contact(String name, String _phone_number){

        // Set the name and phone number
        this._name = name;
        this._phone_number = _phone_number;
    }

    // Get the id
    public int getID(){

        return this._id;
    }

    // Set the id
    public void setID(int id){

        this._id = id;
    }

    // Get the name
    public String getName(){

        return this._name;
    }

    // Set the name
    public void setName(String name){

        this._name = name;
    }

    // Get the phone number
    public String getPhoneNumber(){

        return this._phone_number;
    }

    // Set the phone number
    public void setPhoneNumber(String phone_number){

        this._phone_number = phone_number;
    }
}
