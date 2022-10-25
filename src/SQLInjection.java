import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInjection {
    public static void main(String[] args) throws Exception {
        // String SQL_SELECT = "SELECT * FROM users";
        String Name = "\"franek\" or true = true";
        String SQL_SELECT = "SELECT * FROM users WHERE user_name =" + Name;
        // String SQL_SELECT = "SELECT * FROM users WHERE user_name = \"Jacek\" or true = true";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=utf8", 
                                                            "root", 
                                                            "xvpVPoWbop8Mf3y");
            Statement stat = conn.createStatement()) {
            ResultSet rs = stat.executeQuery(SQL_SELECT);
            while (rs.next()) {
            
            String firstName = rs.getString("user_name");
            int id = rs.getInt("user_id");
            System.out.println(id + " " + firstName);
            
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
