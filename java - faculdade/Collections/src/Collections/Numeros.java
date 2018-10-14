package Collections;
import java.util.*;

import javax.swing.JOptionPane;


/*Fa�a um programa que cria uma cole��o do tipo Double e:
1.1 Ordene os n�meros da cole��o criada no item 1 usando a classe Collections
1.2 Modifique a ordem dos elementos da cole��o criada no item 1 usando um m�todo da classe
Collections
1.3 Leia um n�mero e verifique se ele est� na cole��o criada no item 1
Obs.: use para leitura a classe JOptionPane*/

public class Numeros {
	public static void main(String[] args) {
	ArrayList<Double> meusNumeros = new ArrayList<>();	

	meusNumeros.add(5.3);
	meusNumeros.add(5.0);
	meusNumeros.add(5.1);
	meusNumeros.add(5.2);
	meusNumeros.add(5.4);
	
	Collections.sort(meusNumeros);
	
	String variavel = JOptionPane.showInputDialog("Digite o numero double que deseja buscar");
	double num = Double.parseDouble(variavel);
	
	int valor = Collections.binarySearch(meusNumeros, num);
	System.out.println("Seu valor est� na posi��o " + valor);
	
	}
}