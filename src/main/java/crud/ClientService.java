package crud;

import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.sql.SQLException;
import java.util.List;

public class ClientService implements ICrudDao {

    @Override
    public void create(Client client) throws SQLException {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(client);
        tx.commit();
        session.close();
    }

    @Override
    public Client getById(long Id) throws SQLException {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Query<Client> query = session.createQuery("from Client where id=:id", Client.class);
            query.setParameter("id", Id);
            return query.stream().findFirst().orElse(null);
        }
    }

    @Override
    public void delete(long Id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Client client = session.get(Client.class, Id);
        session.remove(client);
        tx.commit();
        session.close();
    }

    @Override
    public List getAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Query<Client> query = session.createQuery("from Client ", Client.class);
            return query.list();
        }
    }
}