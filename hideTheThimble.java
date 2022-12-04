/*
 * header
 */

import java.util.*;

public class hideTheThimble {
   // score variable to keep track of many games each player won
    // declare variables
    int bestOfNum;
    int playerScore = 0;     //ADD A VARIABLE TO TRACK NUMBER OF GAMES WON BY EACH PLAYER UPDATE IT EVERYTIME A PLAYER WINS
    int computerScore = 0;
    char computerHand;
    char playerHand;
    final char LEFTCHAR = 'L';
    final char RIGHTCHAR = 'R';  /// too many variables// maybe reduce them 0,1,2, R,L are can go to the code
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
/********************************THIS METHOD SHOULD BE REPLACE BY getBestOfNumber() IN getInput classs ********************/
    // getBestOfNum method:
    public void getBestOfNum() {

        System.out.println("Select a best out of number, must be odd");
        bestOfNum = sc.nextInt();
        System.out.println("\n"); // formatting output

        // make sure its odd
        while ((bestOfNum % TWO) == ZERO) {

            System.out.println("Select an Odd number");
            bestOfNum = sc.nextInt();
            System.out.println("\n"); // formatting output

        }

        /*
         * TEST MODE
         * System.out.println("Best out of Number: " + bestOfNum); // formatting output
         * System.out.println("\n"); // formatting output
         */

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
      /********************************USER INPUT SHOULD BE READ BY USING BY USING getPlayerChoice() in getInput ********************/

        System.out.println("Select Hand, L or R");
        playerHand = sc.next().charAt(INDEX_ZERO);
        System.out.println("\n"); // formatting output
        System.out.println("User Guess: " + playerHand + "\n");

        // determine correct input

        boolean correct = false;
        int isleft = (Character.compare(playerHand, LEFTCHAR));
        int isright = (Character.compare(playerHand, RIGHTCHAR));

        while (correct == false) {

            if (isleft == ZERO) { // user input is 'L'

                correct = true;

            } else if (isright == ZERO) { // user input is 'R'

                correct = true;

            } else { // implies user input is incorrect
  /********************************USER INPUT SHOULD BE READ BY USING BY USING getPlayerChoice() in getInput ********************/
                System.out.println("Input L or R");
                playerHand = sc.next().charAt(INDEX_ZERO);
                System.out.println("\n"); // formatting output

                // update values
                isleft = (Character.compare(playerHand, LEFTCHAR));
                isright = (Character.compare(playerHand, RIGHTCHAR));

            }

        }

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
