
package questao12.interfaces;

public interface Terrestre {
    public default void imprimir() {
        System.out.println("Anda na Terra!");
    }
}
