package com.example.registrationform;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    ImageView profileImage;
    TextView profileDetails;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImage = findViewById(R.id.profileImage);
        profileDetails = findViewById(R.id.profileDetails);

        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String gender = getIntent().getStringExtra("gender");
        String hobbies = getIntent().getStringExtra("hobbies");

        String details =
                "Name : " + name +
                        "\n\nEmail : " + email +
                        "\n\nGender : " + gender +
                        "\n\nHobbies : " + hobbies;

        profileDetails.setText(details);

        if (gender.equals("Male")) {
            profileImage.setImageResource(R.drawable.male);
        } else if (gender.equals("Female")) {
            profileImage.setImageResource(R.drawable.female);
        }
    }
}