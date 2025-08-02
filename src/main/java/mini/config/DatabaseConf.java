package mini.config;

public class DatabaseConf {
    
    private final String host;
    private final String port;
    private final String name;
    private final String user;
    private final String password;

    public String getHost() {
        return host;
    }
    public String getPort() {
        return port;
    }
    public String getName() {
        return name;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }

    private DatabaseConf(String dbHost, String dbPort, String dbName, String dbUser, String dbPassword) {
        this.host = dbHost;
        this.port = dbPort;
        this.name = dbName;
        this.user = dbUser;
        this.password = dbPassword;

        System.out.printf("Database configuration: host=%s, port=%s, name=%s, user=%s%n", 
                          dbHost, dbPort, dbName, dbUser);
    }

    private static final DatabaseConf instance = new DatabaseConf(EnvLoader.getEnv().get("dbHost"),
                                                                  EnvLoader.getEnv().get("dbPort"),
                                                                  EnvLoader.getEnv().get("dbName"),
                                                                  EnvLoader.getEnv().get("dbUser"),
                                                                  EnvLoader.getEnv().get("dbPassword")); 

    public static DatabaseConf getInstance() {
        return instance;
    }
}
