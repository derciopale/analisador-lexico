/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import analise.Lexica;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import tokens.Identificador;


/**
 *
 * @author Dercio Pale
 */
public class ModeloTabela extends AbstractTableModel{

    private ArrayList<Lexica> lista;
    String colunas [] ;

    public ModeloTabela(ArrayList<Lexica> lista, String[] colunas) {
        this.lista = lista;
        this.colunas = colunas;
    }
    
    
    public void setLista(ArrayList<Lexica> tokens){
        lista = tokens;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    
}
