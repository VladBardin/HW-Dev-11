package crud;

import java.sql.SQLException;
import java.util.List;

public interface ICrudDao {
    void create(Client client) throws SQLException;
    Client getById(long Id) throws SQLException;
    void delete(long Id) throws SQLException;
    List getAll();
}
