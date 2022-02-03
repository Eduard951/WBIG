package org.wbig;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class Receive_Candidate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        //String text = (String) execution.getVariable("candidate");

        execution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("Candidate_Info_Received")
                //.setVariable("candidate_info", text)
                .correlate();


    }
}
