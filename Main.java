import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseHelper.initializeDatabase();
        ExpenseDAO dao = new ExpenseDAO();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nExpense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Generate Report (Includes Arithmetic Operations)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // consume invalid input
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Category: ");
                    String category = scanner.nextLine();

                    System.out.print("Amount: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Please enter a valid amount.");
                        scanner.next();
                    }
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline

                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();

                    dao.addExpense(new Expense(category, amount, date));
                    System.out.println("Expense added successfully!");
                }

                case 2 -> {
                    List<Expense> expenses = dao.getAllExpenses();
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses found.");
                    } else {
                        for (Expense e : expenses) {
                            System.out.println("ID: " + e.getId() + ", " + e.getCategory() + ", $" + e.getAmount() + ", " + e.getDate());
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Enter ID to delete: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Please enter a valid ID.");
                        scanner.next();
                    }
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    dao.deleteExpense(id);
                    System.out.println("Expense deleted.");
                }

                case 4 -> {
                    List<Expense> allExpenses = dao.getAllExpenses();
                    ReportGenerator.generateReport(allExpenses);
                }

                case 0 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0); // ✅ clean exit
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
