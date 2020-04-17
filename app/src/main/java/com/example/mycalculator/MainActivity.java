package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

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
        leftVal = (TextView)findViewById(R.id.leftValue);
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
        if(!Double.isNaN(leftValue)) {
            rightValue = Double.parseDouble(answer.getText().toString());
            android.util.Log.i("ComputeCalc: ", "lVal: " + leftValue);
            android.util.Log.i("ComputeCalc: ", "rVal: " + rightValue);
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
            try {
                leftValue = Double.parseDouble(answer.getText().toString());
            }
            catch (Exception e){}
        }
    }

    private void deleteValue() {
        float size = answer.getTextSize();
        CharSequence text;
        if (size >= 1) {
            text = answer.getText();
            text = text.subSequence(0, text.length() - 1);
            answer.setText(text);
        }
        else {
            try {
                answer.setText("0");
            }
            catch (Exception e){}
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSign) {
            double val = Double.parseDouble(answer.getText().toString());
            val = -val;
            answer.setText(decimalFormat.format(val));
        }
        if (v.getId() == R.id.btnMult) {
            computeCalculation();
            CURRENT_ACTION = MULT;
            //answer.append("*");
            android.util.Log.i("OnClick: ", "lVal: " + leftValue);
            android.util.Log.i("onClick: ", "rVal: " + rightValue);
            leftVal.setText(decimalFormat.format(leftValue) + " * ");
            answer.setText(null);
        }
        if (v.getId() == R.id.btnDel) {
            deleteValue();
        }
        if (v.getId() == R.id.btnDiv) {
            computeCalculation();
            CURRENT_ACTION = DIV;
            //answer.append("/");
            android.util.Log.i("OnClick: ", "lVal: " + leftValue);
            android.util.Log.i("onClick: ", "rVal: " + rightValue);
            leftVal.setText(decimalFormat.format(leftValue) + " / ");
            answer.setText(null);
        }
        if (v.getId() == R.id.btnAdd) {
            computeCalculation();
            CURRENT_ACTION = ADD;
            //answer.append("+");
            android.util.Log.i("OnClick: ", "lVal: " + leftValue);
            android.util.Log.i("onClick: ", "rVal: " + rightValue);
            leftVal.setText(decimalFormat.format(leftValue) + " + ");
            answer.setText(null);
        }
        if (v.getId() == R.id.btnSub) {
            computeCalculation();
            CURRENT_ACTION = SUB;
            //answer.append("-");
            android.util.Log.i("OnClick: ", "lVal: " + leftValue);
            android.util.Log.i("onClick: ", "rVal: " + rightValue);
            leftVal.setText(decimalFormat.format(leftValue) + " - ");
            answer.setText(null);
        }
        if (v.getId() == R.id.btnEq) {
            computeCalculation();
            android.util.Log.i("OnClick: ", "lVal: " + leftValue);
            android.util.Log.i("onClick: ", "rVal: " + rightValue);
            leftVal.setText(leftVal.getText().toString() + decimalFormat.format(rightValue) +
                    " = ");// + decimalFormat.format(leftValue));
            answer.setText(decimalFormat.format(leftValue));
            //answer.append(" = " + leftValue);
            leftValue = Double.NaN;
            CURRENT_ACTION = 'O';
        }
        if (v.getId() == R.id.btnDot) {
            answer.append(".");
        }
        if (v.getId() == R.id.btnOne) {
            answer.append("1");
        }
        if (v.getId() == R.id.btnTwo) {
            answer.append("2");
        }
        if (v.getId() == R.id.btnThree) {
            answer.append("3");
        }
        if (v.getId() == R.id.btnFour) {
            answer.append("4");
        }
        if (v.getId() == R.id.btnFive) {
            answer.append("5");
        }
        if (v.getId() == R.id.btnSix) {
            answer.append("6");
        }
        if (v.getId() == R.id.btnSeven) {
            answer.append("7");
        }
        if (v.getId() == R.id.btnEight) {
            answer.append("8");
        }
        if (v.getId() == R.id.btnNine) {
            answer.append("9");
        }
        if (v.getId() == R.id.btnZero) {
            answer.append("0");
        }
    }
}
