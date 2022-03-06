import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Connect {
    public static void connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:/Users/bernardmordan/Code/java-projects/RestaurantsDryRun/db.sql";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection made ok");
        } catch(SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch(SQLException err) {
                System.out.println(err.getMessage());
            }
        }
    }
}