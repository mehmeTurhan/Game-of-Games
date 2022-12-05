/*
 * header
 */

import java.util.*;

public class guessTheNumber extends getInput {

    // declare variables
    private int rangeLow;
    private int rangeHigh;
    private int compGuess;
    private int playerGuess;
    private int numGuesses;
    private int numGuessesCounter = 0;
    private final int ONE = 1;
    Scanner sc = new Scanner(System.in);

    private int getRandomInt(int min, int max) {

		Random r = new Random();
		return r.nextInt((max - min) + ONE) + min;
	}

    // start display method
    public void startDisplay() {

        System.out.println(
                "The players will specify the range of numbers and the number of guesses, however the number of guesses cannot be more than half the number of values in the range. So for instance, if the range is from 1-10, the user can make at most 5 guesses.");
                System.out.println("\n"); // formatting output

    }

    // getRange method:
    public void getRange() {

        System.out.println("Select a range of numbers (input 2 integers)");
        rangeLow = getRangeLow();
        rangeHigh = getRangeHigh();
        System.out.println("\n"); // formatting output

        /*          TEST MODE
        System.out.println("\n"); // formatting output
        System.out.println("Range Low:"); // formatting output
        System.out.println(rangeLow); // formatting output
        System.out.println("Range High: "); // formatting output
        System.out.println(rangeHigh); // formatting output
        */

    }

    // getNumGuesses method
    public void getNumGuesses() {

        numGuesses = getNumberOfGuesses(rangeHigh, rangeLow);

        /*      TEST MODE
        System.out.println("Number of Guesses");
        System.out.print(numGuesses);
        System.out.println("\n"); // formatting output
        */
    }

    /*
     * getGuesses function is tentatively set as computer always chooses, user always guesses
     */
    public void getGuesses() {

        // COMPUTER CHOOSES
        compGuess = getRandomInt(rangeLow, rangeHigh);

        // USER CHOOSES
        System.out.println("Guess num:");
        playerGuess = sc.nextInt();
        System.out.println("\n"); // formatting output

        while ((playerGuess > rangeHigh) || (playerGuess < rangeLow)){

            System.out.println("please input a number within the range");
            playerGuess = sc.nextInt();
            System.out.println("\n"); // formatting output

        }

        numGuessesCounter += ONE; // increment by 1

        // call checkGuesses
        checkGuesses();

        /*           TEST MODE
        System.out.println("user guess:"); // formatting output
        System.out.println(guessNum); // formatting output
        System.out.println("comp guess:"); // formatting output
        System.out.println(actualNum); // formatting output
        */




        /*
         * 
         * 
         * 
         * BE SURE TO REMOVE ON SUBMISSION TO OTHER TEAM
         * 
         * added bug to this section:
         * 
         * after the checkGuesses() method is called, it re-calls the getGuesses() method and tries again.
         * 
         * BUT THE getGuesses() METHOD ALSO CHOOSES ANOTHER NUMBER FOR COMPUTER UPON EACH INCORRECT ANSWER
         * 
         * 
         * 
         */

    }

    public void checkGuesses() {

        if (compGuess == playerGuess){

            System.out.println("Guess Correct! Player wins!");
            // break to end, update scoreboard in main

        }
        else {  // implies guess was incorrect
    
            System.out.println("Incorrect Guess.");
            System.out.println("\n"); // formatting output

            // check if max guesses is NOT yet reached
            if (numGuessesCounter < numGuesses){

                System.out.println("You have " + (numGuesses - numGuessesCounter) + " guesses to go.");
                System.out.println("\n"); // formatting output
                getGuesses();

            }
            else {  // implies max guesses has been reached

                System.out.println("You lose!");
                // break to end, update scoreboard in main

            }

        }

    }

    public static void main(String[] args) {

        guessTheNumber game = new guessTheNumber();
        game.startDisplay();
        game.getRange();
        game.getNumGuesses();
        game.getGuesses();

    }

}