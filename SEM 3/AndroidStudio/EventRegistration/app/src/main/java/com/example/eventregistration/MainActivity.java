package com.example.eventregistration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText name,email;
    RadioGroup group;
    RadioButton radio;
    CheckBox android,ai,cyber;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        group=findViewById(R.id.categoryGroup);

        android=findViewById(R.id.android);
        ai=findViewById(R.id.ai);
        cyber=findViewById(R.id.cyber);

        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id=group.getCheckedRadioButtonId();
                radio=findViewById(id);

                String workshops="";

                if(android.isChecked())
                    workshops+="Android Development\n";

                if(ai.isChecked())
                    workshops+="AI & ML\n";

                if(cyber.isChecked())
                    workshops+="Cybersecurity";

                SharedPreferences sp=getSharedPreferences("Registration",MODE_PRIVATE);

                SharedPreferences.Editor editor=sp.edit();

                editor.putString("name",name.getText().toString());
                editor.putString("email",email.getText().toString());
                editor.putString("category",radio.getText().toString());
                editor.putString("workshops",workshops);

                editor.apply();

                startActivity(new Intent(MainActivity.this,Summary.class));

            }
        });

    }
}