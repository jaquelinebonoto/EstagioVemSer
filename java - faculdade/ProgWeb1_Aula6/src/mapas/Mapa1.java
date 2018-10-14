package mapas;
import java.util.*;

public class Mapa1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("um", new Integer(1));
        map.put("dois", new Integer(2));
        map.put("tres", new Integer(3));
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            System.out.println((Integer) it.next());
        }
    }

}
