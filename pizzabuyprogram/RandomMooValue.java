package com.example.pizzabuyprogram;

import java.util.Random;

public class RandomMooValue {
    private String secretValue = "0000";
    public String guess = "0000";
    public Boolean correctGuess = false;
    public int bigCount = 5;
    public int littleCount = 6;
    public void setSecretValue(String secretValue)
    {
        this.secretValue = String.valueOf(secretValue);
    }
    public void setSecretValue(){
        Random rand = new Random();

        String str = Integer.toString(rand.nextInt(10000));
        for(int i = 0; i < 4 - str.length(); i++){
            str = "0" + str;
        }
        secretValue = str;
    }
    public void checkGuess() {
        boolean[] referenced = {false, false, false, false};
        boolean[] referencedGuess = {false, false, false, false};
        this.bigCount = 0;
        this.littleCount = 0;
        for (int i = 0; i < this.secretValue.length(); i++) {
            if (String.valueOf(this.secretValue.charAt(i)).equals(String.valueOf(this.guess.charAt(i)))) {
                this.bigCount++;
                referenced[i] = true;
                referencedGuess[i] = true;
            }
        }
        for (int i = 0; i < this.secretValue.length(); i++) {
            for (int j = 0; j < this.secretValue.length(); j++) {
                if ((this.secretValue.charAt(i)) == (this.guess.charAt(j))) {
                    if (!referencedGuess[j] && !referenced[i]) {
                        this.littleCount++;
                        referencedGuess[j] = true;
                        referenced[i] = true;
                        j = this.secretValue.length();
                    }
                }
            }
        }
    }

    public int getBigMooCount() {
        return this.bigCount;
    }

    public int getLittleMooCount() {
        return this.littleCount;
    }

    public boolean isCorrectGuess() {
        this.correctGuess = bigCount == 4;
        return this.correctGuess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getSecretValue() { return secretValue;}
}
