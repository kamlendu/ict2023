<%-- 
    Document   : formating
    Created on : 08-Aug-2023, 1:31:19 PM
    Author     : root
--%>

<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>
        <%
            request.setAttribute("curdate", new java.util.Date());
            
            %>
            
            <fmt:setLocale value="en_US"/>
            <fmt:setBundle var="mybundle" basename="myvalues"/>
            <fmt:message key="welcome" bundle="${mybundle}"/>
            <br/>
            <fmt:setLocale value="hi_IN"/>
            <fmt:setBundle var="mybundle" basename="myvalues"/>
            <fmt:message key="welcome" bundle="${mybundle}"/>
            
            <br/><!-- comment -->
            <hr/>
            
            
            <c:set var="num" value="34512.76543"/>
            <c:set var="now" value="${curdate}"/>
            
            <br/> <fmt:formatDate type="date" value="${now}"/>
            <br/> <fmt:formatDate type="both" value="${now}"/>
            <br/> <fmt:formatDate type="time" value="${now}"/>
            <br/> <fmt:formatDate pattern="dd-MMM-yyyy" type="both" value="${now}"/>
            
            <br/><br/>
            
           <br/> <fmt:formatNumber maxFractionDigits="2" value="${num}"/>
           <br/> <fmt:formatNumber maxIntegerDigits="2" value="${num}"/>
           <br/> <fmt:formatNumber type="currency" currencySymbol="$" value="${num}"/>
            
            
            
        </h3>
        
            
        <h3>
            
            
            
            
            
        </h3>
    </body>
</html>
