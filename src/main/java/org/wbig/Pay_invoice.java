package org.wbig;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Pay_invoice implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String id = (String) execution.getVariable("job_id");
        String amount = (String) execution.getVariable("amount");
        String percentage = (String) execution.getVariable("percentage");

        Database.createInvoice(Integer.parseInt(amount), Integer.parseInt(id), Integer.parseInt(percentage));
    }
}
