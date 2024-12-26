package com.example.quizapppractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private RadioGroup radioGroupOptions;
    private RadioButton radioButtonOption1, radioButtonOption2, radioButtonOption3, radioButtonOption4;
    private Button buttonNext;

    private String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "Who wrote 'Hamlet'?",
            "What is the square root of 64?",
            "Which is the largest mammal?"
    };

    private String[][] options = {
            {"Berlin", "Madrid", "Paris", "Lisbon"},
            {"Earth", "Mars", "Jupiter", "Venus"},
            {"Charles Dickens", "William Shakespeare", "Leo Tolstoy", "Mark Twain"},
            {"6", "7", "8", "9"},
            {"Elephant", "Whale", "Giraffe", "Hippopotamus"}
    };

    private int[] correctAnswers = {2, 1, 1, 2, 1}; // Correct answer indexes (0-based)
    private int currentQuestion = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        radioGroupOptions = findViewById(R.id.radioGroupOptions);
        radioButtonOption1 = findViewById(R.id.radioButtonOption1);
        radioButtonOption2 = findViewById(R.id.radioButtonOption2);
        radioButtonOption3 = findViewById(R.id.radioButtonOption3);
        radioButtonOption4 = findViewById(R.id.radioButtonOption4);
        buttonNext = findViewById(R.id.buttonNext);

        loadQuestion();

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the selected answer
                int selectedId = radioGroupOptions.getCheckedRadioButtonId();
                int selectedIndex = -1;

                if (selectedId == R.id.radioButtonOption1) selectedIndex = 0;
                else if (selectedId == R.id.radioButtonOption2) selectedIndex = 1;
                else if (selectedId == R.id.radioButtonOption3) selectedIndex = 2;
                else if (selectedId == R.id.radioButtonOption4) selectedIndex = 3;

                if (selectedIndex == correctAnswers[currentQuestion]) {
                    score++;
                }

                // Move to the next question or finish the quiz
                currentQuestion++;
                if (currentQuestion < questions.length) {
                    loadQuestion();
                } else {
                    textViewQuestion.setText("Quiz Over! Your Score: " + score + "/" + questions.length);
                    radioGroupOptions.setVisibility(View.GONE);
                    buttonNext.setVisibility(View.GONE);
                }
            }
        });
    }

    private void loadQuestion() {
        textViewQuestion.setText(questions[currentQuestion]);
        radioButtonOption1.setText(options[currentQuestion][0]);
        radioButtonOption2.setText(options[currentQuestion][1]);
        radioButtonOption3.setText(options[currentQuestion][2]);
        radioButtonOption4.setText(options[currentQuestion][3]);
        radioGroupOptions.clearCheck();
    }
}
