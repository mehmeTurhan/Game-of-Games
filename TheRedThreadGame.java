/**
 * Class:TheRedThreadGame
 * This class implements 'Find the Red Thread game'. In this game, two
 * players pull specified number of threads. The players whose threads
 * contain the Red wins the game. In the implementation the Red thread is
 * encoded as value 1.
 * @author: George Abot Abraham Ret
 * @version 1.0 , 11/30/2022
 *
*/

import java.util.*;

class TheRedThreadGame extends getInput{
    private static int numOfThreads; // total number of threads
    private List<Integer> spoolsBox; // box containing the threads
    private boolean isComputerTheWinner; // computer flag
    private boolean isPlayer1TheWinner; // flag for the player
    Scanner scanner;

    public TheRedThreadGame() {
        numOfThreads = 20;
        spoolsBox = new ArrayList<>();
        scanner = new Scanner(System.in);
        isComputerTheWinner = false;
        isPlayer1TheWinner = false;
    }
    /**
     * returns true if the computer found the red thread, 1 represent the red thread
     *
     */
   public boolean getisComputerTheWinner() {
       return isComputerTheWinner;
   }
   /**
    * returns true if the player pulled the red thread, 1 represent the red thread
    *
    */
   public boolean getisPlayer1TheWinner() {
       return isPlayer1TheWinner;
   }

    /**
     * Fills the container with values [1 ... 20] representing all the
     * 20 threads with 1 representing the Red thread
     */
    public void fillTheContainerWithThreads(){
        Random randomThreads = new Random();
        for(int i = 0; i < numOfThreads; i++) {
            spoolsBox.add(i+1); // values [1, 2,3...]
        }
        Collections.shuffle(spoolsBox); // randomise the values
    }
    /**
     * Utility method for the player to the threads
     *
     */
    public void drawSpoolsForPlayer1 (int numberOfSpoolsToPull){
        if(isRedThread(numberOfSpoolsToPull)) {
            isPlayer1TheWinner = true;
        }

    }
    /**
     * Utility method for the Computer to draw the threads
     *
     */
    public void drawSpoolsForTheComputer (int numberOfSpoolsToPull){
        if(isRedThread(numberOfSpoolsToPull)) {
            isComputerTheWinner = true;
        }

    }
     /**
     * if the Red thread, that is 1, is found, return true otherwise false
     * @param numberOfSpoolsToPull number of spools to pull at a time by
     * each player
     * @returns true if the Red thread was found, otherwise false
     */
    private boolean isRedThread(int numberOfSpoolsToPull){
        Random random = new Random();
        int randomIndex = random.nextInt(numOfThreads); // random index of a value to pull from the box

        // Keeps checking as long as 1 is not pull
        while(numberOfSpoolsToPull - 1 >= 0) {
            Integer spoolDrawn = spoolsBox.get(randomIndex); // draw a spool

            if(spoolDrawn == 1) {
                spoolsBox.remove(spoolDrawn); // finally removed the red
                return true; // return once 1 found
            }
            //System.out.println("Index" + randomIndex + " Value:" +  spoolDrawn);
            numOfThreads = numOfThreads - 1; // reduced the spools index
            if(numOfThreads != 0) {
              randomIndex = random.nextInt(numOfThreads);// generate new random index
            }
            spoolsBox.remove(spoolDrawn); // remove the spools that weren't red
            numberOfSpoolsToPull = numberOfSpoolsToPull - 1;
        }
        return false;
    }

    /**
    * This is the game center. This is where players are playing
    * @returns true 1 if the player1 wins and 2 for the computer
    */
    public int playTheRedThreadGame() {
      int numberOfSpoolsToPull;
      int numberOfSpoolsOfPlayer1;
      int theWinner = 0;
      // System.out.print("Please draw less than half of total spools: ");
       numberOfSpoolsToPull = userInputValidationChecks();
      // userInputValidationChecks(numberOfSpoolsToPull);


      // player inputs
      System.out.print("Please enter the number of spools to pull (Number between 1 - 10): ");
      numberOfSpoolsOfPlayer1 = userInputValidationChecks();
      //userInputValidationChecks(numberOfSpoolsToPull);

      while(numberOfSpoolsToPull != numberOfSpoolsOfPlayer1 ) {
        System.out.print("Please the number of spools to pull should be the same as the decided number (Number between 1 - 10): ");
        numberOfSpoolsOfPlayer1 = userInputValidationChecks();
      }

      //fillTheContainerWithThreads(); // the box with values
      drawSpoolsForPlayer1(numberOfSpoolsOfPlayer1); // player1 draws the spools
      drawSpoolsForTheComputer(numberOfSpoolsToPull); // Computer draws the spools
      // if player 1 won
      if(getisPlayer1TheWinner()) {
        System.out.println("You Won!");
        return 1;
      }
      // check if the Computer won
      if(getisComputerTheWinner()){
        System.out.println("The Computer Won.");
        return 2;
      }
    // keeps checking as long as there no winner yet
      while(!spoolsBox.isEmpty()) {
          if(getisPlayer1TheWinner()){
            System.out.println("You Won!");
            theWinner = 1;
            break;
          } else if(getisComputerTheWinner()) {
            System.out.println("The Computer Won!");
            theWinner = 2;
            break;
          }
      // No winner yet, Player 1 pulls more spools
      if(!getisPlayer1TheWinner() && !getisComputerTheWinner()){
       System.out.println("\nYou missed. The Computer pulled " + numberOfSpoolsToPull + " spool(s).");
       drawSpoolsForTheComputer(numberOfSpoolsToPull);
     }

      if(!getisComputerTheWinner() && !getisComputerTheWinner()){
         System.out.print("\nYour turn to pull. The Computer missed!!: ");
           numberOfSpoolsOfPlayer1 = userInputValidationChecks();
            while(numberOfSpoolsToPull != numberOfSpoolsOfPlayer1 ) {
               System.out.print("Please the number of spools to pull must be the same as the decided number (Number between 1 -10): ");
               numberOfSpoolsOfPlayer1 =userInputValidationChecks();
          }
          drawSpoolsForPlayer1(numberOfSpoolsOfPlayer1);
      }

      }

      return theWinner; // winner determined

    }

}
