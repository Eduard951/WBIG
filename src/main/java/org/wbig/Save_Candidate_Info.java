package org.wbig;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class Save_Candidate_Info implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        int candidate_id = Integer.parseInt((String) execution.getVariable("candidate_id"));
        String fname = (String) execution.getVariable("first_name");
        String lname = (String) execution.getVariable("last_name");
        String dob = (String) execution.getVariable("candidate_dob");
        int phone = Integer.parseInt((String) execution.getVariable("phone_number"));
        String email = (String) execution.getVariable("email");
        String address = (String) execution.getVariable("address");
        String skills = (String) execution.getVariable("skills");
        String qual = (String) execution.getVariable("qualifications");
        String extras = (String) execution.getVariable("extras");

        Database.createCandidate(candidate_id,Database.formatString(fname),Database.formatString(lname), Database.formatString(dob),Database.formatString(address),phone, Database.formatString(address), Database.formatString(skills), Database.formatString(qual), Database.formatString(extras));
        execution.setVariable("Candidate_ID",candidate_id);
    }
}
