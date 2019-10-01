package webd4201.savaliyad;

/**
 * This is a method to get the user type in human readable mode
 *
 * @author - Darren Puffer
 * @version 1.0 (2019/01/12)
 * @since 1.0
 */


/**
 * This is an interface gets information.
 */
interface CollegeInterface {
	/**
     * This attribute COLLEGE_NAME is used to hold the string for the
     * CollegeInterface
     */
    String COLLEGE_NAME = "Durham College";
    /**
     * This attribute PHONE_NUMBER is used to hold the string for the
     * CollegeInterface
     */
    String PHONE_NUMBER = "(905)721-2000";
    /**
     * This attribute MINIMUM_ID_NUMBER is used to hold the long for the
     * CollegeInterface
     */
    long MINIMUM_ID_NUMBER = 100000000L;
    /**
     * This attribute MAXIMUM_ID_NUMBER is used to hold the long for the
     * CollegeInterface
     */
    long MAXIMUM_ID_NUMBER = 999999999L;

    /**
     * This method is to get the user type in human readable mode
     * @return string
     */
    public abstract String getTypeForDisplay();

}