import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logic logic;
        int capacity;
        int menuChoice;
        boolean doesMenuShow = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Enter the Capacity of the HashTable ===");

        while (true) {
            try {
                capacity = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.err.println("\nEnter a valid number!");
            } finally {
                scanner.nextLine();
            }
        }

        logic = new Logic(new Database(capacity));

        while (doesMenuShow) {
            System.out.println("""
                    
                    === HashTable Mastery ===
                    
                    1. PUT something in the table
                    2. GET something from the table
                    3. DELETE something from the table
                    4. Does table CONTAIN
                    5. Get table size
                    6. Exit
                    
                    """);
            while (true) {
                try {
                    menuChoice = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Enter a valid menu option!");
                } finally {
                    scanner.nextLine();
                }
            }

            String key;
            int value;

            switch (menuChoice) {
                case 1:


                    System.out.println("\n=== Enter the key (String) ===");

                    key = scanner.nextLine();

                    System.out.println("\n=== Enter the value (int) ===");

                    while (true) {
                        try {
                            value = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.err.println("\nEnter a valid value!");
                        } finally {
                            scanner.nextLine();
                        }
                    }

                    logic.put(key, value);
                    break;
                case 2:
                    System.out.println("\n=== Enter the key (String) ===");

                    key = scanner.nextLine();

                    value = logic.get(key);

                    if (value != -1) {
                        System.out.println("Key " + key + " has value: " + value);
                    }
                    break;

                case 3:
                    String deleteChoice;

                    System.out.println("\n=== Enter the key (String) ===");

                    key = scanner.nextLine();

                    System.out.println("\n --- Do you really want to delete this entry? (Y/N) ---");

                    deleteChoice = scanner.nextLine();

                    if (deleteChoice.toUpperCase(Locale.ROOT).equals("Y")) {
                        logic.remove(key);
                    }
                    break;

                case 4:
                    System.out.println("\n=== Enter the key (String) ===");

                    key = scanner.nextLine();

                    System.out.println("\n=== Table contains key: " + logic.containsKey(key));
                    break;

                case 5:
                    System.out.println("\n=== Table size: " + logic.size());
                    break;

                case 6:
                    doesMenuShow = false;
                    break;

                default:
                    System.err.println("Enter a valid menu option!");
            }
        }
    }
}