/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula7;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author sbert
 */
public class Exercicio1 {
    public static void main(String[] args) {
        //crie uma coleção do tipo Double
         LinkedList<Double> numeros = new LinkedList<>(
                 Arrays.asList(2.0, 5.5, 7.23, 6.89, 8.0));

        //Ordene os números da coleção criada no item 1 usando a classe Collections
        Collections.sort(numeros);
        
        //Modifique a ordem dos elementos da coleção criada no item 1 usando um método da classe Collections
        Collections.shuffle(numeros);

        //Leia um número e verifique se ele está na coleção criada no item 1
        //Obs.: use para leitura a classe JOptionPane
        String variavel = JOptionPane.showInputDialog("Informe um número");
        double num = Double.parseDouble(variavel);
        
        Collections.sort(numeros);
        int indice = Collections.binarySearch(numeros, num);
        if(indice<0)
            System.out.println("Elemento não encontrado");
        else 
            System.out.println("Elemento está no índice: "+ indice);
    }
}

