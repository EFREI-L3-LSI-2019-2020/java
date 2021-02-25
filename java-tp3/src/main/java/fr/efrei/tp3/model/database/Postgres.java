package fr.efrei.tp3.model.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import fr.efrei.tp3.Constants;
import fr.efrei.tp3.LoggerManager;

/**
 * The type Postrges. This class is a singleton that holds the connection to the
 * app's database. We used PostgreSQL as DBMS. It is hosted in the cloud using
 * Heroku. Thus the life cycle of the connection is as follows :
 * <ul>
 * <li>On a app init the connection is established</li>
 * <li>During the app's life, the same connection is used to perform
 * queries</li>
 * <li>When the application is terminated, the connection is freed by the JVM's
 * garbage collector</li>
 * </ul>
 */
public final class Postgres {

    private static Postgres INSTANCE;

    static {
        INSTANCE = new Postgres();
    }

    /**
     * JDBC Connection
     */
    private Connection connection;

    private Postgres() {
        // Fetching database credentials from db.properties config file
        Properties prop = new Properties();
        ClassLoader classLoader = getClass().getClassLoader(); // Fetch file from embedded resources
        try (InputStream input = classLoader.getResourceAsStream(Constants.PATH_DB)) {
            prop.load(input);
        } catch (IOException ex) {
            LoggerManager.getInstanceLogger().getLogger().debug(ex.getMessage());
        }

        // Establishing connection to the database
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://" + prop.getProperty("db.url") + ":" + prop.getProperty("db.port") + "/"
                            + prop.getProperty("db.name")
                            + "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory&sslmode=require",
                    prop.getProperty("db.username"), prop.getProperty("db.password"));
            LoggerManager.getInstanceLogger().getLogger().info("Connected to PostgreSQL");
        } catch (SQLException e) {
            LoggerManager.getInstanceLogger().getLogger().fatal("Error with database connection");
            LoggerManager.getInstanceLogger().getLogger().debug(e.getMessage());
        }
    }

    /**
     * Gets connection.
     *
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Postgres getINSTANCE() {
        return INSTANCE;
    }
}
