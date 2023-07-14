/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.jdbcproject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author root
 */
public class OptimizedDB {
    
     Connection con;
    PreparedStatement stmt;

    public OptimizedDB() {
        
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
       
        OptimizedDB jp = new OptimizedDB();
       // jp.addEmployee(12, "Prakash", 5000);
      // jp.removeEmployee(12);
        jp.printEmployees();
        jp.printStats();
        
    }
    
    
    private void addEmployee(int eno, String ename, double sal) throws SQLException
    {
    
       
       String inquery = "insert into employee values(?,?,?)";
       
        PreparedStatement  stmt = con.prepareCall(inquery);
        
        stmt.setInt(1, eno);
        stmt.setString(2, ename);
        stmt.setDouble(3, sal);
       
       stmt.executeUpdate();
        
    }
    
    private void removeEmployee(int eno) throws SQLException
    {
        
       
       String delquery = "delete from employee where empno=?";
       
        PreparedStatement pstmt = con.prepareCall(delquery);
        
        pstmt.setInt(1, eno);
       
       pstmt.executeUpdate();
        
    }
    
    
    
    
    // Printing all the employees 
    private void printEmployees() throws SQLException
    {
        
    Statement        stmt = con.createStatement();
        
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
    
    
    private void printStats() throws SQLException
    {
        CallableStatement cstmt = con.prepareCall("{call gross_sal(?)}");
        
        cstmt.registerOutParameter(1, java.sql.Types.DOUBLE);
        
        cstmt.executeQuery();
        
        System.out.println("Sum of Gross  Sal = "+ cstmt.getDouble(1));
       
        CallableStatement cstmt1 = con.prepareCall("{?= call maxsal1()}");
        
        cstmt1.registerOutParameter(1, java.sql.Types.DOUBLE);
        cstmt1.execute();
        
         System.out.println("Max  Sal = "+ cstmt1.getDouble(1));
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
}
