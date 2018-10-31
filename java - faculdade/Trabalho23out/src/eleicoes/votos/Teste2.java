package eleicoes.votos;

/**
 *
 * @author 0783170
 */
/*public class Teste2 {
    public static void main(String[] args) {
        //neste caso não é preciso importar o outro pacorte
        Voto v = new Voto(); //voto é abstrato e não pode ser instanciado
        v.ano = 2018; //objeto não pode acessar atributo privado de classe. teria que usar setter
        v.contador = 12; //mesmo acima, quem dirá setar um contador de classe
        Nulo n = new Nulo();
        n.ano = 2018; //o mesmo que acima, o que muda é que é um objeto de subclasse
        n.contNulos = 10; //objeto não pode acessar variável privada de classe, quem dirá setar o contador
        
    }    
}*/


public class Teste2 {
    public static void main(String[] args) {
        
        Voto v = new Branco(); 
        v.setAno(2018);
        Voto.getContador();
        
        System.out.println(v.toString());
        System.out.println("Total de Votos: " + Voto.getContador());
       
        Nulo n = new Nulo();
        n.setAno(2018);
        System.out.println("Total de Nulos: " + Nulo.getContNulos());
        Nulo.contNulos = 10; 
       
        System.out.println(n.toString());
        System.out.println("Total de Nulos: " + Nulo.getContNulos());
        System.out.println("Total de Votos " + Voto.getContador());
    }    
}
