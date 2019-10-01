package webd4201.savaliyad;


/**
 * This exception is used when user enters invalid information
 * @author dhara
 */
@SuppressWarnings("serial")
public class InvalidUserDataException extends Exception {

    /**
     * Returns the exception message to see the error
     * @param string message
     */
    public InvalidUserDataException(String string) {
        System.out.println("Provided User information is invalid");
    }

    InvalidUserDataException(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
