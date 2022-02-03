package org.wbig;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class Save_Candidate_Info implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        //Database.createCandidate();
        LOGGER.info("receiving.......................");
        LOGGER.info((String) execution.getVariable("candidate_info"));
    }
}
