package conjuntos;

import java.util.*;

public class Conjunto1 {

    public static void main(String[] args) {
        Set<String> conjunto = new HashSet<>();
        conjunto.add("Dois");
        conjunto.add("Tres");
        conjunto.add("Um");
        conjunto.add("Um");
        for (String num : conjunto) {
            System.out.println(num);
        }

    }
}
