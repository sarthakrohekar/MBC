package com.example.variouscontrolspractice;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private RadioGroup radioGroupGender;
    private CheckBox checkBoxReading, checkBoxTraveling, checkBoxGaming;
    private AutoCompleteTextView autoCompleteTextViewCountry;
    private ToggleButton toggleButton;
    private ImageButton imageButton;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        editTextName = findViewById(R.id.editTextName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkBoxReading = findViewById(R.id.checkBoxReading);
        checkBoxTraveling = findViewById(R.id.checkBoxTraveling);
        checkBoxGaming = findViewById(R.id.checkBoxGaming);
        autoCompleteTextViewCountry = findViewById(R.id.autoCompleteTextViewCountry);
        toggleButton = findViewById(R.id.toggleButton);
        imageButton = findViewById(R.id.imageButton);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Set up AutoCompleteTextView
        String[] countries = {"India", "United States", "Canada", "Australia", "United Kingdom"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, countries);
        autoCompleteTextViewCountry.setAdapter(adapter);

        // Handle ImageButton click
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleButton.setChecked(!toggleButton.isChecked());
            }
        });

        // Handle Submit Button click
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String gender = ((RadioButton) findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
                String hobbies = "";
                if (checkBoxReading.isChecked()) hobbies += "Reading ";
                if (checkBoxTraveling.isChecked()) hobbies += "Traveling ";
                if (checkBoxGaming.isChecked()) hobbies += "Gaming ";
                String country = autoCompleteTextViewCountry.getText().toString();
                boolean notifications = toggleButton.isChecked();

                // Display data in logs or as a summary
                System.out.println("Name: " + name);
                System.out.println("Gender: " + gender);
                System.out.println("Hobbies: " + hobbies);
                System.out.println("Country: " + country);
                System.out.println("Notifications: " + (notifications ? "Enabled" : "Disabled"));
            }
        });
    }
}
