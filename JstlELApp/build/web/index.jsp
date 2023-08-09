<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 19 Sep, 2008, 10:17:51 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h2>
        <c:out value="Hello World of JSTL and EL"/> </h2>

        <p> The addition of 3 and 4 is ${3+4} </p>
        
        <c:out value= "The value 9 minus 2 is ${9-2}"/>

        <table border="1">

            <c:forEach var="i" begin="1" end="10" step="1">

                <tr><td> The square of ${i} is ${i*i} </td>

                    <td><c:out value= "The cube of ${i} is ${i*i*i}"/>
        </c:forEach>
</table>
        

        <c:set var="x" value="${8*5}"/>
<c:out value="The value of x is ${x}"/>

 </body>
</html>
