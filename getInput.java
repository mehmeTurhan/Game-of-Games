import java.util.Scanner;

public class getInput {

    private int bestOutOfNumber; // this is a value for: hideTheThimble, coinFlip, and EvenAndOdd
    private String playerChoice; //player choice for hideTheThimble, coinFlip
    private int numberOfSpoolsToPull;
    private Scanner scanner;

    public getInput() {
      bestOutOfNumber = 0;
      numberOfSpoolsToPull = 0;
      playerChoice = "";
      scanner = new Scanner(System.in);
    }
    /*
    * This is a utility method that prompts and validates
    * "best out number" from the user and return
    * value to the caller of: hideTheThimble, coinFlip, and EvenAndOdd
    *
    * @return an odd number to the caller
    */

    public int getBestOfNumber() {
        System.out.println("Select a best out of number, must be odd: ");
        bestOutOfNumber = scanner.nextInt();
        while (bestOutOfNumber % 2 == 0) {
            System.out.print("Select an Odd number: ");
            bestOutOfNumber = scanner.nextInt();
        }
        return bestOutOfNumber;
      }


      /*
      * This is a utility method that prompts and validates
      * player choices for hideTheThimble and coinFlip from the user and return
      * value to the caller of: hideTheThimble, coinFlip
      *
      * @return an a string to the caller
      */
      public String getPlayerChoice(int theChoice){

          if (theChoice == 1){
            System.out.print("Select choice, H or T: ");
            playerChoice = scanner.next();
            while (!("HT".contains(playerChoice)) ){
                    System.out.print("Input H or T: ");
                    playerChoice = scanner.next();
            }
          } else {
            if (theChoice == 2){
              System.out.print("Select Hand, L or R: ");
              playerChoice = scanner.next();
              while (!("HT".contains(playerChoice)) ){
                System.out.println("Select Hand, L or R: ");
                playerChoice = scanner.next();
              }
            }
          }

          return playerChoice;
      }


      /**
      * Validates the player inputs Red TheRedThreadGame
      */
      public int userInputValidationChecks() {
        System.out.print("Please draw a value less than half of total spools: ");
        numberOfSpoolsToPull = scanner.nextInt();
        while(numberOfSpoolsToPull > 10 || numberOfSpoolsToPull < 1){
            System.out.print("Please draw less than half of total spools: ");
            numberOfSpoolsToPull = scanner.nextInt();
        }

        return numberOfSpoolsToPull;
      }
    
    
      /*
      * This is a utility method that prompts 
      * player choices for guessTheNumber and returns
      * value of the low point of range to caller
      *
      * @return integer to caller
      */
    public int getRangeLow() {

        int rangeLow;
        System.out.println("Select low number for range: ");
        rangeLow = scanner.nextInt();
        System.out.println("\n"); // formatting output

        return rangeLow;

    }

      /*
      * This is a utility method that prompts 
      * player choices for guessTheNumber and returns
      * value of the high point of range to caller
      *
      * @return integer to caller
      */
        public int getRangeHigh() {

            int rangeHigh;
            System.out.println("Select high number for range: ");
            rangeHigh = scanner.nextInt();
            System.out.println("\n"); // formatting output

            return rangeHigh;
    
        }

      /*
      * This is a utility method that prompts and validates
      * player choices for guessTheNumber and returns
      * value of the number of guesses to caller
      *
      * @return integer to caller
      */
        public int getNumberOfGuesses(int rangeHigh, int rangeLow) {

            int numGuesses;
            final int MAX = (((rangeHigh - rangeLow) / 2) + 1);

            System.out.println("Enter Number of Guesses"); // not specified in use cases BUT alluded to in description
            numGuesses = scanner.nextInt();
            System.out.println("\n"); // formatting output

            while (numGuesses > MAX) {

                System.out.println("Number of Guesses too large. Must be less than or equal to half of the range.");
                System.out.println("Enter Number of Guesses");
                numGuesses = scanner.nextInt();
                System.out.println("\n"); // formatting output

            }

            return numGuesses;
        }

}
