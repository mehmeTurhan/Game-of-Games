/**
 * Class: guessTheNumber
 * This class implements 'Guess the Number' game. In this game, player is playing
 * against the computer. Player guesses a number in the range, and the computer chooses a number in the range.
 * if player guesses right, they win! IF not, they have a certain amount of tries before they lose.
 * If they are unable to guess correctly, the computer wins.
 * @author: Lucas Stowe  
 * @version 1.0 , 11/30/2022
 * 
 * 
 * this version has bugs to catch!
 *
*/

import java.util.*;

public class guessTheNumberBug extends getInput {

    // declare variables
    private int rangeLow;
    private int rangeHigh;
    private int compGuess;
    private int playerGuess;
    private int numGuesses;
    private int numGuessesCounter = 0;
    private int winner;
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

    }

    // getNumGuesses method
    public void getNumGuesses() {

        numGuesses = getNumberOfGuesses(rangeHigh, rangeLow);

    }

    /*
     * getGuesses function is tentatively set as computer always chooses, user always guesses
     */
    public void getGuesses() {

        // COMPUTER CHOOSES
        compGuess = getRandomInt(rangeLow, 15);

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

    }

    public void checkGuesses() {

        if (compGuess == playerGuess){

            System.out.println("Guess Correct! Player wins!");
            winner = 1;

        }
        else {  // implies guess was incorrect
    
            System.out.println("Incorrect Guess.");
            System.out.println("\n"); // formatting output

            // check if max guesses is NOT yet reached
            if (numGuessesCounter > numGuesses){

                System.out.println("You have " + (numGuesses - numGuessesCounter) + " guesses to go.");
                System.out.println("\n"); // formatting output
                getGuesses();

            }
            else {  // implies max guesses has been reached

                System.out.println("You lose!");
                winner = 2;

            }

        }

    }

    public int playGuessTheNumber() {

        startDisplay();
        getRange();
        getNumGuesses();
        getGuesses();

        return winner;
    }

}