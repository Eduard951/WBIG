package org.wbig;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Delete_Candidate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String candidate_id = (String) execution.getVariable("candidate_id");
        Database.deleteCandidate(Integer.parseInt(candidate_id));
    }
}
