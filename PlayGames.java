import java.util.*;
class PlayGames {

  private int player1Score;
  private int computerScore; 
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      // System.out.println("The players stipulate how many spools a player can \"pull from the box\" at a time, but it cannot be more than half the total number of spools. There are always assumed to be 20 spools, one of which is red.");
      // System.out.print("Enter the number of spools to draw (Number between 1 - 10): ");

      System.out.println("\n!!!Play the Game of Games!!!\n");
      System.out.println("Pick the game to play: \n\n1. Find the Thimble.\n2. Coin Flip.\n3. Guess the Number.\n4. Even and Odd.\n5. Find the Red Thread.");
      int gameToChoice = scanner.nextInt();

              switch (gameToChoice) {
                case 1:

                  break;
                case 2:

                  break;
                case 3:

                  break;
                case 4:

                  break;
                case 5:
                  break;
                case 6:
                  break;
                case 7:
                  break;
              }

      // choose player number
     TheRedThreadGame game = new TheRedThreadGame();
     //game.playGround();

     // games play repeatly until 'quit'
       // after each game, scoreboard displays: # wins / # losses for each player
    // on quit: overall games wons / lost by each player
    // Displays the final winer 🏆🏆🏆🏆 of all games



  }


}
