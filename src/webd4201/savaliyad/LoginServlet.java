package webd4201.savaliyad;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

/**
 * This is a login servlet which is redirecting from the login.jsp file.Based on
 * the given information, user input gets validated authenticated.During the
 * input, if any error occurs, it displays the error message.Also for successful
 * user id or authenticated id and password, session gets set.
 *
 * @author Darren Puffer
 * @version 1.0 (2019/03/01)
 * @since 1.0
 */
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // connect to database
            Connection c = DatabaseConnect.initialize();
            Student.initialize(c);
            User.initialize(c);
            Mark.initialize(c);
            HttpSession session = request.getSession(true);
            StringBuffer errorBuffer = new StringBuffer();
            Student aStudent;
            String login = new String();
            boolean anyErrors = false;
            long id = 0L;
            String password = new String();
//            boolean loggedOn = false;
            try {   // retrieve data from DB

                login = request.getParameter("login").trim(); //this is the name of the text input box on the form
                password = request.getParameter("password").trim();

                id = Long.parseLong(login);
//                session.setAttribute("message", "Hello");

                if (login.length() == 0 || password.length() == 0) {
                    if (login.length() == 0) {
                        errorBuffer.append("User ID cannot be empty<br/>");
                    }
                    if (password.length() == 0) {
                        errorBuffer.append("Password cannot be empty<br/>");
                    }
                    anyErrors = true;
                    session.setAttribute("message", errorBuffer.toString());
                    response.sendRedirect("./login.jsp");
                }
                User aUser = User.authenticate(id, password); //attempt to find the Student, this could cause a NotFoundException
                if (aUser == null) {
                }                //if (aUser == null) errorDebug = "aUser is null"; else errorDebug = " got here! " + aUser.toString();  // Dhara_test
                aStudent = Student.retrieve(aUser.getId());
                if (aStudent == null) {
                } else {
                }                // if the Student was found and retrieved from the db put the found Student onto the session
                session.setAttribute("student", aStudent);
                session.setAttribute("message", "");
//              session.setAttribute("today", new Date());
//              redirect the user to a JSP
                response.sendRedirect("./dashboard.jsp");
//              errorBuffer.append("<strong>Welcome" + aStudent.getFirstName());
                //session.setAttribute("user", aStudent.getId());
//                session.setAttribute("info", );
            } catch (NumberFormatException nfex) {
                errorBuffer.append("<strong>Your login id must be number only. You entered: ").append(login).append("<br/>");
                errorBuffer.append("Please try again.</strong>");
                session.setAttribute("message", errorBuffer.toString());
                session.setAttribute("login", "");
                response.sendRedirect("./login.jsp");
            } catch (NotFoundException nfe) {
                //id = request.getParameter("login"); //this is the name of the text input box on the form

                errorBuffer.append("<strong>Your login information is incorrect.<br/>");
                errorBuffer.append("Please try again.</strong>");

                if (User.isExistingUser(id)) {
                    session.setAttribute("login", id);
                } else {
                    errorBuffer.append("<strong>Invalid login id.</strong>");
                    session.setAttribute("login", "");
                }
                session.setAttribute("message", errorBuffer.toString());
                response.sendRedirect("./login.jsp");

                //for the first deliverable you will have to check if there was a problem
                //with just the password, or login id and password
                //this will require a special method e.g. public static boolean isExistingStudent(String arg);
            }

        } catch (Exception e) //not connected
        {
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
