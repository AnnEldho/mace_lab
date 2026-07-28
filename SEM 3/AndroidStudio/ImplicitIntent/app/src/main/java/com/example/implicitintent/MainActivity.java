package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button map, play, email, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        map = findViewById(R.id.map);
        play = findViewById(R.id.play);
        email = findViewById(R.id.email);
        msg = findViewById(R.id.msg);

        map.setOnClickListener(this);
        play.setOnClickListener(this);
        email.setOnClickListener(this);
        msg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent;

        if (view.getId() == R.id.map) {

            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:10.065206,76.629128"));
            startActivity(intent);

        }

        else if (view.getId() == R.id.play) {

            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=gov.nasa"));
            startActivity(intent);

        }

        else if (view.getId() == R.id.email) {

            intent = new Intent(Intent.ACTION_SEND);

            intent.setType("message/rfc822");

            intent.putExtra(Intent.EXTRA_EMAIL,
                    new String[]{"sa.mca.mace@gmail.com"});

            intent.putExtra(Intent.EXTRA_SUBJECT,
                    "From Android");

            intent.putExtra(Intent.EXTRA_TEXT,
                    "Hello from Android");

            startActivity(Intent.createChooser(intent, "Send Email"));

        }

        else if (view.getId() == R.id.msg) {

            intent = new Intent(Intent.ACTION_SEND);

            intent.setType("image/*");

            Uri imageUri = Uri.parse(
                    "android.resource://" + getPackageName()
                            + "/" + R.drawable.baby);

            intent.putExtra(Intent.EXTRA_STREAM, imageUri);

            intent.putExtra(Intent.EXTRA_TEXT,
                    "Image from Android");

            startActivity(Intent.createChooser(intent, "Share Image"));

        }

    }
}