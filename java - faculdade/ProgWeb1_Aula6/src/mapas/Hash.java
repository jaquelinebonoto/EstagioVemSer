
package mapas;

import java.util.Enumeration;
import java.util.Hashtable;

public class Hash {

    public static void main(String[] args) {
        Hashtable<String, Integer> itens = new Hashtable<>();
        itens.put("cod1", new Integer(1));
        itens.put("cod2", 2);
        itens.put("cod2", new Integer(2));
        Enumeration<Integer> e = itens.elements();
        while (e.hasMoreElements()) {
            Integer i = e.nextElement();
            System.out.println(i);
        }
    }
}


