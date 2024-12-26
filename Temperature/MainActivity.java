package com.example.temperatureconversionpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String selectedInputScale = "";
    private String selectedOutputScale = "";
    private EditText editTextTemperature;
    private TextView inputScaleTextView, outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference to UI components
        Button buttonCelsius = findViewById(R.id.buttonCelsius);
        Button buttonKelvin = findViewById(R.id.buttonKelvin);
        Button buttonFahrenheit = findViewById(R.id.buttonFahrenheit);
        Button buttonToCelsius = findViewById(R.id.buttonToCelsius);
        Button buttonToKelvin = findViewById(R.id.buttonToKelvin);
        Button buttonToFahrenheit = findViewById(R.id.buttonToFahrenheit);
        editTextTemperature = findViewById(R.id.editTextTemperature);
        inputScaleTextView = findViewById(R.id.textViewInputScale);
        outputTextView = findViewById(R.id.textViewOutput);

        // Set OnClickListeners for input scale buttons
        buttonCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedInputScale = "Celsius";
                inputScaleTextView.setText("Input Scale: Celsius selected.");
            }
        });

        buttonKelvin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedInputScale = "Kelvin";
                inputScaleTextView.setText("Input Scale: Kelvin selected.");
            }
        });

        buttonFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedInputScale = "Fahrenheit";
                inputScaleTextView.setText("Input Scale: Fahrenheit selected.");
            }
        });

        // Set OnClickListeners for output scale buttons
        buttonToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedOutputScale = "Celsius";
                convertTemperature();
            }
        });

        buttonToKelvin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedOutputScale = "Kelvin";
                convertTemperature();
            }
        });

        buttonToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedOutputScale = "Fahrenheit";
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        // Get temperature input
        double temperature = Double.parseDouble(editTextTemperature.getText().toString());
        double convertedTemperature = 0.0;

        // Perform conversion
        if (selectedInputScale.equals("Celsius")) {
            if (selectedOutputScale.equals("Kelvin")) {
                convertedTemperature = temperature + 273.15;
            } else if (selectedOutputScale.equals("Fahrenheit")) {
                convertedTemperature = (temperature * 9 / 5) + 32;
            } else {
                convertedTemperature = temperature;
            }
        } else if (selectedInputScale.equals("Kelvin")) {
            if (selectedOutputScale.equals("Celsius")) {
                convertedTemperature = temperature - 273.15;
            } else if (selectedOutputScale.equals("Fahrenheit")) {
                convertedTemperature = (temperature - 273.15) * 9 / 5 + 32;
            } else {
                convertedTemperature = temperature;
            }
        } else if (selectedInputScale.equals("Fahrenheit")) {
            if (selectedOutputScale.equals("Celsius")) {
                convertedTemperature = (temperature - 32) * 5 / 9;
            } else if (selectedOutputScale.equals("Kelvin")) {
                convertedTemperature = (temperature - 32) * 5 / 9 + 273.15;
            } else {
                convertedTemperature = temperature;
            }
        }

        // Display result
        outputTextView.setText("Converted Temperature: " + convertedTemperature);
    }
}
