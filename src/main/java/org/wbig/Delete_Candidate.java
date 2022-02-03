package org.wbig;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Delete_Candidate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        int candidate_id = Integer.parseInt((String) execution.getVariable("Candidate_ID"));
        Database.deleteCandidate(candidate_id);
    }
}
