package com.example.simplecalculatorpractice;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String operator="";
    private Button lastClickedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText operand1 = findViewById(R.id.Operand1);
        EditText operand2 = findViewById(R.id.Operand2);

        Button buttonAdd = findViewById(R.id.btnadd);
        Button buttonSubtract = findViewById(R.id.btnsubtract);
        Button buttonMultiply = findViewById(R.id.btnmultiply);
        Button buttonDivide = findViewById(R.id.btndivide);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        TextView resulttxt = findViewById(R.id.textViewResult);
        TextView equationtxt = findViewById(R.id.textViewEquation);

        buttonAdd.setOnClickListener(view->{
            operator="+";
            buttonAdd.setBackgroundColor(Color.GREEN);
            lastClickedButton=buttonAdd;
        });

        buttonSubtract.setOnClickListener(view->{
            operator="-";
            buttonSubtract.setBackgroundColor(Color.GREEN);
            lastClickedButton=buttonSubtract;
        });

        buttonMultiply.setOnClickListener(view->{
            operator="*";
            buttonMultiply.setBackgroundColor(Color.GREEN);
            lastClickedButton=buttonMultiply;
        });

        buttonDivide.setOnClickListener(view->{
            operator="/";
            buttonDivide.setBackgroundColor(Color.GREEN);
            lastClickedButton=buttonDivide;
        });

        btnCalculate.setOnClickListener(view->{
            if(!operator.isEmpty()){
                double num1 = Double.parseDouble(operand1.getText().toString());
                double num2 = Double.parseDouble(operand2.getText().toString());
                double result = 0;

                if (operator.equals("+")){
                    result=num1+num2;
                }
                if (operator.equals("-")){
                    result=num1-num2;
                }
                if (operator.equals("*")){
                    result=num1*num2;
                }
                if (operator.equals("/")){
                    result=num1/num2;
                }

                equationtxt.setText(num1+""+operator+""+num2);
                resulttxt.setText(String.valueOf(result));

                lastClickedButton.setBackgroundColor(Color.parseColor("#2290E6"));

            }
        });
    }
}
