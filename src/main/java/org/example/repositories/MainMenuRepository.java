package org.example.repositories;

public class MainMenuRepository {
    public String startGameMenu(){
        return  "Please select the difficulty level:\n" +
                "1. Easy   (10 chances)\n" +
                "2. Medium (5 chances)\n" +
                "3. Hard   (3 chances)\n" +
                "\n" +
                "Enter your choice:\n";
    }

    public String mainGameMenu(){
        return  "Welcome to the Number Guessing Game!\n" +
                "I'm thinking of a number between 1 and 100.\n" +
                "You have 5 chances to guess the correct number.\n" +
                "\n" +
                "Please select the option:\n" +
                "1. Start Game\n" +
                "2. View ranking (best attempts)\n" +
                "3. Exit   (3 chances)\n" +
                "\n" +
                "Enter your choice:\n";
    }

    public String greatString(String level){
        return "Great! You have selected the " + level +
                " difficulty level.\nLet's start the game!";
    }
    public String congratString(int countNumber){
        return "Congratulations! You guessed the correct number in "+countNumber +" attempts.";
    }

    public String theNumberisGreaterThanString(int guessNumber){ return "The number is greater than " + guessNumber; }
    public String theNumberisLessThanString   (int guessNumber){ return "The number is less than " + guessNumber; }

    public String onlyValidCharacters() { return "Only valid characters"; }
    public String incorrectString()     { return "Incorrect! select 1,2 or 3"; }
    public String enterYourGuess()      { return "Enter your guess:"; }
    public String numberBetween()       { return "Number between 1 and 100"; }
    public String youLoseString()       { return "GAME OVER"; }
    public String enterNumber()         { return "Enter a number"; }
    public String retryString()         { return "probar otra vez? y or n"; }
    public String yesValue()            { return "y"; }
    public String noValue()             { return "n"; }

}
