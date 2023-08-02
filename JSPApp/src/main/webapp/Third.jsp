<%-- 
    Document   : Third.jsp
    Created on : 02-Aug-2023, 11:06:20 AM
    Author     : root
--%>
<jsp:useBean id="emp" class="beans.Employee" scope="request">
    <jsp:setProperty name="emp" property="*"/>
</jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%
            if(emp.validate())
            {
            %>
        Empno :    <jsp:getProperty name="emp" property="empno"/>
       <br/> Ename :<jsp:getProperty name="emp" property="ename"/> 
       <br/>Salary :<jsp:getProperty name="emp" property="salary"/>  
       <%
           }
           else
           {
           %>
           <jsp:forward page="EmpForm.jsp"/>
           <%
           }
            %>
        </h1>
    </body>
</html>
