package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void updateUser(int id, User user);
    void deleteUser(int id);
    void saveUser(User user);
    User getUserById(int id);
}
