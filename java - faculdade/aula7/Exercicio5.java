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
public class Exercicio5 {
    public static void main(String[] args) {
        //Usando as classes Aluno e Cpf, da aula anterior, faça os itens abaixo:
        //5.1 Adicionar alunos em um TreeMap, usando os construtores sem
        //e com parâmetros, onde a chave é o Cpf e o valor é um objeto do 
        //tipo Aluno
        TreeMap<Cpf, Aluno> alunos = new TreeMap<>();
        alunos.put(new Cpf(12345, 90), new Aluno());
        alunos.put(new Cpf(11223, 90), new Aluno("Marcus", "33445566", "Rua Q", 
                12345, new Cpf(11223, 90)));
        
        Aluno jose = new Aluno("Jose", "33445566", "Rua P", 
                12346, new Cpf(11223, 90));
        alunos.put(jose.getCpf(), jose);
        
        //5.2 Ordenar o mapa usando o Cpf
        // incluir o comparable e o método comparaTo na classe Aluno e na Cpf
        
        //5.3 Imprimir o mapa ordenado usando chave - valor
        Set<Cpf> chaves = alunos.keySet();
        for (Cpf chave : chaves) {
            System.out.println("Chave = " + chave +
                                "Valor = " + alunos.get(chave));
        }
    }
}
