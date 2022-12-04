import java.util.Random;

public class coinFlip extends getInput {
  public static int playerScore=0;    //ADD A VARIABLE TO TRACK NUMBER OF GAMES WON BY EACH PLAYER UPDATE IT EVERYTIME A PLAYER WINS
  public static int computerScore=0;
/********************************THIS METHOD SHOULD BE REPLACE BY getBestOfNumber() IN getInput classs ********************/
    public static int getBestNumber(){
        System.out.println("Select a best out of number, must be odd ");
        int bestOutofNumber = getInt();

        while ( (bestOutofNumber%2) == 0 ){
            System.out.println("Select an Odd number ");
            bestOutofNumber = getInt();
        }

        return bestOutofNumber;
    }
/********************************USER INPUT SHOULD BE READ BY USING BY USING getPlayerChoice() in getInput ********************/
    public static String getPlayerPick(){
        System.out.println("Select choice, H or T ");
        String playerPick = getString();

        while (!("HT".contains(playerPick)) ){

                System.out.println("Input H or T ");
                playerPick = getString();

        }

        return playerPick;
    }

    public static String flipCoin(){

        Random random = new Random();
        int coinflip = random.nextInt(2);
        if ( coinflip == 0){
            System.out.println("The result of the flip is H");
            return  "H";
        }
        else{
            System.out.println("The result of the flip is T");
            return "T";
        }

   }

    public static String displayScoreboard(String pick, String flip){

        if (pick.equals(flip)){
            playerScore += 1;
        }
        else{
            computerScore += 1;
        }

        return "Player 1 :" + playerScore + ", Computer :" + computerScore;
    }

    public static boolean checkFlipsVsBestNum(int bestNumber, int numFlip){
        if (numFlip == bestNumber ){
            return true;
        }
        return false;
    }

  public static void main(String[] args) {
    System.out.println("The players will specify the “best out of number” for the game. For instance, if they choose 7, a player will win the game if they guessed the flip result 4 times. For each coin flip, the player calling heads or tails will indicate if they choose heads or tails.");
    String pick="";
    String flip="";

    int numFlip=0;
    int bestOutofNumber = getBestNumber();
    while(!(checkFlipsVsBestNum(bestOutofNumber, numFlip))){
        pick = getPlayerPick();
        flip = flipCoin();
        numFlip += 1;
        System.out.println(displayScoreboard(pick, flip));
            if(playerScore > (bestOutofNumber/2)){
            System.out.println("Player 1 Wins");
            break;
        }
        else {
            if((checkFlipsVsBestNum(bestOutofNumber, numFlip))){
                System.out.println("Player 1 Loses");
                break;
            }
        }

    }

    input.close();
  }
}
