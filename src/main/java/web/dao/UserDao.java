package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User addUser(User user);
    User updateUser(User user);
    User deleteUser(User user);
    void saveUser(User user);
    User getUserById(int id);
}
