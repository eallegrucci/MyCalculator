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

    @Override
    public void onClick(View v) {
        //TODO: store the data from "answer" into a local string
        //add new input to string and redisplay
        //helper function for displaying called display()
        //helper function for add, sub, mult, div
        //helper function for answer
        //helper function for del

        if (v.getId() == R.id.btnLParen) {
            answer.setText("(");
        }
        if (v.getId() == R.id.btnRParen) {
            answer.setText(")");
        }
        if (v.getId() == R.id.btnMult) {
            answer.setText("*");
        }
        if (v.getId() == R.id.btnDel) {
            answer.setText("DEL");
        }
        if (v.getId() == R.id.btnDiv) {
            answer.setText("/");
        }
        if (v.getId() == R.id.btnAdd) {
            answer.setText("+");
        }
        if (v.getId() == R.id.btnSub) {
            answer.setText("-");
        }
        if (v.getId() == R.id.btnDot) {
            answer.setText(".");
        }
        if (v.getId() == R.id.btnEq) {
            answer.setText("=");
        }
        if (v.getId() == R.id.btnOne) {
            answer.setText("1");
        }
        if (v.getId() == R.id.btnTwo) {
            answer.setText("2");
        }
        if (v.getId() == R.id.btnThree) {
            answer.setText("3");
        }
        if (v.getId() == R.id.btnFour) {
            answer.setText("4");
        }
        if (v.getId() == R.id.btnFive) {
            answer.setText("5");
        }
        if (v.getId() == R.id.btnSix) {
            answer.setText("6");
        }
        if (v.getId() == R.id.btnSeven) {
            answer.setText("7");
        }
        if (v.getId() == R.id.btnEight) {
            answer.setText("8");
        }
        if (v.getId() == R.id.btnNine) {
            answer.setText("9");
        }
        if (v.getId() == R.id.btnZero) {
            answer.setText("0");
        }
    }
}
