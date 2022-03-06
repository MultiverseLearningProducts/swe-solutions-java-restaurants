import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class RestaurantTest {
    @BeforeClass
    public static void createDB() {
        new DB("jdbc:sqlite::memory:");
    }
    @Test
    public void has_a_name_and_id() {
        Restaurant bojangles = new Restaurant("Bojangles");
        assertEquals(bojangles.getId(), 1);
        assertEquals(bojangles.getName(), "Bojangles");
    }
    @Test
    public void collect_all_restaurants() {
        assertEquals(Restaurant.getAll().size(), 1);
    }
}
