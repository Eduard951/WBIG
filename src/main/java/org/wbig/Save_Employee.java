package org.wbig;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Save_Employee implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String start = dateFormat.format((Date) execution.getVariable("Start_Date"));
        String end = dateFormat.format((Date) execution.getVariable("End_Date"));
        String fname = (String) execution.getVariable("First_Name");
        String lname = (String) execution.getVariable("Surname");
        String dob = dateFormat.format((Date) execution.getVariable("Dob"));
        String address = (String) execution.getVariable("Employee_Address");
        Long phone = (Long) execution.getVariable("Phone_Number");
        String email = (String) execution.getVariable("E_Mail");
        String job = (String) execution.getVariable("Employee_Job");
        String job_description = (String) execution.getVariable("Employee_Job_Desc");
        String hoursperweek = (String) execution.getVariable("hours_per_week");
        String duties = (String) execution.getVariable("Employee_Duties");

        Database.createEmployee(Database.formatString(fname), Database.formatString(lname),Database.formatString(dob), Database.formatString(address),phone, Database.formatString(email), Database.formatString(job), Database.formatString(job_description), Integer.parseInt(hoursperweek), Database.formatString(duties),Database.formatString(start), Database.formatString(end));

    }
}
