import java.sql.*;

public class HomeBudgetDao {
    private static final String URL = "jdbc:mysql://localhost:3306/home_budget_desktop_app?characterEncoding=utf8&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";
    private Connection connection;

    public HomeBudgetDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
    }

    public void save(HomeBudget homeBudget) {
        final String sql = "INSERT INTO home_budget(type, description, amount, date) values(?, ?, ?, ?)";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, homeBudget.getType());
            prepStmt.setString(2, homeBudget.getDescription());
            prepStmt.setDouble(3, homeBudget.getAmount());
            prepStmt.setDate(4, homeBudget.getDate());
            prepStmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Could not add record");
            e.printStackTrace();
        }
    }

    public void read(String type) {
        final String sql = "SELECT * FROM home_budget WHERE type = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, type);
            ResultSet result = prepStmt.executeQuery();
            while (result.next()) {
                HomeBudget homeBudget = new HomeBudget();
                homeBudget.setId(result.getInt("id"));
                homeBudget.setType(result.getString("type"));
                homeBudget.setDescription(result.getString("description"));
                homeBudget.setAmount(result.getDouble("amount"));
                homeBudget.setDate(result.getDate("date"));
                System.out.println(homeBudget);
            }
        }catch (SQLException e) {
            System.out.println("Could not get book");
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
