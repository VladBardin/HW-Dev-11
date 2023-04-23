package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;
    public Database() {
        try {
            String connectionUrl = "jdbc:h2:./test";
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static Database getInstance() {
        return INSTANCE;
    }
    public int executeUpdate(String sql) {
        try (Statement st = connection.createStatement()) {
            return st.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}