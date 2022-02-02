package org.wbig;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@ProcessApplication("WBIG")
public class WbigApplication extends ServletProcessApplication{

}
