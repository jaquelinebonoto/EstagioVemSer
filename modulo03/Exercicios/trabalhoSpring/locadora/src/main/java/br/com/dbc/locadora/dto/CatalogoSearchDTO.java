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
 * @author jaqueline.bonoto
 */
@Data
@Builder
public class CatalogoSearchDTO {
    private String titulo;
}
