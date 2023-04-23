package example;

import crud.*;
import hibernate.HibernateUtil;
import org.hibernate.SessionFactory;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws SQLException {
       new DatabaseInitService().initDb();
       final SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Ticket ticket=new Ticket(LocalDateTime.parse("2022-03-17T12:30:00"),  new ClientService().getById(4), new PlanetService().getById("SATURN258"), new PlanetService().getById("MOON51"));
        new TicketService(factory).create(ticket);
       ticket.setFromPlanet(new PlanetService().getById("MARS82"));
        new TicketService(factory).update(ticket);
        new TicketService(factory).delete(10l);
        System.out.println(new TicketService(factory).getAll().toString());
    }
}