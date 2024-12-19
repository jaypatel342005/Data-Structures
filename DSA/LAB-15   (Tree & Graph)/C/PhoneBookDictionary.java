class PhoneBookEntry {
    String name;
    String phoneNumber;
    PhoneBookEntry left;
    PhoneBookEntry right;

    PhoneBookEntry(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        left = null;
        right = null;
    }
}

public class PhoneBookDictionary {
    private PhoneBookEntry root;

    // Function to add a new entry in the phone book
    public void addEntry(String name, String phoneNumber) {
        root = insertEntry(root, name, phoneNumber);
    }

    private PhoneBookEntry insertEntry(PhoneBookEntry node, String name, String phoneNumber) {
        if (node == null) {
            return new PhoneBookEntry(name, phoneNumber);
        }
        int compareResult = name.compareTo(node.name);
        if (compareResult < 0) {
            node.left = insertEntry(node.left, name, phoneNumber);
        } else if (compareResult > 0) {
            node.right = insertEntry(node.right, name, phoneNumber);
        } else {
            // If the name already exists, update the phone number
            node.phoneNumber = phoneNumber;
        }
        return node;
    }

    // Function to remove an entry from the phone book
    public void removeEntry(String name) {
        root = removeEntry(root, name);
    }

    private PhoneBookEntry removeEntry(PhoneBookEntry node, String name) {
        if (node == null) {
            return null;
        }
        int compareResult = name.compareTo(node.name);
        if (compareResult < 0) {
            node.left = removeEntry(node.left, name);
        } else if (compareResult > 0) {
            node.right = removeEntry(node.right, name);
        } else {
            // If the name is found, delete the node
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.name = minValue(node.right);
            node.right = removeEntry(node.right, node.name);
        }
        return node;
    }

    private String minValue(PhoneBookEntry node) {
        String minv = node.name;
        while (node.left != null) {
            minv = node.left.name;
            node = node.left;
        }
        return minv;
    }

    // Function to search for a phone number given a name
    public String searchPhoneNumber(String name) {
        return searchPhoneNumber(root, name);
    }

    private String searchPhoneNumber(PhoneBookEntry node, String name) {
        if (node == null) {
            return null;
        }
        int compareResult = name.compareTo(node.name);
        if (compareResult < 0) {
            return searchPhoneNumber(node.left, name);
        } else if (compareResult > 0) {
            return searchPhoneNumber(node.right, name);
        } else {
            return node.phoneNumber;
        }
    }

    // Function to list all entries in ascending order of name
    public void listEntriesAscending() {
        listEntriesAscending(root);
    }

    private void listEntriesAscending(PhoneBookEntry node) {
        if (node != null) {
            listEntriesAscending(node.left);
            System.out.println(node.name + ": " + node.phoneNumber);
            listEntriesAscending(node.right);
        }
    }

    // Function to list all entries in descending order of name
    public void listEntriesDescending() {
        listEntriesDescending(root);
    }

    private void listEntriesDescending(PhoneBookEntry node) {
        if (node != null) {
            listEntriesDescending(node.right);
            System.out.println(node.name + ": " + node.phoneNumber);
            listEntriesDescending(node.left);
        }
    }

    public static void main(String[] args) {
        PhoneBookDictionary phoneBook = new PhoneBookDictionary();

        // Add new entries
        phoneBook.addEntry("John", "1234567890");
        phoneBook.addEntry("Alice", "9876543210");
        phoneBook.addEntry("Bob", "4567890123");
        phoneBook.addEntry("Emily", "3210987654");

        // Search for a phone number
        String phoneNumber = phoneBook.searchPhoneNumber("Alice");
        if (phoneNumber != null) {
            System.out.println("Phone number of Alice: " + phoneNumber);
        } else {
            System.out.println("Alice not found in the phone book.");
        }

        // Remove an entry
        phoneBook.removeEntry("Bob");

        // List all entries in ascending order of name
        System.out.println("\nEntries in ascending order of name:");
        phoneBook.listEntriesAscending();

        // List all entries in descending order of name
        System.out.println("\nEntries in descending order of name:");
        phoneBook.listEntriesDescending();
    }
}
