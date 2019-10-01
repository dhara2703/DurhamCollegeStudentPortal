package webd4201.savaliyad;

/**
 * This exception is throws when invalid password is given (This can be useful
 * for login system)
 *
 * @author Darren Puffer
 * @author dhara
 *
 */
@SuppressWarnings("serial")
public class InvalidPasswordException extends Exception {

    /**
     * Returns the exception message to see the error
     * @param id long id to set message for that id given password is not in valid format
     */
    public InvalidPasswordException(long id) {
        System.out.println(id + " is invalid password.");
    }
}
