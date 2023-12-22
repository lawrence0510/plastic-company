import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
    	String server = "jdbc:mysql://140.119.19.145:3306/";
		String database = "digital_business";
		String url = server + database + "?useSSL=false";
		String username = "group5";
		String password = "plastic";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connection successful!");
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}
