import java.util.*;

public class ReportGenerator {
    public static void generateReport(List<Expense> expenses) {
        System.out.println("\n--- Expense Report ---");

        double total = ArithmeticOperations.getTotal(expenses);
        double diff = ArithmeticOperations.getDifference(expenses);
        double prod = ArithmeticOperations.getProduct(expenses);
        double avg = ArithmeticOperations.getAverage(expenses);

        Map<String, Double> categoryMap = new HashMap<>();

        for (Expense e : expenses) {
            categoryMap.put(e.getCategory(),
                categoryMap.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }

        System.out.println("Total Expenses: $" + total);
        System.out.println("Subtracted Total (left-to-right): $" + diff);
        System.out.println("Product of Amounts: $" + prod);
        System.out.println("Average Expense: $" + avg);

        System.out.println("\nCategory-wise Breakdown:");
        for (Map.Entry<String, Double> entry : categoryMap.entrySet()) {
            System.out.println("- " + entry.getKey() + ": $" + entry.getValue());
        }
        System.out.println("--------------------------");
    }
}
