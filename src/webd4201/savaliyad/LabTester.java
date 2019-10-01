package webd4201.savaliyad;

import java.sql.Connection;
import java.util.*;

/**
 * Class Description. Main method to test the Student JDBC methods
 *
 * @author Darren Puffer
 * @version 1.0 (2018 January 18)
 * @since 1.0
 */
public class LabTester {

    static Mark aMark;

    public static void main(String[] args) throws Exception {
        System.out.println("******************************************************* Lab 1 Output *******************************************************\n");
        Connection c = null;
        Student mainStudent;  //object for a program created Student
        Student dbStudent;   //object for database retrieved Student
        long possibleId = 100222229L;
        GregorianCalendar cal = new GregorianCalendar();
        Date lastAccess = cal.getTime();
        cal.set(2019, Calendar.JANUARY, 18);
        Date enrol = cal.getTime();
        mainStudent = new Student();
        dbStudent = new Student();

        System.out.println("\nCreate a Student user to insert/delete later in the program, passing:\n\t"
                + "Student student1 = new Student(" + possibleId + "L, \"password\", \"Robert\", \"McReady\","
                + " \"bob.mcready@dcmail.ca\", enrol, lastAccess, 's', true, \"CPA\", \"Computer Programmer Analyst\", 3);\n");

        mainStudent = new Student(possibleId, "password", "Robert", "McReady", "bob.mcready@dcmail.ca",
                enrol, lastAccess, true, 's', "CPA", "Computer Programmer Analyst", 3);

//			mainStudent.dump();
        try {

            // initialize the database (i.e. create a database connection)
            c = DatabaseConnect.initialize();
            User.initialize(c);
            Student.initialize(c);

            try // attempt to get a Student that does NOT exist, throws Exception
            {
                System.out.println("\nAttempt to retrieve a student that does not exist (Id: " + possibleId + ")");
                dbStudent = Student.retrieve(possibleId);
                System.out.println("Student record with id " + possibleId + " retrieved from the database\n");
                dbStudent.dump();
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
            }

            try // attempt to get a Student that does exist
            {
                possibleId = 100111111L;
                System.out.println("\nAttempt to retrieve a student that does exist (Id: " + possibleId + ")");
                dbStudent = Student.retrieve(possibleId);
                System.out.println("Student record with id " + possibleId + " retrieved from the database\n");
                dbStudent.dump();
                dbStudent.toString();
                for (int i = 0; i < dbStudent.getMarks().size(); i++) {
                    aMark = dbStudent.getMarks().get(i);
                    System.out.println("");
                    aMark.dump();
                }
                System.out.println("GPA:  " + dbStudent.CalculateGPA());
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
            }

            try // now, try to find the another Student
            {
                possibleId = 100111110L;
                dbStudent = Student.retrieve(possibleId);
                System.out.println("\n\n");
                dbStudent.dump();
                dbStudent.toString();
                for (int i = 0; i < dbStudent.getMarks().size(); i++) {
                    aMark = dbStudent.getMarks().get(i);
                    System.out.println("");
                    aMark.dump();
                }
                System.out.println("GPA:  " + dbStudent.CalculateGPA());

            } catch (NotFoundException e) {
                System.out.println("\n\nDid not find student record with id " + possibleId + ".\n");
            }

            try // attempt to get a Student that does exist
            {
                possibleId = 100222229L;
                System.out.println("\nAttempt to insert a new student record for "
                        + mainStudent.getFirstName() + " " + mainStudent.getLastName()
                        + "(Id: " + mainStudent.getId() + ")");
                mainStudent.create();
                System.out.println("Student record added to the database.\n");
            } catch (DuplicateException e) {
                System.out.println(e);
            }

            try // Attempt to update the student info
            {
                possibleId = 100222229L;
                System.out.println("\nChange the student object and attempt to update the student record for "
                        + mainStudent.getFirstName() + " " + mainStudent.getLastName()
                        + "(Id: " + mainStudent.getId() + ")");
                
                mainStudent.setFirstName("Jena");
                mainStudent.setLastName("Patel");
                mainStudent.setEmailAddress("jena.pate@dcmail.ca");
                mainStudent.setProgramCode("CP");
                mainStudent.setProgramDescription("Computer Programming Analyst");
                mainStudent.setYear(3);
                mainStudent.setLastAccess(new GregorianCalendar().getTime());
                mainStudent.update();
                System.out.println("Student record updated in the database.\n");
                mainStudent.dump();

            } catch (NotFoundException e) {
                System.out.println(e);
            }

            System.out.println("\nStudents are encouraged to comment out the folowing try...catch block to"
                    + " verify the new record exists in pgAdmin by running the \"SELECT * FROM Students;\" command ");

//            try // now, attempt to delete the new Student
//            {
//                possibleId = 100222229L;
//
//                System.out.println("\nAttempt to delete the new student record for "
//                        + mainStudent.getFirstName() + " " + mainStudent.getLastName() + "(Id: " + mainStudent.getId() + ")");
//                mainStudent.delete();
//                System.out.println("Student record with id " + mainStudent.getId() + " successfully removed from the database.\n");
//            } catch (NotFoundException e) {
//                System.out.println(e);
//            }
//              trying to check that the user id and password combination matches with the used provided information
            try // now, try to find the given Student
            {
                User authenticatedUser = Student.authenticate(100648840, "password1");
                System.out.println("Successful Attempt with user:");
                authenticatedUser.dump();
            } catch (NotFoundException e) {
                System.out.println("Did not find student id with given password.\n");
            }

//            
//            
        } catch (Exception e) {   //catch for database initialize/connect try
            System.out.println(e.toString());
        } finally { // close the database resources, if possible
            try {
                Student.terminate();
                User.terminate();
                Mark.terminate();
            } catch (Exception e) {
            }
            try {
                DatabaseConnect.terminate();
            } catch (Exception e) {
            }
        }
    }
}
