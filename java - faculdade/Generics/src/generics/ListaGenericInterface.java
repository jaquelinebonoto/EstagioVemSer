
package generics;

public interface ListaGenericInterface<E> {
    public void adicionar (E obj);
    public boolean remover(int i);
    public String listar();
    public int totalizar();
    public void removerTodos();
    public E pegarElemento(int i);
    public void removerElemento(E obj);
}
