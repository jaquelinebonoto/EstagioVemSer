/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula7;

import java.util.*;

/**
 *
 * @author sbert
 */
public class Exercicio3 {

    public static void main(String[] args) {

        //Usando a classe Pessoa da aula anterior faça os itens abaixo:
        //3.1 Adicionar 4 pessoas em uma lista, usar os construtores sem e com parâmetros
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Leonardo", "3344", "Rua Z"));
        pessoas.add(new Pessoa("Amora", "3355", "Rua w"));
        //3.2 Imprimir o primeiro e o último objetos
        System.out.println(pessoas.get(0));
        System.out.println(pessoas.get(pessoas.size()-1));
        
        //3.3 Ordenar a lista usando o nome
        Collections.sort(pessoas);
        
        //3.4 Imprimir a lista ordenada
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.toString());
        }
                

    }
}
