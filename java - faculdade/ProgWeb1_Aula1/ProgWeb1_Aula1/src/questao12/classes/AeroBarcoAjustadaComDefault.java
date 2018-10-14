
package questao12.classes;

import questao12.interfaces.Aquatico;
import questao12.interfaces.Terrestre;


public class AeroBarcoAjustadaComDefault implements Aquatico, Terrestre{
    public void imprimir() {
        Aquatico.super.imprimir();
        Terrestre.super.imprimir();
        System.out.println("Anda na Terra e na Água!");
    }
}
