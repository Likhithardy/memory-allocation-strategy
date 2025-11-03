import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDBConnection {
    public static void main(String[] args) {
        // Step 1: Database details
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";         // your MySQL username
        String password = "pavan0130";     // your MySQL password

        // Step 2: Try connecting
        try {
            // Step 3: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Driver loaded successfully!");

            // Step 4: Create a connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to database!");

            // Step 5: Create a statement
            Statement stmt = conn.createStatement();

            // Step 6: Run a SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            // Step 7: Read data from ResultSet
            System.out.println("\n🎓 Students List:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
            }

            // Step 8: Close connection
            conn.close();
            System.out.println("\n✅ Connection closed.");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
