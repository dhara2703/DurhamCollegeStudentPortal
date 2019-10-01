package webd4201.savaliyad;

import java.util.Date;
import java.sql.PreparedStatement;
import java.util.Vector;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * StudentDA - this file is contains all of the data access methods, that
 * actually get/set data to the database. Note: that all the methods are static
 * this is because you do not really create StudentDA objects
 *
 * @author Darren Puffer
 * @version 1.0 (21-01-2019)
 * @since 1.0
 */
public class StudentDA {

    /**
     * contains Student references to store individual student
     */
//    static Vector<Student> Students = new Vector<Student>();
    /**
     * Creates an object of student class
     */
    static Student aStudent;

    /**
     * Creates an object of user class
     */
    static User aUser;

    /**
     * Create A MARK OBJECT
     */
    static Mark aMark;

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
    /**
     * holds the program code
     */
    static String programCode;
    /**
     * Holds the program description
     */
    static String programDescription;
    /**
     * holds the year
     */
    static int year;
    
    
        /**
     * Holds the course code
     */
    static String courseCode;
    /**
     * Holds the course name
     */
    static String courseName;
    /**
     * Holds the result
     */
    static int result;
    /**
     * Holds the GPA weight
     */
    static float gpaWeighting;



    static Vector<Mark> marks = new Vector<>();

//    private static final String CREATE_STMT_USER = "INSERT INTO Users "
//            + "(Id , Password, FirstName, LastName, EmailAddress, LastAccess, EnrolDate, Enabled, Type) VALUES"
//            + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String CREATE_STMT_STUDENT = "INSERT INTO Students "
            + "(Id, ProgramCode, ProgramDescription, Year) VALUES "
            + "(?,?,?,?)";

    private static final String STUDENT_RETRIEVE_ID = "SELECT Id, ProgramCode, ProgramDescription, Year FROM students WHERE Id = ?";

    private static final String UPDATE_STMT_STUDENT = "UPDATE Students set ProgramCode = ?, ProgramDescription = ?, Year = ? WHERE Id = ?";

    private static final String STUDENT_DELETE = "DELETE FROM Students WHERE Id = ?";

    //private static final String IS_STUDENT_EXIST = "SELECT * FROM Students WHERE Id = ?";
    private static final String MARK_RETRIEVE = "SELECT marks.id, courses.courseCode, courseTitle, result, "
            + "gpaWeighting FROM courses, marks WHERE courses.courseCode = marks.courseCode AND id = ?;";

    /**
     * establish the database connection
     *
     * @param c connection object
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
     *
     * @param aStudent to create a new student
     * @return boolean depending upon the success of inserting the new record
     * @throws DuplicateException id id is already exist
     * @throws NotFoundException id does not found
     * @throws InvalidIdException for invalid id
     * @throws InvalidPasswordException for invalid password size
     * @throws InvalidNameException for invalid name
     */
    public static boolean create(Student aStudent) throws DuplicateException, NotFoundException, InvalidPasswordException, InvalidNameException, InvalidIdException {

        boolean inserted = false; // insertion success flag retrieve the Student
        // attribute values
        id = aStudent.getId();
        programCode = aStudent.getProgramCode();
        programDescription = aStudent.getProgramDescription();
        year = aStudent.getYear();
//        marks = aStudent.getMarks();
        if (User.isExistingUser(id)) {
            throw new DuplicateException(id);
        } else {

            // see if this Student already exists in the database
            try {
                aConnection.setAutoCommit(false);
                if (UserDA.create(aStudent)) {
                    PreparedStatement psInsertStudent = aConnection.prepareStatement(CREATE_STMT_STUDENT);
                    psInsertStudent.setLong(1, id);
                    psInsertStudent.setString(2, programCode);
                    psInsertStudent.setString(3, programDescription);
                    psInsertStudent.setInt(4, year);
//                    psInsertStudent.setInt(5, marks);

                    if (psInsertStudent.executeUpdate() > 0) {
                        aConnection.commit();
                        inserted = true;
                    } else {
                        aConnection.rollback();
                        inserted = false;
                    }

                } else { // if user is not delete, we have to get the student back in db      
                    System.err.print("Transaction is being rolled back");
                    aConnection.rollback();
                }
            } catch (SQLException ee) {
                System.out.println(ee);
            }
        }
        return inserted;
    }

    /**
     * This method is used to retrieve a record based on given id
     *
     * @param key is an id
     * @return student object
     * @throws NotFoundException for not exist id
     */
    public static Student retrieve(long key) throws NotFoundException { // retrieve Student and Boat data
        aStudent = null;
        aUser = null;
        aMark = null;
        Vector <Mark> dbMark = new Vector <Mark>();  
        // System.out.println(sqlQuery);
        // execute the SQL query statement
        try {
            PreparedStatement psRetrieve = aConnection.prepareStatement(STUDENT_RETRIEVE_ID);
            psRetrieve.setLong(1, key);

            PreparedStatement psRetrieveMark = aConnection.prepareStatement(MARK_RETRIEVE);
            psRetrieveMark.setLong(1, key);

            ResultSet rs = psRetrieve.executeQuery();
            
            ResultSet rsMark;

            // next method sets cursor & returns true if there is data
            boolean gotIt = rs.next();
//            System.out.println("Retrieved?: " + gotIt);

            if (gotIt) { // extract the data

//                marks = Mark.retrieveAll(key);
                aUser = User.retrieve(key);
                id = aUser.getId();
                password = aUser.getPassword();
                firstName = aUser.getFirstName();
                lastName = aUser.getLastName();
                emailAddress = aUser.getEmailAddress();
                lastAccess = aUser.getLastAccess();
                enrolDate = aUser.getEnrolDate();
                enabled = aUser.isenabled();
                type = aUser.gettype();

                programCode = rs.getString("ProgramCode");
                programDescription = rs.getString("ProgramDescription");
                year = rs.getInt("Year");
//                Students = rs.get("Mark");
                
                rsMark = psRetrieveMark.executeQuery();
                gotIt = rsMark.next();
                if(gotIt) {
                           courseCode = rsMark.getString("courseCode");
                           courseName = rsMark.getString("courseTitle");
                           result = rsMark.getInt("result");
                           gpaWeighting = rsMark.getFloat("gpaWeighting");
                           aMark = new Mark(courseCode,courseName,result,gpaWeighting);
                           dbMark.add(aMark);
                       while (rsMark.next())
                       {
                           courseCode = rsMark.getString("courseCode");
                           courseName = rsMark.getString("courseTitle");
                           result = rsMark.getInt("result");
                           gpaWeighting = rsMark.getFloat("gpaWeighting");
                           aMark = new Mark(courseCode,courseName,result,gpaWeighting);
                           dbMark.add(aMark);
                       }
                   }
                    
                
                // Try to create a student
                try {
                    aStudent = new Student(id, password, firstName, lastName, emailAddress, enrolDate, lastAccess, true, 's', programCode, programDescription, year, dbMark);
                } catch (Exception e) {
                    System.out.println("The given id: " + id + " is in incorrect. Please try again.");
                }

            } else // nothing was retrieved
            {
                throw (new NotFoundException(id));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (InvalidIdException ex) {
            Logger.getLogger(StudentDA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidPasswordException ex) {
            Logger.getLogger(StudentDA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidNameException ex) {
            Logger.getLogger(StudentDA.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aStudent;
    }

    /**
     * This method updates the information for particular given id. It updates
     * in both users and students table
     *
     * @param aStudent is an object
     * @return integer if record is retrieved or not
     * @throws NotFoundException for record found or not
     */
    public static int update(Student aStudent) throws NotFoundException {

        int records = 0; // records updated in method

        // retrieve the Student argument attribute values
        // define the SQL query statement using the phone number key
        // see if this Student exists in the database
        // NotFoundException is thrown by find method
        try {
            aConnection.setAutoCommit(false);
            retrieve(id);   // determine if there is a Student record to

            id = aStudent.getId();
            records = UserDA.update(aStudent);
            programCode = aStudent.getProgramCode();
            programDescription = aStudent.getProgramDescription();
            year = aStudent.getYear();

            if (records > 0) {
                PreparedStatement psUpdateStudent = aConnection.prepareStatement(UPDATE_STMT_STUDENT);

                psUpdateStudent.setLong(4, id);
                psUpdateStudent.setString(1, programCode);
                psUpdateStudent.setString(2, programDescription);
                psUpdateStudent.setInt(3, year);

                psUpdateStudent.executeUpdate();
                aConnection.commit();
            } else {
                aConnection.rollback();
            }
        } catch (NotFoundException e) {
            throw new NotFoundException(id);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return records;
    }

    /**
     * this method is used to delete a record based on given id
     *
     * @param aStudent is an object
     * @return the number of record gets affected
     * @throws InvalidIdException for invalid id exception
     * @throws NotFoundException for id not found
     */
    public static int delete(Student aStudent) throws NotFoundException, InvalidIdException {

        int records = 0;
        // retrieve the student id (key)
        id = aStudent.getId();
        // create the SQL delete statement

        // see if this Student already exists in the database
        try {
            aConnection.setAutoCommit(false);

            retrieve(id); // used to determine if record exists
            // for the passed Student
            // if found, execute the SQL update statement
            //PreparedStatement psDeleteUser = aConnection.prepareStatement(USER_DELETE);
            PreparedStatement psDeleteStudent = aConnection.prepareStatement(STUDENT_DELETE);
            //psDeleteUser.setLong(1, id);
            psDeleteStudent.setLong(1, id);
            //records = psDeleteUser.executeUpdate();
            records = psDeleteStudent.executeUpdate();
            if (records > 0) {
                records = UserDA.delete(aStudent);
                if (records > 0) {
                    aConnection.commit();
                } else { // if user is not delete, we have to get the student back in db                    
                    aConnection.rollback();
                }
            }

        } catch (NotFoundException e) {
            throw new NotFoundException(id);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return records;
    }

//    /**
//     * This method is used to check whether the user has passed the login id and
//     * password are valid.
//     *
//     * @param id
//     * @param password
//     * @return aStudent object
//     * @throws Exception
//     * @throws NotFoundException
//     * @throws InvalidNameException
//     * @throws InvalidIdException
//     * @throws InvalidPasswordException
//     */
//    public static Student authenticate(long id, String password) throws NotFoundException, InvalidPasswordException, InvalidNameException, InvalidIdException {
//
//        try {
//            aStudent = retrieve(id);
//
//            String givenPassowrd = User.hashPassword(password);
//            String actualPassowrd = aStudent.getPassword();
//
//            if (!(actualPassowrd.equals(givenPassowrd))) {
//                aStudent = null;
//            }
//        } catch (NotFoundException nfe) {
//
//            throw new NotFoundException(id);
//        }
//
//        return aStudent;
//    }
}
