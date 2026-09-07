package ma.youcode.lineperm.service;
import java.util.HashMap;
import java.util.Map;
import ma.youcode.lineperm.model.User;

public class UserService {
    private final Map<String, User> users ;

    public UserService() {
        this.users = new HashMap<>();
    }

    public void signUp(String login, String password) {

        login = login.trim();

        if (login.isEmpty()){
            System.out.println("login invalide");
            return;
        }
        if (users.containsKey(login)){
            System.out.println("login deja use");
            return;
        }
        if (password == null || password.isEmpty()){
            System.out.println("password invalide");
            return;
        }

        String passwordHash = password;

        User user = new User(login, passwordHash);

        users.put(login, user);

        System.out.println("cmtp creer");
    }

    public User login(String login, String passwordHash) {
        User user = users.get(login);
        return user;
    }

}
