package com.dorfing.mysqliteexample;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/*
 * Android application that uses SQLite to store contact information.
 * Information includes Name and Phone Number.
 * The user enters a Name and Phone Number and clicks a button to add the contact.
 * The user may also delete all the contacts with the delete button

 - Jordan Patrick Marx (5/4/2016)
 */
public class MainActivity extends Activity {

    Button contactButton;
    Button deleteButton;
    DatabaseHandler db;
    EditText nameEditText;
    EditText phoneNumberEditText;
    TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DatabaseHandler class
        db = new DatabaseHandler(this);

        // Insert the contacts
        db.addContact(new Contact("Testing", "555-5555"));


        // Name edit text box
        nameEditText = (EditText) findViewById(R.id.main_editnametext);

        // Phone number edit text box
        phoneNumberEditText = (EditText) findViewById(R.id.main_editphonenunmbertext);

        // Button for adding the contact
        contactButton = (Button) findViewById(R.id.main_contactbutton);

        // Set the click listener
        contactButton.setOnClickListener(confirmContactButtonListener);

        // Button for deleting all the contacts
        deleteButton = (Button) findViewById(R.id.main_deletebutton);

        // Set the click listener
        deleteButton.setOnClickListener(deleteContactButtonListener);

        // TextView for displaying all the contacts
        outputText = (TextView) findViewById(R.id.main_textview);

        // Make the text view scrollable
        outputText.setMovementMethod(new ScrollingMovementMethod());

        // Display all the contacts
        DisplayContacts();

    }



    /* Function called when user clicks on the contact button.
     * If name and/or phone number is empty then contact not added.
     */
    private View.OnClickListener confirmContactButtonListener = new View.OnClickListener() {
        public void onClick(View v) {

            // If name and/or phone number empty then don't add contact
            if(nameEditText.getText().toString().matches("") ||
                    phoneNumberEditText.getText().toString().matches(""))
            {
                // Toast
                Toast.makeText(getApplicationContext(), "Field is Missing", Toast.LENGTH_LONG).show();
            }
            else
            {
                // Add the contact
                db.addContact(new Contact(nameEditText.getText().toString(), phoneNumberEditText.getText().toString()));

                // Toast
                Toast.makeText(getApplicationContext(), "Added New Contact", Toast.LENGTH_LONG).show();

                // Display the contacts
                DisplayContacts();

                // Clear edit text
                nameEditText.setText("");
                phoneNumberEditText.setText("");
            }


        }
    };



    /*
     * Function called when user clicks the delete button.
     * Get all the contacts and delete them
     */
    private View.OnClickListener deleteContactButtonListener = new View.OnClickListener() {
        public void onClick(View v) {

            // Get all the contacts
            List<Contact> contacts = db.getAllContacts();

            // Delete each contact
            for (Contact cn : contacts) {
                db.deleteContact(cn);

            }

            // Display the contacts
            DisplayContacts();

        }
    };

    /*
     * Function to display all the contacts on the TextView.
     */
    public void DisplayContacts() {
        // String buffer for storing the info
        StringBuffer output = new StringBuffer();

        // Get all the contacts
        List<Contact> contacts = db.getAllContacts();

        // Append each contact to output
        for (Contact cn : contacts) {
            output.append("\n Name:" + cn.getName());
            output.append("\n Phone Number:" + cn.getPhoneNumber());
            output.append("\n");

        }

        // Set the text
        outputText.setText(output);
    }


}
