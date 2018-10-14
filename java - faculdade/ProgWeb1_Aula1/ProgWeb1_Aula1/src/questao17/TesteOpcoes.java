
package questao17;

import javax.swing.JOptionPane;


public class TesteOpcoes {
    public static void main(String[] args) {
        int opcao = montaMenu();
        switch(opcao){
            case 3: JOptionPane.showMessageDialog(null, "Abrir");
                break;
        }
    }
    private static int montaMenu(){
        String str = "";
        for(OpcoesMenu op : OpcoesMenu.values())
            str +=  op.toString() + "\n";
        return Integer.parseInt(JOptionPane.showInputDialog(str));             
    }
}
