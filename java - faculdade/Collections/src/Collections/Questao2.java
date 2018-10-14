package Collections;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

//2) Determine o resultado de cada operação realizada sobre a lista original:

public class Questao2 {
		 public static void main(String[] args) {
		 List<Integer> lst = new ArrayList<Integer>(Arrays.asList(3, 5, 4, 2, 3, 2, 1, 3));
		 //1
		 Collections.sort(lst);
		 System.out.println("1: Coloca em Ordem ascendente " +lst);
		 //2
		 Collections.shuffle(lst);
		 System.out.println("2: Embaralha a lista com valor default de aleatoriedade " +lst);
		 //3
		 Collections.shuffle(lst, new Random(2));
		 System.out.println("3: Embaralha a lista podendo definir uma probabilidade de aleatoriedade" +lst);
		 //4
		 Collections.sort(lst);
		 System.out.println("4: Coloca em ordem crescente " +lst);
		 Collections.reverse(lst);
		 System.out.println("4: Inverte anterior " +lst);
		 //5
		 int sz = lst.size();
		 for (int i = 0; i < sz / 2; i++) {
		 Collections.swap(lst, i, sz - 1 - i);
		 }
		 System.out.println("5: Lista invertida com o método swap " +lst);
		 //6
		 Collections.addAll(lst, -1, -2, -3);
		 System.out.println("5: Adicionado mais 3 valores à lista " +lst);
		 //7
		 Collections.sort(lst);
		 int in = Collections.binarySearch(lst, 4);
		 System.out.println("Posição do valor 4 na lista: " + in);
		 in = Collections.binarySearch(lst, 2);
		 System.out.println(in);
		 in = Collections.binarySearch(lst, 3);
		 System.out.println(in);
		 //8
		 int fre = Collections.frequency(lst, 2);
		 System.out.println(fre);
		 fre = Collections.frequency(lst, 3);
		 System.out.println(fre);
		 }
		}

