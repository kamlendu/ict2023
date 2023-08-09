<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<link href="newcss.css" rel="stylesheet" >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>if else</title>
    </head>
    <body >
        <h2 align="center">
        <c:out value="if else"/> </h2>
        
        <a href="index.jsp">
            Index
        </a>
        <br>
         <hr class="cssborder" />
        <br> 
        Code:
        <p class="code">
             &lt;c:set var="x"  value="0"/><br>
        &lt;c:out value="The value of x is $ {x}"/>
        <br>
             &lt;c:if  test="${x == '0'}" >

                 &lt;c:out value="Welcome, member!">&lt;/c:out>

            &lt;/c:if>
        <br><br>
          &lt;c:set var="x"  value="1"/><br>
        &lt;c:out value="The value of x is $ {x}"/>
        <br>
              &lt;c:if  test="${x == '0'}" >

                  &lt;c:out value="Welcome, guest!">&lt;/c:out>

            &lt;/c:if>

        </p>
        <br>
         Output:
         <br>
         <c:set var="x"  value="1"/>
        <c:out value="The value of x is ${x}"/>
        <br>
              <c:if  test="${x == '0'}" >
                  
                  <c:out value="Welcome, member!"></c:out>
                              </c:if>
        <c:if  test="${x == '1'}" >

                  <c:out value="Welcome, Guest!"></c:out>
                              </c:if>
       
        <br><br>
        
      

<br>
         <hr class="cssborder" />

          


 </body>
</html>
