package com.example.validations;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText username;
    TextView error, face;
    CheckBox terms;
    Button submit;
    ToggleButton toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        error = findViewById(R.id.error);
        terms = findViewById(R.id.terms);
        submit = findViewById(R.id.submit);
        toggle = findViewById(R.id.toggle);
        face = findViewById(R.id.face);

        // TextWatcher validation
        username.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {

                if (s.toString().trim().isEmpty()) {
                    error.setText("Username cannot be empty");
                } else if (s.toString().trim().length() < 3) {
                    error.setText("Username must contain at least 3 characters");
                } else {
                    error.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // CheckBox validation
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = username.getText().toString().trim();

                if (name.isEmpty() || name.length() < 3) {
                    Toast.makeText(
                            MainActivity.this,
                            "Enter a valid username",
                            Toast.LENGTH_SHORT
                    ).show();
                } else if (!terms.isChecked()) {
                    Toast.makeText(
                            MainActivity.this,
                            "Please accept the terms and conditions",
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    Toast.makeText(
                            MainActivity.this,
                            "Validation Successful",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });

        // ToggleButton: Happy/Sad face
        toggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                face.setText("😊");
            } else {
                face.setText("☹️");
            }
        });
    }
}