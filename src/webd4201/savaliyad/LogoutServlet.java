package webd4201.savaliyad;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
//import java.sql.*;


/**
 * This is a logout servlet which is redirecting from the webpage when user clicks on the
 * logout button.It deletes the session and redirect the user to the login page.
 *
 * @author Darren Puffer
 * @version 1.0 (2019/03/01)
 * @since 1.0
 */

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        

        HttpSession session = request.getSession(true); //retrieve the session (or start)       
        session.removeAttribute("student");//remove the object stored at login
//        session.invalidate();
        response.sendRedirect("./login.jsp");  //redirect to logout.jsp
        session.setAttribute("message", "<h2>You have successfully logged out</h2>");//give an informational message
    }
     public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}