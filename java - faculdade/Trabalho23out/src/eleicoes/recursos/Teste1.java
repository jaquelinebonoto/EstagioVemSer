package eleicoes.recursos;

import eleicoes.votos.Nulo;
import eleicoes.votos.Valido;
import eleicoes.votos.Voto;

/**
 *
 * @author 0783170
 */
/*public class Teste1 {
    public static void main(String[] args) {
        //necessário fazer as importações porque estamos usando classes de outro pacote
        Voto v = new Voto(); //voto não pode ser instanciado
        v.ano = 2018; 
        //como é um atributo privado, ele só pode ser adicionado dentro do parenteses de criação do objeto
        //é preciso usar os gets e sets para atribuir valor ou consultar
        v.setAno(2018); //assim é como deveria estar na linha de código acima
        //um método público para setar um valor de ano
        //além disso, ele só pode ser acessado por classes do mesmo pacote e aqui não é o caso pq é default
            
        v.contador = 12;
        //neste caso é ainda mais restritivo.
        //a variável contador não poderá ser setada por um objeto porque é uma variável estática
        //essa variável é incrementada sempre que um objeto da classe Voto for instanciado. está no construtor
        
        
        Nulo n = new Nulo();
        //neste caso ocorre algo semelhante. aos anteriores
        //Foi instanciado um voto do nulo, ele terá acesso aos métodos da classe voto porque é subclasse.
        //no entanto, o atributo ano continua sendo privado.
        //teria que informar o ano na criacão do objeto ou dar um set.
        n.setAno(2018); //exemplo correto
        Nulo n1 = new Nulo (2018); //outro exemplo correto
        
        
        n.ano = 2018; //errado conforme explicado acima
//além disso, ele só pode ser acessado por classes do mesmo pacote e aqui não é o caso pq é default
        n.contNulos = 10; //não é possível setar uma valor privado static partindo de um objeto
    }
}*/

public class Teste1 {
    public static void main(String[] args) {
        Voto v = new Valido();
        v.setAno(2018); 
        Voto.getContador(); 
        System.out.println(v.toString());
        System.out.println("Total de Votos: " + Voto.getContador());
        
        
        Nulo n = new Nulo();
        n.setAno(2018); 
        Nulo n1 = new Nulo (2018); 
        System.out.println(n.toString());
        System.out.println(n1.toString());
        System.out.println("Total de votos nulos: " + Nulo.getContNulos());
        System.out.println("Total de Votos (agora com os nulos): " + Voto.getContador());
    
    }
}