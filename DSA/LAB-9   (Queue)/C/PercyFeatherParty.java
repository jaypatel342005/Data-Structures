import java.util.*;

public class PercyFeatherParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of queries: ");
        int queries = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Stack<String> feathers = new Stack<>();

        System.out.println("Enter the queries:");
        for (int i = 0; i < queries; i++) {
            String query = scanner.nextLine();
            String[] parts = query.split("_");

            if (parts[0].equals("buy")) {
                feathers.push(parts[1]);
            } else if (parts[0].equals("fetch")) {
                if (!feathers.isEmpty()) {
                    String bottomFeather = feathers.remove(0);
                    feathers.push(bottomFeather);
                    System.out.println("Percy wears " + bottomFeather + " feather to the party!");
                } else {
                    System.out.println("Percy's suitcase is empty!");
                }
            }
        }

        scanner.close();
    }
}
