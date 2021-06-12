package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void userAdd(User user);
    public void removeUserById(int id);
    public void updUser(User user);


}
