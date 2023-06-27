package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etBirthdate, etCurrentDate;
    Button btnCalculate, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBirthdate = findViewById(R.id.etBirthdate);
        etCurrentDate = findViewById(R.id.etCurrentDate);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnNext = findViewById(R.id.btnNext);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String birthdate = etBirthdate.getText().toString();
                String currentDate = etCurrentDate.getText().toString();

                int age = calculateAge(birthdate, currentDate);
                Toast.makeText(MainActivity.this, "Idade: " + age, Toast.LENGTH_LONG).show();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    public static int calculateAge(String birthdate, String currentDate) {
        String[] birthdateParts = birthdate.split("/");
        String[] currentDateParts = currentDate.split("/");

        int birthDay = Integer.parseInt(birthdateParts[0]);
        int birthMonth = Integer.parseInt(birthdateParts[1]);
        int birthYear = Integer.parseInt(birthdateParts[2]);

        int currentDay = Integer.parseInt(currentDateParts[0]);
        int currentMonth = Integer.parseInt(currentDateParts[1]);
        int currentYear = Integer.parseInt(currentDateParts[2]);

        int age = currentYear - birthYear;

        if (currentMonth < birthMonth) {
            age--;
        } else if (currentMonth == birthMonth && currentDay < birthDay) {
            age--;
        }

        return age;
    }
}
