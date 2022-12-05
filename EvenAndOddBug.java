import java.util.*;

public class EvenAndOddBug extends getInput{
	 int sum = 0;
	 public static int player_score = 0;
	 public static int other_score = 0;
	 Scanner sc = new Scanner(System.in);

	 void getSum(int num1, int num2) {
	 	sum = num1 + num2;
	 	System.out.println("----- sum is " + sum + " -----");
	 	
	 	/* Test Mode
	 	 * System.out.println(sum);
	 	*/
	 }

	 String even_or_odd() {
	 	if(sum % 2 == 0) {
	 		System.out.println("The sum is a Even number");
	 		return "E";
	 	} 		
	 	else {
	 		System.out.println("The sum is a Odd number");
	 		return "E"; // Bug
	 	}	 		
	 }

	 void winner(String choice, int BestNum) {
	 	
	 	/* Test Mode
	 	 * System.out.println(even_or_odd());
	 	*/
	 	
	 	if(even_or_odd().equals(choice)) {
	 		other_score++; //Bug
	 		System.out.println("\nYou Win!\n");
	 	}	
	 	else {
	 		other_score++;
	 		System.out.println("\nThe other player Wins!\n");
	 	}
	 	System.out.println("----- Scoreboard -----");
	 	System.out.println("Your score: " + player_score + "\tThe other player score: " + other_score);
	 	if(player_score == BestNum) System.out.println("You are the Winner!!!\n");
	 	else System.out.println("You lose the game...\n");
	 }

	 int getPlayerNum() {
	 	System.out.print("\nChoose an Integer from 1-5: ");
	 	int number = sc.nextInt();
	    while(number < 1 && number > 5) { //Bug
	 		System.out.println("!!! Please follow the instruction and enter valid input !!!\n");
	 		System.out.print("\nChoose an Integer from 1-5: ");
	 		number = sc.nextInt();
	 	}
	 	return number;
	 }

	 public static void main(String[] args) {
	 	System.out.println("\nThe players choose even or odd.They remain even or odd for the whole game; they cannot change from throw to throw. Values from 1-5 are valid throws. The user will specify the “best out of number” for the game. For instance, if they choose 7, the first player to win 4 throws wins the game. The “best of number” chosen must be odd.\n");
	 	EvenAndOdd game = new EvenAndOdd();

		// Promot player choose from Even / Odd number.
		System.out.println("'O' for odd number, 'E' for even number");
	 	String player_choice = game.getPlayerChoice(4);

	 	// Prompt best out of number
		int target = game.getBestOfNumber();

		while(player_score < target || other_score < target) {
			// Promot player enter number from 1-5 
	 		int player_number = game.getPlayerNum();
	 		int another_number = game.getPlayerNum();

	 		// Computer calculate sum
	 		game.getSum(player_number, another_number);

	 		// Decide winner and show scoreboard
        	game.winner(player_choice, target);

        	// End loop
        	if(player_score == target || other_score == target) break;
		} 	
	 }
}