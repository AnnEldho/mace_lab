package com.example.eventregistration;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Summary extends AppCompatActivity {

    TextView summary;
    Button back,confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        summary=findViewById(R.id.summary);

        back=findViewById(R.id.back);
        confirm=findViewById(R.id.confirm);

        SharedPreferences sp=getSharedPreferences("Registration",MODE_PRIVATE);

        String data="Name : "+sp.getString("name","")+
                "\n\nEmail : "+sp.getString("email","")+
                "\n\nCategory : "+sp.getString("category","")+
                "\n\nWorkshops :\n"+sp.getString("workshops","");

        summary.setText(data);

        back.setOnClickListener(v -> finish());

        confirm.setOnClickListener(v -> {

            LayoutInflater inflater=getLayoutInflater();

            View view=inflater.inflate(R.layout.custom_toast,null);

            Toast toast=new Toast(getApplicationContext());

            toast.setView(view);

            toast.setDuration(Toast.LENGTH_LONG);

            toast.show();

        });

    }
}