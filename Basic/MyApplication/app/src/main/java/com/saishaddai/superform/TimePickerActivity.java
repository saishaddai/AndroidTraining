package com.saishaddai.superform;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class TimePickerActivity extends Activity {

    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        timePicker = (TimePicker) findViewById(R.id.time_picker);
    }

    public void showResults(View view) {
        Toast.makeText(this, formatTime(timePicker), Toast.LENGTH_SHORT).show();
    }

    private String formatTime(TimePicker timePicker) {
        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();

        return "Chosen hour: " + hour + ":" + minute;
    }

}
