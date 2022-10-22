import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectCheck {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        try {

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB?useSSL=false&characterEncoding=utf8",
                                        "root",
                                    "admin");
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }finally {
            if (conn != null) {
                try {
                    System.out.println("connected with DB");
                    conn.close();
                } catch (SQLException e) { 
                    e.printStackTrace(); 
                }

            }

        }
        
    }
}
