<%-- 
    Document   : ccase
    Created on : 09-Aug-2023, 11:07:14 AM
    Author     : root
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="alt"%>
<jsp:doBody var="content"/>

<%-- any content can be specified here e.g.: --%>
<h2>
    <%
    String text = jspContext.getAttribute("content").toString();
    String attr = jspContext.getAttribute("alt").toString();
    
    if(attr.equalsIgnoreCase("upper"))
     out.println("Upper Case : "+ text.toUpperCase());
     else if(attr.equalsIgnoreCase("lower"))
      out.println("Lower Case : "+ text.toLowerCase());
     else
      out.println("Attribute value is incorrect !");
    
    

   %> 
</h2>