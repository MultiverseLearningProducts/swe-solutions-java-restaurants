import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    public static Connection conn;

    public DB(String url) {
        try {
            DB.conn = DriverManager.getConnection(url);
        } catch(SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public static void close() {
        try {
            DB.conn.close();
        } catch(SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}
