<%-- 
    Document   : upper
    Created on : 09-Aug-2023, 11:01:11 AM
    Author     : root
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>
<jsp:doBody var="content"/>

<%-- any content can be specified here e.g.: --%>
<h2>
    <%
      String text = jspContext.getAttribute("content").toString();
      
      out.println("Upper Case : "+ text.toUpperCase());
    %>
</h2>