
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PasswordManagerApp {
    private static Map<String, String> passwordVault = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Password Manager Menu:");
            System.out.println("1. Add Password");
            System.out.println("2. Retrieve Password");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPassword(scanner);
                    break;
                case 2:
                    retrievePassword(scanner);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting Password Manager App.");
    }

    private static void addPassword(Scanner scanner) {
        System.out.print("Enter website or account name: ");
        String website = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Store password in the vault
        passwordVault.put(website, password);
        System.out.println("Password added successfully!");
    }

    private static void retrievePassword(Scanner scanner) {
        System.out.print("Enter website or account name: ");
        String website = scanner.nextLine();

        // Retrieve password from the vault
        String password = passwordVault.get(website);
        if (password != null) {
            System.out.println("Password for " + website + ": " + password);
        } else {
            System.out.println("Password not found for " + website);
        }
    }
}
