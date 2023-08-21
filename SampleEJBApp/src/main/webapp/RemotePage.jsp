<%-- 
    Document   : RemotePage
    Created on : 21-Aug-2023, 12:32:53 PM
    Author     : root
--%>

<%@page contentType="text/html" import="ejb.*, javax.naming.*, java.util.Properties"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%!  
            MathEJBRemote mbr = null;
            HelloBeanLocal hbl=null;
            InitialContext ic;
            InitialContext   ic1;
            
            public void jspInit()
            {
                try{
            Properties p = new Properties();
             p.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            p.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            
            ic = new InitialContext(p);
            
             ic1 = new InitialContext();
          
          
            mbr = (MathEJBRemote) ic.lookup("ejb/math");
            hbl = (HelloBeanLocal)ic1.lookup("java:global/SampleEJBApp/HelloBean");
            
            }
            catch(NamingException ne)
            {
                ne.printStackTrace();
            }


                }

               public void jspDestroy()
                {
                    mbr=null;
                    hbl=null;
                } 
            
            
            %>
            
            EJB Says : <%=hbl.sayHello("Server")%>
            
            <br/> The sum pf 70 and 40 is <%=mbr.sum(70, 40)%>
                    
                    
            
        </h1>
    </body>
</html>
