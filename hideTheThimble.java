/*
 * header
 */

import java.util.*;

public class hideTheThimble extends getInput {

    // declare variables
    int bestOfNum;
    int playerScore = 0;
    int computerScore = 0;
    char computerHand;
    char playerHand;
    final char LEFTCHAR = 'L';
    final char RIGHTCHAR = 'R';
    final int LEFTINT = 0;
    final int RIGHTINT = 1;
    final int INDEX_ZERO = 0;
    final int ZERO = 0;
    final int ONE = 1;
    final int TWO = 2;
    Scanner sc = new Scanner(System.in);

    private int getRandomInt(int min, int max) {

        Random r = new Random();
        return r.nextInt((max - min) + ONE) + min;
    }

    // start display method
    public void startDisplay() {

        System.out.println(
                "The players will specify the 'best out of number' for the game. For instance, if they choose 7, a player will win the game if they successfully guess the hand holding the thimble 4 or more times. The 'best out of number' chosen must be odd");
        System.out.println("\n"); // formatting output

    }



    // getBestOfNum method:
    public void getBestOfNum() {

        bestOfNum = getBestOfNumber();
        System.out.println("\n"); // formatting output

    }

    public void putThimble() {

        int generator = getRandomInt(LEFTINT, RIGHTINT);

        if (generator == LEFTINT) {

            computerHand = LEFTCHAR;

        } else { // implies generator pulled a 1, and computer selected right hand

            computerHand = RIGHTCHAR;

        }

        /*
         * TEST MODE
         * System.out.println("Computer selected: " + computerHand + "\n");
         */

        getThimbleGuess();
    }

    public void getThimbleGuess() {

        playerHand = getPlayerChoice(2).charAt(0);

        /*
         * TEST MODE
         * System.out.println("User Guess: " + playerHand + "\n");
         */

        displayScoreboard();
        checkGuess();

    }

    public void displayScoreboard() {

        System.out.println("SCOREBOARD");
        System.out.println("Player: " + playerScore + "    Computer: " + computerScore);

    }

    public void checkGuess() {

        int same = (Character.compare(playerHand, computerHand)); // 0 if same, -1 or 1 if not

        if (same == ZERO) {

            playerScore += ONE; // increment by 1

            // if score now equals best of num, return to main with updated GOG Score player
            // + 1
            if (playerScore == bestOfNum) {

                displayScoreboard();
                // implement here

            } else { // implies best of num not reached yet...

                putThimble();

            }

        } else { // implies that the guess was incorrect

            computerScore += ONE; // increment by 1

            // if score now equals best of num, return to main with updated GOG Score
            // computer + 1
            if (computerScore == bestOfNum) {

                displayScoreboard();
                // implement here

            } else { // implies best of num not reached yet...

                putThimble();

            }

        }

    }

    public static void main(String[] args) {

        hideTheThimble game = new hideTheThimble();
        game.startDisplay();
        game.getBestOfNum();
        game.putThimble();

    }

}
