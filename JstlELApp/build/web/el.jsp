<%-- 
    Document   : index
    Created on : 25 Aug, 2010, 12:22:42 AM
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
    <%!
    int i;
    String y = "Hello";
    %>
    <body>
        <h1>The addition of 40 and 30 is ${40+30} </h1>
        
	<h1>The session id is ${pageContext.session.id} </h1>

        <h1>The Browser is ${param.x} </h1>

        <%
            session.setAttribute("name1", "Kamal1");
            request.setAttribute("name1", "Kamal2");
            application.setAttribute("name1", "Kamal3");
            pageContext.setAttribute("name1", "hello");

        %>

        <h1>The Session Name is ${sessionScope.name1} </h1>
        <h1>The Request Name is ${requestScope.name1} </h1>
        <h1>The Application Name is ${applicationScope.name1} </h1>
        <h1>The Browser is ${header["User-Agent"]} </h1>
        <h1>The page name is ${pageScope.name1} </h1>
        <h1>The header is ${pageContext.request.protocol} </h1>

        <%
        for( i=0;i<10;i++) { 
        pageContext.setAttribute("hi", new Integer(i));
            %>
       
        <h2> ${hi} </h2> 
        <% } %>

    </body>
</html>
