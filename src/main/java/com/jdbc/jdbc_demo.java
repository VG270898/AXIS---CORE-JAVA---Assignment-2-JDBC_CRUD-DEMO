package com.jdbc;

import java.sql.*;

public class jdbc_demo {
    String url = "jdbc:mysql://localhost:3306/test";
    String user= "root";
    String password = "vishalgupta";

    Connection con = DriverManager.getConnection(url,user,password);

    public jdbc_demo() throws SQLException {
    }

    void insertData(int empId,String empname,String dept,int salary) throws SQLException {
        Statement st = con.createStatement();
        int t = st.executeUpdate("insert into employee values('"+empId+"','"+empname +"','"+dept+"','"+salary+"')");
        if(t>0){
            System.out.println("Data successfully Inserted!");
        }
        else{
            System.out.println("Not Inserted!");
        }
    }

    void updateData(String columnToChange,String data,String selectingColumn,int selectingValue) throws SQLException {
        Statement st = con.createStatement();
        int t2=st.executeUpdate("update employee set "+columnToChange+" = '"+data+"' where "+selectingColumn+" = '"+selectingValue+"'");
        if(t2>0){
            System.out.println("Data Updated successfully!");
        } else{
            System.out.println("Not Updated!");
        }
    }

    void displayDetails() throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from employee");

        while(rs.next()){
            System.out.println(rs.getString("empid") + " : " + rs.getString("empname")+ " : " + rs.getString("dept")+ " : " + rs.getString("salary"));
        }
    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        jdbc_demo obj = new jdbc_demo();

        //inserting data into table "employee"
        //obj.insertData(105,"Kailash Roy","HR",23000);


        //Updating table "employee"

        //obj.updateData("empname","Bajirao","empid",104);


//
//        //Deleting table row from "employee"
//
//        int t3=st.executeUpdate("delete from employee where empid = '"+105+"'");
//        if(t3>0){
//            System.out.println("Data Deleted successfully!");
//        }
//        else{
//            System.out.println("Not Deleted!");
//        }


        //Displaying details of table "employee"

        obj.displayDetails();

    }
}
