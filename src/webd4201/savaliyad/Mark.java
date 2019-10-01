package webd4201.savaliyad;

import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Vector;

/**
 * This class is used to get the Student marks and tacks information for all
 * subjects. Based on the marks it calculates the GPA and sends it back to
 * student.
 * @author dhara
 *
 */
public class Mark extends Student {

//    /**
//     *  to hold students inn a vector
//     */
//    static Vector<Student> Students = new Vector<Student>();
    /**
     * Vector for marks to hold student marks
     */
    static Vector<Mark> marks = new Vector<>();

    /**
     * This is a constant variable which holds the minimum value as a double
     */
    public final double MINIMUM_GPA = 0.0F;
    /**
     * This is a constant variable which holds the maximum value as a double
     */
    public final double MAXIMUM_GPA = 5.0F;
    /**
     * This is used to store the student final GPA with one decimal point
     */
    public final DecimalFormat GPA = new DecimalFormat("#.0");

    /**
     * Holds the course code
     */
    private String courseCode;
    /**
     * Holds the course name
     */
    private String courseName;
    /**
     * Holds the result
     */
    private int result;
    /**
     * Holds the GPA weight
     */
    private float gpaWeighting;

    /**
     * @return the courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

//    /**
//     * To get the total of all subject's marks.
//     */
//    static int totalResult = 0;
//
//    /**
//     * To get the total of all subject's marks.
//     */
//    static double totalGpaWeighting = 0;
//
//    /**
//     * To get the average of all grades
//     */
//    static double weightedAverage = 0;
//
//    /**
//     * To find the GPA for student
//     */
//    static double overallGPA = 0;
//
//    /**
//     * To find the GPA for student
//     */
//    static double gpaCounter = 0;
//
//    /**
//     * To find the quality points
//     */
//    static double qualityPoints = 0;
//
//    /**
//     * To find the GPA per subject
//     */
//    static double gpa = 0;

    /**
     * To find the GPA per subject
     */
    static double totalgpaWeighting = 0;

    /**
     * @param courseCode the courseCode to set
     */
    public final void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public final void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the result
     */
    public int getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public final void setResult(int result) {
        this.result = result;
    }

    /**
     * @return the gpaWeighting
     */
    public double getGpaWeighting() {
        return gpaWeighting;
    }

    /**
     * @param gpaWeighting the gpaWeighting to set
     */
    public final void setGpaWeighting(float gpaWeighting) {
        this.gpaWeighting = gpaWeighting;
    }

//
    /**
     * This is a parameterized constructor
     *
     * @param courseCode sets course code
     * @param courseName sets course name
     * @param result sets result
     * @param gpaWeighting sets gpa weighting
     * @throws InvalidNameException for wrong name
     * @throws InvalidPasswordException for invalid password
     * @throws InvalidIdException for invalid id
     */
    public Mark(String courseCode, String courseName, int result,
            float gpaWeighting) throws InvalidIdException, InvalidPasswordException, InvalidNameException {
        super();
        setCourseCode(courseCode);
        setCourseName(courseName);
        setResult(result);
        setGpaWeighting(gpaWeighting);
    }

    /**
     * This is a default construction which uses the Student class to access the
     * information and update the records with the specific record.
     *
     * @throws InvalidNameException for wrong name
     * @throws InvalidPasswordException for invalid password
     * @throws InvalidIdException for invalid id
     */
    public Mark() throws InvalidIdException, InvalidPasswordException, InvalidNameException {
        super();
        setCourseCode(courseCode);
        setCourseName(courseName);
        setResult(result);
        setGpaWeighting(gpaWeighting);
    }

    /**
     * This is a toString method which is overridden
     *
     * @return the output as string format with displaying the student
     * information
     */
    @Override
    public String toString() {
        
//        String output = "Course Code:  ";
        String output = String.format("%-15s", getCourseCode());
//        output += "Course Name:  ";
        output += String.format("%-45s", getCourseName());
//        output += "Course Result:  ";
        output += String.format("%-40s", getResult());
//        output += "Course Weighting:  ";
        output += String.format("%-35s", GPA.format(getGpaWeighting()));
        
//        output += Mark.gpaCalculator();
        return output;
        
        
    }

//    /**
//     * Defines the GPA value per subject
//     * @return gpa per subject
//     */
//    public static double CalculateGPA() {
//
//        String grade = "";
//        String achivement = "";
//        double gpa = 0;
//        double gradeValue = 0.0;
//        int result = 0;
//        int counter = 0;
//        double average = 0;
//        double totalGPAhrs = 0;
//
//        for (int i = 0; i < marks.size(); i++) {
////            System.out.println("Course Code: " + marks.elementAt(i).getCourseCode());
////            System.out.println("Course Name: " + marks.elementAt(i).getCourseName());
////            System.out.println("Course Weighting: " + marks.elementAt(i).getGpaWeighting());
////            System.out.println("Course Result: " + marks.elementAt(i).getResult());
//            counter++;
//            result += marks.elementAt(i).getResult();
//            totalGPAhrs += marks.elementAt(i).getGpaWeighting();
//            
//        }
        
//        average = result/counter; 
//            
//        
//
//        if (average <= 100 && average >= 90) {
//            achivement = "Outstanding";
//            grade = "A+";
//            gradeValue = 5.00;
//        } else if (average >= 85) {
//            achivement = "Exemplary";
//            grade = "A";
//            gradeValue = 4.50;
//        } else if (average >= 80) {
//            achivement = "Excellent";
//            grade = "A-";
//            gradeValue = 4.00;
//        } else if (average >= 75) {
//            achivement = "Very Good";
//            grade = "B+";
//            gradeValue = 3.50;
//        } else if (average >= 70) {
//            achivement = "Good";
//            grade = "B";
//            gradeValue = 3.00;
//        } else if (average >= 65) {
//            achivement = "Satisfactory";
//            grade = "C+";
//            gradeValue = 2.50;
//        } else if (average >= 5.0060) {
//            achivement = "Acceptable";
//            grade = "C";
//            gradeValue = 2.00;
//        } else if (average >= 55) {
//            achivement = "Conditional Pass";
//            grade = "D+";
//            gradeValue = 1.50;
//        } else if (average >= 50) {
//            achivement = "Conditional Pass";
//            grade = "D";
//            gradeValue = 1.00;
//        } else {
//            achivement = "Fail";
//            grade = "F";
//            gradeValue = 0.00;
//        }

//       
//        qualityPoints = totalGPAhrs * gradeValue;
//        gpa = qualityPoints / totalGPAhrs;
//
//        System.out.println("Per Subject GPA weighting: " + gpa);
//
//        return gpa;
    
}
