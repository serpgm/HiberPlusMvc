package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void userAdd(User user);
    public void removeUserById(int id);
    public void updUser(User user);
}
