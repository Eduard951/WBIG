package org.wbig;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Send_Rejection implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        //candidate_status
        /*
        {
"messageName" : "candidate_status",
"processVariables" : {
"candidate_id": { "value":"0"},
"status" : {"value" : "approved", "type" : "String"}
}}
         */

    }
}
