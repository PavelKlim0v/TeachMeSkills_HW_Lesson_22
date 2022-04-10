package by.tms.storage;

import by.tms.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static final List<User> users = new ArrayList<User>();

    public void save (User user){
        // на null
        users.add(user);

    }

    public  User findByLogin (String login){
        for (User user:users){
            // на null
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }
    public  boolean isExistsByLogin (String login){
        for (User user:users){
            // на null
            if (user.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    public  boolean isDeleteByLogin (String login){
        for (User user:users){
            // на null
            if (user.getLogin().equals(login)){
                users.remove(user.getUserId());
                return true;
            }
        }
        return false;
    }
}
