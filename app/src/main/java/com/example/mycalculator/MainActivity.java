package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button sign, dot, del, one, two, three, four, five, six, seven, eight, nine, zero;
    Button add, sub, div, mult, equals;
    TextView leftVal, answer;

    private double leftValue = Double.NaN;
    private double rightValue;

    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char MULT = '*';
    private static final char DIV = '/';

    private char CURRENT_ACTION;

    DecimalFormat decimalFormat = new DecimalFormat("#.##########");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sign = (Button)findViewById(R.id.btnSign);
        dot = (Button)findViewById(R.id.btnDot);
        del = (Button)findViewById(R.id.btnDel);
        one = (Button)findViewById(R.id.btnOne);
        two = (Button)findViewById(R.id.btnTwo);
        three = (Button)findViewById(R.id.btnThree);
        four = (Button)findViewById(R.id.btnFour);
        five = (Button)findViewById(R.id.btnFive);
        six = (Button)findViewById(R.id.btnSix);
        seven = (Button)findViewById(R.id.btnSeven);
        eight = (Button)findViewById(R.id.btnEight);
        nine = (Button)findViewById(R.id.btnNine);
        zero = (Button)findViewById(R.id.btnZero);
        add = (Button)findViewById(R.id.btnAdd);
        sub = (Button)findViewById(R.id.btnSub);
        div = (Button)findViewById(R.id.btnDiv);
        mult = (Button)findViewById(R.id.btnMult);
        equals = (Button)findViewById(R.id.btnEq);
        leftVal = (TextView)findViewById(R.id.leftValueText);
        answer = (TextView)findViewById(R.id.answer);
        sign.setOnClickListener(this);
        dot.setOnClickListener(this);
        del.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        div.setOnClickListener(this);
        mult.setOnClickListener(this);
        equals.setOnClickListener(this);
    }

    private void computeCalculation() {
        if(!Double.isNaN(leftValue) && !answer.getText().toString().isEmpty()) {
            rightValue = Double.parseDouble(answer.getText().toString());
            answer.setText(null);

            if(CURRENT_ACTION == ADD)
                leftValue = this.leftValue + rightValue;
            else if(CURRENT_ACTION == SUB)
                leftValue = this.leftValue - rightValue;
            else if(CURRENT_ACTION == MULT)
                leftValue = this.leftValue * rightValue;
            else if(CURRENT_ACTION == DIV)
                leftValue = this.leftValue / rightValue;
        }
        else {
            leftValue = Double.parseDouble(answer.getText().toString());
        }
    }

    private void deleteValue() {
        float size = answer.getText().toString().length();
        CharSequence text;
        android.util.Log.i("deleteVal: ", "size: " + size);
        if (size >= 1) {
            text = answer.getText().toString();
            text = text.subSequence(0, text.length() - 1);
            answer.setText(text);
        }
        else {
            leftValue = Double.NaN;
            rightValue = Double.NaN;
            answer.setText(null);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSign) {
            if (answer.getText().toString().isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                builder.setMessage("No value to negate");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else {
                double val = Double.parseDouble(answer.getText().toString());
                val = -val;
                answer.setText(decimalFormat.format(val));
            }
        }
        if (v.getId() == R.id.btnMult) {
            if (answer.getText().toString().isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                builder.setMessage("Nothing to multiply");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else {
                computeCalculation();
                CURRENT_ACTION = MULT;
                leftVal.setText(decimalFormat.format(leftValue) + " * ");
                answer.setText(null);
            }
        }
        if (v.getId() == R.id.btnDel) {
            deleteValue();
        }
        if (v.getId() == R.id.btnDiv) {
            if (answer.getText().toString().isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                builder.setMessage("Nothing to divide");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else {
                computeCalculation();
                CURRENT_ACTION = DIV;
                leftVal.setText(decimalFormat.format(leftValue) + " / ");
                answer.setText(null);
            }
        }
        if (v.getId() == R.id.btnAdd) {
            if (answer.getText().toString().isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                builder.setMessage("Nothing to add");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else {
                computeCalculation();
                CURRENT_ACTION = ADD;
                leftVal.setText(decimalFormat.format(leftValue) + " + ");
                answer.setText(null);
            }
        }
        if (v.getId() == R.id.btnSub) {
            if (answer.getText().toString().isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                builder.setMessage("Nothing to subtract");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else {
                computeCalculation();
                CURRENT_ACTION = SUB;
                leftVal.setText(decimalFormat.format(leftValue) + " - ");
                answer.setText(null);
            }
        }
        if (v.getId() == R.id.btnEq) {
            if (answer.getText().toString().isEmpty() || Double.isNaN(leftValue)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                builder.setMessage("Nothing to calculate");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else {
                computeCalculation();
                leftVal.setText(leftVal.getText().toString() + decimalFormat.format(rightValue) +
                            " = " + decimalFormat.format(leftValue));
                leftValue = Double.NaN;
                answer.setText(null);
                CURRENT_ACTION = '0';
            }
        }
        if (v.getId() == R.id.btnDot) {
            answer.append(".");
        }
        if (v.getId() == R.id.btnOne) {
            if (answer.getText().toString() == "0") {
                answer.setText("1");
            }
            answer.append("1");
        }
        if (v.getId() == R.id.btnTwo) {
            if (answer.getText().toString() == "0") {
                answer.setText("2");
            }
            answer.append("2");
        }
        if (v.getId() == R.id.btnThree) {
            if (answer.getText().toString() == "0") {
                answer.setText("3");
            }
            answer.append("3");
        }
        if (v.getId() == R.id.btnFour) {
            if (answer.getText().toString() == "0") {
                answer.setText("4");
            }
            answer.append("4");
        }
        if (v.getId() == R.id.btnFive) {
            if (answer.getText().toString() == "0") {
                answer.setText("5");
            }
            answer.append("5");
        }
        if (v.getId() == R.id.btnSix) {
            if (answer.getText().toString() == "0") {
                answer.setText("6");
            }
            answer.append("6");
        }
        if (v.getId() == R.id.btnSeven) {
            if (answer.getText().toString() == "0") {
                answer.setText("7");
            }
            answer.append("7");
        }
        if (v.getId() == R.id.btnEight) {
            if (answer.getText().toString() == "0") {
                answer.setText("8");
            }
            answer.append("8");
        }
        if (v.getId() == R.id.btnNine) {
            if (answer.getText().toString() == "0") {
                answer.setText("9");
            }
            answer.append("9");
        }
        if (v.getId() == R.id.btnZero) {
            if (answer.getText().toString() == "0") {
                answer.setText("0");
            }
            answer.append("0");
        }
    }
}
