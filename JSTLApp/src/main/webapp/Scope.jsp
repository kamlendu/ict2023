<%-- 
    Document   : Scope
    Created on : 07-Aug-2023, 3:09:31 PM
    Author     : root
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setAttribute("username", "Paresh");
            session.setAttribute("username", "logged-in");
            application.setAttribute("username", "Reliance Ltd");
        

        
        %>
        
        <h3>
            Username     : ${requestScope.username}
      <br/> Login status : ${sessionScope.username}
      <br/> Company      : ${applicationScope.username}
        
      <c:forEach   var="strr" items="${applicationScope.strArray}">
          <br/> ${strr}
      </c:forEach>
      
        
        </h3>
    </body>
</html>
