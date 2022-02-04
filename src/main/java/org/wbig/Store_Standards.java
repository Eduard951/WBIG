package org.wbig;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.net.URL;
import java.net.HttpURLConnection;

public class Store_Standards implements JavaDelegate{

    private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");


    @Override
    public void execute(DelegateExecution execution) throws Exception {


        String job_description_recruiter = (String) execution.getVariable("Job_Description");
        long job_salary = (long) execution.getVariable("Job_Salary");
        String job_name = (String) execution.getVariable("Job_Name");
        String job_address = (String) execution.getVariable("Job_Address");


        String job_experience = (String) execution.getVariable("Required_Experience");
        String job_skills = (String) execution.getVariable("Required_skills");


        Database.createJob(null,null,Database.formatString(job_skills),null,null, Long.parseLong(job_experience));
        execution.setVariable("Job_ID",Database.getJobID());
    }
}
