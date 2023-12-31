/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
@WebServlet(name = "HelloServlet", initParams = 
        {
            @WebInitParam(name="host", value="www.google.co.in"),
            @WebInitParam(name="port", value="3186")
        },
        urlPatterns = {"/HelloServlet"})
public class HelloServlet extends HttpServlet {

    
    
    
    @Override
    public void init()
            throws ServletException {
       
        super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
   
    System.out.println(" I am in the init method..");
    
    
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void destroy() {
        super.destroy(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
   
    System.out.println(" I am in the destroy method..");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3> Hello World of Servlets !!! </h3>");
            
            HttpSession session = request.getSession();
            
                out.println("<h1>Application - company : " + this.getServletContext().getAttribute("company")+ "</h1>");
         
            out.println("<h1>Session - Username : " + session.getAttribute("username") + "</h1>");
          
            
//            String firstName = request.getParameter("fname");
//            String lastName = request.getParameter("lname");
//         
//            out.println("<h3> Full Name :"+ firstName + " "+ lastName+ "</h3>");
//            
          //  String pname[] = request.getParameterValues("pname");
            
          //  out.println("<h3> Full Name :"+ pname[0] + " "+ pname[1]+ "</h3>");
       
          
          out.println(request.getMethod());
          out.println(request.getQueryString());
           out.println("<br/>"+request.getLocalPort());
           
           out.println("<br/>"+ this.getInitParameter("host"));
            out.println("<br/>"+ this.getInitParameter("port"));
           
          
           
           //response.sendRedirect("http://localhost:8080/SampleWebApp/Another");
          
          
          
            
//             Enumeration<String> hnames = request.getHeaderNames();
//        
//        while(hnames.hasMoreElements())
//        {
//            String hname = hnames.nextElement();
//            
//            out.println("<h3>" + hname + " :"+ request.getHeader(hname)+"</h3>");
//        }
//        
         
            out.println("</body>");
            out.println("</html>");
        }
        
       
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(" I am in the doGet method..");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println(" I am in the doPost method..");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
