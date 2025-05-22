import java.util.List;

public class ArithmeticOperations {
    public static double getTotal(List<Expense> expenses) {
        double sum = 0;
        for (Expense e : expenses) {
            sum += e.getAmount();
        }
        return sum;
    }

    public static double getDifference(List<Expense> expenses) {
        if (expenses.isEmpty()) return 0;
        double diff = expenses.get(0).getAmount();
        for (int i = 1; i < expenses.size(); i++) {
            diff -= expenses.get(i).getAmount();
        }
        return diff;
    }

    public static double getProduct(List<Expense> expenses) {
        double prod = 1;
        for (Expense e : expenses) {
            prod *= e.getAmount();
        }
        return prod;
    }

    public static double getAverage(List<Expense> expenses) {
        if (expenses.isEmpty()) return 0;
        return getTotal(expenses) / expenses.size();
    }
}
