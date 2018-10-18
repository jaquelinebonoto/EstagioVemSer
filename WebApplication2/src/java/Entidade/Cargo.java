/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Tanisi
 */
@Entity
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   private String cargo = null;  
   private double min_sal = 0;  
   private double max_sal=0;  
   private int id_cargo=0;
   
    public void setNome(String cargo){  
      this.cargo = cargo;  
   }  
        
   public void setMin_sal(double min_sal){  
      this.min_sal = min_sal;  
   }  
  
   public void setMax_sal(double max_sal){  
      this.max_sal = max_sal;  
   } 
   
    public void setId_cargo(int id_cargo){  
      this.id_cargo = id_cargo;  
   } 
  
   public String getCargo(){  
      return cargo;  
   }  
  
   public double getMin_sal(){  
      return min_sal;  
   }  
        
   public double getMax_sal(){  
      return max_sal;  
   }  
  
     public int getId_cargo(){  
      return id_cargo;  
   }  
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
      
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Cargo[ id=" + id + " ]";
    }
    
}
