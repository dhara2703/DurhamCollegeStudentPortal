package webd4201.savaliyad;

import java.sql.*;

/**
 * This class contains information for for the database connection. there are two methods are used : initialize and terminate
 * @author dhara
 * @author Darren Puffer
 * @version 1.0 (2019/01/21)
 * @since 1.0
 */
public class DatabaseConnect {
	/**
     * string variable named url to store the Database Location
     */
    static String url = "jdbc:postgresql://127.0.0.1:5432/webd4201_db";
    /**
     * Creating a Connection object to open port to db
     */
    static Connection aConnection;
    /**
     * String variable which stores the database user
     */
    static String user = "webd4201_admin";
    /**
     * String variable that stores database user password
     */
    static String password = "webd4201_password";

    /**
     * This function is used to establish a database connection based upon the
     * given values
     * @return aConnection - the connection to the WEBD4201_db database
     */
    public static Connection initialize() {
        try {
            Class.forName("org.postgresql.Driver"); // loads the JDBC driver of
            // the POSTGRESQL
            // This command create the instance of the database connection
            aConnection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) // any other database exception (misnamed db, misnamed user, or wrong password)
        {
            System.out.println(e);
        }
        return aConnection;
    }

    /**
     * closes the database connection using the terminate function
     */
    public static void terminate() {
        try {
            aConnection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}