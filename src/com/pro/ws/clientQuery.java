package com.pro.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

public class clientQuery {
    private static String WS_URL = "http://ip:port/ws/QueryPort?wsdl";

    public static String getClient(String canshu) {
        URL url = null;
        try {
            url = new URL(WS_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        QName qname = new QName("http://service.ws.com/", "QueryDelegateService");
        Service service = Service.create(url, qname);
        QueryDelegate queryDelegate = service.getPort(QueryDelegate.class);
        Map<String, Object> req_ctx = ((BindingProvider) queryDelegate).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("POLICE"));
        headers.put("Password", Collections.singletonList("POLICE"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        String result = queryDelegate.query(canshu);
        return result;
    }

    public static void main(String[] args) throws Exception {
        String result = clientQuery.getClient("{\"serviceName\":\"TRAINING_RECORD\",\"page\":\"1\"}");
        // String result =
        // clientQuery.getClient("{\"serviceName\":\"TRAINING_RECORD_SEARCH\",\"SFZMHM\":\"341226198806163758\",\"SFZMLX\":\"1\",\"page\":\"1\"}");

        System.out.println(result);
    }

    @WebService(targetNamespace = "http://service.ws.com/", serviceName = "QueryDelegateService")
    public static interface QueryDelegate {
        public String query(String parameters);
    }

}
