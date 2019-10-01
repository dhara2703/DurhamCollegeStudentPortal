package webd4201.savaliyad;

import java.io.*;
import javax.servlet.*;
import java.util.GregorianCalendar;
import javax.servlet.http.*;
import java.sql.*;

/**
 * This servlet is used to update the user information who is currently logged
 * in. They can update thier user information as well as their student
 * information too like, what program they are in and other information.
 *
 * @author dhara
 * @since 15 April, 2019
 */
public class UpdateStudentServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // connect to database
            Connection c = DatabaseConnect.initialize();
            Student.initialize(c);
            User.initialize(c);
            HttpSession session = request.getSession(true);
            StringBuffer errorBuffer = new StringBuffer();
            long id = 0L;
            String firstName = new String();
            String lastName = new String();
            String email = new String();
            String progCode = new String();
            String progDesc = new String();
            String progYear = new String();
            boolean anyErrors = false;
            int validProgYear = 0;

            try {   // retrieve data from DB
                Student sessionStudent = (Student) session.getAttribute("student");
                id = sessionStudent.getId();
                firstName = request.getParameter("firstName").trim();
                lastName = request.getParameter("lastName").trim();
                email = request.getParameter("email").trim();
                progCode = request.getParameter("progCode").trim();
                progDesc = request.getParameter("progDesc").trim();
                progYear = request.getParameter("progYear").trim();

                if (firstName.isEmpty() || lastName.length() == 0 || email.length() == 0 || progCode.length() == 0 || progDesc.isEmpty() || progYear.isEmpty()) {
                    if (firstName.length() == 0) {
                        errorBuffer.append("First Name cannot be empty<br/>");
                    }
                    if (lastName.length() == 0) {
                        errorBuffer.append("Last Name cannot be empty<br/>");
                    }
                    if (email.length() == 0) {
                        errorBuffer.append("Email Address cannot be empty<br/>");
                    }
                    if (progCode.length() == 0) {
                        errorBuffer.append("Program Code cannot be empty<br/>");
                    }
                    if (progDesc.length() == 0) {
                        errorBuffer.append("Program Description cannot be empty<br/>");
                    }
                    if (progYear.length() == 0) {
                        errorBuffer.append("Program Year cannot be empty<br/>");
                    }

                    
                }

                if (!User.isValidEmailAddress(email)) {
                    anyErrors = true;
                    errorBuffer.append("<h3>").append(email).append(" is not a valid email.</h3>\n");
                    session.setAttribute("EmailAddress", "");
                }

                session.setAttribute("FirstName", firstName);
                session.setAttribute("LastName", lastName);
                session.setAttribute("EmailAddress", email);
                session.setAttribute("ProgramCode", progCode);
                session.setAttribute("ProgramDesc", progDesc);
                session.setAttribute("ProgYear", progYear);

                validProgYear = Integer.parseInt(progYear);

                if (User.isExistingUser(id)) {
                    User aUser = User.retrieve(id);
                    Student aStudent = Student.retrieve(id);

                    if (!firstName.equals(aUser.getFirstName()) || !lastName.equals(aUser.getLastName())
                            || !email.equals(aUser.getEmailAddress()) || !progCode.equals(aStudent.getProgramCode())
                            || !progDesc.equals(aStudent.getProgramDescription()) || !progYear.equals(aStudent.getYear())) {
                        aUser.setFirstName(firstName);
                        aUser.setLastName(lastName);
                        aUser.setEmailAddress(email);
                        aUser.update();
                        aStudent.setProgramCode(progCode);
                        aStudent.setProgramDescription(progDesc);
                        aStudent.setYear(validProgYear);
                        aStudent.setLastAccess(new GregorianCalendar().getTime());
                        aStudent.update();
                        session.removeAttribute("student");
                        session.setAttribute("message", "Student Information Changed Successfully");

                    }
                    session.setAttribute("student", aStudent);
                    response.sendRedirect("./dashboard.jsp");
                } else {
                    errorBuffer.append("<strong>Your User ID does not exist.<br/>");
                    errorBuffer.append("Please try again.</strong>");
                    session.setAttribute("message", errorBuffer.toString());
                    response.sendRedirect("./login.jsp");

                }
            } catch (NotFoundException nfe) {
                anyErrors = true;
                errorBuffer.append("<strong>Your ID is not exist in our system<br/>");
                errorBuffer.append("Please try again.</strong>");
                session.setAttribute("message", errorBuffer.toString());
                response.sendRedirect("./login.jsp");
            }
        } catch (Exception e) {//not connected
            System.out.println(e);
            String line1 = "<h2>A network error has occurred!</h2>";
            String line2 = "<p>Please notify your system "
                    + "administrator and check log. " + e.toString() + "</p>";
            formatErrorPage(line1, line2, response);

        }
    }

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void formatErrorPage(String first, String second,
            HttpServletResponse response) throws IOException {
        PrintWriter output = response.getWriter();
        response.setContentType("text/html");
        output.println(first);
        output.println(second);
        output.close();
    }
}
