
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Setting MIME type for HTTP header */
        response.setContentType("text/html");

        /* Obtaining the output stream */
        PrintWriter out = response.getWriter();

        /* Memory variables that will hold the username and password */
        String username = "";
        String password = "";

        /* Retrieving all unexpired cookies */
        Cookie[] cookies = request.getCookies();

        /* If cookies were retrieved */
        if (cookies != null) {
            /* Traversing across all the cookies and extracting the username and password from the ValidUser and ValidPassword cookies respectively. */
            for (int i = 0; i < cookies.length; i++) {
                Cookie thisCookie = cookies[i];

                if (thisCookie.getName().equals("ValidUser")) {
                    username = thisCookie.getValue();
                } else if (thisCookie.getName().equals("ValidPassword")) {
                    password = thisCookie.getValue();
                }
            }
        }

        /* Generating the actual Login form user interface */
        out.println("<HTML><HEAD><TITLE>Login Form</TITLE></HEAD>");
        out.println("<BODY><FORM ACTION='/SessionApp/RememberMe' METHOD='post' NAME='frmLogin'>");
        out.println("<TABLE><TR><TD ALIGN='center'><IMG SRC='/security.jpg' WIDTH='64' HEIGHT='64' BORDER='0'>");

        out.println("<TABLE WIDTH='25%' BORDER='1' ALIGN='center' CELLPADDING='3' CELLSPACING='1' BORDERCOLOR='#000000'>");
        out.println("<TR BORDERCOLOR='#92CAEB' BGCOLOR='white'><TD COLSPAN='2'>Member Login</TD></TR>");
        out.println("<TR BORDERCOLOR='#E6F3FB'><TD ALIGN='right'>Username:</TD><TD>");
        out.println("<INPUT NAME='txtusername' TYPE='text' TABINDEX='1' VALUE='" + username + "' SIZE='15' MAXLENGTH='15'></TD>");
        out.println("</TR><TR BORDERCOLOR='#E6F3FB'><TD ALIGN='right'>Password:</TD><TD>");
        out.println("<INPUT NAME='txtpassword' TYPE='password' TABINDEX='2' VALUE='" + password + "' SIZE='15' MAXLENGTH='15'></TD></TR>");
        out.println("<TR BORDERCOLOR='#E6F3FB'><TD COLSPAN='2' ALIGN='right'>");
        out.println("<INPUT NAME='chkrem' TYPE='checkbox' VALUE='REMEMBER' TABINDEX='3'>REMEMBER ME</TD></TR>");
        out.println("<TR BORDERCOLOR='#E0EEF7'><TD COLSPAN='2' ALIGN='right'>");
        out.println("<INPUT NAME='submit' TYPE='submit' VALUE='Sign In' TABINDEX='4'></TD></TR>");
        out.println("</TABLE></TD></TR></TABLE></FORM></BODY></HTML>");

        /* Closing the output stream */
        out.close();
    }
}