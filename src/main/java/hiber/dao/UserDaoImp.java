package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User findingUsers(String model, int series) {
//        String HQL = "SELECT User FROM User user INNER JOIN Car WHERE user.car.carModel =: md and user.car.carSeries =: ser";
        String HQL = "FROM Car car INNER JOIN car.user WHERE car.carModel =: md AND car.carSeries =: ser";
        Car car = sessionFactory.getCurrentSession().
                createQuery(HQL, Car.class).setParameter("md", model).setParameter("ser", series).getSingleResult();
        return car.getUser();
    }

}
