import java.util.Hashtable;
import java.util.Scanner;

// Common Methods:
// put(key, value): Adds a key-value pair to the map.
// get(key): Retrieves the value associated with a key.
// containsKey(key): Checks if a key is present in the map.
// remove(key): Removes a key-value pair from the map.
// keySet(): Returns a set of all keys in the map.
// values(): Returns a collection of all values in the map.

public class DictionaryDemo {
    public static void main(String[] args) {
        // Create a Hashtable to store key-value pairs
        Hashtable<String, String> dictionary = new Hashtable<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nDictionary Options:");
            System.out.println("1. Add a new word and its meaning");
            System.out.println("2. Search for the meaning of a word");
            System.out.println("3. Print the dictionary");
            System.out.println("4. Delete a word");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1/2/3/4/5): ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    // Add a new word and its meaning
                    System.out.print("Enter the word: ");
                    String newword = sc.nextLine().toLowerCase();
                    System.out.print("Enter the meaning: ");
                    String meaning = sc.nextLine();
                    dictionary.put(newword, meaning);
                    System.out.println("'" + newword + "' added to the dictionary.");
                    break;

                case 2:
                    // Search for the meaning of a word
                    System.out.print("Enter the word to search for: ");
                    String word = sc.nextLine().toLowerCase();
                    String m = dictionary.get(word);
                    if (m != null) {
                        System.out.println("Meaning of '" + word + "': " + m);
                    } else {
                        System.out.println("'" + word + "' not found in the dictionary.");
                    }
                    break;

                case 3:
                    // Print the dictionary
                    System.out.println("\nDictionary:");
                    for (String key : dictionary.keySet()) {
                        System.out.println(key + ": " + dictionary.get(key));
                    }
                    break;

                case 4:
                    // Delete a word
                    System.out.print("Enter the word to delete: ");
                    String delword = sc.nextLine().toLowerCase();
                    if (dictionary.containsKey(delword)) {
                        dictionary.remove(delword);
                        System.out.println("'" + delword + "' deleted from the dictionary.");
                    } else {
                        System.out.println("'" + delword + "' not found in the dictionary.");
                    }
                    break;

                case 5:
                    // Exit the program
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
