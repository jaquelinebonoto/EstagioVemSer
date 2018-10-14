
package listas;

import java.util.LinkedList;

public class Lista2{
     public static void main(String args[]){
            LinkedList<Number> lista = new LinkedList<>();
            lista.add(new Integer(10)); 
            lista.add(new Double(20.89)); 
            lista.add(new Long(30)); 
            lista.add(23.5F); 
            for(Number obj: lista) {
                    System.out.println(obj);
            }
            lista.removeFirst();
            lista.removeLast();
            for(Number obj: lista) {
                System.out.println(obj);
            }
     }
}

