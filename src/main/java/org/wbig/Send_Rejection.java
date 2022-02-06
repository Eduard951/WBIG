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

public class Send_Rejection implements JavaDelegate {


        private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");
        @Override
        public void execute(DelegateExecution execution) throws Exception {
            LOGGER.info("SENDING");

            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost("http://141.26.157.254:8080/engine-rest/message");
            //HttpPost httppost = new HttpPost("http://141.26.157.242:8080/engine-rest/message");
// Request parameters and other properties.
            String job_json = "{\r\n" +
                    "\"messageName\": \"candidate_status\",\r\n" +
                    //"\"businessKey\": \""+ execution.getBusinessKey()+"\",\r\n" +
                    "\"processVariables\" : {" +
                    "\"candidate_id\": {\"value\": \""+execution.getVariable("candidate_id")+"\", \"type\": \"String\"}, \r\n   " +
                    "\"status\": {\"value\": \"rejected\", \"type\": \"String\"}, \r\n   " +
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
