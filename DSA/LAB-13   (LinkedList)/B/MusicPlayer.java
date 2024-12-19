import java.awt.Desktop;
import java.net.URI;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Timer;
import java.util.TimerTask;

public class MusicPlayer {
    Node head;
    Node tail;

    public MusicPlayer() {
        this.head = null;
        this.tail = null;
    }

    public void addFirst(String value) {
        Node node = new Node(value);
        if (head == null) {
            node.left = null;
            node.right = null;
            head = node;
            tail = node;
            return;
        }
        node.left = null;
        node.right = head;
        head.left = node;
        head = node;
    }

    public void addLast(String value) {
        Node node = new Node(value);
        if (tail == null) {
            node.left = null;
            node.right = null;
            head = node;
            tail = node;
            return;
        }
        tail.right = node;
        node.left = tail;
        node.right = null;
        tail = node;
    }

    public void delete(String value) {
        Node pointer = head;
        Node prePointer = head;
        if (head.data.equals(value)) {
            head = head.right;
            head.left = null;
        }
        if (tail.data.equals(value)) {
            tail = tail.left;
            tail.right = null;
        } else {
            while (!pointer.data.equals(value)) {
                prePointer = pointer;
                pointer = pointer.right;
            }
            prePointer.right = pointer.right;
            pointer = pointer.right;
            pointer.left = prePointer;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("No songs in the playlist.");
            return;
        }

        Node pointer = head;
        int count = 1;

        while (pointer != null) {
            System.out.println("Song no. " + count + " " + pointer.data);
            pointer = pointer.right;
            count++;
        }

        System.out.println();
    }

    public void displayNew() {
        if (tail == null) {
            System.out.println("No songs in the playlist.");
            return;
        }

        Node pointer = tail;
        int count = 1;

        while (pointer != null) {
            System.out.println("Song no. " + count + " " + pointer.data);
            pointer = pointer.left;
            count++;
        }

        System.out.println();
    }

    public int size() {
        Node pointer = head;
        int c = 0;
        while (pointer.right != null) {
            pointer = pointer.right;
            c++;
        }
        return c;
    }

    public void random() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(size()) + 1;
        Node pointer = head;
        for (int i = 1; i < randomIndex; i++) {
            pointer = pointer.right;
        }
        System.out.println("Playing random song: " + pointer.data);
        String youtubeLink = "https://www.youtube.com/results?search_query=" + pointer.data.replace(" ", "+");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Desktop.getDesktop().browse(new URI(youtubeLink));
                } catch (Exception e) {
                    System.out.println("Error opening YouTube link: " + e.getMessage());
                }
            }
        }, 1000);
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Node pointer = head;
            while (pointer != null) {
                writer.write(pointer.data);
                writer.newLine();
                pointer = pointer.right;
            }
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                addLast(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        final String GREEN = "\033[0;32m";
        final String RESET = "\033[0m";
        System.out.println(GREEN + "\r\n" + //
                "  _______            __          __             \r\n" + //
                " |__   __|           \\ \\        / /             \r\n" + //
                "    | |_   _ _ __   __\\ \\  /\\  / /_ ___   _____ \r\n" + //
                "    | | | | | '_ \\ / _ \\ \\/  \\/ / _` \\ \\ / / _ \\\r\n" + //
                "    | | |_| | | | |  __/\\  /\\  / (_| |\\ V /  __/\r\n" + //
                "    |_|\\__,_|_| |_|\\___| \\/  \\/ \\__,_| \\_/ \\___|\r\n" + //
                "                                                \r\n" + //
                "                                                \r\n" + //
                "" + RESET);
        final String CYAN = "\033[0;36m";
        final String YELLOW = "\033[0;33m";
        final String RED_BOLD = "\033[1;31m";
        MusicPlayer list = new MusicPlayer();
        Scanner jt = new Scanner(System.in);
        final String dataFilename = "playlist.txt";
        File file = new File(dataFilename);
        if (!file.exists()) {
            System.out.println("Playlist file not found. Creating a new file...");
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }
        list.loadFromFile(dataFilename);
        System.out.println(CYAN + "What you do in your music playlist :-" + RESET);
        System.out.println("1. Add new song at last.");
        System.out.println("2. Add new song at first.");
        System.out.println("3. Remove song");
        System.out.println("4. Show as new to old");
        System.out.println("5. Show as old to new");
        System.out.println("6. Play ramdom song to playlist.");
        System.out.println("7. See total no of song");
        System.out.println("8. exit");
        while (true) {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.print(RED_BOLD + ">>>  " + RESET);
            int select = jt.nextInt();
            jt.nextLine();

            String choice = "";

            System.out.println("-------------------------------------------------------------------------------------");

            if (select == 1) {
                System.out.println(YELLOW + "You select option no. 1" + RESET);
                System.out.println();
                while (true) {
                    System.out.print("Enter the song : ");
                    choice = jt.nextLine();
                    if (choice.equals("stop")) {
                        break;
                    }
                    list.addLast(choice);
                    list.saveToFile(dataFilename);
                }
            } else if (select == 2) {
                System.out.println(YELLOW + "You select option no. 2" + RESET);
                System.out.println();
                while (true) {
                    System.out.print("Enter the song : ");
                    choice = jt.nextLine();
                    if (choice.equals("stop")) {
                        break;
                    }
                    list.addFirst(choice);
                    list.saveToFile(dataFilename);
                }
            } else if (select == 3) {
                System.out.println(YELLOW + "You select option no. 3" + RESET);
                System.out.println();
                while (true) {
                    System.out.print("Enter the song : ");
                    choice = jt.nextLine();
                    if (choice.equals("stop")) {
                        break;
                    }
                    try {
                        list.delete(choice);
                        list.saveToFile(dataFilename);
                    } catch (Exception e) {
                        System.out.println(RED_BOLD + "Song not match" + RESET);
                    }
                }
            } else if (select == 4) {
                System.out.println(YELLOW + "You select option no. 4" + RESET);
                list.displayNew();
            } else if (select == 5) {
                System.out.println(YELLOW + "You select option no. 5" + RESET);
                list.display();
            } else if (select == 6) {
                list.random();
            } else if (select == 7) {
                try {
                    int c = list.size();
                    System.out.println("No of song : " + (c + 1));
                } catch (Exception e) {
                    System.out.println("Enter Song first : ");
                }
            } else if (select == 8) {
                System.out.println(RED_BOLD + "Exiting..." + RESET);
                break;
                // System.exit(select);
            } else {
                System.out.println(RED_BOLD + "Error (JT): Function not found" + RESET);
            }
        }
        return;
    }
}

class Node {
    String data;
    Node left;
    Node right;

    Node(String value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}
