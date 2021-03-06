package org.wbig;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class DenyCandidates implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        int id = Integer.parseInt((String) execution.getVariable("candidate_id"));
        Database.rejectCandidate(id);
    }
}
