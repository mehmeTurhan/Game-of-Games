import java.util.*;
class PlayGamesTest {

  private static int player1Score;
  private static int computerScore;
  //private static List<List<Integer>> GamesOfGamesScoreboard = new ArrayList<>();
  private static int[][] GamesOfGamesScoreboard = new int[5][2];
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      // System.out.println("The players stipulate how many spools a player can \"pull from the box\" at a time, but it cannot be more than half the total number of spools. There are always assumed to be 20 spools, one of which is red.");
      // System.out.print("Enter the number of spools to draw (Number between 1 - 10): ");

      // game objects
       TheRedThreadGameTest redThreadGame;
       CoinFlipTest coinFlipGame;
       hideTheThimbleTest hideTheThimble;
       guessTheNumberTest guessTheNumber;
       EvenAndOddTest even_or_odd;

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
          hideTheThimble = new hideTheThimbleTest();
          winner = hideTheThimble.playhideTheThimble();
          hideTheThimble.displayScoreboard();
          scoreboard(winner, gameChoice, GamesOfGamesScoreboard);
            break;
          case 2:
            System.out.println("\nYou are playing the Coin Flip Game!\n");
            coinFlipGame = new CoinFlipTest();
            winner = coinFlipGame.playCoinFlip();
            scoreboard(winner, gameChoice, GamesOfGamesScoreboard);
            break;
          case 3:
            System.out.println("\nYou are playing the Guess the Number!\n");
            guessTheNumber = new guessTheNumberTest();
            winner = guessTheNumber.playGuessTheNumber();
            scoreboard(winner, gameChoice, GamesOfGamesScoreboard);
            break;
          case 4:
            System.out.println("\nYou are playing the Even and Odd Game!\n");
            even_or_odd = new EvenAndOddTest();
            winner = even_or_odd.playEvenOrOdd();
            scoreboard(winner, gameChoice, GamesOfGamesScoreboard);
            break;
          case 5:
                System.out.println("\nYou are playing the Red Thread Game! 1 in the list represents the Red Thread,\n");
                redThreadGame = new TheRedThreadGameTest(); // new instance of the game
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

      finalScoreboard(gameChoice, GamesOfGamesScoreboard);

      scanner.close();
  }


  public static void scoreboard(int winner, int gameChoice, int [][] GamesOfGamesScoreboard) {
                player1Score = GamesOfGamesScoreboard[gameChoice - 1][0];
                computerScore = GamesOfGamesScoreboard[gameChoice - 1][1];
                if(winner == 1) {
                 player1Score = player1Score + 1;
                 GamesOfGamesScoreboard[gameChoice - 1][0] = player1Score;
                 if(gameChoice == 5) {
                   System.out.println("You Won " + GamesOfGamesScoreboard[gameChoice - 1][0]);
                 }
                }else if(winner == 2) {
                  computerScore = computerScore + 1;
                  GamesOfGamesScoreboard[gameChoice - 1][1] = computerScore;
                  if(gameChoice == 5) {
                    System.out.println("The Computer Won " + GamesOfGamesScoreboard[gameChoice - 1][1]);
                  }

                }

  }

  public static void finalScoreboard( int gameChoice, int [][] GamesOfGamesScoreboard) {

                // int playerTotalScore = 0;
                // int computerTotalScore = 0;
                int gamesWonByComputer = 0;
                int gamesWonByThePlayer = 0;
                for(int i = 0; i < GamesOfGamesScoreboard.length; i++){
                    if(GamesOfGamesScoreboard[i][0] > GamesOfGamesScoreboard[i][1]){
                      gamesWonByThePlayer = gamesWonByThePlayer + 1;
                      System.out.println("Player: " + GamesOfGamesScoreboard[i][0] );
                    }else {
                      gamesWonByComputer = gamesWonByComputer + 1;
                      System.out.println("Computer: " + GamesOfGamesScoreboard[i][1] );
                    }
                    // playerTotalScore = GamesOfGamesScoreboard[i][0];
                    // computerTotalScore += GamesOfGamesScoreboard[i][1];
                }
              //  System.out.println("Computer: " + computerTotalScore + "PLAYER: " + playerTotalScore);
                if(gamesWonByThePlayer > gamesWonByComputer) {
                  System.out.println("You are the winner. You won " + gamesWonByThePlayer + "/" + GamesOfGamesScoreboard.length + " games.");
                  System.out.println("You Lost " + (GamesOfGamesScoreboard.length - gamesWonByThePlayer) + "/" + GamesOfGamesScoreboard.length);
                } else {
                    System.out.println("The Computer Won. It Won " + gamesWonByComputer + "/" + GamesOfGamesScoreboard.length);
                    System.out.println("It Lost " + (GamesOfGamesScoreboard.length -  gamesWonByComputer) + "/" + GamesOfGamesScoreboard.length);
                }
  }

  public static void displayTheGamesOfGamesMenu(){

    System.out.println("Please enter the game to play or quit the Games of Games: \n");
    System.out.println("1. Find the Thimble.");
    System.out.println("2. Coin Flip.");
    System.out.println("3. Guess the Number.");
    System.out.println("4. Even and Odd.");
    System.out.println("5. Find the Red Thread.");
    System.out.println("6. Or Quit the Games of Games.\n");
    System.out.print("Enter your choice: ");
  }

}
