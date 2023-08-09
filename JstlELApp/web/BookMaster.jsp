<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<HTML>
	<HEAD>
		<TITLE>Book Information</TITLE>
	</HEAD>

	<BODY>



<c:choose>
<c:when test="${param.txtBookName eq 'MySQL'}">
    <font color="Green"/>
</c:when>
<c:when test="${param.txtBookName eq 'Linux'}">
    <font color="Red"/>
</c:when>
<c:when test="${param.txtBookName eq'PHP'}">
    <font color="Black"/>
</c:when>
<c:when test="${param.txtBookName eq 'Java'}">
    <font color="Blue">
</c:when>
<c:otherwise><Font color="Purple"/>
</c:otherwise>
</c:choose>
 
  <%--  
    <% 
    response.sendRedirect("http://localhost:8080/JstlELApp/");
    
    
    
    %>
    --%>
    
		<H1>This is Book Information</H1>
		<B>Book Name:&nbsp; ${param.txtBookName}<BR>
		Synopsis:&nbsp; ${param.txtSynopsis}<BR>
		Author Name:&nbsp; ${param.txtAuthorName}<BR>
		<I>Publisher Name:&nbsp;${param.txtPublisherName} </I>
                </B>
                    </font>
</BODY>
</HTML> 
