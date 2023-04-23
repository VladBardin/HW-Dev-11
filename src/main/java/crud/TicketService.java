package crud;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TicketService {
    private SessionFactory sessionFactory;
    public TicketService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void create(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.persist(ticket);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }
    public Ticket read(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }
    public void update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.merge(ticket);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Ticket ticket = session.get(Ticket.class, id);
                if (ticket != null) {
                    session.remove(ticket);
                }
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }
    public List<Ticket> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Ticket> query = session.createQuery("FROM Ticket", Ticket.class);
            return query.getResultList();
        }
}
}