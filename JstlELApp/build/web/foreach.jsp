<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<link href="newcss.css" rel="stylesheet" >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>forEach</title>
    </head>
    <body >
        <h2 align="center">
        <c:out value="forEach"/> </h2>
        
        <a href="index.jsp">
            Index
        </a>

        <br>
         <hr class="cssborder" />
        <br> 
        Code:
        <p class="code">
              <br>

           &lt;c:forEach var="i" begin="1" end="10" step="1">
               <br>
            &lt;c:out value= "i : $ {i}"/>
            <br>
            &lt;/c:forEach>
            <br>

        </p>
        <br>
         Output:
         <br>
          <br>
           

            <c:forEach var="j" items="${intArray}">

                     <br/> <c:out value="${j}" />
            </c:forEach>


                       <c:forEach var="str" items="${stringArray}">

                     <br/> <c:out value="${str}" />
            </c:forEach>

                      <c:forEach var="map" items="${stringMap}">

                     <br/> <c:out value="${map}"/>
                      </c:forEach>
        <br>
         <hr class="cssborder" />

          


 </body>
</html>
