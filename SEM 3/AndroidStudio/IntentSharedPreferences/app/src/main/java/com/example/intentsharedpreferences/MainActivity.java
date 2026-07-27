package com.example.intentsharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name,email;
    Button submit;
    SharedPreferences sp;
    String n,e;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email);
        submit=(Button) findViewById(R.id.submit);

        submit.setOnClickListener(this);

        sp = getSharedPreferences("MyData", MODE_PRIVATE);

        if(sp.contains("Name"))
            name.setText(sp.getString("Name",""));
        if(sp.contains("Email"))
            email.setText(sp.getString("Email",""));

    }

    @Override
    public void onClick(View view) {
       n=name.getText().toString();
       e=email.getText().toString();

       SharedPreferences.Editor editor=sp.edit();
        editor.putString("Name", n);
        editor.putString("Email", e);
        editor.apply();

        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(i);
    }
}