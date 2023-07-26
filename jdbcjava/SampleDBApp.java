// import the package
import java.sql.*;

class SampleDBApp
{



public static void main(String args[])
{
Connection con;
Statement stmt;
ResultSet rs;

try{
 
// Loading the driver
Class.forName("com.mysql.jdbc.Driver");

// Establishing a Database Connection

con = DriverManager.getConnection( "jdbc:mysql://localhost/test","root","ompandey");

stmt = con.createStatement();

String query = "select * from employee";

rs = stmt.executeQuery(query);

while(rs.next())
{

System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+ rs.getString(3)+"\n");

}

}
catch(ClassNotFoundException cnfe)
{

System.out.println(cnfe.toString());
}
catch(SQLException sqle)
{

System.out.println(sqle.toString());
}




}

} //class ends
