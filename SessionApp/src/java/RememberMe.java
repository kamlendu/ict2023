
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
//import javax.sql.*;

public class RememberMe extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Setting MIME type for HTTP header */
        response.setContentType("text/html");

        /* Obtaining the output stream */
        PrintWriter out = response.getWriter();

        /* Creating a Connection and Statement object for later use */
        Connection con = null;
        Statement stmt;

        try {
            /* Memory variables that hold Db login information */
            String username = "root";
            String password = "ompandey";
            String url = "jdbc:mysql://localhost/test?useSSL=false";

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            con = DriverManager.getConnection(url, username, password);

            /* If the connection is successful */
            if (con != null) {
                out.println("<BR>Successfully connected to MySQL server using TCP/IP...<BR>");
                stmt = con.createStatement();
                /* A query that will determine if the username and password captured are valid */
                String query = "SELECT user FROM login WHERE user = '" + request.getParameter("txtusername").toString() + "' AND password ='" + request.getParameter("txtpassword").toString() + "'";
                /* Executing the querACTION='/SessionApp/RememberMe' METHOD='post' NAME='frmLogin'>");y using the ResultSet object */
                ResultSet rs = stmt.executeQuery(query);

                /* If the resultset holds no records */
                if (rs.next() == false) {
                    out.println("<BR>Sorry. Invalid Login. Please try again.");
                } /* If the resultset holds records */ else {
                    out.println("<BR>Successful Login. Welcome to the world of Servlets.");

                    /* If the chkrem i.e. Remember Me check box is checked on */
                    if (request.getParameter("chkrem") != null) {
                        /* A cookie to hold the username is created */
                        Cookie returnLoginUser = new Cookie("ValidUser", request.getParameter("txtusername").toString());
                        /* Setting how much time in seconds should elapse before the cookie expires */
                        returnLoginUser.setMaxAge(36000);
                        /* Adding cookie to the Set-Cookie response header by means of the addCookie method of HttpServletResponse */
                        response.addCookie(returnLoginUser);

                        /* A cookie to hold the password is created */
                        Cookie returnLoginPassword = new Cookie("ValidPassword", request.getParameter("txtpassword").toString());
                        /* Setting how much time in seconds should elapse before the cookie expires */
                        returnLoginPassword.setMaxAge(36000);
                        /* Adding cookie to the Set-Cookie response header by means of the addCookie method of HttpServletResponse */
                        response.addCookie(returnLoginPassword);
                    } /* If the chkrem i.e. Remember Me check box is checked off */
                    else {
                        /* Assigning a null value */
                        Cookie returnLoginUser = new Cookie("ValidUser", "");
                        /* Deleting the cookie */
                        returnLoginUser.setMaxAge(0);
                        /* Adding cookie to the Set-Cookie response header by means of the addCookie method of HttpServletResponse */
                        response.addCookie(returnLoginUser);

                        /* Assigning a null value */
                        Cookie returnLoginPassword = new Cookie("ValidPassword", "");
                        /* Deleting the cookie */
                        returnLoginPassword.setMaxAge(0);
                        /* Adding cookie to the Set-Cookie response header by means of the addCookie method of HttpServletResponse */
                        response.addCookie(returnLoginPassword);

                        out.println("<BR><BR>You did not choose to remember the login information. Hence you will need to enter login details the next time you visit us.");
                    }
                }
            }
            /* Closing the output stream */
            out.close();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}