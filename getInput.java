import java.util.Scanner;

public class getInput {
    public static Scanner input = new Scanner(System.in);

    public static int getInt(){
        int num = input.nextInt();
        return num;
    }

    public static String getString(){
        String strng = input.next();
        return strng;
    } 

    public static char getChar(){
        char chr = input.next().charAt(0);
        return chr;
    } 
    
}
