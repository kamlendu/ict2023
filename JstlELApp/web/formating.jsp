<%-- 
    Document   : Formating
    Created on : 23 Sep, 2008, 6:56:11 AM
    Author     : root
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
        <%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
        
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <fmt:requestEncoding/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>
         <fmt:setLocale value="en"/>
        <fmt:setBundle   basename="bundle.mybundle.CommonBundle" var="mybundle" />
        <br>
          <fmt:message key="welcome" bundle="${mybundle}"/>
         <br>
        <br>
        
        <fmt:setLocale value="hi_IN"/>
        <br> <fmt:setBundle   basename="bundle.mybundle.CommonBundle" var="hindibundle" />
             <fmt:message key="welcome" bundle="${hindibundle}"/>
            <br>
        <br>
        <fmt:setLocale value="sa_IN"/>
        <br> <fmt:setBundle   basename="bundle.mybundle.CommonBundle" var="sanskritbundle" />
             <fmt:message key="welcome" bundle="${sanskritbundle}"/>
            <br>
                <br>
        <fmt:setLocale value="gu_IN"/>
        <br> <fmt:setBundle   basename="bundle.mybundle.CommonBundle" var="gujaratibundle" />
             <fmt:message key="welcome" bundle="${gujaratibundle}"/>
            <br>
                <br>
        <fmt:setLocale value="pa_IN"/>
        <br> <fmt:setBundle   basename="bundle.mybundle.CommonBundle" var="punjabibundle" />
             <fmt:message key="welcome" bundle="${punjabibundle}"/>
            <br>
            
        </h2>
        
    </body>
</html>
