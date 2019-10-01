package webd4201.savaliyad;

/**
 * This exception is used when invalid name is provided to to insert.
 *
 * @author Darren Puffer
 * @author dhara
 */
@SuppressWarnings("serial")
class InvalidNameException extends Exception {

    /**
     * Returns the exception message to see the error
     *
     * @param string
     */
    public InvalidNameException(String string) {
        System.out.println(string + " is invalid name. Name cannot be a number");
    }
}
