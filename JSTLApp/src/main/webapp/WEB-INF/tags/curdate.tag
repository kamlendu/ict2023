<%-- 
    Document   : curdate
    Created on : 09-Aug-2023, 10:50:34 AM
    Author     : root
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
<h2>
    
    <%
        out.println("Current Date : "+ new java.util.Date().toString());
        %>
</h2>