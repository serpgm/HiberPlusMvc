package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.DAO.UserDAOImpl;
import web.model.User;


import java.util.List;

@Component
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO = new UserDAOImpl();

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void userAdd(User user) {
        userDAO.userAdd(user);

    }

    @Override
    public void removeUserById(int id) {

        userDAO.removeUserById(id);

    }

    @Override
    public void updUser(User user) {

        userDAO.updUser(user);

    }
}
