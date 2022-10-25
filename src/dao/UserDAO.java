package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import model.User;

public class UserDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/myDB?useSSL=false&characterEncoding=utf8";
    private static  final String USER = "root";
    private static  final String PASSWORD = "xvpVPoWbop8Mf3y";
    private static final String CREATE_USER_QUERY ="INSERT INTO users(user_name, user_email) VALUES (?, ?)";
    private static final String READ_USER_QUERY ="SELECT * FROM users WHERE user_id = ?"; 
    public User create(User user) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
           
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {// wskaznik pozycjonuje sie przed rekordem
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    public User read(int userId) {
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
                PreparedStatement statement = conn.prepareStatement(READ_USER_QUERY);
                statement.setInt(1,userId);
                
                ResultSet resultSet = statement.executeQuery();
                String a,b;
                int c;
                if(resultSet.next()){
                    System.out.println(resultSet.getString("user_name"));                   
                    a = resultSet.getString("user_name");
                    b = resultSet.getString("user_email");
                    c = resultSet.getInt("user_id");
                    return new User(a,b,c);
                }
            } catch (SQLException e){
                e.printStackTrace();
                
            }return null;
    }
}
