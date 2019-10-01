package webd4201.savaliyad;

/**
 * This exception is used to throw an exception when retrieving the id and the
 * id is not exist in the system.
 *
 * @author Darren Puffer
 * @author Dhara Savaliya
 *
 */
@SuppressWarnings("serial")
public class InvalidIdException extends Exception {

    public InvalidIdException(long id) {
        System.out.println(id + " is invalid id.");
    }

}
