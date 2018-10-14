
package listas;

import java.util.*;

public class Lista1{
     public static void main(String args[]){
            List<Integer> lista = new ArrayList<>();
            lista.add(new Integer(10)); 
            lista.add(20); 
            for(Integer obj: lista) {
                    System.out.println(obj);
            }
            System.out.println(lista.indexOf(20));
     }
}
