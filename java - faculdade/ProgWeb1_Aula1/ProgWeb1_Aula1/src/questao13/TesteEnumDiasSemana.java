
package questao13;


public class TesteEnumDiasSemana {
    public static void main(String[] args) {
        //Imprimindo/pegando um valor da Enum
        DiasSemana dia = DiasSemana.QUARTA;
        System.out.println("Dia:"+dia.toString());
        
        //Percorrendo os valor da Enum
        for(DiasSemana dias : DiasSemana.values())
            System.out.println("dias:"+dias.getValor());
        
      //Percorrendo os valor da Enum
        for(DiasSemana dias : DiasSemana.values())
            System.out.println("dias:"+dias.toString());
        
        //Comparando valores
        comparaEnum(DiasSemana.QUARTA);
    }
    public static void comparaEnum(DiasSemana opcao){
	switch(opcao){	
            case DOMINGO:
			System.out.println("Valor é domingo!");
                        break;
            case SEGUNDA:
			System.out.println("Valor é segunda!");
                        break;
            case QUARTA:
			System.out.println("Valor é quarta!");
        }
    }
}
