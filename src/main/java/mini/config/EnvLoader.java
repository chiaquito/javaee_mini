package mini.config;

import java.lang.System;
import java.util.HashMap;

import mini.common.string.Strings;

public class EnvLoader {
    static final private HashMap<String, String> env;

    static {
        // env variables for database configuration
        String dbHost = Strings.exists(System.getenv("dbHost"))? System.getenv("dbHost") : "localhost";
        String dbPort = Strings.exists(System.getenv("dbPort"))? System.getenv("dbPort") : "3306";
        String dbName = Strings.exists(System.getenv("dbName"))? System.getenv("dbName") : "db";
        String dbUser = Strings.exists(System.getenv("dbUser"))? System.getenv("dbUser") : "root";
        String dbPassword = Strings.exists(System.getenv("dbPassword"))? System.getenv("dbPassword") : "password";

        // env variables for app behavior
        String testVariable = Strings.exists(System.getenv("testVariable"))? System.getenv("testVariable") : " :)";
        
        
        env = new HashMap<>();
        env.put("dbHost", dbHost);
        env.put("dbPort", dbPort);
        env.put("dbName", dbName);
        env.put("dbUser", dbUser);
        env.put("dbPassword",dbPassword);

        env.put("testVariable", testVariable);

        // terraform用のデバッグ // TODO: remove after confirming IaC works
        System.out.printf("dbHost: %s, dbPort: %s, dbName: %s%n", dbHost, dbPort, dbName);

        System.out.printf("dbUser: %s, dbPassword: %s%n", dbUser, dbPassword);

    }


    public static HashMap<String, String> getEnv(){
        return env;
    }
}
