
package br.com.dbc.locadora.config;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 *
 * @author tiago
 */

public class SoapConnector extends WebServiceGatewaySupport {
 
    public Object callWebService(Object request){
        return getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
