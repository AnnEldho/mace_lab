package com.example.implicitintent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button map, play, email, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        map = (Button) findViewById(R.id.map);
        play = (Button) findViewById(R.id.play);
        email = (Button) findViewById(R.id.email);
        msg = (Button)  findViewById(R.id.msg);

        map.setOnClickListener(this);
        play.setOnClickListener(this);
        email.setOnClickListener(this);
        msg.setOnClickListener(this);
    }

    @SuppressLint("IntentReset")
    @Override
    public void onClick(View view) {

        Intent intent, chooser;

        if (view.getId() == R.id.map) {

            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:10.065206,76.629128"));
            chooser = Intent.createChooser(intent, "Launch Maps");
            startActivity(chooser);

        }

        if (view.getId() == R.id.play) {

            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=gov.nasa"));
            chooser = Intent.createChooser(intent, "Google Play");
            startActivity(chooser);

        }

        if (view.getId() == R.id.email) {

            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto"));

            String to[] = {"sa.mca.mace@gmail.com"};

            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "From Emulator");
            intent.putExtra(Intent.EXTRA_TEXT, "My First test mail");
            intent.setType("message/rfc822");

            chooser = Intent.createChooser(intent, "Email Application");
            startActivity(chooser);

        }

        if (view.getId() == R.id.msg) {

            intent = new Intent(Intent.ACTION_SEND);

            Uri imgUri = Uri.parse(
                    "android.resource://com.example.implicitintents/drawable/" + R.drawable.baby);

            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM, imgUri);
            intent.putExtra(Intent.EXTRA_TEXT, "I have attached an attachment");

            chooser = Intent.createChooser(intent, "Messenger");
            startActivity(chooser);

        }
    }
}