/**
 * Class:coinFlip
 * This class implements 'Coin Flip' game. In this game, player is playing
 * against the computer. Player guesses heads or tails and computer flips the coin
 * if player guesses right, then player gets a point, if guessed wrong
 * computer gets a point. Whoever raches the (best out of number / 2)+1
 * they win the game
 * 
 * In this mode, we added some bugs for other group to test and find the bugs.
 * 
 * @author: Mehmet Turhan   
 * @version 1.0 , 11/30/2022
 *
*/


import java.util.Random;

public class CoinFlipTestBug extends getInput {
  public static int playerScore=0;   
  public static int computerScore=0;
  private int isTheWinner;
    
    public CoinFlipTestBug() {
        playerScore = 0;
        computerScore = 0;
        isTheWinner = 0;
    }
    //Displays the game description
    public static void gameDisplay(){
        System.out.println("The players will specify the “best out of number” for the game. For instance, if they choose 7, a player will win the game if they guessed the flip result 4 times. For each coin flip, the player calling heads or tails will indicate if they choose heads or tails.");
    }

    //gets the best out of number using getBestOfNumber() from getInput class
    public int getBestNumber(){
        int bestOutofNumber = getBestOfNumber();
        return bestOutofNumber;
    }
    
    //gets the player's pick using getPlayerChoice(theChoice) from getInput class
    public String getPlayerPick(){
        String playerPick = getPlayerChoiceCoinFlip();
        return playerPick;
    }

    //Mimics coin flip by getting a random integer, and making the values equal to heads or tails
    //Also, displays the result of the flip
    public static String flipCoin(){

        Random random = new Random();
        int coinflip = random.nextInt(2);
        if ( coinflip == 0){
            System.out.println("The result of the flip is H");
            return  "H";
        }
        else{
            System.out.println("The result of the flip is H");
            return "T";
        }

   }

    //Updates scores and displays scoreboard
    public static String displayScoreboard(String pick, String flip){

        if (pick.equals(flip)){
            playerScore += 1;
        }
        else{
            computerScore += 1;
        }

        return "Player 1 :" + playerScore + ", Computer :" + computerScore;
    }

    //Checks if number of flips equal to best out of number
    public static boolean checkFlipsVsBestNum(int bestNumber, int numFlip){
        if (numFlip == bestNumber ){
            return true;
        }
        return false;
    }

//Code test in main
   public int playCoinFlip() {
    gameDisplay();  
    String pick="";
    String flip="";

    int numFlip=0;
    int bestOutofNumber = getBestNumber();
    while(!(checkFlipsVsBestNum(bestOutofNumber, numFlip))){
        //flip and display the result before the user picks
        flip = flipCoin();
        pick = getPlayerPick();
        numFlip += 1;
        System.out.println(displayScoreboard(pick, flip));
        if(playerScore == (bestOutofNumber/2)){
            isTheWinner = 1;
            System.out.println("Player 1 Wins");
            break;
        }
        else if((checkFlipsVsBestNum(bestOutofNumber, numFlip))){
            isTheWinner = 2;
            System.out.println("Player 1 Loses");
            break;
        }
    }

    return isTheWinner;
  }
}
