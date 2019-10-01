package webd4201.savaliyad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * UserDA - this file contains all of the data access methods, that actually
 * get/set data to the database. Note: that all the methods are static this is
 * because you do not really create UserDA objects.
 * @author Darren Puffer
 * @version 1.0 (21-01-2019)
 * @since 1.0
 */
public class UserDA {

    /**
     * using an student to create an user
     */
    static User aUser;

    /**
     * declare variables for the database connection
     */
    static Connection aConnection;
    /**
     * declare variables as the statement
     */
    static Statement aStatement;

    // declare static variables for all Student instance attribute values
    /**
     * holds id information
     */
    static long id;
    /**
     * holds the password information
     */
    static String password;
    /**
     * holds the first name
     */
    static String firstName;
    /**
     * holds the last name
     */
    static String lastName;
    /**
     * holds the email address
     */
    static String emailAddress;
    /**
     * holds the last access
     */
    static Date lastAccess;
    /**
     * holds the enroll date
     */
    static Date enrolDate;
    /**
     * holds the enabled type
     */
    static boolean enabled;
    /**
     * holds the user type
     */
    static char type;

    // This is used to create a user
    private static final String CREATE_STMT_USER = "INSERT INTO Users "
            + "(Id , Password, FirstName, LastName, EmailAddress, LastAccess, EnrolDate, Enabled, Type) VALUES"
            + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String USER_RETRIEVE_ID = "SELECT Id, Password, FirstName, LastName, EmailAddress, LastAccess, EnrolDate, Enabled, Type FROM Users WHERE Id = ?";

    private static final String UPDATE_STMT_USER = "UPDATE Users set Password = ?, FirstName = ?, LastName = ?, EmailAddress = ?, LastAccess = ?, EnrolDate = ?, Enabled = ?, Type = ? WHERE Id = ?";

    private static final String USER_DELETE = "DELETE FROM Users WHERE Id = ?";

    private static final String IS_USER_EXIST = "SELECT * FROM Users WHERE Id = ?";

    /**
     * establish the database connection
     * @param c connection
     */
    public static void initialize(Connection c) {
        try {
            aConnection = c;
            aStatement = aConnection.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * close the database connection
     */
    public static void terminate() {
        try { // close the statement
            aStatement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
    
    /**
     * This method is used to insert new record. First it tries to insert the
     * record in users table than it inserts in students table
     * @param aUser object
     * @return boolean depending upon the success of inserting the new record
     * @throws DuplicateException for already existed id
     */ 
    public static boolean create(User aUser) throws DuplicateException {

        boolean inserted = false; // insertion success flag retrieve the Student
        // attribute values

        id = aUser.getId();
        password = aUser.getPassword();
        firstName = aUser.getFirstName();
        lastName = aUser.getLastName();
        emailAddress = aUser.getEmailAddress();
        lastAccess = aUser.getLastAccess();
        enrolDate = aUser.getEnrolDate();
        enabled = aUser.isenabled();
        type = aUser.gettype();

        // see if this Student already exists in the database
        try {
            retrieve(id);
            throw (new DuplicateException(id));
        } // if NotFoundException, add Student to database
        catch (NotFoundException e) {
            try { // execute the SQL update statement

                PreparedStatement psInsertUser = aConnection.prepareStatement(CREATE_STMT_USER);

                psInsertUser.setLong(1, id);
                psInsertUser.setString(2, User.hashPassword(password));
                psInsertUser.setString(3, firstName);
                psInsertUser.setString(4, lastName);
                psInsertUser.setString(5, emailAddress);
                psInsertUser.setDate(6, new java.sql.Date(lastAccess.getTime()));
                psInsertUser.setDate(7, new java.sql.Date(enrolDate.getTime()));
                psInsertUser.setBoolean(8, enabled);
                psInsertUser.setString(9, String.valueOf(type));
                psInsertUser.executeUpdate();
               

            } catch (SQLException ee) {
                System.out.println(ee);
            }
             inserted = true;
            
        }
        return inserted;
    }

     /**
     * This method is used to retrieve a record based on given id
     * @param key is an id
     * @return User object
     * @throws NotFoundException if id is not exist
     */
    public static User retrieve(long key) throws NotFoundException { // retrieve Student and Boat data
        aUser = null;

        // System.out.println(sqlQuery);
        // execute the SQL query statement
        try {

            PreparedStatement psRetrieve = aConnection.prepareStatement(USER_RETRIEVE_ID);
            psRetrieve.setLong(1, key);

            ResultSet rs = psRetrieve.executeQuery();

            // next method sets cursor & returns true if there is data
            boolean gotIt = rs.next();
//                System.out.println("Retrieved?: " + gotIt);

            if (gotIt) { // extract the data
                id = rs.getLong("Id");
                password = rs.getString("Password");
                firstName = rs.getString("FirstName");
                lastName = rs.getString("LastName");
                emailAddress = rs.getString("EmailAddress");
                lastAccess = rs.getDate("LastAccess");
                enrolDate = rs.getDate("EnrolDate");
                enabled = rs.getBoolean("enabled");
                type = rs.getString("type").charAt(0);

                // create Student
                try {
                    aUser = new User(id, password,firstName, lastName,emailAddress,lastAccess, enrolDate, enabled, type);
                } catch (Exception e) {
                    System.out.println("Record for User"
                            + id
                            + " contains an invalid id. Verify and correct.");
                }

            } else {// nothing was retrieved
                throw (new NotFoundException(id));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return aUser;
    }

    /**
     * This method updates the information for particular given id. It updates
     * in users table
     * @param aUser object
     * @return integer for record is updated or not
     * @throws NotFoundException for id not found in database
     */
    public static int update(User aUser) throws NotFoundException {

        int records = 0; // records updated in method

        try {

            id = aUser.getId();

            retrieve(id);   // determine if there is a  record to

            password = aUser.getPassword();
            firstName = aUser.getFirstName();
            lastName = aUser.getLastName();
            emailAddress = aUser.getEmailAddress();
            lastAccess = aUser.getLastAccess();
            enrolDate = aUser.getEnrolDate();
            enabled = aUser.isenabled();
            type = aUser.gettype();

            PreparedStatement psUpdateUser = aConnection.prepareStatement(UPDATE_STMT_USER);

            psUpdateUser.setLong(9, id);
            psUpdateUser.setString(1, User.hashPassword(password));
            psUpdateUser.setString(2, firstName);
            psUpdateUser.setString(3, lastName);
            psUpdateUser.setString(4, emailAddress);
            psUpdateUser.setDate(5, new java.sql.Date(lastAccess.getTime()));
            psUpdateUser.setDate(6, new java.sql.Date(enrolDate.getTime()));
            psUpdateUser.setBoolean(7, enabled);
            psUpdateUser.setString(8, String.valueOf(type));
            psUpdateUser.executeUpdate();

            records = psUpdateUser.executeUpdate();

        } catch (NotFoundException e) {
            throw new NotFoundException(id);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return records;
    }

    /**
     * this method is used to delete a record based on given id
     * @param aUser object
     * @return the number of record gets affected
     * @throws NotFoundException for id does not exist in database
     */
    public static int delete(User aUser) throws NotFoundException {

        int records = 0;
        // retrieve the  id (key)
        id = aUser.getId();
        // create the SQL delete statement

        // see if this Student already exists in the database
        try {

            retrieve(id); // used to determine if record exists
            // for the passed Student
            // if found, execute the SQL update statement
            PreparedStatement psDeleteUser = aConnection.prepareStatement(USER_DELETE);

            psDeleteUser.setLong(1, id);

            records = psDeleteUser.executeUpdate();

        } catch (NotFoundException e) {
            throw new NotFoundException(id);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return records;
    }

    /**
     * This method is looking for the given id to search for.
     * @param id user id
     * @return boolean - if it founds sets true else sets false
     * @throws DuplicateException if id is exist
     */
    public static boolean isExistingUser(long id) throws DuplicateException {
        boolean exists = true;
        // execute the SQL query statement
        try {
            PreparedStatement psIsUserExist = aConnection.prepareStatement(IS_USER_EXIST);
            psIsUserExist.setLong(1, id);
            ResultSet rs = psIsUserExist.executeQuery();
            exists = rs.next();
            if (exists) {
                throw (new DuplicateException(id));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return exists;
    }
    
    
    /**
     * This method is used to check whether the user has passed the login id and
     * password are valid.
     *
     * @param id is an User id
     * @param password is User's password
     * @return User object
     * @throws NotFoundException for not User id does not exist
     */
    public static User authenticate(long id, String password) throws NotFoundException {

        try {
            aUser = retrieve(id);

            String givenPassowrd = User.hashPassword(password);
            String actualPassowrd = aUser.getPassword();

            if (!(actualPassowrd.equals(givenPassowrd))) {
                aUser = null;
                throw new NotFoundException(id);
            }
        } catch (NotFoundException nfe) {
            throw new NotFoundException(id);
        }

        return aUser;
    }

}
