public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World! Lets get going with Databases");
        new DB("jdbc:sqlite:/Users/bernardmordan/Code/java-projects/RestaurantsDryRun/db.sql");
        // Restaurant bojos = new Restaurant("BoJangles");
        Restaurant.init();
        System.out.printf("%d restaurants\n", Restaurant.getAll().size());
        new Restaurant("Jazz cafe");
        System.out.printf("%d restaurants\n", Restaurant.getAll().size());
        DB.close();
    }
}
