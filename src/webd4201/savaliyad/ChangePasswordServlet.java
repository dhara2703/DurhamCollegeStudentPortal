package webd4201.savaliyad;

import java.io.*;
import java.sql.*;
import java.util.GregorianCalendar;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * This is a change password servlet which is redirecting from the
 * changepassword.jsp file.Based on the given information, user input gets
 * validated for passing the new password.During the input, if any error occurs,
 * it displays the error message. Finally if user enters the correct password
 * for new password and confirm password correct, they get successful password
 * change message.
 *
 * @author Darren Puffer
 * @author dhara
 * @version 1.0 (2019/03/01)
 * @since 1.0
 */

public class ChangePasswordServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // connect to database
            Connection c = DatabaseConnect.initialize();
            Student.initialize(c);
            HttpSession session = request.getSession(true);
            StringBuffer errorBuffer = new StringBuffer();
            long id = 0L;
            try {
                // Customer aCust = (Customer) request.getSession(false).getAttribute( "customer");
                //id = Long.parseLong((String) request.getAttribute("user"));
                Student sessionStudent = (Student) session.getAttribute("student");
                id = sessionStudent.getId();
                String oldPassword = new String();
                String newPassword = new String();
                String confirmPassword = new String();

                oldPassword = request.getParameter("currentpwd").trim();
                newPassword = request.getParameter("newpwd").trim();
                confirmPassword = request.getParameter("confirmpwd").trim();

                User aStudent = Student.authenticate(id, oldPassword); //attempt to find the Student, this could cause a NotFoundException

                if (oldPassword.length() == 0 || newPassword.length() == 0 || confirmPassword.length() == 0) {
                    if (oldPassword.length() == 0) {
                        session.setAttribute("message", "Please enter your current password");
                    } else if (newPassword.length() == 0) {
                        session.setAttribute("message", "Please enter your new password");
                    } else if (confirmPassword.length() == 0) {
                        session.setAttribute("message", "Please enter the new password again");
                    } else {
                        session.setAttribute("message", "You must fill the form to change your password");
                        
                    }	
                    response.sendRedirect("./changePassword.jsp");
                } else if (newPassword.length() >= 8 && newPassword.length() <= 20) {
                    if (newPassword.equals(confirmPassword)) {
                        aStudent.setPassword(Student.hashPassword(confirmPassword));
                        aStudent.setLastAccess(new GregorianCalendar().getTime());
                        aStudent.update();
                        session.removeAttribute("student");
                        session.setAttribute("student", aStudent);
                        session.setAttribute("message", "Password Changed Successfully");
                        response.sendRedirect("./dashboard.jsp");
                    } else {
                        session.setAttribute("message", "New password and Confirm Password must be same");

                    }
                } else {
                    session.setAttribute("message", "Password length must be between 8 to 20 characters.");
                    response.sendRedirect("./changePassword.jsp");

                }
            } catch (NumberFormatException nfex) {
            	
                errorBuffer.append("<strong>Please provide valid user name.<br/>");
                errorBuffer.append("Please try again.</strong>");
                session.setAttribute("message", errorBuffer.toString());
                response.sendRedirect("./changePassword.jsp");

            } catch (NotFoundException nfe) {

                errorBuffer.append("<br/>Your current password is Invalid");
                session.setAttribute("message", errorBuffer.toString());
                response.sendRedirect("./changePassword.jsp");
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
