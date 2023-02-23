package com.example.pizzabuyprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RandomMooValue rmv = new RandomMooValue();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button setSecretValueButton = findViewById(R.id.SSV);
        final Button randomButton = findViewById(R.id.Random);
        final Button button = findViewById((R.id.checkGuessButton));
        final EditText secretValue = findViewById(R.id.inValue);
        final EditText guessValue = findViewById(R.id.guessValue);
        final TextView bigCount = findViewById(R.id.bigMooCount);
        final TextView littleCount = findViewById(R.id.littleMooCount);
        final TextView correct = findViewById(R.id.correctGuess);
        setSecretValueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Code here executes on main thread after user presses button
                rmv.setSecretValue(secretValue.getText().toString());
            }
        });
        randomButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Code here executes on main thread after user presses button
                rmv.setSecretValue();
                secretValue.setText(rmv.getSecretValue());

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (secretValue.getText().toString().length() == 4) {
                    rmv.setSecretValue(secretValue.getText().toString());
                }

                rmv.setGuess(guessValue.getText().toString());
                rmv.checkGuess();
                littleCount.setText(Integer.toString(rmv.getBigMooCount()));

                if (guessValue.length() == 4) {
                    if (rmv.isCorrectGuess()) {
                        correct.setText("LORI MOO");
                    } else {
                        correct.setText("No Lori Moo");
                    }
                } else {
                    guessValue.setText("0055");
                    rmv.setGuess("0000");
                }
                bigCount.setText(Integer.toString(rmv.getBigMooCount()));
                littleCount.setText(Integer.toString(rmv.getLittleMooCount()));
            }
        });
    }
}