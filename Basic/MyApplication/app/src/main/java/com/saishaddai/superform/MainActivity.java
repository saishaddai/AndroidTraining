package com.saishaddai.superform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToTextEditionForm(View view) {
        startChosenActivity(TextEditionActivity.class);
    }

    public void goToButtonsForm(View view) {
        startChosenActivity(ButtonsActivity.class);
    }

    private void startChosenActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    public void goToDatePickerForm(View view) {
        startChosenActivity(DatePickerActivity.class);
    }

    public void goToTimePickerForm(View view) {
        startChosenActivity(TimePickerActivity.class);
    }

}
