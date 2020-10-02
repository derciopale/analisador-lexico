/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analise;

import java.util.ArrayList;
import regrasSemanticas.Regras;
/**
 *
 * @author Dercio Pale
 */
public class Semantica {
    
    public static void analise(ArrayList ArrayFita){
        System.out.print("\n Estamos em analise semantica \n");
        boolean isLinguagemAceita = true;
        int i;
        boolean flag = false;
        //remover da fita espaços ou "tabs";
        //for(){
            
        //}
        
        while (!ArrayFita.isEmpty() || isLinguagemAceita == false){
            isLinguagemAceita = verificaRegra(ArrayFita);
            
            //Para cada frase seguida de uma quebra de linha, temos uma nova análise por linha    
            while (flag == false || !ArrayFita.isEmpty()){
                if (!(ArrayFita.get(0).toString().contains("\n"))){
                    ArrayFita.remove(0);
                }
                else{
                    flag = true;
                    ArrayFita.remove(0);
                }
            }
            flag = false;
        }
        
        if (isLinguagemAceita){
            System.out.print("\n LINGUAGEM APROVADA \n -------------------");
        }
        else{
            System.out.print("\n REPROVADA NO TESTE SEMANTICO \n -------------------");
        }
    }
    
    public static boolean verificaRegra(ArrayList a){
        //Regras.isBloco(a) 1
        //Regras.isSimboloInicial(a) 3
        //Regras.isAtribuicao(a) 4 
        //Regras.isDeclaracao(a) 5 ou +
        
        if(Regras.isBloco(a)){
            return true;
        }
        else{
            if(Regras.isSimboloInicial(a)){
                return true;
            }
            else{
                if(Regras.isAtribuicao(a)){
                    return true;
                }
                else{
                    if(Regras.isDeclaracao(a)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
