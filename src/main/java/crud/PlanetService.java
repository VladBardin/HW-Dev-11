package crud;

import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.sql.SQLException;
import java.util.List;

public class PlanetService implements ICrudDaoPl {
    @Override
    public void create(Planet planet) throws SQLException {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(planet);
        tx.commit();
        session.close();
    }
    @Override
    public Planet getById(String Id) throws SQLException {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Query<Planet> query = session.createQuery("from Planet where id=:id", Planet.class);
            query.setParameter("id", Id);
            return query.stream().findFirst().orElse(null);
        }
    }
    @Override
    public void delete(String Id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Planet planet = session.get(Planet.class, Id);
        session.remove(planet);
        tx.commit();
        session.close();
    }
    @Override
    public List getAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Query<Planet> query = session.createQuery("from Planet ", Planet.class);
            return query.list();
        }
    }
}