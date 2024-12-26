package com.example.databasepractice;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameEditText = findViewById(R.id.editTextName);
        EditText ageEditText = findViewById(R.id.editTextAge);
        Button insertButton = findViewById(R.id.buttonInsert);
        Button displayButton = findViewById(R.id.buttonDisplay);
        TextView resultTextView = findViewById(R.id.textViewResult);

        dbHelper = new DatabaseHelper(this);

        insertButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            String ageStr = ageEditText.getText().toString();

            if (!name.isEmpty() && !ageStr.isEmpty()) {
                int age = Integer.parseInt(ageStr);
                dbHelper.insertData(name, age);
                nameEditText.setText("");
                ageEditText.setText("");
            }
        });

        displayButton.setOnClickListener(v -> {
            String data = dbHelper.getAllData();
            resultTextView.setText(data);
        });
    }
}
