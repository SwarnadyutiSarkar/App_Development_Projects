import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HabitTrackerApp {
    private static Map<String, Integer> habitTracker = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Habit Tracker Menu:");
            System.out.println("1. Add Habit");
            System.out.println("2. Increment Habit");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addHabit(scanner);
                    break;
                case 2:
                    incrementHabit(scanner);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting Habit Tracker App.");
    }

    private static void addHabit(Scanner scanner) {
        System.out.print("Enter habit name: ");
        String habit = scanner.nextLine();

        // Add habit to tracker with initial count of 0
        habitTracker.put(habit, 0);
        System.out.println("Habit added successfully!");
    }

    private static void incrementHabit(Scanner scanner) {
        System.out.print("Enter habit name: ");
        String habit = scanner.nextLine();

        // Increment habit count
        Integer count = habitTracker.get(habit);
        if (count != null) {
            habitTracker.put(habit, count + 1);
            System.out.println(habit + " count incremented to " + (count + 1));
        } else {
            System.out.println("Habit not found.");
        }
    }
}
