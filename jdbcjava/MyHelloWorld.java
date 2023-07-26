import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyHelloWorld extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello It is My World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello It is My World!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
