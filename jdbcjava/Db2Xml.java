import java.sql.Connection;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.*;
class Db2Xml  {

   Connection con;
  // final static String dbname= DATABASE_NAME;

  public static void main (String args[]) throws IOException {
	
      String xml= new Db2Xml().getXmlFromDB(args[0]);
	System.out.println(xml);
 FileOutputStream fs = new java.io.FileOutputStream(new java.io.File("/root/xmlfile.xml"));
        BufferedOutputStream bf = new BufferedOutputStream(fs);
        DataOutputStream ds= new DataOutputStream(fs);
        ds.writeUTF(xml);

	return;	
	}

 String getXmlFromDB(String tableName)  
	{
	
	//Document doc=null;
	 ResultSet rs = null;
    Statement stmt = null;
    String sql;
    // String tableName = args[0];
    try {
      DocumentBuilderFactory factory = 
         DocumentBuilderFactory.newInstance();
      DocumentBuilder builder =factory.newDocumentBuilder();
      Document doc = builder.newDocument();

      Element results = doc.createElement(tableName);
      doc.appendChild(results);

      // connection to an ACCESS MDB
      con = AccessCon.getConnection();
      sql =  "select * from "+ tableName;
      stmt = con.createStatement();
      rs = stmt.executeQuery(sql);

      ResultSetMetaData rsmd = rs.getMetaData();
      int colCount = rsmd.getColumnCount();

      while (rs.next()) {
        Element row = doc.createElement("Row");
        results.appendChild(row);
        for (int ii = 1; ii <= colCount; ii++) {
           String columnName = rsmd.getColumnName(ii);
           Object value = rs.getObject(ii);
           Element node = doc.createElement(columnName);
           node.appendChild(doc.createTextNode(value.toString()));
           row.appendChild(node);
        }
      }

      return getDocumentAsXml(doc); 
	
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    finally {
      try {
        if (con != null) con.close();
        if (stmt != null) stmt.close();
        if (rs != null) rs.close();
      }
      catch (Exception e) {
      }
   
	}
return null; 
}

 public static String getDocumentAsXml(Document doc)
      throws TransformerConfigurationException, TransformerException {
    DOMSource domSource = new DOMSource(doc);
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    //transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,"yes");
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.ENCODING,"ISO-8859-1");
    // we want to pretty format the XML output
    // note : this is broken in jdk1.5 beta!
    transformer.setOutputProperty
       ("{http://xml.apache.org/xslt}indent-amount", "4");
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    //
    java.io.StringWriter sw = new java.io.StringWriter();
    StreamResult sr = new StreamResult(sw);
    transformer.transform(domSource, sr);
    return sw.toString();
 }
}

class AccessCon {
  public static Connection getConnection() throws Exception {
   Class.forName("com.mysql.jdbc.Driver").newInstance();
  /* Connection c = DriverManager.getConnection
  ("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=c:/tech97.mdb");
   return c;*/
   
   //To use an already defined ODBC Datasource :

     String URL = "jdbc:mysql://localhost/test";
     Connection c = DriverManager.getConnection(URL, "root", "ompandey");
   return c;
   
  }
}

