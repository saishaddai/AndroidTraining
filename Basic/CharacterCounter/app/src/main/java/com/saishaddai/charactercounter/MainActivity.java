package com.saishaddai.charactercounter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    TextView counter;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = (TextView) findViewById(R.id.counter);
        editText = (EditText) findViewById(R.id.edit_text);
        editText.addTextChangedListener(new EditTextWatcher(counter));
    }

}
