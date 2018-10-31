
package trabalho23out;

import eleicoes.arquivo.Arquivo;
import static eleicoes.recursos.Situacao.ABERTA;
import static eleicoes.recursos.Situacao.FECHADA;
import eleicoes.recursos.Urna;
import eleicoes.votos.Branco;
import eleicoes.votos.Nulo;
import eleicoes.votos.Valido;
import eleicoes.votos.Voto;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 0783170
 */
public class Menu {
    public static void main(String[] args) {
        boolean sair = false;
    
        //1 – Cadastrar Urna (com a situação fechada)      
        //2 – Abrir Urna (que modifica a situação para aberta)       
        //3 – Votar (permite cadastrar um voto)        
        //4 – Fechar Urna (que modifica a situação para fechada e mostra o número total de votos, o número total de votos válidos, votos nulos e votos brancos) e salva todos os dados da Urna no arquivo “Urna_zona_secao.txt”
        //5 – Mostrar Dados Urna (que abre o arquivo Urna_zona_secao.txt e mostra as totalizações dos votos)
        
        //List<Aluno> alunos = new ArrayList<>();
        Urna u2 = new Urna (1, 11, FECHADA);
        List<Voto> votos = new LinkedList<>();
        u2.setVotos(votos);
        while(!sair){
        switch (montaMenu()){
            case "1": //cadastrar urna
                System.out.println("Entrou no menu 1");
                String zona = JOptionPane.showInputDialog("Informe a Zona:\n");
                String secao = JOptionPane.showInputDialog("Informe a Seção: \n");
                //converte a a zona de String para int
                int zone = Integer.parseInt(zona);
                int secaoo = Integer.parseInt(secao);
                Urna u = new Urna(zone, secaoo);
                System.out.println("Urna inicializada" + u.toString());
                System.out.println("Situação antes de fechar: " + u.getSituacao());
                u.setSituacao(ABERTA);
                u.setZona(132);
                u.setSecao(150);
                System.out.println("Situação depois de fechar manualmente e trocar valores: " + u.toString());
                break;
            case "2": //Abrir Urna (que modifica a situação para aberta)
                System.out.println("Entrou no menu 2");
                System.out.println("Situação antes: " + u2.getSituacao().toString());
                if (u2.getSituacao() == FECHADA) u2.setSituacao(ABERTA);
                System.out.println("Situação depois: " + u2.getSituacao().toString());
                break; 
            case "3": //3 – Votar (permite cadastrar um voto)
                System.out.println("Entrou no menu 3");
                String eleitor = JOptionPane.showInputDialog("Informe Eleitor:\n");
                String candidatoLegenda = JOptionPane.showInputDialog("Informe Candidato Legenda: \n");
                //converte a a zona de String para int
                long eleitor1 = Long.parseLong(eleitor);
                int candLegenda = Integer.parseInt(candidatoLegenda);
                if ((candLegenda==13 || candLegenda==17) && (eleitor1 !=0)){
                    Voto v1 = new Valido (eleitor1, candLegenda, 2018);
                    votos.add(v1);
                }
                if ((candLegenda!=13 && candLegenda!=17 && candLegenda!=0) && (eleitor1 !=0)){
                    Voto v1 = new Nulo (eleitor1, candLegenda, 2018);
                    votos.add(v1);
                }
                if ((candLegenda==0) && (eleitor1 !=0)){
                    Voto v1 = new Branco (eleitor1, 2018);
                    votos.add(v1);
                }
                u2.setVotos(votos);
                System.out.println("Resultado da inserção em u2: " + u2.toString());
                break;
            case "4"://4 – Fechar Urna (que modifica a situação para fechada e mostra 
                //o número total de votos, o número total de votos válidos, votos nulos e votos brancos)
                //e salva todos os dados da Urna no arquivo “Urna_zona_secao.txt”
                u2.setSituacao(FECHADA);
                System.out.println("Urna 2 situação: " + u2.getSituacao());
                System.out.println("Total de Votos desta urna: " + u2.getVotos().size());
                System.out.println("Brancos: " + Branco.getContBrancos() + "\n");
                System.out.println("Nulos: " + Nulo.getContNulos() + "\n");
                System.out.println("Validos: " + Valido.getContValidos() + "\n");
                break;
            case "5": // 5 – Mostrar Dados Urna (que abre o arquivo Urna_zona_secao.txt e mostra as totalizações dos votos)   
                Arquivo<Urna> a = new Arquivo("Urna_zona_secao.txt");
                a.abrir("w");
                a.gravarObjeto(u2);
                a.abrir("r");
                a.lerObjeto();
                a.fechar();
                break;
            case "6":
                sair = true;
                break;
            } 
        }
            sair=false;
    }
    
    
    private static String montaMenu(){
        String menu = "1 - Cadastrar Urna\n";
        menu+= "2 - Trocar situação da urna\n";
        menu+= "3 - Cadastrar voto em u2\n";
        menu+= "4 - Fechar Urna\n";       
        menu+= "5 - Mostra dados da Urna\n";
        menu+= "6 - Sair";
        return JOptionPane.showInputDialog(menu);    
    }
}
