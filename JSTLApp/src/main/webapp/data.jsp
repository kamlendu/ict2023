<%-- 
    Document   : data
    Created on : 24-Jan-2023, 1:45:39 PM
    Author     : root
--%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>
            <sql:setDataSource dataSource="jdbc/ictdata"/>    
            
           
            <sql:update var="insert"> 
                        insert into employee values (?,?,?)
                        <sql:param value="140"/>
                        <sql:param value="Abhay"/>
                        <sql:param value="8000"/>                 
                      </sql:update>
            
                     
            
            <sql:query var="query">
                select * from employee
            </sql:query>
                
                <c:forEach var="row" items="${query.rowsByIndex}">
            <br/>        ${row[0]} &nbsp;&nbsp;&nbsp; ${row[1]} &nbsp;&nbsp;&nbsp; ${row[2]}
                </c:forEach>
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        </h3>
    </body>
</html>
