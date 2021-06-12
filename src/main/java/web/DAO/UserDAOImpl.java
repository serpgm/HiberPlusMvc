package web.DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Component
@Transactional
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void userAdd(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(int id) {
        entityManager.remove(getUserById(id));
    }
    @Override
    public void updUser(User user) {
        entityManager.merge(user);
    }
}
