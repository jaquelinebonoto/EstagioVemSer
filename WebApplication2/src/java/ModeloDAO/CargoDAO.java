/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;
import java.sql.Connection;
import Entidade.Cargo;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Tanisi
 */
public class CargoDAO extends DAO{
   
   public Statement stm;  
   public ResultSet res = null;  
  /* 
    public void inserirDados(){  
     
      try {  
         String query = "insert into cargo(id_cargo,nome_cargo,min_sal,max_sal) values(100,'"+cargo+"',"+min_sal+","+max_sal+")";  
         stm.executeUpdate(query);  
         System.out.println("Registro inserido");
      }catch (SQLException e){System.out.println("Erro na inserção:" + e.getMessage());}  
        
   }  
  
  
     
   public boolean excluirDados(){  
     
    boolean testa = false;  
     
      try {  
         String query = "delete from cargo where nome_cargo='" + cargo+"'";  
         int linhas = stm.executeUpdate(query);  
           
         if (linhas > 0)  
            testa = true;  
         else  
            testa = false;  
  
      }catch (SQLException e){System.out.println("Erro na exclusão:" + e.getMessage());}  
        
      return testa;  
   }  
     
   public boolean consultarDados(){  
        
      boolean testa = false;  
           
      try {  
         String query = "select * from pessoa where nome='" + cargo+"'";  
         res = stm.executeQuery(query);  
           
         if (res.next()){testa = true;}  
         else{testa = false;}  
           
      }catch (SQLException e){System.out.println("Erro na inserção:" + e.getMessage());}  
        
      return testa;  
   }     
  
   public void setConsulta() {  
        
      try {  
         res = stm.executeQuery("select * from cargo");  
      }   
      catch (SQLException e){  
      }  
  
   }  
  
   public ResultSet getResultado() {  
      return res;  
   } 
   */
       public void insertCargo(Cargo cargo) throws SQLException, ClassNotFoundException, IOException {
      
       Connection conexao=null;
       CallableStatement clst = null;
      

       try
       {
        conexao = getConexao();

        clst = conexao.prepareCall("{call insert_cargo(?, ?, ?)}");
        clst.setString(1, cargo.getCargo());
        clst.setDouble(2, cargo.getMin_sal());
        clst.setDouble(3, cargo.getMax_sal());
        clst.execute();
       }
       catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        finally
        { 
           
         if (clst != null) { try { clst.close(); } catch (SQLException ex) {} }
         if (conexao != null) { try { conexao.close(); } catch (SQLException ex) {} }


        }
    }
       
        public List<Cargo> getDados(String nome_cargo) throws SQLException, ClassNotFoundException, IOException {
        // call the PL/SQL procedures with the three parameters
      // the first two string parameters (1 and 2) are passed to the procedure
      // as command-line arguments
      // the REF CURSOR parameter (3) is returned from the procedure
       Connection conexao =null;
       CallableStatement callStmt =null;
       ResultSet rset;
       
       
        List<Cargo> listaCargo = new ArrayList<>();
        
      try
      {
 
      conexao = getConexao();
     

      String jobquery = "begin get_dados(?, ?); end;";
      callStmt = conexao.prepareCall(jobquery);
      callStmt.registerOutParameter(2, OracleTypes.CURSOR);
      callStmt.setString(1, nome_cargo);
      callStmt.execute();

      // return the result set
      rset = (ResultSet)callStmt.getObject(2);

      while (rset.next()) {
          
                Cargo c = new Cargo();
                c.setNome(rset.getString("NOME_CARGO"));
                c.setMin_sal(rset.getDouble("MIN_SAL"));
                c.setMax_sal(rset.getDouble("MAX_SAL"));
                listaCargo.add(c);

            }
      
      }
   catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
         if (callStmt != null) { try { callStmt.close(); } catch (SQLException ex) {} }
         if (conexao != null) { try { conexao.close(); } catch (SQLException ex) {} }

        }

   return listaCargo;
        }
      
}
