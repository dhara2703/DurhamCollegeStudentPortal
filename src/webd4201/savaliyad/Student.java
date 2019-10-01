package webd4201.savaliyad;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a class which holds student information and extending from user. It
 * holds the current enrolled program code, description, the finished years and
 * their marks.
 *
 * @author Darren Puffer
 * @version 1.0 (2019/01/12)
 * @since 1.0
 */
public class Student extends User {

    /**
     * This holds a default program code "UNDC" as constant (final) string.
     */
    public final static String DEFAULT_PROGRAM_CODE = "UNDC";

    /**
     * This holds a default program description "Undeclared" as constant (final)
     * string.
     */
    public final static String DEFAULT_PROGRAM_DESCRIPTION = "Undeclared";

    /**
     * This holds a default program year as 1 integer constant (final) .
     */
    public final static int DEFAULT_YEAR = 1;

    /**
     * Holds a program code
     */
    private String programCode;

    /**
     * Holds a program description
     */
    private String programDescription;

    /**
     * Holds program year
     */
    private int year;

    /**
     * Holds marks for the current enrolled program's courses
     */
    private Vector<Mark> marks = new Vector<>();

    /**
     * @return the programCode
     */
    public String getProgramCode() {
        return programCode;
    }

    /**
     * @param programCode the programCode to set
     */
    public final void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    /**
     * @return the programDescription
     */
    public String getProgramDescription() {
        return programDescription;
    }

    /**
     * @param programDescription the programDescription to set
     */
    public final void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public final void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the marks
     */
    public Vector<Mark> getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public final void setMarks(Vector<Mark> marks) {
        this.marks = marks;
    }

    /**
     * This method verifies that connection is initialized
     *
     * @param c connection
     */
    public static void initialize(Connection c) {
        StudentDA.initialize(c);
    }

    /**
     * This is a method which is used to terminate the database connection.
     */
    public static void terminate() {
        StudentDA.terminate();
    }

    /**
     * This method is used to retrieve information from the given id
     *
     * @param id gets the id to find the user info from database
     * @return the data for the id
     * @throws NotFoundException if id not found in database
     */
    public static Student retrieve(long id) throws NotFoundException {
        return StudentDA.retrieve(id);
    }

    /**
     * This is used to create new student // * @return boolean if set true and
     * false depending upon id is exist or not
     *
     * @return a boolean true value if exist else false
     * @throws DuplicateException if same id is exist in database
     */
    @Override
    public boolean create() throws DuplicateException {
        boolean isCreated = false;
        try {
            isCreated = StudentDA.create(this);
        } catch (NotFoundException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidPasswordException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidNameException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidIdException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCreated;
    }

    /**
     * This is used to delete student record based on given id
     *
     * @throws NotFoundException user id does not exist
     */
    @Override
    public void delete() throws NotFoundException {
        try {
            StudentDA.delete(this);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * This method is used to update the student information depending upon the
     * given id
     *
     * @throws NotFoundException user id does not exist
     */
    public void update() throws NotFoundException {
        StudentDA.update(this);
    }

    /**
     * This is a parameterized constructor gets the users information and also
     * sets the student information including marks and also sets marks.
     *
     * @param id sets id
     * @param password sets password
     * @param firstName sets first name
     * @param lastName sets last name
     * @param emailAddress sets email address
     * @param enrol sets enroll date
     * @param lastAccess sets last access
     * @param enabled sets enabled type
     * @param type sets type
     * @param programCode sets prog code
     * @param programDescription sets prog description
     * @param year sets year
     * @param marks sets marks
     * @throws InvalidNameException for invalid name exception
     * @throws InvalidPasswordException for invalid password
     * @throws InvalidIdException for invalid id
     */
    public Student(long id, String password, String firstName, String lastName,
            String emailAddress, java.util.Date enrol, java.util.Date lastAccess,
            boolean enabled, char type, String programCode,
            String programDescription, int year, Vector<Mark> marks) throws InvalidIdException, InvalidPasswordException, InvalidNameException {
        super(id, password, firstName, lastName, emailAddress, enrol, lastAccess, enabled, type);
        setProgramCode(programCode);
        setProgramDescription(programDescription);
        setYear(year);
        setMarks(marks);
    }

    /**
     * This is a parameterized constructor gets the users information and also
     * sets the student information except of marks. However it creates a new
     * vector for the student.
     *
     * @param id sets student id
     * @param password sets password
     * @param firstName sets first name
     * @param lastName sets last name
     * @param emailAddress sets email address
     * @param enrol sets enroll date
     * @param lastAccess sets last access
     * @param enabled sets boolean
     * @param type sets type
     * @param programCode sets code
     * @param programDescription sets program description
     * @param year sets year
     * @throws InvalidNameException for invalid name
     * @throws InvalidPasswordException for invalid password
     * @throws InvalidIdException * for invalid id
     */
    public Student(long id, String password, String firstName, String lastName,
            String emailAddress, java.util.Date enrol, java.util.Date lastAccess,
            boolean enabled, char type, String programCode,
            String programDescription, int year) throws InvalidIdException, InvalidPasswordException, InvalidNameException {
        this(id, password, firstName, lastName, emailAddress, enrol,
                lastAccess, enabled, type, programCode, programDescription, year, new Vector<Mark>());

    }

    /**
     * This is a default constructor which sets the default properties to with
     * default values.
     *
     * @throws InvalidNameException for invalid name
     * @throws InvalidPasswordException for invalid password
     * @throws InvalidIdException * for invalid id
     */
    public Student() throws InvalidIdException, InvalidPasswordException, InvalidNameException {
        this(DEFAULT_ID, DEFAULT_PASSWORD, DEFAULT_FIRST_NAME,
                DEFAULT_LAST_NAME, DEFAULT_EMAIL_ADDRESS,
                new Date(), new Date(), DEFAULT_ENABLED_STATUS, DEFAULT_TYPE,
                DEFAULT_PROGRAM_CODE, DEFAULT_PROGRAM_DESCRIPTION, DEFAULT_YEAR);
    }

    /**
     * This method is used to print student information in readable format.
     * Also, we have added the suffixes to it .
     *
     * @return the toString method to print the student information in human
     * readable information.
     */
    @Override
    public String toString() {

        String formattedYear = null;
        int year = getYear();
        if ((year != 0)) {
            //if the year is a valid number then  format it, 
            //it will return the same string passed if invalid
            if (year == 1) {
                formattedYear = year + "st ";
            } else if (year == 2) {
                formattedYear = year + "nd ";
            } else if (year == 3) {
                formattedYear = year + "rd ";
            } else if (year >= 4 && year <= 9) {
                formattedYear = year + "th ";
            }
        } else {
            formattedYear = null;
        }

        String output = getTypeForDisplay() + " info for";
        output += "\n\t" + getFirstName() + " " + getLastName() + " (" + getId() + ")";
        output += "\n\tCurrently in " + (formattedYear != null ? formattedYear : year) + "year of ";
        output += " \"" + getProgramDescription() + "\"";
        output += " (" + getProgramCode() + ")";
        output += "\n\tat " + COLLEGE_NAME;
        output += "\n\tEnrolled:  " + DF.format(getEnrolDate());
        output += "\n\tLast Access:  " + DF.format(new Date());


        
//        output += Mark.gpaCalculator();
        
        return output;
    }

    /**
     * This method used to set the user type as string
     *
     * @return string for user type
     */
    @Override
    public String getTypeForDisplay() {
        return "Student";
    }

    /**
     * @return string formatted output
     */
    public String createWelcome() {
        String output = "<br/><h2>" + getTypeForDisplay() + " info for: </h2><br/>Name: "
                + getFirstName() + " " + getLastName() + "<br/>ID: " + getId()
                + "<br/>Currently in: " + getYear() + " Year Program<br/>Program Description: "
                + getProgramDescription() + "<br/>Program Code: "
                + getProgramCode() + "<br/>Enrolled: " + DF.format(getEnrolDate())
                + "<br/>Last Accessed on: " + getLastAccess() + "<br/>";

        if (getMarks().isEmpty()) {
            output += "No marks on record.<br/>";
        } else {
            for (int i = 0; i < marks.size(); i++) {
                output += marks.elementAt(i).getCourseCode() + "     ";
                output += marks.elementAt(i).getCourseName() + "     ";
                output += marks.elementAt(i).getGpaWeighting() + "     ";
                output += marks.elementAt(i).getResult() + "     ";
            }
            output += "GPA     :" + CalculateGPA();
        }
        return output;
    }

    public double CalculateGPA() {
        double gpa = 0;
        double gradePoint = 0;
        double hours = 0;
        double qualityPoint = 0;

        for (Mark marks : getMarks()) {

            if (marks.getResult() >= 90) {
                gradePoint = 5;
            } else if (marks.getResult() >= 85) {
                gradePoint = 4.5;
            } else if (marks.getResult() >= 80) {
                gradePoint = 4.0;
            } else if (marks.getResult() >= 75) {
                gradePoint = 3.5;
            } else if (marks.getResult() >= 70) {
                gradePoint = 3;
            } else if (marks.getResult() >= 65) {
                gradePoint = 2.5;
            } else if (marks.getResult() >= 60) {
                gradePoint = 2;
            } else if (marks.getResult() >= 55) {
                gradePoint = 1.5;
            } else if (marks.getResult() >= 50) {
                gradePoint = 1;
            } else {
                gradePoint = 0;
            }

            qualityPoint += gradePoint * marks.getGpaWeighting();
            hours += marks.getGpaWeighting();

        }
        gpa = qualityPoint / hours;
        gpa = (Math.round((gpa * 100.0))/100.0);

        return gpa;

    }

}
