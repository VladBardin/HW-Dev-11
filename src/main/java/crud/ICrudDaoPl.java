package crud;

import java.sql.SQLException;
import java.util.List;

public interface ICrudDaoPl {
    void create(Planet planet) throws SQLException;
    Planet getById(String Id) throws SQLException;
    void delete(String Id) throws SQLException;
    List getAll();
}
