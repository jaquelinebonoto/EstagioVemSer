/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.entity;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jaqueline.bonoto
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO implements Serializable{
    private String nome;
    private Long telefone;     
    private String cep;
    private int numeroCasa;
}
