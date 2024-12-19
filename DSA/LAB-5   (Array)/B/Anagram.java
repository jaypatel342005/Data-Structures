import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of words (N)
        System.out.print("Enter the number of words: ");
        int N = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Create an array to store the words
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            System.out.print("Enter word " + (i + 1) + ": ");
            words[i] = sc.nextLine();
        }

        // Generate a random index
        Random random = new Random();
        int randomIndex = random.nextInt(N);

        // Display the word at the random index
        String displayedWord = words[randomIndex];
        System.out.println("Displayed word: " + displayedWord);

        // User input: Anagram guess
        System.out.print("Enter an anagram of the displayed word: ");
        String userGuess = sc.nextLine();

        // Check if user's guess is an anagram
        boolean isAnagram = checkAnagram(displayedWord, userGuess);
        if (isAnagram) {
            System.out.println("Correct! It's an anagram.");
        } else {
            System.out.println("Oops! Not an anagram.");
        }
    }

    // Helper method to check if two strings are anagrams
    public static boolean checkAnagram(String word1, String word2) {
        // Remove spaces and convert to lowercase
        word1 = word1.replaceAll("\\s", "").toLowerCase();
        word2 = word2.replaceAll("\\s", "").toLowerCase();

        // Sort characters and compare
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
