package org.wbig;

import connectjar.org.apache.http.HttpEntity;
import connectjar.org.apache.http.HttpResponse;
import connectjar.org.apache.http.client.HttpClient;
import connectjar.org.apache.http.client.methods.HttpPost;
import connectjar.org.apache.http.entity.StringEntity;
import connectjar.org.apache.http.impl.client.HttpClients;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.io.InputStream;
import java.util.logging.Logger;

public class Pay_invoice implements JavaDelegate {
    private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String id = (String) execution.getVariable("job_id");
        String amount = (String) execution.getVariable("amount");
        String percentage = (String) execution.getVariable("percentage");

        Database.createInvoice(Integer.parseInt(amount), Integer.parseInt(id), Integer.parseInt(percentage));


        LOGGER.info("SENDING");

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://141.26.157.254:8080/engine-rest/message");
        //HttpPost httppost = new HttpPost("http://141.26.157.242:8080/engine-rest/message");
// Request parameters and other properties.
        String job_json = "{\r\n" +
                "\"messageName\": \"send_amount\",\r\n" +
                //"\"businessKey\": \""+ execution.getBusinessKey()+"\",\r\n" +
                "\"processVariables\" : {" +
                "\"job_id\": {\"value\": \""+id+"\", \"type\": \"String\"}, \r\n   " +
                "\"amount\": {\"value\": \""+amount+"\", \"type\": \"String\"}, \r\n   " +
                "\"status\": {\"value\": \"paid\", \"type\": \"String\"}, \r\n   " +
                "}" +
                "}";
        LOGGER.info(job_json);

        StringEntity stringEntity = new StringEntity(job_json,"UTF-8");
        httppost.setHeader("Accept", "application/json");
        httppost.setHeader("Content-type", "application/json");
        httppost.setEntity(stringEntity);

//Execute and get the response.
        HttpResponse response = httpclient.execute(httppost);
        LOGGER.info(response.toString());
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                LOGGER.info(instream.toString());
            }
        }





    }
}
