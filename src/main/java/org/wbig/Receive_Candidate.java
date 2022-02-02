package org.wbig;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Receive_Candidate implements JavaDelegate {


    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String text = (String) execution.getVariable("text_postman");

        execution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("Candidate_Info_Received")
                .setVariable("text_postman", text)
                .correlate();

    }
}
