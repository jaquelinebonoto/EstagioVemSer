/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.service;

import br.com.dbc.locadora.config.SoapConnector;
import br.com.dbc.locadora.entity.ConsultaCepDTO;
import br.com.dbc.locadora.ws.ConsultaCEP;
import br.com.dbc.locadora.ws.ConsultaCEPResponse;
import br.com.dbc.locadora.ws.ObjectFactory;
import javax.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Windows
 */
@Service
public class CorreioService {
        @Autowired
    private SoapConnector soapConnector;
    
    @Autowired 
    private ObjectFactory objectFactory;
    
   
    
    public ConsultaCepDTO buscarCEP(String cep){
        
        ConsultaCEP consulta = objectFactory.createConsultaCEP();
        
        consulta.setCep(cep);
        
        ConsultaCEPResponse resposta = ((JAXBElement<ConsultaCEPResponse>) soapConnector
                .callWebService(objectFactory.createConsultaCEP(consulta))).getValue();
        
        return ConsultaCepDTO.builder().rua(resposta.getReturn().getEnd())
                        .bairro(resposta.getReturn().getBairro())
                        .cidade(resposta.getReturn().getCidade())
                        .estado(resposta.getReturn().getUf())
                .build();
    }
}