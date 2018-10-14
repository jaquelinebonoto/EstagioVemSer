
package questao2;

public class TesteProjeto {
    public static void main(String[] args) {
        Projeto vetorProjs[] = new Projeto[6];
        vetorProjs[0] = new Projeto();
        Data data = new Data(12, 12, 2014);
        vetorProjs[0] = new Projeto("SIA", new Data(14, 05, 2014), data);
        vetorProjs[1] = vetorProjs[0];
        vetorProjs[1].setDataFim(new Data(31, 01, 2015));
        for (int i = 0; i < 1; i++) {
        System.out.println(vetorProjs[i].toString());
        }
        data = vetorProjs[0].getDataInicio();
        data.setDia(21);
        vetorProjs[1].setDataFim(data);
        for (int i = 0; i < 1; i++) {
        System.out.println(vetorProjs[i].toString());
        }

    }
}
