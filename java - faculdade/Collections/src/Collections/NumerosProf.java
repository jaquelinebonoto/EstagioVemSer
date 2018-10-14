package Collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JOptionPane;


public class NumerosProf {
	public static void main(String[] args) {
	LinkedList<Double> numeros = new LinkedList<>(Arrays.asList(2.0, 5.5, 8.0, 7.23, 6.1));
	
	Collections.sort(numeros);
	Collections.shuffle(numeros);
	
	String variavel = JOptionPane.showInputDialog("Informe um número");
	double num = Double.parseDouble(variavel);
	Collections.sort(numeros);
	int indice = Collections.binarySearch(numeros, num);
	if (indice<0) System.out.println("Elementro não encontrado");
	else System.out.println("Elemento está no índice: " +indice);	
	}
}
