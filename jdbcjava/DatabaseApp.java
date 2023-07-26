import java.sql.*;


class DatabaseApp 
{

	public static void main(String[] args) 
	{
	try
		{	
	Connection con;	

// Loading the Driver Class
Class.forName("com.mysql.jdbc.Driver"); 
	
//Establishing Connection with the database			
con= DriverManager.getConnection("jdbc:mysql://localhost/test?useSSL=false","root","ompandey");


//Class.forName("oracle.jdbc.OracleDriver"); //pure oracle java driver
//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //odbc driver
		
//Connection con= DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost:1521:XE");            		
//Connection con = DriverManager.getConnection(" jdbc:odbc:testdsn " , "root"  , "") ;		

Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

		
	String query = "Select * from employees";
	ResultSet rs = st.executeQuery(query);
		
		ResultSetMetaData rmeta=rs.getMetaData();


		if(args[0].equals("S"))
		{

		for (int i=1;i<=rmeta.getColumnCount();i++ )
		System.out.print(rmeta.getColumnName(i)+"\t");

		System.out.println();

		while (rs.next())
		{
	
			for (int i=1;i<4;i++ )
			{
				System.out.print(rs.getString(i)+"\t");
			}
		System.out.println();
		}
		rs.close();
		}
		else if(args[0].equals("I"))
		{
		 Statement insert = con.createStatement();
		String inquery="insert into employee  values ("+args[1]+",'"+args[2]+"',"+ args[3]+")";
		insert.executeUpdate(inquery); 

		}
		else if(args[0].equals("D"))
		{
		Statement delete = con.createStatement();
      String delquery = "delete from employee where ename = '" + args[1]+"'";
		delete.executeUpdate(delquery); 


		}
	
		}
		catch(ClassNotFoundException ex)
		{
		 System.out.println("Driver not found "+ ex.toString());
		}
		catch (SQLException e)
		{
                  System.out.println(e.toString());e.printStackTrace();
		}
		
	}
}
