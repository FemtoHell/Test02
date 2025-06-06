package com.example.test02;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameInput;
    private Button wishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameInput = findViewById(R.id.nameInput);
        wishButton = findViewById(R.id.wishButton);


        wishButton.setOnClickListener(v -> {
            String userName = nameInput.getText().toString().trim();


            if (userName.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter your name!", Toast.LENGTH_SHORT).show();
                return;
            }


            Intent intent = new Intent(MainActivity.this, LuckyNumberActivity.class);
            intent.putExtra("USER_NAME", userName);
            startActivity(intent);
        });
    }
}