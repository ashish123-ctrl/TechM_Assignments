package day2;
import java.util.Scanner;
public class alternate {
	public static String capitalizeAlternate(String str) {
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if(i % 2 == 0) 
			{
				charArray[i] = Character.toUpperCase(charArray[i]);
            } 
        }
        return new String(charArray);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String output = capitalizeAlternate(input);
        System.out.println("Output: " + output);
    }
}