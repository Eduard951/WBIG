package org.wbig;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.function.Supplier;
import java.util.logging.Logger;

public class Create_Opening_Information implements JavaDelegate{
    private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String job_description_recruiter = (String) execution.getVariable("Job_Description");
        long job_salary = (long) execution.getVariable("Job_Salary");
        String job_name = (String) execution.getVariable("Job_Name");
        String job_address = (String) execution.getVariable("Job_Address");
        String id = (String) execution.getVariable("Job_ID");

        int actual_id = Integer.parseInt(id);

        Database.updateJob(Database.formatString(job_name), Database.formatString(job_description_recruiter), String.valueOf(Long.parseLong(String.valueOf(job_salary))), Database.formatString(job_address), actual_id);
        LOGGER.info("CREATED OPENING JOB INFORMATION");
        LOGGER.info(Database.getJob(actual_id).toString());
    }
}
