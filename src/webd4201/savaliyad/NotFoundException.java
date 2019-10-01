package webd4201.savaliyad;

/**
 * This is an exception of NotFoundException when user tries to find a record
 * based on given id when a record is not found in database.
 * @author Darren Puffer
 */

@SuppressWarnings("serial")
public class NotFoundException extends Exception {
    
     /**
     * Returns the exception message to see the error
     * @param id for printing message saying id is not found 
     */
    public NotFoundException(long id) {
        System.out.println("Student with id: " + id + " does not exist with provided information.");
        
    }
}
