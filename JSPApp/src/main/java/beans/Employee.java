/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;
import java.util.Hashtable;

/**
 *
 * @author root
 */
public class Employee implements Serializable {
    
    int empno;
    String ename;
    double salary;
    Hashtable errors;

    public Employee() {
        empno=0;
        ename="";
        salary=0.0;
        errors = new Hashtable();
    }

    
    
    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
     public boolean validate()
    {
    boolean allOK=true;
    
     if(empno==0)
    {
        errors.put("empno","Empno can not be zero");
        allOK=false;
        empno=0;
    }
    
    if(ename.equals(""))
    {
        errors.put("ename","Name can not be blank");
        allOK=false;
        ename="";
    }
     if(salary==0.0)
    {
        errors.put("salary","Salary can not be zero");
        allOK=false;
        salary=0.0;
    }
    return allOK;
    }

      public String getError(String s)
    {
        String err = (String) errors.get(s.trim());
          
        return (err==null)?"":err;
    }
    
    
    

    @Override
    public String toString() {
        return "Employee{" + "empno=" + empno + ", ename=" + ename + ", salary=" + salary + '}';
    }
    
    
    
    
}
