package com.example.a300363695_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText UserName;
    EditText UserGuesses;
    int numberOfGuesses;
    char LetterToGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserName = findViewById(R.id.UserName);
        UserGuesses = findViewById(R.id.UserGuess);
        Button goToSummary = findViewById(R.id.summaryButton);
        Button NewGame = findViewById(R.id.newGameButton);

        goToSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("key_name", UserName.getText().toString());
                    intent.putExtra("Guesses", numberOfGuesses);
                    startActivity(intent);
            }
        });

        NewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOfGuesses = 0;
                LetterToGuess = getRandomCapitalLetter();
                UserName = null;
                UserGuesses = null;
            }
        });

    }
    public void checkGuess(View view) {
        String guessStr = UserGuesses.getText().toString();
        if (guessStr.isEmpty()) {
            Toast.makeText(this, "Please enter a valid guess.", Toast.LENGTH_LONG).show();
            return;
        }

        char a = guessStr.toUpperCase().charAt(0);
        char b = LetterToGuess;
        int result = Character.compare(a, b);
        if (result < 0) {
            Toast.makeText(this, "Secret letter is AFTER your guess.", Toast.LENGTH_SHORT).show();
            numberOfGuesses++;
        } else if (result > 0) {
            Toast.makeText(this, "Secret letter is BEFORE your guess.", Toast.LENGTH_SHORT).show();
            numberOfGuesses++;
        } else {
            Toast.makeText(this, "Congratulations! It is Correct Letter", Toast.LENGTH_SHORT).show();
            numberOfGuesses++;
        }
    }

    public void GenerateSecretLetter(View view) {
        LetterToGuess = getRandomCapitalLetter();
        Toast.makeText(this, "Secret Letter Generated! " + LetterToGuess, Toast.LENGTH_LONG).show();
    }

    public char getRandomCapitalLetter() {
        String s = "ABCDEFGHIJ";
        Random random = new Random();
        int index = random.nextInt(s.length());
        char secretLetter = s.charAt(index);
        return secretLetter;
    }

}