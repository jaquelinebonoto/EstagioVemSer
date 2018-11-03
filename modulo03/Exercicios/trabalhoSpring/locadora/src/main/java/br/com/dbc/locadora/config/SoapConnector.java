
package br.com.dbc.locadora.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 *
 * @author tiago
 */
@Configuration
public class SoapConnector extends WebServiceGatewaySupport {
 
    public Object callWebService(String url, Object request){
        return getWebServiceTemplate().marshalSendAndReceive(url, request);
    }
}
