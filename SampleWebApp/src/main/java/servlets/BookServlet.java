/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "BookServlet", urlPatterns = {"/BookServlet"})
public class BookServlet extends HttpServlet {
    
    Connection con;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    

    public BookServlet() {
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false","root", "ompandey");
            System.out.println("Connection Established .. ");
        }
        catch(ClassNotFoundException e )
        {
            System.out.println("Driver class Not found...");
        }
        catch(SQLException sqe)
        {
                   System.out.println("Connection not esatblished...");
    
        }

        
        
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookServlet</title>");            
            out.println("</head>");
            out.println("<body>");
           
            String bname = request.getParameter("bname");
            String pname = request.getParameter("pname");
            String aname = request.getParameter("authname");
            String synopsis= request.getParameter("synopsis");
            
            try{
            PreparedStatement stmt = con.prepareCall("insert into BookMaster(BookName,AuthorName, PublisherName, Synopsis) values(?,?,?,?)");
            stmt.setString(1, bname);
            stmt.setString(2, aname);
            stmt.setString(3, pname);
            stmt.setString(4, synopsis);
            
            stmt.executeUpdate();
            
            
            }
            catch(SQLException e)
            {
               e.printStackTrace();
            }
           
            out.println("<br/> Book Name : "+ bname);
            out.println("<br/> Publisher Name : "+ pname);
            out.println("<br/> Author Name Name : "+ aname);
            out.println("<br/> Synopsis : "+ synopsis);
            
            
            out.println("<h1>Servlet BookServlet at " + request.getContextPath() + "</h1>");
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
