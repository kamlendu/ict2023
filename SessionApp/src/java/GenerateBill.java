//      
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class GenerateBill extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession sessionCart = request.getSession(true);

        /* Setting MIME type for HTTP header */
        response.setContentType("text/html");
        /* Obtaining the output stream */
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Linux Books</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY BGCOLOR='pink'>");

        out.println("<H1 ALIGN='center'>Bill</H1>");
        out.println("<H2 ALIGN='center'>www.bookstore.com</H2>");
        out.println("<H5 ALIGN='right'><B>Date:</B> " + (new Date()) + "</H5><HR><BR>");

        out.println("<TABLE BORDER='0' ALIGN='center' BORDERCOLOR='maroon' WIDTH='90%'>");
        out.println("<TR>");
        out.println("<TD ALIGN='center' BGCOLOR='white' STYLE='Border:2px dashed blue'><FONT COLOR='blue'><B>Book</B></FONT></TD>");
        out.println("<TD ALIGN='center' BGCOLOR='white' STYLE='Border:2px dashed blue'><FONT COLOR='blue'><B>Price</B></FONT></TD>");
        out.println("</TR>");

        String productName = null;
        float totalCost = 0;
        float price = 0;

        Enumeration productNames = sessionCart.getAttributeNames();

        for (int i = 0; productNames.hasMoreElements(); i++) {
            productName = (String) productNames.nextElement();
            price = Float.valueOf(sessionCart.getAttribute(productName).toString());
            out.println("<TR>");
            out.println("<TD ALIGN='left' STYLE='Border:1px dashed #990033'>");
            out.println(productName);
            out.println("</TD>");

            out.println("<TD ALIGN='center' STYLE='Border:1px dashed #990033'>");
            out.println(price);
            out.println("</TD>");
            out.println("</TR>");
            totalCost += price;
        }
        out.println("<TR>");
        out.println("<TD ALIGN='right' STYLE='Border:3px dashed #990033'><B>Total: </B></TD>");
        out.println("<TD ALIGN='center' STYLE='Border:3px dashed #990033'>" + totalCost + "</TD>");
        out.println("</TR>");
        out.println("</TABLE>");
        out.println("</BODY></HTML>");
        out.close();
    }
}