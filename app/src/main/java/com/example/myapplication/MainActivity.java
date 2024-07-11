package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputValue;
    private Spinner unitSpinner;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.inputValue);
        unitSpinner = findViewById(R.id.unitSpinner);
        resultText = findViewById(R.id.resultText);
        Button convertButton = findViewById(R.id.convertButton);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnit();
            }
        });
    }

    private void convertUnit() {
        String input = inputValue.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }

        double value = Double.parseDouble(input);
        String selectedUnit = unitSpinner.getSelectedItem().toString();
        double result;

        switch (selectedUnit) {
            case "Centimeters to Meters":
                result = value / 100;
                resultText.setText(String.format("%.2f Meters", result));
                break;
            case "Meters to Centimeters":
                result = value * 100;
                resultText.setText(String.format("%.2f Centimeters", result));
                break;
            case "Grams to Kilograms":
                result = value / 1000;
                resultText.setText(String.format("%.2f Kilograms", result));
                break;
            case "Kilograms to Grams":
                result = value * 1000;
                resultText.setText(String.format("%.2f Grams", result));
                break;
            default:
                resultText.setText("Invalid Conversion");
                break;
        }
    }
}
