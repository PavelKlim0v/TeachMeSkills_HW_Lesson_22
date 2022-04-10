package by.tms.service;

import by.tms.model.User;
import by.tms.storage.UserStorage;

public class UserService {
    private static final UserStorage userStorage = new UserStorage();

    public boolean add(User user) {
        if (userStorage.isExistsByLogin(user.getLogin())) {
            return false;
        }
        userStorage.save(user);
        return true;
    }

    public User findUserByLogin(String login) {
        if (userStorage.findByLogin(login) != null) {
            return userStorage.findByLogin(login);
        }
        return null;
    }

    public boolean deleteUserByLogin(String login) {
        if (userStorage.findByLogin(login) != null) {
            userStorage.isDeleteByLogin(login);
            return true;
        }
        return false;
    }
}
