package com.example.factorial;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.math.BigInteger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText number;
    Button factorial;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = (EditText) findViewById(R.id.number);
        factorial = (Button) findViewById(R.id.factorialButton);
        result = (TextView) findViewById(R.id.result);

        factorial.setOnClickListener(this);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void onClick(View v){
        int n = Integer.parseInt(number.getText().toString());

        if (n < 0) {
            result.setText("Error! Enter a positive number.");
            return;
        }
        BigInteger fact = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        result.setText(String.format("Factorial = %d", fact));

        }

    }
