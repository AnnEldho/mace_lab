package com.example.loginvalidation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText user,pwd;
    Button login;
    String u="s6108";
    String p="abc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.username);
        pwd = findViewById(R.id.password);
        login = findViewById(R.id.loginButton);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String a = user.getText().toString().trim();
        String b = pwd.getText().toString().trim();

        // Check if fields are empty
        if (a.isEmpty() || b.isEmpty()) {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (a.equals(u) && b.equals(p)) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Invalid Login", Toast.LENGTH_LONG).show();
        }
    }
}