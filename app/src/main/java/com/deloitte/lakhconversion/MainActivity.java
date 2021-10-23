package com.deloitte.lakhconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    MaterialButton resetButton;
    TextView resultTV;
    TextInputEditText editText;

    TextWatcher mTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            runOnTextChanged();

        }
    };

    private void runOnTextChanged() {
        if (Objects.requireNonNull(editText.getText()).toString().equals(""))
            resultTV.setText("");
        else {
            float num = Float.parseFloat(editText.getText().toString());
            float convertedVal = num / 10000000;
            resultTV.setText(String.valueOf(convertedVal));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetButton=findViewById(R.id.reset_button);
        resultTV=findViewById(R.id.convertedValue);
        editText=findViewById(R.id.editTextNumber);

        editText.addTextChangedListener(mTextWatcher);
        runOnTextChanged();

        resetButton.setOnClickListener(v -> editText.setText(""));

    }


}