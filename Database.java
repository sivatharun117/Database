import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {

    public static void main(String[] args) {

        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "your_password";

        try {
            // Establish connection
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            System.out.println("Database connected successfully!");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute SQL query
            String sql = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(sql);

            // Display results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
