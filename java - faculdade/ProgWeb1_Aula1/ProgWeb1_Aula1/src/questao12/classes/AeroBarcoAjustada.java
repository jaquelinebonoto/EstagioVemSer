
package questao12.classes;

import questao12.interfaces.Aquatico;
import questao12.interfaces.Terrestre;

public class AeroBarcoAjustada implements Aquatico, Terrestre{
    @Override
    public void imprimir() {
        System.out.println("Anda na Terra e na Água!");
    }
}
