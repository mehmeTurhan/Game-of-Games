import java.util.Random;
import java.util.Scanner;

public class coinFlip {
  int bestOutofNumber=0;
  
  public static getBestNumber(bestOutofNumber){
    Scanner input = new Scanner(System.in);
    
    while ( (bestOutofNumber%2) == 0 ){
      System.out.print("Select a best out of number, must be odd");
      bestOutofNumber = input.nextInt();
    }
    
    return bestOutofNumber;
  }
  
  public static void main(String[] args) {
    getBestNumber(bestOutofNumber);
  }
}
