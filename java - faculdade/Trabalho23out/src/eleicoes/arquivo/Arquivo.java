
package eleicoes.arquivo;

import java.io.*;
import java.util.Arrays;

/**
 *
 * @author 0783170
 * @param <T>
 */
public class Arquivo <T> {
    private ObjectOutputStream saida;
    private ObjectInputStream entrada;
    private String nomeArq;

    public Arquivo(String nome){ nomeArq=nome; }
    public Arquivo (){};

    public void abrir(String tipo) {
        if (tipo.equals("w")){ // abre para gravação
            try{
            saida = new ObjectOutputStream(new FileOutputStream( nomeArq) );
            System.out.println("Aberto para Gravação");
            }catch(FileNotFoundException e){
                System.out.println("Arquivo não encontrado" + e.getStackTrace());
            }catch (IOException e){
                System.out.println("Problema com a entrada dos dados" + Arrays.toString(e.getStackTrace()));
            }catch (SecurityException e){
                System.out.println("Problema com a entrada de dados" + e.getCause().toString());
            }catch(NullPointerException e){
                System.out.println("Problema com a entrada de dados" + e.toString());
            }
        } else{ // abre para leitura
            try{
            entrada = new ObjectInputStream(new FileInputStream( nomeArq) );
            System.out.println("Aberto para Leitura");
            }catch(FileNotFoundException e){
                System.out.println("Arquivo não encontrado" + Arrays.toString(e.getStackTrace()));
            } catch (StreamCorruptedException e){
                System.out.println("Problema com a leitura" + e.toString());
            } catch (IOException e){
                System.out.println("Problema com a leitura" + e.toString());
            } catch (SecurityException e){
                System.out.println("Problema com a leitura" + e.toString());
            }catch (NullPointerException e){
                System.out.println("Problema com a leitura" + e.toString());
            }
        }
     }
    
    public void gravarObjeto(T obj){
        try{
        saida.writeObject(obj);
        saida.flush();
        System.out.println("Objeto gravado");
        }catch (InvalidClassException e){
            System.out.println("Problema com a entrada dos dados (escrita)" + e.toString() );
        } catch (NotSerializableException e){
            System.out.println("Problema com a entrada dos dados (escrita)" + e.toString() );
        } catch (IOException e){       
            System.out.println("Problema com a entrada dos dados (escrita)" + e.toString() );
        }
    }
    
    public T lerObjeto() {
        T palavra = null;
        try{
            palavra = (T)entrada.readObject();
            System.out.println("Objeto lido" + palavra);
        }catch (ClassNotFoundException e){
            System.out.println("Problema com a leitura do arquivo" + e.toString());
        }catch (InvalidClassException e){
            System.out.println("Problema com a leitura do arquivo" + e.toString());
        } catch (StreamCorruptedException e){
            System.out.println("Problema com a leitura do arquivo" + e.toString());
        } catch (OptionalDataException e){
            System.out.println("Problema com a leitura do arquivo" + e.toString());        
        } catch (IOException e){
            System.out.println("Problema com a leitura do arquivo" + e.toString());            
        } 
        return palavra;
    }
    public void fechar() {
        try{
          if(saida != null) saida.close();
          if(entrada != null) entrada.close();
          System.out.println("Conexão fechada");
        } catch (IOException e){
            System.out.println("Erro ao encerrar o arquivo.");
        }
    }
 
}
