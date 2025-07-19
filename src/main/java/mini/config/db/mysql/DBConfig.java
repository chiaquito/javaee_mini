package mini.config.db.mysql;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import mini.config.Env;

public class DBConfig {
    private static final HikariDataSource ds;
    
    static {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }


        String jdbcUrl = String.format(
        "jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=Asia/Tokyo",
                Env.getEnv().get("dbHost"),
                Env.getEnv().get("dbPort"),
                Env.getEnv().get("dbName")
                );
                
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(Env.getEnv().get("dbUser"));
        config.setPassword(Env.getEnv().get("dbPassword"));
        config.setMaximumPoolSize(3); 

        ds = new HikariDataSource(config);

        System.out.printf("pathの確認: %s",System.getenv("PATH"));
    }

    public static DataSource getDataSource() {
        return ds;
    }
}
