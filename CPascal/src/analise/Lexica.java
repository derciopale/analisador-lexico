/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analise;


import tokens.Identificador;
import java.util.ArrayList;
import tokens.Constante;
import tokens.Reservada;
import tokens.Operador;
import tokens.Terminador;
import tokens.Erro;
/**
 *
 * @author Dercio Pale
 */
public class Lexica {
    public static ArrayList<Identificador> ArrayIdentificadores = new ArrayList();
    public static ArrayList<Constante> ArrayConst = new ArrayList();
    public static ArrayList<Erro> ArrayErros = new ArrayList();
    public static ArrayList<Reservada> ArrayReservados = new ArrayList();
    public static ArrayList<Operador> ArrayOperadores = new ArrayList(); 
    public static ArrayList<Terminador> ArrayTerminadores = new ArrayList();
    public static ArrayList ArrayFita = new ArrayList();
    
    public static void analiseLexica(String codigo){
        limparArrays();
        String[] fita;
        int i;
        fita = codigo.split(""); //Cria um vetor de string com a fita
        int coluna = 0; int col = 0; // coluna
        int linha = 0; int lin = 0; //linha
        String token = new String(); //guarda tokens
        token = "";
        
        for (i = 0; i<= fita.length - 1; i++){//Percorre toda a fita          
            if (!fita[i].equals(" ") && !fita[i].equals("\n") && !fita[i].equals("\t")){//quebra de palavra
                if (token.equals("")){//guardar linha e coluna inicial de uma palavra
                    token = fita[i];
                    lin = linha;
                    col = coluna; 
                }else{
                    token = token + fita[i];
                }
            }else{
                encontraTipo(token, lin, col);
                token = "";
            }
            
            linha++;
            if (fita[i].equals("\n")){
                ArrayFita.add("\n");
                coluna++;
                linha = 0;
            }
            
        }
        
      
        
        System.out.print("\n  Terminadores: ");
        System.out.print(ArrayTerminadores);
        System.out.print("\n  Palavras Reservadas: ");
        System.out.print(ArrayReservados);
        System.out.print("\n  Operadores: ");
        System.out.print(ArrayOperadores);
        System.out.print("\n  Identificadores: ");
        System.out.print(ArrayIdentificadores);
        System.out.print("\n  Constantes: ");
        System.out.print(ArrayConst);
        System.out.print("\n  Erros: ");
        System.out.print(ArrayErros);
        
        
        //TABELA LÉXICA
        System.out.print("\n  Fita: ");
        System.out.print(ArrayFita);
        
        //análise sintatica... passando array fita caso, array erro lexico == vazio
        
        if (ArrayErros.size() > 0){
            System.out.print("\n LINGUAGEM REPROVADA EM ANÁLISE LEXICA: \n" + ArrayErros);
        }
        else{
            Semantica.analise(ArrayFita);
        }
    }
      
    public static void encontraTipo(String token, int lin, int col){
        if (Alfabeto.isOperador(token)){
            operador(token,lin,col);
        }
        else{
            if(Alfabeto.isTerminador(token)){
                terminador(token, lin, col);
            }
            else{
                if(Alfabeto.isReservada(token)){
                    reservada(token, lin, col);
                }
                else{
                    if(Alfabeto.isIdentificador(token)){
                        identificador(token,lin,col);
                    }
                    else{
                        if(Alfabeto.isConstante(token)){
                            constante(token,lin,col);
                        }
                        else{
                            if (!token.equals("\n") && !token.equals(" ") && !token.equals("\t")){
                                erro(token,lin,col);
                            }
                        }
                    }
                }
            }
        }
        
    }
    
    //--------------------Armazenamento de dados---------------------//
    
    public static void erro(String token, int linha, int coluna){
        Erro i = new Erro(token,linha,coluna);
        ArrayErros.add(i);
        ArrayFita.add(i);
    }
    
    public static void reservada(String token, int linha, int coluna){
        Reservada i = new Reservada(token,linha,coluna);
        ArrayReservados.add(i);
        ArrayFita.add(i);
    }
    
    public static void operador(String token, int linha, int coluna){
        Operador i = new Operador(token,linha,coluna);
        ArrayOperadores.add(i);
        ArrayFita.add(i);
    }
    
    public static void terminador(String token, int linha, int coluna){
        Terminador i = new Terminador(token,linha,coluna);
        ArrayTerminadores.add(i);
        ArrayFita.add(i);
    }
    
    public static void identificador(String token, int linha, int coluna){
        Identificador i = new Identificador(token,linha,coluna);
        ArrayIdentificadores.add(i);
        ArrayFita.add(i);
    }
    
    public static void constante(String token, int linha, int coluna){
        Constante i = new Constante(token,linha,coluna);
        ArrayConst.add(i);
        ArrayFita.add(i);
    }
    
    public static void limparArrays(){
        ArrayIdentificadores.clear();
        ArrayConst.clear();
        ArrayErros.clear();
        ArrayReservados.clear();
        ArrayOperadores.clear();
        ArrayTerminadores.clear();
        ArrayFita.clear();
    }
    
}
