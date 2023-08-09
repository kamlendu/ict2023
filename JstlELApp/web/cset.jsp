<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<link href="newcss.css" rel="stylesheet" >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>c:set</title>
    </head>
    <body >
        <h2 align="center">
        <c:out value="c:set"/> </h2>
        
        <a href="index.jsp">
            Index
        </a>
        <br>
         <hr class="cssborder" />
        <br> 
        Code:
        <p class="code">
            <c:out value='
            <c:set var="x" value="$ {8*5}"/>'  >            </c:out>
            <br>
            <c:out value='
            <c:out value="The value of x is $ {x}"/>'  >            </c:out>

        </p>
         Output:
         <p >
            <c:set var="x" value="${8*5}"/>
            <c:out value="The value of x is ${x}"/>
         </p>

         <hr class="cssborder" />

          


 </body>
</html>
