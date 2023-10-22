package com.example.a300363695_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    int probability, numOfGuesses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView PrintUserName = findViewById(R.id.userNameTextView);
        TextView PrintUserGuesses = findViewById(R.id.userGuessTextView);
        TextView PrintSuccessProbability = findViewById(R.id.probabilityTextView);
        Button BackToMain = findViewById(R.id.backButton);

        Bundle extras = getIntent().getExtras();
        String UserName = extras.getString("key_name");
        numOfGuesses = getIntent().getIntExtra("Guesses", 7);
        if(numOfGuesses == 0)
            probability = 0;
         else
            probability = (100 / numOfGuesses);

        PrintUserName.setText(UserName);
        PrintUserGuesses.setText(String.valueOf(numOfGuesses));
        PrintSuccessProbability.setText(String.valueOf(probability));

        BackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}