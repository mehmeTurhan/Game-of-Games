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

}
