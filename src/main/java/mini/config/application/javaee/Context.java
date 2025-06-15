package mini.config.application.javaee;

import java.sql.Connection;

public class Context {
    private final Connection conn;

    public Context(Connection connection) {
        this.conn = connection;
    }

    public Connection getConnection() {
        return conn;
    }
}
