package com.saishaddai.superform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class TextEditionActivity extends Activity {

    private EditText personNameText;
    private EditText passwordText;
    private EditText passwordNumericText;
    private EditText emailText;
    private EditText phoneText;
    private EditText zipText;
    private EditText timeText;
    private EditText dateText;
    private EditText numberText;
    private EditText numberSignedText;
    private EditText numberDecimalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_edition);

        initializeEditTextFields();
    }

    private void initializeEditTextFields() {
        personNameText = (EditText) findViewById(R.id.person_name);
        passwordText = (EditText) findViewById(R.id.password_text);
        passwordNumericText = (EditText) findViewById(R.id.password_numeric);
        emailText = (EditText) findViewById(R.id.email_address);
        phoneText = (EditText) findViewById(R.id.phone_number);
        zipText = (EditText) findViewById(R.id.zip_code);
        timeText = (EditText) findViewById(R.id.time_field);
        dateText = (EditText) findViewById(R.id.date_field);
        numberText = (EditText) findViewById(R.id.number_field);
        numberSignedText = (EditText) findViewById(R.id.number_signed);
        numberDecimalText = (EditText) findViewById(R.id.number_decimal);
    }

    public void showResults(View view) {
        Intent intent = new Intent(this, TextEditionResultsActivity.class);
        String personName = personNameText.getText().toString();
        String password = passwordText.getText().toString();
        String passwordNumeric = passwordNumericText.getText().toString();
        String email = emailText.getText().toString();
        String phone = phoneText.getText().toString();
        String zip = zipText.getText().toString();
        String time = timeText.getText().toString();
        String date = dateText.getText().toString();
        String number = numberText.getText().toString();
        String numberSigned = numberSignedText.getText().toString();
        String numberDecimal = numberDecimalText.getText().toString();

        intent.putExtra("personName", personName);
        intent.putExtra("password", password);
        intent.putExtra("passwordNumeric", passwordNumeric);
        intent.putExtra("email", email);
        intent.putExtra("phone", phone);
        intent.putExtra("zip", zip);
        intent.putExtra("time", time);
        intent.putExtra("date", date);
        intent.putExtra("number", number);
        intent.putExtra("numberSigned", numberSigned);
        intent.putExtra("numberDecimal", numberDecimal);
        startActivity(intent);
    }
}
