package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button leftParen, rightParen, dot, del;
    Button one, two, three, four, five, six, seven, eight, nine, zero;
    Button add, sub, div, mult;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftParen = (Button)findViewById(R.id.btnLParen);
        rightParen = (Button)findViewById(R.id.btnRParen);
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
        answer = (TextView)findViewById(R.id.answer);
        leftParen.setOnClickListener(this);
        rightParen.setOnClickListener(this);
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
    }

    protected void displayValue() {
        CharSequence text = answer.getText();
        CharSequence result = "";
        CharSequence val, left, right;
        if (answer.getTextSize() <= 1) {
            return;
        }
        for (int i = 0; i < text.length(); i++) {
            while (text.charAt(i) != '*' && text.charAt(i) != '(' && text.charAt(i) != ')'
                    && text.charAt(i) != '+' && text.charAt(i) != '-' && text.charAt(i) != '/') {
                //val += text.charAt(i);
            }
        }

        answer.setText(result);
    }

    protected void deleteValue() {
        float size = answer.getTextSize();
        CharSequence text;
        if (size <= 1) {
            answer.setText("");
        }
        else {
            text = answer.getText();
            text = text.subSequence(0, text.length() - 1);
            answer.setText(text);
        }
    }

    @Override
    public void onClick(View v) {
        //TODO: store the data from "answer" into a local string
        //add new input to string and redisplay
        //helper function for displaying called display()
        //helper function for add, sub, mult, div
        //helper function for answer
        //helper function for del

        if (v.getId() == R.id.btnLParen) {
            answer.append("(");
        }
        if (v.getId() == R.id.btnRParen) {
            answer.append(")");
        }
        if (v.getId() == R.id.btnMult) {
            answer.append("*");
        }
        if (v.getId() == R.id.btnDel) {
            //remove item
            deleteValue();
        }
        if (v.getId() == R.id.btnDiv) {
            answer.append("/");
        }
        if (v.getId() == R.id.btnAdd) {
            answer.append("+");
        }
        if (v.getId() == R.id.btnSub) {
            answer.append("-");
        }
        if (v.getId() == R.id.btnDot) {
            answer.append(".");
        }
        if (v.getId() == R.id.btnEq) {
            displayValue();
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
