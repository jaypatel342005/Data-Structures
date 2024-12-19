import java.util.Scanner;

public class Vowel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char character = scanner.next().charAt(0);
        character = Character.toLowerCase(character);



        // Check if the character is a vowel
        if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u' ||
            character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U') {
            System.out.println("The character " + character + " is a vowel.");
        } else {
            System.out.println("The character " + character + " is not a vowel.");
        }
        scanner.close();

    }
}
