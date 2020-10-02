/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasSemanticas;

import java.util.ArrayList;


/**
 *
 * @author Dercio Pale
 */
public class Regras { 
    
    public static boolean isSimboloInicial(ArrayList simbolo){
        // "program" IDENTIFICADOR TERMINADOR
        String a,b,c;
        
        a = simbolo.get(0).toString(); //program?
        b = simbolo.get(1).getClass() + "";// pertence a classe IDENTIFICADOR?
        c = simbolo.get(2).getClass()+ "";// pertence a classe TERMINADOR?
        
        if(a.contains("program") && b.equals("class tokens.Identificador") && c.equals("class tokens.Terminador")){
            System.out.print("\n True SIMBOLO INICIAL \n");
            return true;
        }
        else{
            System.out.print("\n Erro Simbolo inicial \n");
            return false;
        }
    }
    
    public static boolean isDeclaracao(ArrayList simbolo){
        // "var" | "const" IDENTIFICADOR ":" TIPO (RESERVADA) TERMINADOR
        String a, b, c, d, e;
        
        a = simbolo.get(0).toString(); //var? ou const?
        b = simbolo.get(1).getClass() + "";// IDENTIFICADOR?
        c = simbolo.get(2).toString(); // ":"?
        d = simbolo.get(3).getClass() + ""; // RESERVADA?
        e = simbolo.get(4).getClass()+ ""; //TERMINADOR? 
        
        if((a.contains("var") || a.contains("const")) && b.equals("class tokens.Identificador") && c.contains(":") && d.equals("class tokens.Reservada")&& e.equals("class tokens.Terminador")){
            System.out.print("\n True DECLARACAO \n");
            return true;
        }
        else{
            System.out.print("\n Erro DECLARACAO \n");
            return false;
        }
    }
    
    public static boolean isBloco(ArrayList simbolo){
        // "begin" (RESERVADA) ..... "end" (RESERVADA)
        String a;
        a = simbolo.get(0).toString();
        
        if(a.contains("begin") || a.contains("end")){
             System.out.print("\n True BLOCO \n");
            return true;
        }
        System.out.print("\n ERRO BLOCO \n");
        return false;
    }
    
    public static boolean isAtribuicao(ArrayList simbolo){
        //IDENTIFICADOR ":=" (CONSTANTE | IDENTIFICADOR | EXPRESSAO)  TERMINADOR
        String a, b, c, d;
        
        a = simbolo.get(0).getClass() + ""; //IDENTIFICADOR
        b = simbolo.get(1).toString(); // ":=" ?
        c = simbolo.get(2).getClass() + ""; // CONSTANTE | IDENTIFICADOR
        d = simbolo.get(3).getClass() + ""; // TERMINADOR
        
        if(a.equals("class tokens.Identificador") && b.contains(":=") && (c.equals("class tokens.Constante") || c.equals("class tokens.Identificador") && d.equals("class tokens.Terminador"))){
            System.out.print("\n True ATRIBUICAO \n");
            return true;
        }
        else{
            System.out.print("\n ERRO ATRIBUICAO \n");
            return false;
        }
    }
}
