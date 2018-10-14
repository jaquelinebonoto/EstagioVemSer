
package generics;


public class TesteLista {
     public static void main(String[] args) {
	 
	 MinhaLista<String> turma = new MinhaLista<>();
	 
         turma.adicionar("Jaqueline");
	 turma.adicionar("José");
	 turma.adicionar("Amora");
	 turma.adicionar("Felipe");
		 
	 System.out.println(turma.listar());	
	 System.out.println("Tamanho da Lista: " + turma.totalizar());
	 turma.remover(2);
	 System.out.println("Tamanho da Lista: " +turma.totalizar());
		 
	 System.out.println("Pegar elemento 0: " + turma.pegarElemento(0));		 
 }    
}
