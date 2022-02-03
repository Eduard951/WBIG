package org.wbig;

import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database{

    static Connection conn;


    public Database() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");

    }

    public static void createCandidate(String firstName, String lastName, String dob, String address, int phoneNumber, String email, String qualifications, String skills) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO Candidate (FirstName,LastName,DOB,Address,PhoneNumber,email,Qualifications,Skills) VALUES("+firstName+","+lastName+","+dob+","+address+","+phoneNumber+","+email+","+qualifications+","+skills+");");
    }

    public static void createJob(String name, String description, String stardards, double salary, String location, String skills) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO Job (Name,Description,StandardOfEligibility,Salary,Location,Skills) VALUES("+name+","+description+","+stardards+","+salary+","+location+","+skills+");");
    }

    public static void createInvoice(int fee) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO Invoice (Fee) VALUES("+fee+");");
    }

    public static void createEmployee(String firstName, String lastName, String dob, String address, int phoneNumber, String email, String job, String jobDescription,int hours, String duties) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO Employee (FirstName,LastName,DOB,Address,PhoneNumber,email,Job,JobDescription,HoursPerWeek,Duties) VALUES("+firstName+","+lastName+","+dob+","+address+","+phoneNumber+","+email+","+job+","+jobDescription+","+hours+","+duties+");");
    }

    public static void changeCandidateStatus(int candidate_id, boolean eligible) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("UPDATE Candidate SET IsEligible = "+eligible+" WHERE Candidate_ID = "+candidate_id+";");
    }

    public static List<String> getCandidate(int candidate_id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        ArrayList<String> arrayList = new ArrayList<String>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Candidate WHERE Candidate_ID="+candidate_id);
        while (rs.next()) {
            arrayList.add(String.valueOf(rs.getInt("Candidate_ID")));
            arrayList.add(rs.getString("FirstName"));
            arrayList.add(rs.getString("LastName"));
            arrayList.add(rs.getString("DOB"));
            arrayList.add(rs.getString("Address"));
            arrayList.add(String.valueOf(rs.getInt("PhoneNumber")));
            arrayList.add(rs.getString("email"));
            arrayList.add(rs.getString("Qualifications"));
            arrayList.add(rs.getString("Skills"));
        }
        return arrayList;
    }


    public static List<String> getJob ( int job_id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        ArrayList<String> arrayList = new ArrayList<String>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Job WHERE Job_ID = " + job_id);
        while (rs.next()) {
            arrayList.add(String.valueOf(rs.getInt("Job_ID")));
            arrayList.add(rs.getString("Name"));
            arrayList.add(rs.getString("Description"));
            arrayList.add(rs.getString("StandardOfEligibility"));
            arrayList.add(String.valueOf(rs.getDouble("Salary")));
            arrayList.add(rs.getString("Location"));
            arrayList.add(rs.getString("Skills"));
        }
        return arrayList;
    }

    public static List<String> getInvoice ( int invoice_id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        ArrayList<String> arrayList = new ArrayList<String>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Invoice WHERE Invoice_ID = " + invoice_id);
        while (rs.next()) {
            arrayList.add(String.valueOf(rs.getInt("Invoice_ID")));
            arrayList.add(rs.getString("Fee"));
        }
        return arrayList;
    }

    public static List<String> getEmployee ( int employee_id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        ArrayList<String> arrayList = new ArrayList<String>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employee WHERE Employee_ID = " + employee_id);
        while (rs.next()) {
            arrayList.add(String.valueOf(rs.getInt("Employee_ID")));
            arrayList.add(rs.getString("FirstName"));
            arrayList.add(rs.getString("LastName"));
            arrayList.add(rs.getString("DOB"));
            arrayList.add(rs.getString("Address"));
            arrayList.add(String.valueOf(rs.getInt("PhoneNumber")));
            arrayList.add(rs.getString("email"));
            arrayList.add(rs.getString("Job"));
            arrayList.add(rs.getString("JobDescription"));
            arrayList.add(String.valueOf(rs.getInt("HoursPerWeek")));
            arrayList.add(rs.getString("Duties"));
        }
        return arrayList;
    }

    public static String formatString(String text){
        text = "'"+text+"'";
        return text;
    }

    public static void deleteCandidate(int ID) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
    }
}
