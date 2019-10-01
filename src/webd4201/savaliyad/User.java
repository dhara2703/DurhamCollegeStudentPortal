package webd4201.savaliyad;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


/**
 * This class is set to abstract so, it cannot be instantiated and also it
 * implements CollegeInterface.
 *
 * @author Darren Puffer
 * @version 1.0 (2019/01/12)
 * @since 1.0
 */
public class User implements CollegeInterface {

    /**
     * stores default id as long type
     */
    public final static long DEFAULT_ID = 100123456L;
    /**
     * stores default password as string type
     */
    public final static String DEFAULT_PASSWORD = "password";
    /**
     * stores minimum length required for the password
     */
    public final static byte MINIMUM_PASSWORD = 8;
    /**
     * stores maximum length required for the password
     */
    public final static byte MAXIMUM_PASSWORD = 20;
    /**
     * stores the default first name
     */
    public final static String DEFAULT_FIRST_NAME = "John";
    /**
     * stores the default last name
     */
    public final static String DEFAULT_LAST_NAME = "Doe";
    /**
     * stores the default email address
     */
    public final static String DEFAULT_EMAIL_ADDRESS = "john.doe@dcmail.com";
    /**
     * stores default enabled status
     */
    public final static boolean DEFAULT_ENABLED_STATUS = true;
    /**
     * stores default user type
     */
    public final static char DEFAULT_TYPE = 's';
    /**
     * stores the required length for the id
     */
    public final static byte ID_NUMBER_LENGTH = 9;
    /**
     * stores the expected date format required
     */
    public static final DateFormat DF = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);

    /**
     * This date format is used to format the date to work with database for
     * compatible string
     */
    private static final SimpleDateFormat SQL_DF = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * stores the default password type
     */
    public final static String DEFAULT_PASSWORD_TYPE = "SHA-1";

    // Instance Attributes
    /**
     * holds id
     */
    private long id;
    /**
     * holds password
     */
    private String password;
    /**
     * holds first name
     */
    private String firstName;
    /**
     * holds last name
     */
    private String lastName;
    /**
     * holds email address
     */
    private String emailAddress;
    /**
     * holds last access date
     */
    private Date lastAccess;
    /**
     * holds enroll date
     */
    private Date enrolDate;
    /**
     * holds enabled type
     */
    private boolean enabled;
    /**
     * holds user type
     */
    private char type;

    /**
     * This method verifies that connection is initialized
     *
     * @param c connection
     */ 
    public static void initialize(Connection c) {
        UserDA.initialize(c);
    }

    /**
     * This is a method which is used to terminate the database connection.
     */
    public static void terminate() {
        UserDA.terminate();
    }

    /**
     * This method is used to retrieve information from the given id
     * @param id for user id
     * @return an object
     * @throws InvalidIdException for invalid id
     * @throws InvalidPasswordException for invalid password size
     * @throws InvalidNameException for invalid name 
     * @throws NotFoundException for not exist id
     */
    public static User retrieve(long id) throws InvalidIdException, InvalidPasswordException, InvalidNameException, NotFoundException {
        return UserDA.retrieve(id);
    }

     /**
     * This is used to create new user
     * @return boolean with true or false
     * @throws DuplicateException if id is already exist
     */
    public boolean create() throws DuplicateException {
        return UserDA.create(this);
    }

    /**
     * This is used to delete user record based on given id
     * @throws NotFoundException if id does not found throws an exception
     */
    public void delete() throws NotFoundException {
        UserDA.delete(this);
    }
    
    /**
    * Find a user from existing user. This method is called created in UserDA
    * @param id with user id
    * @return boolean for user is exist or not
    * @throws DuplicateException for user already exist 
    */
    public static boolean isExistingUser(long id) throws DuplicateException {
        return UserDA.isExistingUser(id);
    }
    
    /**
     * This is used to update user record based on given id
     * @throws NotFoundException if id does not found in database
     */
    public void update() throws NotFoundException{
        UserDA.update(this);
    }
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     * @throws InvalidIdException for invalid id
     */
    public final void setId(long id) throws InvalidIdException {
        if (verifyId(id)) {
            this.id = id;
        } else {
            throw new InvalidIdException(id);
        }
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     * @throws InvalidPasswordException for invalid password size
     */
    public final void setPassword(String password) throws InvalidPasswordException {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     * @throws InvalidNameException for invalid name 
     */
    public final void setFirstName(String firstName) throws InvalidNameException {
        if (firstName != null && !firstName.isEmpty()) {
            try {
                Double.parseDouble(firstName);
                throw new InvalidNameException(firstName + "is not a valid first name, cannot be a number");
            } catch (NumberFormatException nfe) {
                this.firstName = firstName;
            }
        }
    }

    /**
     *
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     * @throws InvalidNameException for invalid name 
     */
    public final void setLastName(String lastName) throws InvalidNameException {
        if (lastName != null && !lastName.isEmpty()) {
            try {
                Double.parseDouble(firstName);
                throw new InvalidNameException(lastName);
            } catch (NumberFormatException nfe) {
                this.lastName = lastName;
            }
        }
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public final void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the lastAccess
     */
    public Date getLastAccess() {
        return lastAccess;
    }

    /**
     * @param lastAccess the lastAccess to set
     */
    public final void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    /**
     * @return the enrolDate
     */
    public Date getEnrolDate() {
        return enrolDate;
    }

    /**
     * @param enrolDate the enrolDate to set
     */
    public final void setEnrolDate(Date enrolDate) {
        this.enrolDate = enrolDate;
    }

    /**
     * @return the enabled
     */
    public boolean isenabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public final void setenabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the type
     */
    public char gettype() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public final void settype(char type) {
        this.type = type;
    }

    /**
     * @param id user id
     * @param password for user password
     * @param firstName for user first name
     * @param lastName for user last name
     * @param emailAddress for user email address
     * @param lastAccess for user last access
     * @param enrolDate for enroll date
     * @param enabled for enabled or not
     * @param type for user type
     * @throws InvalidIdException for invalid id
     * @throws InvalidPasswordException for invalid password size
     * @throws InvalidNameException for invalid name 
     */
    public User(long id, String password, String firstName, String lastName,
            String emailAddress, Date lastAccess, Date enrolDate,
            boolean enabled, char type) throws InvalidIdException, InvalidPasswordException, InvalidNameException {
        setId(id);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(emailAddress);
        setLastAccess(lastAccess);
        setEnrolDate(enrolDate);
        setenabled(enabled);
        settype(type);
    }

    /**
     * Default Constructor with no parameters
     * @throws InvalidIdException for invalid id
     * @throws InvalidPasswordException for invalid password size
     * @throws InvalidNameException for invalid name 
     */
    public User() throws InvalidIdException, InvalidPasswordException, InvalidNameException {
        this(DEFAULT_ID, DEFAULT_PASSWORD, DEFAULT_FIRST_NAME,
                DEFAULT_LAST_NAME, DEFAULT_EMAIL_ADDRESS, new Date(),
                new Date(), DEFAULT_ENABLED_STATUS, DEFAULT_TYPE);
    }

    
    
    /**
     * this method returns the user type
     * @return string User
     */
    @Override
    public String getTypeForDisplay() {
        return "User";
    }

    /**
     * this method is used to get the object information using the toString
     * method
     */
    public void dump() {
        System.out.println(toString());
    }

    /**
     * This method verifies that the id is in range or not. If it is not than it
     * @param validId as a long
     * @return boolean for id is correct format or not
     */
    public static boolean verifyId(long validId) {

        boolean isVerified = true;
        long verifyLength = validId;
        int idCounter = 0;

        if (MINIMUM_ID_NUMBER >= validId && MAXIMUM_ID_NUMBER <= validId) {
            isVerified = false;
        }
        while (verifyLength != 0) {
            verifyLength /= 10;
            ++idCounter;
        }
        if (idCounter != ID_NUMBER_LENGTH) {
            isVerified = false;
        }
        return isVerified;
    }

    /**
     * This method passes the password parameter and hashes it.
     * @param pass string
     * @return string hashed password
     */
    public static String hashPassword(String pass) {
        String password = pass;

        try { //Try to digest password using the SHA1 algorithm
            MessageDigest md = MessageDigest.getInstance("SHA1");

            md.update(password.getBytes());
            byte[] hashedPassword = md.digest();
            String hashFinalPass = decToHex(hashedPassword);
            password = hashFinalPass;
        } catch (NoSuchAlgorithmException e) { //Catch an exception for the SHA1 algorithm if not found
            System.out.println("Couldn't find the hashing algorithm specified");
        }
        return password;
    }

    /**
     * This converts the passed array of bytes into hexadecimal and concatenate
     * it as a 40 character string
     * @param bytes of array
     * @return a string 
     */
    public static String decToHex(byte[] bytes) {
        String hex = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02x", bytes[i]));
        }
        hex = sb.toString();
        return hex;
    }

     /**
     * this is a toString method to get the user information
     * @return the string formated output for the user
     */
    @Override
    public String toString() {

        String output = "User Info for: " + getId();
        output += "\n\tName        : " + getFirstName() + " " + getLastName()
                + "(" + getEmailAddress() + ")";
        output += "\n\tCreated on  : " + SQL_DF.format(getEnrolDate());
        output += "\n\tLast Access : " + SQL_DF.format(new Date());

        return output;
    }
    
    /**
     * Verifies the given email address is valid or not
     * @param email string variable which holds user entered email
     * @return result boolean if user exist in the system sets true else false
     */
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
    
    /**
     * @param id user id 
     * @param password user password
     * @return a student object
     * @throws InvalidPasswordException  invalid password
     * @throws NotFoundException for not exist id
     */
    public static User authenticate(long id, String password) throws NotFoundException, InvalidPasswordException {
        return UserDA.authenticate(id, password);

    }

    

}
