package org.wbig;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.util.logging.Logger;

public class Create_Opening_Information implements JavaDelegate{
    private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        //Database.createJob();
        LOGGER.info("CREATED OPENING JOB INFORMATION");
    }
}
