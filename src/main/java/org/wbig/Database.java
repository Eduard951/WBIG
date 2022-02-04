package org.wbig;

import org.apache.ibatis.jdbc.SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database{

    static Connection conn;


    public Database() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");

    }

    public static void createCandidate(int id, String firstName, String lastName, String dob, String address, int phoneNumber, String email, String qualifications, String skills, String extras) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO Candidate (Candidate_ID,FirstName,LastName,DOB,Address,PhoneNumber,email,Qualifications,Skills,Extras) VALUES("+id+","+firstName+","+lastName+","+dob+","+address+","+phoneNumber+","+email+","+qualifications+","+skills+","+extras+");");
    }

    public static void createJob(String name, String description, String skills, Double salary, String location, long experience) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO Job (Name,Description,Skills,Salary,Location,Experience) VALUES("+name+","+description+","+skills+","+salary+","+location+","+experience+");");
    }

    public static void createInvoice(int fee, int jobid, int percentage) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO Invoice (Fee,Job_ID,percentage) VALUES("+fee+","+jobid+","+percentage+");");
    }

    public static void createEmployee(String firstName, String lastName, String dob, String address, long phoneNumber, String email, String job, String jobDescription,int hours, String duties,String start, String end) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO Employee (FirstName,LastName,DOB,Address,PhoneNumber,email,Job,JobDescription,HoursPerWeek,Duties,Start_Date,End_Date) VALUES("+firstName+","+lastName+","+dob+","+address+","+phoneNumber+","+email+","+job+","+jobDescription+","+hours+","+duties+","+start+","+end+");");

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
            arrayList.add(rs.getString("Skills"));
            arrayList.add(String.valueOf(rs.getDouble("Salary")));
            arrayList.add(rs.getString("Location"));
            arrayList.add(String.valueOf(rs.getInt("Experience")));
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
        stmt.executeUpdate("DELETE FROM Candidate WHERE(Candidate_ID = '"+ID+"');");
    }

    public static void updateJob(String name, String description, String salary, String location, int id)throws SQLException, ClassNotFoundException {
        //UPDATE `wbig`.`Job` SET `Name` = 'Job name', `Description` = 'job desc', `Salary` = '5000', `Location` = 'main' WHERE (`Job_ID` = '4');
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("UPDATE Job SET Name = "+name+" ,Description = "+description+" ,Salary = +"+Integer.parseInt(salary)+" ,Location = +"+location+" WHERE (Job_ID = "+id+");");
    }

    public static String getJobID() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        String id = "";
        ResultSet rs = stmt.executeQuery("SELECT Job_ID FROM Job WHERE Job_ID=(SELECT MAX(Job_ID) FROM Job)");
        while (rs.next()) {
            id = String.valueOf(rs.getInt("Job_ID"));
        }
        return id;
    }

    public static String getCandidateID() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        String id = "";
        ResultSet rs = stmt.executeQuery("SELECT Candidate_ID FROM Candidate WHERE Candidate_ID=(SELECT MAX(Candidate_ID) FROM Candidate)");
        while (rs.next()) {
            id = String.valueOf(rs.getInt("Job_ID"));
        }
        return id;
    }

    public static void approveCandidate(int id)throws SQLException, ClassNotFoundException {
        //UPDATE `wbig`.`Job` SET `Name` = 'Job name', `Description` = 'job desc', `Salary` = '5000', `Location` = 'main' WHERE (`Job_ID` = '4');
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("UPDATE Candidate SET IsEligible = 1 WHERE(Candidate_ID = "+id+");");
        //stmt.executeUpdate("UPDATE Job SET Name = "+name+" ,Description = "+description+" ,Salary = +"+Integer.parseInt(salary)+" ,Location = +"+location+" WHERE (Job_ID = "+id+");");
    }

    public static void rejectCandidate(int id)throws SQLException, ClassNotFoundException {
        //UPDATE `wbig`.`Job` SET `Name` = 'Job name', `Description` = 'job desc', `Salary` = '5000', `Location` = 'main' WHERE (`Job_ID` = '4');
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("UPDATE Candidate SET IsEligible = 0 WHERE(Candidate_ID = "+id+");");
    }

    public static void approveManagerCandidate(int id)throws SQLException, ClassNotFoundException {
        //UPDATE `wbig`.`Job` SET `Name` = 'Job name', `Description` = 'job desc', `Salary` = '5000', `Location` = 'main' WHERE (`Job_ID` = '4');
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("UPDATE Candidate SET ManagerDecision = 1 WHERE(Candidate_ID = "+id+");");
    }

    public static void rejectManagerCandidate(int id)throws SQLException, ClassNotFoundException {
        //UPDATE `wbig`.`Job` SET `Name` = 'Job name', `Description` = 'job desc', `Salary` = '5000', `Location` = 'main' WHERE (`Job_ID` = '4');
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://141.26.157.254:3306/wbig", "WBIG", "wbig");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("UPDATE Candidate SET ManagerDecision = 0 WHERE(Candidate_ID = "+id+");");
    }
}
