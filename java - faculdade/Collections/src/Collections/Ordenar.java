package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Ordenar {
	public static void main(String[] args) {
		TreeSet<Integer> numeros = new TreeSet<>();
		numeros.add(88);
		numeros.add(20);
		numeros.add(55);
		
		for (Integer num: numeros) {
			System.out.println(num);
		}
		
		TreeSet<Aluno> alunos = new TreeSet<>();
		alunos.add(new Aluno("João", null, null, 1234, new Cpf()));
		alunos.add(new Aluno("Maria", null, null, 3456, new Cpf()));
		alunos.add(new Aluno("José", null, null, 7895, new Cpf()));
		
		for (Aluno a: alunos) {
			System.out.println(a.toString());
		}
		
		
		//Usando a classe Pessoa da aula anterior faça os itens abaixo:
		//	3.1 Adicionar 4 pessoas em uma lista, usar os construtores sem e com parâmetros
		//	3.2 Imprimir o primeiro e o último objetos
		//	3.3 Ordenar a lista usando o nome
		//	3.4 Imprimir a lista ordenada
		
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("Jaque", "33333", "asbndiudhw"));
		pessoas.add(new Pessoa("Elba", "433333", "asbnswcddiudhw"));
		pessoas.add(new Pessoa("Anna", "533333", "asbndicfadhw"));
		pessoas.add(new Pessoa("Zelia", "633333", "asbndifaudhw"));
		
		
		System.out.println("Primeira pessoa da Lista " + pessoas.get(0));
		System.out.println("Última pessoa da Lista " + pessoas.get(pessoas.size()-1) + "\n");
		
		
		Collections.sort(pessoas);
		System.out.println("Pessoas da lista em ordem: ");
		for (Pessoa pessoa: pessoas) {
			System.out.print(pessoa.toString());
		}
		
		
	}
}
