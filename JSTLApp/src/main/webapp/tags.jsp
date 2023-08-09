<%-- 
    Document   : tags
    Created on : 09-Aug-2023, 10:53:46 AM
    Author     : root
--%>
<%@taglib prefix="mytags" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <mytags:curdate/>
        <br/><!-- comment -->
        <mytags:upper>how are you</mytags:upper>
        <br/>
        <mytags:ccase alt="lower"> THIS IS JAVA WORLD </mytags:ccase>
        <br/>
        <mytags:ccase alt="upper"> m.sc.(i.c.t) </mytags:ccase>
        <br/>
        <mytags:ccase alt="dsfsdf"> m.sc.(i.c.t) </mytags:ccase>
        
    </body>
</html>
