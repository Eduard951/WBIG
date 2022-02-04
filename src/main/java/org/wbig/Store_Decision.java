package org.wbig;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class Store_Decision implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");
    @Override
    public void execute(DelegateExecution execution) throws Exception {
    boolean decision = (boolean) execution.getVariable("Candidate_Approval1");
    String id = (String) execution.getVariable("candidate_id");



    if(decision == true){
        Database.approveManagerCandidate(Integer.parseInt(id));
    }else{
        Database.rejectManagerCandidate(Integer.parseInt(id));
    }

    }
}
