package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText num1, num2;
    Button add, sub, mul, div;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.editTextText);
        num2 = findViewById(R.id.editTextText2);

        add = findViewById(R.id.button);
        sub = findViewById(R.id.button2);
        mul = findViewById(R.id.button3);
        div = findViewById(R.id.button4);

        result = findViewById(R.id.textView);

        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String s1 = num1.getText().toString().trim();
        String s2 = num2.getText().toString().trim();

        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(s1);
        double b = Double.parseDouble(s2);
        double ans = 0;

        if (v.getId() == R.id.button) {
            ans = a + b;
        } else if (v.getId() == R.id.button2) {
            ans = a - b;
        } else if (v.getId() == R.id.button3) {
            ans = a * b;
        } else if (v.getId() == R.id.button4) {
            if (b == 0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                return;
            }
            ans = a / b;
        }

        result.setText("Result = " + ans);
    }
}