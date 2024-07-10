package com.example.calculatorapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatorapp.Controller.CalculatorController;

public class MainActivity extends AppCompatActivity {

    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char MULTIPLICATION = '*';
    public static final char MOD = '%';
    public static final char DIVISION = '/';
    public static final char NEGATIVE = 'N';
    Button off, c, mod, div, multi, minus, plus, equal, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, dot, negative;
    TextView inputDisplay, outputDisplay;
    char currentSymbol;
    String errMsg;
    double firstValue = Double.NaN, secondValue;
    CalculatorController calculatorController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the controller
        calculatorController = new CalculatorController();

        // Define components from activity_main.xml
        // Buttons
        off = findViewById(R.id.off);
        dot = findViewById(R.id.dot);
        c = findViewById(R.id.c);
        mod = findViewById(R.id.precent);
        div = findViewById(R.id.div);
        multi = findViewById(R.id.multi);
        minus = findViewById(R.id.min);
        equal = findViewById(R.id.equal);
        plus = findViewById(R.id.plus);
        btn0 = findViewById(R.id.zero);
        btn1 = findViewById(R.id.one);
        btn2 = findViewById(R.id.two);
        btn3 = findViewById(R.id.three);
        btn4 = findViewById(R.id.four);
        btn5 = findViewById(R.id.five);
        btn6 = findViewById(R.id.six);
        btn7 = findViewById(R.id.seven);
        btn8 = findViewById(R.id.eight);
        btn9 = findViewById(R.id.nine);
        negative = findViewById(R.id.negative);
        // TextViews
        inputDisplay = findViewById(R.id.input);
        outputDisplay = findViewById(R.id.output);

        // Set onClickListeners for buttons
        btn0.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "0"));
        btn1.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "1"));
        btn2.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "2"));
        btn3.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "3"));
        btn4.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "4"));
        btn5.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "5"));
        btn6.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "6"));
        btn7.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "7"));
        btn8.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "8"));
        btn9.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "9"));
        dot.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "."));

        plus.setOnClickListener(v -> {
            if (!inputDisplay.getText().toString().isEmpty()) {
                allCalculations();
                currentSymbol = ADDITION;
                inputDisplay.setText("");
                outputDisplay.setText(firstValue + "+");
            }
        });

        minus.setOnClickListener(v -> {
            if (!inputDisplay.getText().toString().isEmpty()) {
                allCalculations();
                currentSymbol = SUBTRACTION;
                inputDisplay.setText("");
                outputDisplay.setText(firstValue + "-");
            }
        });

        multi.setOnClickListener(v -> {
            if (!inputDisplay.getText().toString().isEmpty()) {
                allCalculations();
                currentSymbol = MULTIPLICATION;
                inputDisplay.setText("");
                outputDisplay.setText(firstValue + "*");
            }
        });

        div.setOnClickListener(v -> {
            if (!inputDisplay.getText().toString().isEmpty()) {
                allCalculations();
                currentSymbol = DIVISION;
                inputDisplay.setText("");
                outputDisplay.setText(firstValue + "/");
                if (errMsg != null) {
                    inputDisplay.setText("");
                    outputDisplay.setText(errMsg);
                    errMsg = null;
                    firstValue = Double.NaN;
                }
            }
        });

        mod.setOnClickListener(v -> {
            if (!inputDisplay.getText().toString().isEmpty()) {
                allCalculations();
                currentSymbol = MOD;
                inputDisplay.setText("");
                outputDisplay.setText(firstValue + "%");
            }
        });

        equal.setOnClickListener(v -> {
            allCalculations();
            currentSymbol = '0';
            inputDisplay.setText("");
            outputDisplay.setText(firstValue + "");
            firstValue = Double.NaN;
            if (errMsg != null) {
                inputDisplay.setText("");
                outputDisplay.setText(errMsg);
                errMsg = null;
                firstValue = Double.NaN;
            }
        });

        c.setOnClickListener(v -> {
            firstValue = Double.NaN;
            secondValue = Double.NaN;
            currentSymbol = '0';
            inputDisplay.setText("");
            outputDisplay.setText("");
        });

        off.setOnClickListener(v -> finish());

        negative.setOnClickListener(v -> {
            if (inputDisplay.getText().toString().isEmpty()) {
                inputDisplay.setText("-");
            } else if (inputDisplay.getText().toString().equals("-")) {
                inputDisplay.setText("");
            } else {
                allCalculations();
                firstValue *= -1;
                inputDisplay.setText(firstValue + "");
            }
        });
    }

    public void allCalculations() {
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(inputDisplay.getText().toString());
            switch (currentSymbol) {
                case ADDITION:
                    this.firstValue = calculatorController.add(firstValue, secondValue);
                    break;
                case SUBTRACTION:
                    this.firstValue = calculatorController.sub(firstValue, secondValue);
                    break;
                case MULTIPLICATION:
                    this.firstValue = calculatorController.multi(firstValue, secondValue);
                    break;
                case DIVISION:
                    try {
                        this.firstValue = calculatorController.div(firstValue, secondValue);
                    } catch (IllegalArgumentException e) {
                        errMsg = "cannot divide by zero";
                    }
                    break;
                case MOD:
                    this.firstValue = calculatorController.mod(firstValue, secondValue);
                    break;
            }
        } else {
            try {
                firstValue = Double.parseDouble(inputDisplay.getText().toString());
            } catch (NumberFormatException e) {
                inputDisplay.setText("");
            }
        }
    }
}