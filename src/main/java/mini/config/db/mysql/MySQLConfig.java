package mini.config.db.mysql;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import mini.config.DatabaseConf;

public class MySQLConfig {
    private static HikariDataSource ds;
    
    static {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }


        try {
        String jdbcUrl = String.format(
        "jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=Asia/Tokyo&allowPublicKeyRetrieval=true",
                DatabaseConf.getInstance().getHost(),
                DatabaseConf.getInstance().getPort(),
                DatabaseConf.getInstance().getName()
                );
                
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(DatabaseConf.getInstance().getUser());
        config.setPassword(DatabaseConf.getInstance().getPassword());
        config.setMaximumPoolSize(3); 

        ds = new HikariDataSource(config);

        System.out.printf("pathの確認: %s",System.getenv("PATH"));
        } catch (Exception e) {
            ds = new HikariDataSource();
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }
}
