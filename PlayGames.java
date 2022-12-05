import java.util.*;
class PlayGames {

  private static int player1Score;
  private static int computerScore;
  //private static List<List<Integer>> GamesOfGamesScoreboard = new ArrayList<>();
  private static int[][] GamesOfGamesScoreboard = new int[5][2];
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      // System.out.println("The players stipulate how many spools a player can \"pull from the box\" at a time, but it cannot be more than half the total number of spools. There are always assumed to be 20 spools, one of which is red.");
      // System.out.print("Enter the number of spools to draw (Number between 1 - 10): ");

      // game objects
       TheRedThreadGame redThreadGame;
       CoinFlip coinFlipGame;
       hideTheThimble hideTheThimble;
       guessTheNumber guessTheNumber;

      System.out.println("\n!!!Play the Game of Games!!!\n");
      //displayTheGamesOfGamesMenu();
      int gameChoice;
      //String isGameOver = scanner.nextInt();
      do {
        displayTheGamesOfGamesMenu();
        gameChoice = scanner.nextInt();
        int winner = 0;
        switch (gameChoice) {
          case 1:
          System.out.println("\nYou are playing the Hide The Thimble Game!\n");
          hideTheThimble = new hideTheThimble();
          winner = hideTheThimble.playhideTheThimble();
          //winner = hideTheThimble.playCoinFlip();
          player1Score = GamesOfGamesScoreboard[gameChoice - 1][0];
          computerScore = GamesOfGamesScoreboard[gameChoice - 1][1];
          System.out.println(winner);
            break;
          case 2:
            System.out.println("\nYou are playing the Coin Flip Game!\n");
            coinFlipGame = new CoinFlip();
            winner = coinFlipGame.playCoinFlip();
            player1Score = GamesOfGamesScoreboard[gameChoice - 1][0];
            computerScore = GamesOfGamesScoreboard[gameChoice - 1][1];
            System.out.println(winner);

            if(winner == 1) {
             player1Score = player1Score + 1;
             GamesOfGamesScoreboard[gameChoice - 1][0] = player1Score;
             System.out.println("You Won " + GamesOfGamesScoreboard[gameChoice - 1][0] + " times.");
            }else if(winner == 2) {
              computerScore = computerScore + 1;
              GamesOfGamesScoreboard[gameChoice - 1][1] = computerScore;
              System.out.println("The Computer Won " + GamesOfGamesScoreboard[gameChoice - 1][1] + " times.");
            }
            break;
          case 3:
            System.out.println("\nYou are playing the Guess the Number!\n");
            guessTheNumber = new guessTheNumber();
            winner = guessTheNumber.playGuessTheNumber();
            player1Score = GamesOfGamesScoreboard[gameChoice - 1][0];
            computerScore = GamesOfGamesScoreboard[gameChoice - 1][1];
            System.out.println(winner);

            break;
          case 4:


            break;
          case 5:
                System.out.println("\nYou are playing the Red Thread Game!\n");
                redThreadGame = new TheRedThreadGame(); // new instance of the game
                redThreadGame.fillTheContainerWithThreads(); // repopulate the spools after every game
                winner = redThreadGame.playTheRedThreadGame();  // the players play ground
                // set player scoreboard for every game
                player1Score = GamesOfGamesScoreboard[gameChoice - 1][0];
                computerScore = GamesOfGamesScoreboard[gameChoice - 1][1];

                if(winner == 1) {
                  player1Score = player1Score + 1;
                 GamesOfGamesScoreboard[gameChoice - 1][0] = player1Score;
                 System.out.println("You Won " + GamesOfGamesScoreboard[gameChoice - 1][0] + " times.");
                }else if(winner == 2) {
                  computerScore = computerScore + 1;
                  GamesOfGamesScoreboard[gameChoice - 1][1] = computerScore;
                  System.out.println("The Computer Won " + GamesOfGamesScoreboard[gameChoice - 1][1] + " times.");
                }
                  break;
        }
      } while(gameChoice != 6);

     // games play repeatly until 'quit'
       // after each game, scoreboard displays: # wins / # losses for each player
    // on quit: overall games wons / lost by each player
    // Displays the final winer 🏆🏆🏆🏆 of all games
  }

  public static void displayTheGamesOfGamesMenu(){

    System.out.println("Please enter the game to play or quit the Games of Games: \n");
    System.out.println("1. Find the Thimble.");
    System.out.println("2. Coinf Flip.");
    System.out.println("3. Guess the Number.");
    System.out.println("4. Even and Odd.");
    System.out.println("5. Find the Red Thread.");
    System.out.println("6. Or Quit the Games of Games.\n");
    System.out.print("Enter your choice: ");
  }

}
