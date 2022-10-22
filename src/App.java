import dao.UserDAO;
import model.User;

public class App {
    public static void main(String[] args) throws Exception {
        UserDAO userDAO = new UserDAO();
        User fran = new User("Fran", "email@pp.pl");
        userDAO.create(fran);
        System.out.println(fran.toString());
    }
}
