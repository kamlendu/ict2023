<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<link href="newcss.css" rel="stylesheet" >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>choose - switch</title>
    </head>
    <body >
        <h2 align="center">
        <c:out value="choose - switch"/> </h2>
        
        <a href="index.jsp">
            Index
        </a>
        <br>
         <hr class="cssborder" />
        <br> 
        Code:
        <p class="code">
              <br>

          &lt;c:set var="x"  value="1"/>
          <br>
        &lt;c:out value="The value of x is ${x}"/>
        <br><br>
              &lt;c:choose>
              <br>
              &lt;c:when test="${x == 0}" >
              <br>
                &lt;c:out value="0 is selected."/>
                <br>
              &lt;/c:when>
              <br>
              &lt;c:when test="${x == 1}" >
              <br>
                &lt;c:out value="1 is selected."/>
                <br>
              &lt;/c:when>
              <br>
                &lt;c:when test="${x == 2}" >
                <br>
                &lt;c:out value="2 is selected."/>
                <br>
              &lt;c:when>
              <br>
              &lt;c:otherwise>
              <br>
                &lt;c:out value="x is unknown."/>
                <br>
              &lt;/c:otherwise>
              <br>
            &lt;/c:choose>
            <br>



        </p>
        <br>
         Output:
         <br>
          
          <c:set var="x"  value="1"/>
        <c:out value="The value of x is ${x}"/>
        <br><br>
              <c:choose>
              <c:when test="${x == 0}" >
                <c:out value="0 is selected."/>
              </c:when>
              <c:when test="${x == 1}" >
                <c:out value="1 is selected."/>
              </c:when>
                <c:when test="${x == 2}" >
                <c:out value="2 is selected."/>
              </c:when>
              <c:otherwise>
                <c:out value="x is unknown."/>
              </c:otherwise>
            </c:choose>


<br>
         <hr class="cssborder" />

          


 </body>
</html>
