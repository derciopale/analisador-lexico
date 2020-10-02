/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

/**
 *
 * @author Dercio Pale
 */
public class Erro {
    private String cadeia;
    private int linha;
    private int coluna;
    
    public Erro() {
        
    }

    public Erro(String cadeia, int linha, int coluna) {
        this.cadeia = cadeia;
        this.linha = linha;
        this.coluna = coluna;
    }
    

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
        
    
    public String getCadeia() {
        return cadeia;
    }

    public void setCadeia(String cadeia) {
        this.cadeia = cadeia;
    }

    @Override
    public String toString() {
        return " " + cadeia + " [" + linha +", "+ coluna + "] ;";
    }
    
}
