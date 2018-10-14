
package Questao8;

public class Teste {
    public static void main(String[] args) {
        Pagamento vetor [] = new Pagamento[5];
        Cheque c1 = new Cheque(1234, 1267, 0);
        Cheque cheques[] = new Cheque[4];
        cheques[2] = new Cheque(1235, 12, 1245);
        vetor[0] = new PagamentoCheque("12/11/2008", c1, 100.0);
        vetor[1] = new PagamentoCheque ("", null, 0.0);
        vetor[2] = new PagamentoCheque ("16/11/2008", new Cheque(1234, 1, 3453), 150.0);
        vetor[3] = new PagamentoCheque ("", null, 0.0);
        vetor[4] = new PagamentoCheque ("18/11/2008", cheques[1], 50.0);

        for(int i=0; i<vetor.length; i++)
        System.out.println(vetor[i].toString());
}

}
