package com.example.registrationform;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText name, email;
    RadioGroup genderGroup;
    CheckBox coding, music, sports;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);

        genderGroup = findViewById(R.id.genderGroup);

        coding = findViewById(R.id.coding);
        music = findViewById(R.id.music);
        sports = findViewById(R.id.sports);

        submit = findViewById(R.id.submit);

        submit.setOnClickListener(v -> {

            String userName = name.getText().toString().trim();
            String userEmail = email.getText().toString().trim();

            if (userName.isEmpty() || userEmail.isEmpty()) {
                Toast.makeText(this,
                        "Please enter all details",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            int selectedId = genderGroup.getCheckedRadioButtonId();

            if (selectedId == -1) {
                Toast.makeText(this,
                        "Please select gender",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selectedGender =
                    findViewById(selectedId);

            String gender = selectedGender.getText().toString();

            String hobbies = "";

            if (coding.isChecked()) {
                hobbies += "Coding ";
            }

            if (music.isChecked()) {
                hobbies += "Music ";
            }

            if (sports.isChecked()) {
                hobbies += "Sports ";
            }

            Intent intent =
                    new Intent(MainActivity.this, ProfileActivity.class);

            intent.putExtra("name", userName);
            intent.putExtra("email", userEmail);
            intent.putExtra("gender", gender);
            intent.putExtra("hobbies", hobbies);

            startActivity(intent);
        });
    }
}