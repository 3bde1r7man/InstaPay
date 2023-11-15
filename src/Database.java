import java.util.HashMap;

public class Database {
    HashMap <String, User> users = new HashMap <String, User> ();
    public void saveUser(User user) {
        users.put(user.getUserName(), user);
    }
    public User getUser(String userName) {
        return users.get(userName);
    }
    public boolean isUniqueUserName(String userName) {
        return !users.containsKey(userName);
    }
}