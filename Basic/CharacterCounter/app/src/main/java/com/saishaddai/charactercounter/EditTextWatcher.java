package com.saishaddai.charactercounter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

public class EditTextWatcher implements TextWatcher {

    private TextView counter;
    private boolean disableEditText = false;

    public EditTextWatcher(TextView textView) {
        this.counter = textView;
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        counter.setText("" + s.length()); //Strangely important to add an empty string
    }

    public void afterTextChanged(Editable s) {
    }
}
