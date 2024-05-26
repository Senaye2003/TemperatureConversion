package com.example.conversiontemperature;

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

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private String TAG = "Demo";
    EditText input_temperature;
    EditText output_temperature;

    Button toF;
    Button toC;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        input_temperature = findViewById(R.id.editTextNumberDecimal);
        output_temperature = findViewById(R.id.editTextNumberDecimalOutput);

        toF = findViewById(R.id.button1);
        toF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = input_temperature.getText().toString();
                if(inputText.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter a Temperature", Toast.LENGTH_SHORT).show();
                    return;
                } try {
                    double input_temperature = Double.parseDouble(inputText.toString());
                    double outcome = input_temperature*(9.0/5.0)+32;
                    output_temperature.setText(String.valueOf(outcome));
                }  catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Invalid input. Please Enter a Valid Number", Toast.LENGTH_SHORT).show();
                }

            }
        });

        toC = findViewById(R.id.button2);
        toC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = input_temperature.getText().toString();
                if(inputText.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter a Temperature", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double inputNumber = Double.parseDouble(inputText);
                    double outcome = (inputNumber - 32)* (5.0/9.0);
                    output_temperature.setText(String.valueOf(outcome));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this,  "Invalid input. Please E1212nter a Valid Number.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reset = findViewById(R.id.button3);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_temperature.setText("Enter Temperature");
                output_temperature.setText("");
                Toast.makeText(MainActivity.this, "Inputs have been reset", Toast.LENGTH_SHORT).show();
            }
        });





    }
}