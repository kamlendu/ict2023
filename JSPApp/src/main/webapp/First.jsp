<%-- 
    Document   : First
    Created on : 31-Jul-2023, 11:07:59 AM
    Author     : root
--%>
<%@page contentType="text/html" import="java.util.Date, java.io.*, java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include  file="header.jsp" %>
        
        
        <h1>Hello World of JSP!</h1>
        <h1>Today date is <%=new Date().toString()%></h1>
        <br><!-- comment -->
        <%!
            String fullname="";
            Connection con=null;
            Statement stmt =null;
            
           

            %>
        
            
            
        <%   
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            
             fullname= fname + " "+ lname;
            
           
            
        
        %>
        
        
        <h2> Full Name : <%=fullname%> </h2>
        
        <!-- comments
        <jsp:include page="Second.jsp" flush="true">
            <jsp:param name="city" value="Surat"/>
        </jsp:include>
        -->
        
        <jsp:forward page="Second.jsp">
            <jsp:param name="city" value="Surat"/>
        </jsp:forward>
       
        
    </body>
</html>
