/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package it.jdbcproject;

import java.sql.*;

/**
 *
 * @author root
 */
public class JDBCProject {
    
    Connection con;
    Statement stmt;

    public JDBCProject() {
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false","root", "ompandey");
            System.out.println("Connection Established .. ");
        }
        catch(ClassNotFoundException e )
        {
            System.out.println("Driver class Not found...");
        }
        catch(SQLException sqe)
        {
                   System.out.println("Connection not esatblished...");
    
        }
        
    }
    
    
    

    public static void main(String[] args) throws SQLException {
       
        JDBCProject jp = new JDBCProject();
       // jp.addEmployee(11, "Prakash", 5000);
       jp.removeEmployee(11);
        jp.printEmployees();
    }
    
    
    private void addEmployee(int eno, String ename, double sal) throws SQLException
    {
       stmt = con.createStatement();
       
       String inquery = "insert into employee values("+ eno+",'"+ename+"',"+ sal+")";
       
       stmt.executeUpdate(inquery);
        
    }
    
    private void removeEmployee(int eno) throws SQLException
    {
         stmt = con.createStatement();
       
       String delquery = "delete from employee where empno="+eno;
       
       stmt.executeUpdate(delquery);
        
    }
    
    
    
    
    // Printing all the employees 
    private void printEmployees() throws SQLException
    {
        
        stmt = con.createStatement();
        
        String query= "select * from employee";
        
       ResultSet rs = stmt.executeQuery(query);
       
       ResultSetMetaData rmeta = rs.getMetaData();
       
        for(int i=1; i<=rmeta.getColumnCount(); i++)
           {
                System.out.print(rmeta.getColumnName(i)+"\t");
           }
       System.out.println();
       while(rs.next())
       {
           for(int i=1; i<=rmeta.getColumnCount(); i++)
           {
               System.out.print(rs.getString(i)+"\t");
           }
           System.out.println();
       }
        
        rs.close();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
