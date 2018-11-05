/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.dto;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Windows
 */
@Builder
@Data
public class ConsultaCepDTO {

    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    
}
