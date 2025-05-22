import java.sql.*;
import java.util.*;

public class ExpenseDAO {
    public void addExpense(Expense e) {
        String sql = "INSERT INTO expenses(category, amount, date) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getCategory());
            stmt.setDouble(2, e.getAmount());
            stmt.setString(3, e.getDate());
            stmt.executeUpdate();
            System.out.println("Expense added.");
        } catch (Exception ex) {
            System.out.println("Add error: " + ex.getMessage());
        }
    }

    public List<Expense> getAllExpenses() {
        List<Expense> list = new ArrayList<>();
        String sql = "SELECT * FROM expenses";

        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Expense(
                    rs.getInt("id"),
                    rs.getString("category"),
                    rs.getDouble("amount"),
                    rs.getString("date")));
            }
        } catch (Exception e) {
            System.out.println("Retrieve error: " + e.getMessage());
        }
        return list;
    }

    public void deleteExpense(int id) {
        String sql = "DELETE FROM expenses WHERE id = ?";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Expense deleted.");
        } catch (Exception e) {
            System.out.println("Delete error: " + e.getMessage());
        }
    }
}
