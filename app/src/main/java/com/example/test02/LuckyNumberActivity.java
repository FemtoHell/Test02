package com.example.test02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;
import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    private TextView luckyNumberTitle;
    private TextView luckyNumberDisplay;

    private String userName;
    private int luckyNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luck);


        luckyNumberTitle = findViewById(R.id.luckyNumberTitle);
        luckyNumberDisplay = findViewById(R.id.luckyNumberDisplay);


        Intent intent = getIntent();
        userName = intent.getStringExtra("USER_NAME");


        Random random = new Random();
        luckyNumber = random.nextInt(1000) + 1;


        updateUI();



    }

    @SuppressLint("SetTextI18n")
    private void updateUI() {

        luckyNumberTitle.setText(userName + "'s Lucky Number is:");


        luckyNumberDisplay.setText(String.valueOf(luckyNumber));
    }


}