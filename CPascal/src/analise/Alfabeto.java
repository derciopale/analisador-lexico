/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analise;

/**
 *
 * @author Dercio Pale
 */
public class Alfabeto {
    
    public static boolean isTerminador(String a){
        if (";".equalsIgnoreCase(a)){
            return true;
        }
        
        return false;
    }
    
    public static boolean isOperador(String a){
        if ("(".equals(a) || ")".equals(a) || ":=".equals(a) || "*".equals(a) || "/".equals(a) || "=".equals(a) || "<>".equals(a) || "not".equalsIgnoreCase(a)
                || "<".equals(a) || ">".equals(a) || "<=".equals(a) || ">=".equals(a) || "-".equals(a) || "+".equals(a)
                || "div".equalsIgnoreCase(a) || "mod".equalsIgnoreCase(a) || "and".equalsIgnoreCase(a) || "or".equalsIgnoreCase(a)
                || ":".equals(a)){
            return true;
        }
        
        return false;
    }
    
    public static boolean isConstante(String token){
        String[] a;
        a = token.split("");
  
        int i;
        for (i = 0; i <= (a.length -1); i++){ // for percorre letras para saber se existem itens != numerais
            if (!isNumeral(a[i])){
                return false;
            }
        }
                
        return true;
    }
    
    public static boolean isIdentificador(String token){
        String[] a;
        a = token.split("");
        
        if(!(isLetra(a[0]))){
            return false;
        }
        
        int i;
        
        for (i = 1; i <= (a.length -1); i++){ // for percorre letras para saber se existem itens não identificaveis.
            if (!isLetra(a[i]) && !isNumeral(a[i])){
                return false;
            }
        }
        return true;
    }
    
    public static boolean isReservada(String a){
        if (       "array".equalsIgnoreCase(a) || "asm".equalsIgnoreCase(a) || "begin".equalsIgnoreCase(a)
                || "case".equalsIgnoreCase(a) || "const".equalsIgnoreCase(a) || "constructor".equalsIgnoreCase(a) 
                || "do".equalsIgnoreCase(a) || "downto".equalsIgnoreCase(a) || "else".equalsIgnoreCase(a) || "end".equalsIgnoreCase(a)
                || "file".equalsIgnoreCase(a) || "for".equalsIgnoreCase(a) || "foward".equalsIgnoreCase(a) || "function".equalsIgnoreCase(a) 
                || "goto".equalsIgnoreCase(a) || "if".equalsIgnoreCase(a) || "implementation".equalsIgnoreCase(a) || "in".equalsIgnoreCase(a)
                || "inline".equalsIgnoreCase(a) || "interface".equalsIgnoreCase(a) || "label".equalsIgnoreCase(a)  
                || "nil".equalsIgnoreCase(a) || "object".equalsIgnoreCase(a) || "of".equalsIgnoreCase(a)
                || "integer".equalsIgnoreCase(a)
                || "packed".equalsIgnoreCase(a) || "procedure".equalsIgnoreCase(a) || "program".equalsIgnoreCase(a)
                || "record".equalsIgnoreCase(a) || "repeat".equalsIgnoreCase(a) || "set".equalsIgnoreCase(a) || "shl".equalsIgnoreCase(a)
                || "shr".equalsIgnoreCase(a) || "string".equalsIgnoreCase(a) || "then".equalsIgnoreCase(a) || "to".equalsIgnoreCase(a)
                || "type".equalsIgnoreCase(a) || "unit".equalsIgnoreCase(a) || "until".equalsIgnoreCase(a) || "uses".equalsIgnoreCase(a)
                || "var".equalsIgnoreCase(a) || "with".equalsIgnoreCase(a) || "xor".equalsIgnoreCase(a) || "begin.".equalsIgnoreCase(a) ){
            
            return true;
        }
        return false;
    }
    
    public static boolean isNumeral(String a){
        if ("1".equals(a) ||"2".equals(a) ||"3".equals(a) ||"4".equals(a) ||"5".equals(a) ||"6".equals(a) ||"7".equals(a) ||"8".equals(a) ||"9".equals(a) ||"0".equals(a))
            return true;
        else
            return false;
    }
    
    public static boolean isLetra(String a){
        if(isNumeral(a)){
            return false;
        }
        else{
            if("a".equalsIgnoreCase(a) || "b".equalsIgnoreCase(a) || "c".equalsIgnoreCase(a) || "d".equalsIgnoreCase(a) || "e".equalsIgnoreCase(a) || "f".equalsIgnoreCase(a) ||
               "g".equalsIgnoreCase(a) || "h".equalsIgnoreCase(a) || "i".equalsIgnoreCase(a) || "j".equalsIgnoreCase(a)
                     || "k".equalsIgnoreCase(a) || "l".equalsIgnoreCase(a) || "m".equalsIgnoreCase(a) || "n".equalsIgnoreCase(a) || "o".equalsIgnoreCase(a) || "p".equalsIgnoreCase(a) || "q".equalsIgnoreCase(a) || "r".equalsIgnoreCase(a)
                     || "s".equalsIgnoreCase(a) || "t".equalsIgnoreCase(a) || "u".equalsIgnoreCase(a) || "v".equalsIgnoreCase(a) || "w".equalsIgnoreCase(a) || "x".equalsIgnoreCase(a) || "y".equalsIgnoreCase(a) || "z".equalsIgnoreCase(a))
                return true;
        }
        return false;
    }
    
    public static boolean isErro(String a){
        if (isNumeral(a) == false && isLetra(a) == false)
            return true;
        else
            return false;
    }
    
}
