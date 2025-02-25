package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User addUser(User user);
    User updateUser(User user);
    User deleteUser(User user);
    void saveUser(User user);
    User getUserById(int id);
}
