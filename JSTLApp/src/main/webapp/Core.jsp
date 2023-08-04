<%-- 
    Document   : Core
    Created on : 03-Aug-2023, 12:05:11 PM
    Author     : root
--%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>    <c:out value="Hello world of JSTL-EL"/>
         <br/>    <c:out value="The sum of 20 and 30 is ${20+30}"/>
         <br/>
         
          <c:set var="num" value="10"/>
         
         
          <c:if var="cond" test="${num > 10}">
             <br/> Num is greater than 10
         </c:if>
             <c:if var="cond" test="${num < 10}">
             <br/> Num is less than 10
         </c:if>
             
             
             <c:choose>
                 <c:when test="${num > 10}">
                     <br/> Num is greater than 10 
                 </c:when>
                  <c:when test="${num < 10}">
                     <br/> Num is less than 10 
                 </c:when> 
                     <c:otherwise>
                      <br/> Num is equal to 10     
                     </c:otherwise>
                 
                 
             </c:choose>    
         
         
         <c:set var="fname" value="${param.fname}"/>
         <c:set var="lname" value="${param.lname}"/>
         
         <br/>
         <c:out value="Full Name : ${fname} ${lname}"/>
         
         <c:forEach var="val" items="${paramValues.y}">
             <br/> ${val}
         </c:forEach>
           <br/>  
          <c:forEach var="h" items="${header}">
             <br/> ${h}
         </c:forEach>   
             
         <br/>
         
        
        
         
         <c:forEach var="x" begin="1" end="10" >
             
        <br/>     The square of ${x} is ${x*x}
         </c:forEach>
         
         
            
            
        </h3>
    </body>
</html>
