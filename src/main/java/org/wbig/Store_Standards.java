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
        String job_start = execution.getVariable("Job_start_date").toString();
        String job_end = execution.getVariable("Job_End_date").toString();
        long job_salary = (long) execution.getVariable("Job_Salary");
        String job_name = (String) execution.getVariable("Job_Name");


        String job_experience = (String) execution.getVariable("Required_Experience");
        String job_skills = (String) execution.getVariable("Required_skills");
        String job_education = (String) execution.getVariable("Required_Education");
        String job_accreditations = (String) execution.getVariable("Required_accreditations");
        String job_extras = (String) execution.getVariable("Required_Extras");

        String standards = "Description:" + job_description_recruiter + ", Skills: "+ job_skills + ", Education: "+ job_education + ", Accreditations: "+ job_accreditations + ", Extras: "+ job_extras;

        LOGGER.info(standards);
        //Database.createJob(job_name, job_description_recruiter,standards, job_salary, "Main Building NY",job_skills);
        LOGGER.info((Database.getCandidate(1).get(0)));
    }
}
