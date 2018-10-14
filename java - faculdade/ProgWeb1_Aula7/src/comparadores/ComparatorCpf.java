package comparadores;

import classes.Cpf;
import java.util.*;
public class ComparatorCpf implements Comparator<Cpf> {
   @Override
   public int compare(Cpf obj1, Cpf obj2) {
      return obj1.compareTo(obj2);
   }
}

