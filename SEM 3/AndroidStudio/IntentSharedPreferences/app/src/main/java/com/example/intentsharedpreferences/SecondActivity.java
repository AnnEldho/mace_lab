package com.example.intentsharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView display;
    Button previous;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        display = findViewById(R.id.display);
        previous = findViewById(R.id.previous);

        previous.setOnClickListener(this);

        sp = getSharedPreferences("MyData", MODE_PRIVATE);

        String name = sp.getString("Name", "");
        String email = sp.getString("Email", "");

        display.setText("Name : " + name + "\n\nEmail : " + email);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}