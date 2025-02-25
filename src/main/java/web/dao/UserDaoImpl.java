package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return em.find(User.class, id);
    }


    @Override
    @Transactional
    public void updateUser(int id, User user) {
        em.merge(new User(id, user.getName(), user.getUsername(), user.getPassword(), user.getEmail()));
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        em.remove(getUserById(id));
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        em.persist(user);
    }
}
