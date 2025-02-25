package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager em;
    private final EntityManagerFactory entityManagerFactory;
    @Autowired
    public UserDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        em = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }


    @Override
    public void updateUser(int id, User user) {
        em.merge(new User(user.getName(), user.getUsername(), user.getPassword(), user.getEmail()));
    }

    @Override
    public void deleteUser(int id) {
        em.remove(getUserById(id));
    }

    @Override
    public void saveUser(User user) {

        em.persist(user);
    }
}
