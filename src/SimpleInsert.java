import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class SimpleInsert {
    public static void main(String[] args) throws Exception {
        String sql = "INSERT INTO users VALUES (11,\"franek\",\"franek@gmail.com\")";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&characterEncoding=utf8", 
                                                            "root", 
                                                            "admin");
            Statement stat = conn.createStatement()) {
            stat.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
