package webd4201.savaliyad;

import java.util.Date;

/**
 * This is faculty class and extends from the User class.
 * @author Darren Puffer
 * @author dhara
 * @version 1.0 (2019/01/21)
 * @since 1.0
 */
public class Faculty extends User {
	
	/**
     * This hold a default school code SET as constant (final) in string format
    */
    public final static String DEFAULT_SCHOOL_CODE = "SET";
    /**
    * This hold a default school description as constant (final) in string
    * format
    */
    public final static String DEFAULT_SCHOOL_DESCRIPTION = "School of Engineering & Technology";
    /**
	 * This hold a default office number as constant (final) in string format
     */
    public final static String DEFAULT_OFFICE = "H-140";
    /**
    * This hold a default phone extension to 1234 as constant (final) in
    * integer format
    */
    public final static int DEFAULT_PHONE_EXTENSION = 1234;

    // Instance Attributes

   /**
    * To hold the school code
    */
    private String schoolCode;

    /**
    * To hold the school description
    */

    private String schoolDescription;
    /**
    * To hold the office room number
    */
    private String office;
    /**
    * To hold the extension
    */
    private int extension;

    /**
     * @return the schoolCode
     */
    public String getSchoolCode() {
        return schoolCode;
    }

    /**
     * @param schoolCode the schoolCode to set
     */
    public final void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    /**
     * @return the schoolDescription
     */
    public String getSchoolDescription() {
        return schoolDescription;
    }

    /**
     * @param schoolDescription the schoolDescription to set
     */
    public final void setSchoolDescription(String schoolDescription) {
        this.schoolDescription = schoolDescription;
    }

    /**
     * @return the office
     */
    public String getOffice() {
        return office;
    }

    /**
     * @param office the office to set
     */
    public final void setOffice(String office) {
        this.office = office;
    }

    /**
     * @return the extension
     */
    public int getExtension() {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public final void setExtension(int extension) {
        this.extension = extension;
    }

	
	
	/**
	* This is parameterized constructor which used to create a new object. It
        * uses the abstract class properties using the super keyword.
	* @param id set id
        * @param password set password
        * @param firstName sets first name
        * @param lastName sets last name
        * @param emailAddress sets email address
        * @param lastAccess sets last access
        * @param enrolDate sets enroll date
        * @param enabled sets enabled
        * @param type sets type
        * @param schoolCode sets school code
        * @param schoolDescription sets school description
        * @param office sets office
        * @param extension sets extension
        * @throws InvalidIdException for wrong not valid id
        * @throws InvalidPasswordException for wrong password size
        * @throws InvalidNameException for wrong user name
        */
	public Faculty(long id, String password, String firstName, String lastName,
			String emailAddress, Date lastAccess, Date enrolDate,
			boolean enabled, char type,String schoolCode,
            String schoolDescription, String office, int extension) throws InvalidIdException,
			InvalidPasswordException, InvalidNameException {
		super(id, password, firstName, lastName, emailAddress, lastAccess,
				enrolDate, enabled, type);
		setSchoolCode(schoolCode);
        setSchoolDescription(schoolDescription);
        setOffice(office);
        setExtension(extension);
	}

	/**
	* This is a default constructor which has no parameters and throws
        * InvalidIdException if the id is already exists and messages that the id
        * is already exist. 
        * @throws InvalidIdException for invalid id
        * @throws InvalidPasswordException for invalid password size
        * @throws InvalidNameException for invalid name 
	*/
	public Faculty() throws InvalidIdException, InvalidPasswordException,
			InvalidNameException {
		super();
        setSchoolCode(schoolCode);
        setSchoolDescription(schoolDescription);
        setOffice(office);
        setExtension(extension);
	}

}
