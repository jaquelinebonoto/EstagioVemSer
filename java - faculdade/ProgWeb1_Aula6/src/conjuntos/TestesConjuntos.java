
package conjuntos;

import java.util.*;


public class TestesConjuntos {

    public static void main(String[] args) {
        //o que a linha abaixo faz?
        SortedSet ss = new TreeSet(Arrays.asList(2, 3, 5));
        Object fe = ss.first(); //retorna: ?
        Object le = ss.last(); //retorna: ?
        ss.add(1); //conjunto resultante = ?
        ss.add(4); //conjunto resultante = ?
        SortedSet s1 = ss.headSet(3); //s1 = ?
        SortedSet s2 = ss.tailSet(3); //s2 = ?
        SortedSet s3 = ss.subSet(2, 5); //s3 = ?
    }
}
