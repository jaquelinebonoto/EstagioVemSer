package br.com.dbc.mavencomapache;

import org.apache.commons.lang3.StringUtils;

public class Programa {
    public static void main(String[] args) {
        String palavra = new String ();
        
        String capitalize = StringUtils.capitalize("Palavra");
        System.out.println(capitalize);
        System.out.println(palavra);  
        
        System.out.println("Instalando e testando StringUtils");
        System.out.println("-----------------------------------------------");
        System.out.println("Teste de comandos isEmpty");
        System.out.println(StringUtils.isEmpty(palavra)); //true
        System.out.println(StringUtils.isEmpty(""));//true
        System.out.println(StringUtils.isEmpty(" ")); //false
        System.out.println(StringUtils.isEmpty(capitalize)); //false
        System.out.println(StringUtils.isEmpty("  bob  "));//false
        
 
        System.out.println("-----------------------------------------------");
        System.out.println("Teste de comandos isBlank");        
        System.out.println(StringUtils.isBlank(palavra));//true
        System.out.println(StringUtils.isBlank(""));//true
        System.out.println(StringUtils.isBlank(" ")); //true  
        System.out.println(StringUtils.isBlank(capitalize)); //false
        System.out.println(StringUtils.isBlank("  bob  "));  //false
  
        System.out.println("-----------------------------------------------");
        System.out.println("Teste de comandos trimToNull");  
        System.out.println(StringUtils.trimToNull(null));
        System.out.println(StringUtils.trimToNull(""));
        System.out.println(StringUtils.trimToNull("     "));
        System.out.println(StringUtils.trimToNull("abc"));
        System.out.println(StringUtils.trimToNull("    abc    "));
        System.out.println(StringUtils.trimToNull(" " + capitalize));
    
   
        System.out.println("-----------------------------------------------");
        System.out.println("Teste de comandos equals");  
        System.out.println(StringUtils.equals(null, null));
        System.out.println(StringUtils.equals(null, "abc"));
        System.out.println(StringUtils.equals("abc", null));
        System.out.println(StringUtils.equals("abc", "abc"));
        System.out.println(StringUtils.equals("abc", "ABC"));
        
        
        System.out.println("-----------------------------------------------");
        System.out.println("Teste de comandos contains"); 
        System.out.println(StringUtils.contains(null, 3));
        System.out.println(StringUtils.contains("*", null));
        System.out.println(StringUtils.contains("", ""));
        System.out.println(StringUtils.contains("abc", ""));
        System.out.println(StringUtils.contains("abc", "a"));
        System.out.println(StringUtils.contains("abc", "z"));
        
        
        System.out.println("-----------------------------------------------");
        System.out.println("Teste de comandos leftPad"); 
        System.out.println(StringUtils.leftPad("", 3));
        System.out.println(StringUtils.leftPad("bat", 5));        
        System.out.println(StringUtils.leftPad("bat", 15));
        System.out.println(StringUtils.leftPad("bat", 1));
        System.out.println(StringUtils.leftPad("bat", -1));
        System.out.println(StringUtils.leftPad("", 3, 'z'));
        System.out.println(StringUtils.leftPad("bat", 3, 'z'));
        System.out.println(StringUtils.leftPad("bat", 5, 'z'));
  
        System.out.println("-----------------------------------------------");
        System.out.println("Teste de comandos rightPad"); 
        System.out.println(StringUtils.rightPad("", 3));
        System.out.println(StringUtils.rightPad("bat", 5));        
        System.out.println(StringUtils.rightPad("bat", 15));
        System.out.println(StringUtils.rightPad("bat", 1));
        System.out.println(StringUtils.rightPad("bat", -1));
        
    }  
}

