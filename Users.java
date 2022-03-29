import java.util.ArrayList;
import java.util.UUID;

public class Users {
    private static Users user;
    private ArrayList<User> users;

    private Users(){
        users = DataLoader.getAllUsers();
    }

    public static Users getInstance() {
        if(user == null) {
            user = new Users();
        }
        return user;
    }

    public boolean haveUser(String keyword){
        for (User user : users) {
            
        }
        return true;
    }

    public ArrayList<User> getAllUsers() {
        return DataLoader.getAllUsers();
    }

    public User getUserByUUID(UUID user_id) {
        for(User user: users) {
            if(user.getUUID().equals(user_id)) {
                return user;
            }
        }
        return null;
    }

}
