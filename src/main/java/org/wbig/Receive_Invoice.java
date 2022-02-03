package org.wbig;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Receive_Invoice implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String invoice_id = (String) execution.getVariable("invoice_id");
        String fee = (String) execution.getVariable("invoice_fee");

        execution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("Receive_Invoice")
                .setVariable("invoice_id", invoice_id)
                .setVariable("invoice_fee", fee)
                .correlate();

    }
}
