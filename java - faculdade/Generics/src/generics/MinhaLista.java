
package generics;

import java.util.LinkedList;


public class MinhaLista<E> implements ListaGenericInterface<E> {
    private LinkedList<E> lista;

    public MinhaLista() {
    }

    public MinhaLista(LinkedList<E> lista) {
        this.lista = lista;
    }
    
    
    @Override
    public void adicionar(E obj) {
        lista.add(obj);
    }

    @Override
    public boolean remover(int i) {
        if (i <= lista.size()){
            lista.remove();
            return true;
        }
        return false;
    }

    @Override
    public String listar() {
        String aux="";
        for (E obj:lista){
            aux+=obj.toString() + "\n";
        }
        return aux;
    }

    @Override
    public int totalizar() {
        return lista.size();
    }

    @Override
    public void removerTodos() {
        lista.removeAll(lista);
        //ou lista.clear();
    }

    @Override
    public E pegarElemento(int i) {
        return lista.get(i);
    }

    @Override
    public void removerElemento(E obj) {
        lista.remove(obj);
    }

    void add(String jaque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
