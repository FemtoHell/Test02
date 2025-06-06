package com.example.test02;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    private TextView luckyNumberTitle;
    private TextView luckyNumberDisplay;
    private Button shareButton;
    private String userName;
    private int luckyNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luck);

        // Initialize views
        luckyNumberTitle = findViewById(R.id.luckyNumberTitle);
        luckyNumberDisplay = findViewById(R.id.luckyNumberDisplay);
        shareButton = findViewById(R.id.button);
        // Get user name from intent
        Intent intent = getIntent();
        userName = intent.getStringExtra("USER_NAME");

        // Generate random lucky number (1-1000)
        Random random = new Random();
        luckyNumber = random.nextInt(1000) + 1;

        // Update UI
        updateUI();

        // Set click listener for share button
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareActivity();
            }
        });
    }

    private void updateUI() {
        // Update title with user name
        luckyNumberTitle.setText(userName + "'s Lucky Number is:");

        // Display the lucky number
        luckyNumberDisplay.setText(String.valueOf(luckyNumber));
    }

    private void shareActivity() {
        // Create share intent
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");

        String shareMessage = "Hey! My name is " + userName +
                " and my lucky number is " + luckyNumber +
                ". What's yours?\n\nDownload Lucky Number App now!";

        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My Lucky Number");

        // Create chooser
        Intent chooser = Intent.createChooser(shareIntent, "Share via");
        startActivity(chooser);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Navigate back to MainActivity
        finish();
    }
}