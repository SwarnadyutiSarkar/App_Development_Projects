import java.util.Scanner;

public class CurrencyConverterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Currency Converter Menu:");
            System.out.println("1. Convert USD to EUR");
            System.out.println("2. Convert EUR to USD");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    convertUSDtoEUR(scanner);
                    break;
                case 2:
                    convertEURtoUSD(scanner);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting Currency Converter App.");
    }

    private static void convertUSDtoEUR(Scanner scanner) {
        System.out.print("Enter USD amount: ");
        double usdAmount = scanner.nextDouble();
        double eurAmount = usdAmount * 0.82; // Conversion rate as of writing
        System.out.println("EUR equivalent: " + eurAmount);
    }

    private static void convertEURtoUSD(Scanner scanner) {
        System.out.print("Enter EUR amount: ");
        double eurAmount = scanner.nextDouble();
        double usdAmount = eurAmount / 0.82; // Conversion rate as of writing
        System.out.println("USD equivalent: " + usdAmount);
    }
}
