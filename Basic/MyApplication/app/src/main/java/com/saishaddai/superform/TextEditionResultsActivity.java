package com.saishaddai.superform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class TextEditionResultsActivity extends Activity {

    private TextView personNameText;
    private TextView passwordText;
    private TextView passwordNumericText;
    private TextView emailText;
    private TextView phoneText;
    private TextView zipText;
    private TextView timeText;
    private TextView dateText;
    private TextView numberText;
    private TextView numberSignedText;
    private TextView numberDecimalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_edition_results);

        initializeTextViewFields();

        Intent intent = getIntent();
        personNameText.setText("Person Name: " + intent.getStringExtra("personName"));
        passwordText.setText("Password: " + intent.getStringExtra("password"));
        passwordNumericText.setText("password Numeric: " + intent.getStringExtra("passwordNumeric"));
        emailText.setText("Email: " + intent.getStringExtra("email"));
        phoneText.setText("Phone: " + intent.getStringExtra("phone"));
        zipText.setText("Zip: " + intent.getStringExtra("zip"));
        timeText.setText("Time: " + intent.getStringExtra("time"));
        dateText.setText("Date: " + intent.getStringExtra("date"));
        numberText.setText("Number: " + intent.getStringExtra("number"));
        numberSignedText.setText("Number signed: " + intent.getStringExtra("numberSigned"));
        numberDecimalText.setText("Number decimal: " + intent.getStringExtra("numberDecimal"));


    }

    private void initializeTextViewFields() {
        personNameText = (TextView) findViewById(R.id.person_name_results);
        passwordText = (TextView) findViewById(R.id.password_text_results);
        passwordNumericText = (TextView) findViewById(R.id.password_numeric_results);
        emailText = (TextView) findViewById(R.id.email_address_results);
        phoneText = (TextView) findViewById(R.id.phone_number_results);
        zipText = (TextView) findViewById(R.id.zip_edition_results);
        timeText = (TextView) findViewById(R.id.time_field_results);
        dateText = (TextView) findViewById(R.id.date_field_results);
        numberText = (TextView) findViewById(R.id.number_field_results);
        numberSignedText = (TextView) findViewById(R.id.number_signed_results);
        numberDecimalText = (TextView) findViewById(R.id.number_decimal_results);
    }

}
