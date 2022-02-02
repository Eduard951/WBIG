package org.wbig;

import connectjar.org.apache.http.HttpEntity;
import connectjar.org.apache.http.HttpResponse;
import connectjar.org.apache.http.client.ClientProtocolException;
import connectjar.org.apache.http.client.ResponseHandler;
import connectjar.org.apache.http.client.methods.CloseableHttpResponse;
import connectjar.org.apache.http.client.methods.HttpGet;
import connectjar.org.apache.http.client.methods.HttpPost;
import connectjar.org.apache.http.entity.StringEntity;
import connectjar.org.apache.http.impl.client.CloseableHttpClient;
import connectjar.org.apache.http.impl.client.HttpClients;
import connectjar.org.apache.http.util.EntityUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class Send_Job_Information implements JavaDelegate {
    private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://_othergroupurl_:8080/engine-rest/message");

        post.setHeader("Accept", "application/json");
        post.setHeader("Content-Type","application/json");

        String job_json = "{\r\n" +
        "  \"text\": \"hello world\",\r\n" + "}";
        StringEntity stringEntity = new StringEntity(job_json);
        post.setEntity(stringEntity);
        CloseableHttpResponse response = client.execute(post);
        String response_string = response.toString();

        LOGGER.info("Sending.......................");
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
