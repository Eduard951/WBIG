package org.wbig;

import connectjar.org.apache.http.HttpEntity;
import connectjar.org.apache.http.HttpResponse;
import connectjar.org.apache.http.NameValuePair;
import connectjar.org.apache.http.client.ClientProtocolException;
import connectjar.org.apache.http.client.HttpClient;
import connectjar.org.apache.http.client.ResponseHandler;
import connectjar.org.apache.http.client.entity.UrlEncodedFormEntity;
import connectjar.org.apache.http.client.methods.CloseableHttpResponse;
import connectjar.org.apache.http.client.methods.HttpGet;
import connectjar.org.apache.http.client.methods.HttpPost;
import connectjar.org.apache.http.entity.StringEntity;
import connectjar.org.apache.http.impl.client.CloseableHttpClient;
import connectjar.org.apache.http.impl.client.HttpClients;
import connectjar.org.apache.http.message.BasicNameValuePair;
import connectjar.org.apache.http.util.EntityUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Send_Job_Information implements JavaDelegate {
    private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");
    @Override
    public void execute(DelegateExecution execution) throws Exception {
LOGGER.info("SENDING");

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://141.26.157.254:8080/engine-rest/message");
        //HttpPost httppost = new HttpPost("http://141.26.157.242:8080/engine-rest/message");
// Request parameters and other properties.
        String job_json = "{\r\n" +
                "\"messageName\": \"Candidate_Info_Received\",\r\n" +
                "\"processVariables\" : {" +
                "\"job_post_id\": {\"value\": \"0\", \"type\": \"String\"}, \r\n   " +
                "\"job_title\": {\"value\": \""+execution.getVariable("Job_Name")+"\", \"type\": \"String\"}, \r\n   " +
                "\"job_description\": {\"value\": \""+execution.getVariable("Job_Description")+"\", \"type\": \"String\"}, \r\n   " +
                "\"salary_in_euros\": {\"value\": \""+execution.getVariable("Job_Salary")+"\", \"type\": \"long\"}, \r\n   " +
                "\"min_job_experience_required_years\": {\"value\": \"5\", \"type\": \"long\"}, \r\n   " +
                "\"skills_required\": {\"value\": \""+execution.getVariable("Required_skills")+"\", \"type\": \"String\"}, \r\n   " +
                "\"office_address\": {\"value\": \""+execution.getVariable("Job_Address")+"\", \"type\": \"String\"}, \r\n   " +
                "\"complete\": {\"value\": \"true\", \"type\": \"String\"} \r\n   " +
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



        /*
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://141.26.157.242:8080/engine-rest/message");

        post.setHeader("Accept", "application/json");
        post.setHeader("Content-Type","application/json");
        String job_json = "{\r\n" +
                "\"messageName\": \"job_details\",\r\n" +
                "\"processVariables\" : {" +
                "\"job_post_id\": {\"value\": \"0\", \"type\": \"String\"}, \r\n   " +
                "\"job_title\": {\"value\": \""+execution.getVariable("Job_Name")+"\", \"type\": \"String\"}, \r\n   " +
                "\"job_description\": {\"value\": \""+execution.getVariable("Job_Description")+"\", \"type\": \"String\"}, \r\n   " +
                "\"salary_in_euros\": {\"value\": \""+execution.getVariable("Job_Salary")+"\", \"type\": \"long\"}, \r\n   " +
                "\"min_job_experience_required_years\": {\"value\": \"5\", \"type\": \"long\"}, \r\n   " +
                "\"skills_required\": {\"value\": \""+execution.getVariable("Required_skills")+"\", \"type\": \"String\"}, \r\n   " +
                "\"office_address\": {\"value\": \""+execution.getVariable("Job_Address")+"\", \"type\": \"String\"}, \r\n   " +
                "\"complete\": {\"value\": \"true\", \"type\": \"String\"} \r\n   " +
                "}" +
                "}";
        StringEntity stringEntity = new StringEntity(job_json);
        post.setEntity(stringEntity);
        CloseableHttpResponse response = client.execute(post);
        String response_string = response.toString();

        LOGGER.info(response_string);
        //client.close();
        /*
        CloseableHttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        String s = EntityUtils.toString(entity);

        execution.setVariable("content", s);
        client.close();
         */
    }
}
