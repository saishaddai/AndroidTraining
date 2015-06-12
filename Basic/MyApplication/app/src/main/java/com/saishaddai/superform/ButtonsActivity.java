package com.saishaddai.superform;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;


public class ButtonsActivity extends Activity {

    RatingBar ratingBar;
    RadioGroup radioButtons;
    CheckBox checkbox1;
    CheckBox checkbox2;
    Switch switchButton;
    ToggleButton toggleButton;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        addListenerOnRatingBar();
        addListenerToRadioButtons();
        addListenerToCheckboxes();
        addListenerToSwitch();
        addListenerToToggleButton();

        initializeAndAddListenerToSpinner();

    }

    private void addListenerToCheckboxes() {
        checkbox1 = (CheckBox) findViewById(R.id.checkBox);
        checkbox2 = (CheckBox) findViewById(R.id.checkBox2);

        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getApplicationContext(), "checkbox 1: " + buttonView.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });

        checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getApplicationContext(), "checkbox 2: " + buttonView.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initializeAndAddListenerToSpinner() {
        spinner = (Spinner) findViewById(R.id.spinner);
        //TODO add something in the simple adapter for this spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "chosen: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "nothing chosen", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void addListenerToToggleButton() {
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getApplicationContext(), "value is now: " + isChecked,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addListenerToSwitch() {
        switchButton = (Switch) findViewById(R.id.switch1);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getApplicationContext(), "value is now: " + isChecked,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void addListenerToRadioButtons() {
        radioButtons = (RadioGroup) findViewById(R.id.radio_buttons);
        radioButtons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton) {
                    Toast.makeText(getApplicationContext(), "choice: radio button 1",
                            Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radioButton2) {
                    Toast.makeText(getApplicationContext(), "choice: radio button 2",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void addListenerOnRatingBar() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                //ratingBar.getRating() also does the magic
                Toast.makeText(getApplicationContext(), String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void imageButtonPressed(View view) {
        Toast.makeText(this, R.string.image_button_pressed, Toast.LENGTH_SHORT).show();
    }
}
