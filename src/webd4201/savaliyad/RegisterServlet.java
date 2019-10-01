package webd4201.savaliyad;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.util.Date;

/**
 * This servlet is used for getting information from the web page using user input.
 * @author dhara
 */
@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	
	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try 
        {        	 
            Connection c = DatabaseConnect.initialize();// connect to database
            Student.initialize(c);
            User.initialize(c);
            boolean anyErrors = false;
            HttpSession session = request.getSession(true);
            StringBuffer errorBuffer = new StringBuffer();
            String id = new String();
            String password = new String();
            String confirmPassword = new String();
            String firstName = new String();
            String lastName = new String();
            String email = new String();
            String progCode = new String();
            String progDesc = new String();
            String progYear = new String();
            int validProgYear = 0;
            long validId = 0L;
            
           
            try 
            {   // retrieve data from DB
                id = request.getParameter("userId").trim();
                password = request.getParameter("password").trim();
                confirmPassword = request.getParameter("confirmPassword").trim();
                firstName = request.getParameter("firstName").trim();
                lastName = request.getParameter("lastName").trim();
                email = request.getParameter("email").trim();
                progCode = request.getParameter("progCode").trim();
                progDesc = request.getParameter("progDesc").trim();
                progYear = request.getParameter("progYear").trim();

                if (id.length() == 0 || password.length() == 0 || confirmPassword.isEmpty() || firstName.isEmpty() || lastName.length() == 0 || email.length() == 0 || progCode.length() == 0 || progDesc.isEmpty() || progYear.isEmpty()) 
                {
                    if (id.length() == 0) {errorBuffer.append("User ID cannot be empty<br/>"); }
                    if (password.length() == 0) { errorBuffer.append("Password cannot be empty<br/>"); }
                    if (confirmPassword.length() == 0) { errorBuffer.append("Confirm Password cannot be empty<br/>"); }
                    if (firstName.length() == 0) { errorBuffer.append("First Name cannot be empty<br/>"); }
                    if (lastName.length() == 0) { errorBuffer.append("Last Name cannot be empty<br/>"); }
                    if (email.length() == 0) { errorBuffer.append("Email Address cannot be empty<br/>"); }
                    if (progCode.length() == 0) { errorBuffer.append("Program Code cannot be empty<br/>"); }
                    if (progDesc.length() == 0) { errorBuffer.append("Program Description cannot be empty<br/>"); }
                    if (progYear.length() == 0) { errorBuffer.append("Program Year cannot be empty<br/>"); }
                    anyErrors = true;
                    session.setAttribute("message", errorBuffer.toString());
                    response.sendRedirect("./register.jsp");
                } 
                if (validId < User.MINIMUM_ID_NUMBER || validId > User.MAXIMUM_ID_NUMBER) {
                    errorBuffer.append("User ID must be between 100000000 and 999999999.");
                    session.setAttribute("message", errorBuffer.toString());
                    response.sendRedirect("./register.jsp");
                }                 
                if (!password.equals(confirmPassword)) {
                    errorBuffer.append("Password and Confirm Password must be same.");
                    session.setAttribute("message", errorBuffer.toString());
                    response.sendRedirect("./register.jsp");
                } else if (password.length() < User.MINIMUM_PASSWORD && password.length() > User.MAXIMUM_PASSWORD) {
                    errorBuffer.append("Password should be minimu 8 characters and maximum 20 characters long.");
                    session.setAttribute("message", errorBuffer.toString());
                    response.sendRedirect("./register.jsp");
                } else if (!User.isValidEmailAddress(email)) {
                    anyErrors = true;
                    errorBuffer.append("<h3>").append(email).append(" is not a valid email.</h3>\n");
                    session.setAttribute("EmailAddress", "");
                }
                validId = Long.parseLong(id);
                validProgYear = Integer.parseInt(progYear);

                if (!User.isExistingUser(validId)) {
                    Student aStudent = new Student(validId, password, firstName, lastName, email, new Date(), new Date(), true, 's', progCode, progDesc, validProgYear);
                    aStudent.create();
                    session.setAttribute("student", aStudent);
                    response.sendRedirect("./dashboard.jsp");
                } else {
                    id = request.getParameter("login"); //this is the name of the text input box on the form
                    errorBuffer.append("<strong>Your User ID is already exist.<br/>");
                    errorBuffer.append("Please try again.</strong>");

                    long passedId = Long.parseLong(id);
                    if (User.isExistingUser(passedId)) {
                        session.setAttribute("login", id);
                    } else {
                        errorBuffer.append("<br/>Invalid login id.");
                        session.setAttribute("login", "");
                    }
                    session.setAttribute("message", errorBuffer.toString());
                    response.sendRedirect("./login.jsp");
        
                }
	        } catch (NumberFormatException nfex) {
	            anyErrors = true;
	            errorBuffer.append("<strong>Your login id must be number only.<br/>");
	            errorBuffer.append("Please try again.</strong>");
	            session.setAttribute("UserIDNumber", errorBuffer.toString());
	            response.sendRedirect("./register.jsp");
	        } catch (DuplicateException de) {
                    anyErrors = true;
	            errorBuffer.append("<strong>Your login id is already exist. Please.<br/>");
	            errorBuffer.append("Please try again.</strong>");
	            session.setAttribute("UserIDNumber", errorBuffer.toString());
	            response.sendRedirect("./register.jsp");
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

