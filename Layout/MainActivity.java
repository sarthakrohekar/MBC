package com.example.layoutpractice;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonLinear1, buttonLinear2;
    private Button buttonRelative1, buttonRelative2;
    private Button buttonConstraint1, buttonConstraint2;
    private Button buttonFrame1, buttonFrame2;
    private Button buttonGrid1, buttonGrid2, buttonGrid3, buttonGrid4;
    private Button buttonTable1, buttonTable2, buttonTable3, buttonTable4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Buttons
        buttonLinear1 = findViewById(R.id.buttonLinear1);
        buttonLinear2 = findViewById(R.id.buttonLinear2);
        buttonRelative1 = findViewById(R.id.buttonRelative1);
        buttonRelative2 = findViewById(R.id.buttonRelative2);
        buttonConstraint1 = findViewById(R.id.buttonConstraint1);
        buttonConstraint2 = findViewById(R.id.buttonConstraint2);
        buttonFrame1 = findViewById(R.id.buttonFrame1);
        buttonFrame2 = findViewById(R.id.buttonFrame2);
        buttonGrid1 = findViewById(R.id.buttonGrid1);
        buttonGrid2 = findViewById(R.id.buttonGrid2);
        buttonGrid3 = findViewById(R.id.buttonGrid3);
        buttonGrid4 = findViewById(R.id.buttonGrid4);
        buttonTable1 = findViewById(R.id.buttonTable1);
        buttonTable2 = findViewById(R.id.buttonTable2);
        buttonTable3 = findViewById(R.id.buttonTable3);
        buttonTable4 = findViewById(R.id.buttonTable4);

        // Set Click Listeners for buttons (just for demonstration, you can set your own actions)
        buttonLinear1.setOnClickListener(v -> showMessage("Linear Button 1 Clicked"));
        buttonLinear2.setOnClickListener(v -> showMessage("Linear Button 2 Clicked"));
        buttonRelative1.setOnClickListener(v -> showMessage("Relative Button 1 Clicked"));
        buttonRelative2.setOnClickListener(v -> showMessage("Relative Button 2 Clicked"));
        buttonConstraint1.setOnClickListener(v -> showMessage("Constraint Button 1 Clicked"));
        buttonConstraint2.setOnClickListener(v -> showMessage("Constraint Button 2 Clicked"));
        buttonFrame1.setOnClickListener(v -> showMessage("Frame Button 1 Clicked"));
        buttonFrame2.setOnClickListener(v -> showMessage("Frame Button 2 Clicked"));
        buttonGrid1.setOnClickListener(v -> showMessage("Grid Button 1 Clicked"));
        buttonGrid2.setOnClickListener(v -> showMessage("Grid Button 2 Clicked"));
        buttonGrid3.setOnClickListener(v -> showMessage("Grid Button 3 Clicked"));
        buttonGrid4.setOnClickListener(v -> showMessage("Grid Button 4 Clicked"));
        buttonTable1.setOnClickListener(v -> showMessage("Table Button 1 Clicked"));
        buttonTable2.setOnClickListener(v -> showMessage("Table Button 2 Clicked"));
        buttonTable3.setOnClickListener(v -> showMessage("Table Button 3 Clicked"));
        buttonTable4.setOnClickListener(v -> showMessage("Table Button 4 Clicked"));
    }

    private void showMessage(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
