<%-- 
    Document   : Second
    Created on : 01-Aug-2023, 10:40:09 PM
    Author     : root
--%>
<jsp:useBean id="emp" class="beans.Employee" scope="request"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Second Page !
        <br/>
       <!-- The city is <%= request.getParameter("city") %> -->
       
       <%
           emp.setEmpno(2);
           emp.setEname("Vinay");
           emp.setSalary(7000.0);
           
           %>
       
        <jsp:forward page="Third.jsp"/>
           
        
          </h1>
    </body>
</html>
