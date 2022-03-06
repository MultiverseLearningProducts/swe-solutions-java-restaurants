import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Restaurant {
    private static ArrayList<Restaurant> all = new ArrayList<>();
    private String name;
    private int id;

    public static void init() {
        try {
            Statement selectAll = DB.conn.createStatement();
            ResultSet results = selectAll.executeQuery("SELECT * FROM restaurants;");
            while(results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                new Restaurant(id, name);
            }

        } catch(SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public static ArrayList<Restaurant> getAll() {
        return Restaurant.all;
    }

    public Restaurant(String name) {
        this.name = name;

        try {
            Statement createTable = DB.conn.createStatement();
            createTable.execute("CREATE TABLE IF NOT EXISTS restaurants (id INTEGER PRIMARY KEY, name TEXT);");
            PreparedStatement insert = DB.conn.prepareStatement("INSERT INTO restaurants (name) VALUES (?);");
            insert.setString(1, this.name);
            insert.executeUpdate();
            this.id = insert.getGeneratedKeys().getInt(1);
            Restaurant.all.add(this);
        } catch(SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
        Restaurant.all.add(this);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
