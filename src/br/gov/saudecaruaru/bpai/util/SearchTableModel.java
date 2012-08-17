/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Albuquerque
 */
public class SearchTableModel extends  AbstractTableModel{
    
    
    private String[] columns= new String[2];
    
    private List<Search> list;

    public SearchTableModel(List<Search> list, String columnId, String ColumnDescription) {
        this.list = list;
        this.columns[0]=columnId;
        this.columns[1]=ColumnDescription;
    }

    public SearchTableModel(String columnId, String ColumnDescription) {
        this.list= new ArrayList<Search>();
        this.columns[0]=columnId;
        this.columns[1]=ColumnDescription;
    }
    
    

 public int getRowCount() {
        //cada produto na lista será uma linha
        return this.list.size();
    }
 
    public int getColumnCount() {
        //vamos exibir só Nome e Quantidade, então são 2 colunas
        return this.columns.length;
    }
 
    @Override
    public String getColumnName(int column) {
        
        return this.columns[column];
    }
 
    @Override
    public Class getColumnClass(int columnIndex) {
        //retorna a classe que representa a coluna
        return String.class;
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        //pega o produto da linha
        Search model = this.list.get(rowIndex);
 
        //verifica qual valor deve ser retornado
        switch(columnIndex){
            case 0:
                    return model.getId();
            case 1:
                    return model.getDescription();
            default:
                    return "";
        }
    }
 
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //pega o produto da linha
        Search model = this.list.get(rowIndex);
 
        //verifica qual valor vai ser alterado
        switch(columnIndex){
            case 0:
                    model.setId(aValue.toString());
                    break;
            case 1:
                    model.setDescription(aValue.toString());
            default:
                    ;
        }
 
        //avisa que os dados mudaram
        fireTableCellUpdated(rowIndex, columnIndex); 
    }
    
    public void setValueAt(Search aValue, int rowIndex) {
        //pega o produto da linha
        Search model = this.list.get(rowIndex);
 
        //verifica qual valor vai ser alterado
        model.setId(aValue.getId());
        model.setDescription(aValue.getDescription());
 
        //avisa que os dados mudaram
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //no nosso caso todas vão ser editáveis, entao retorna true pra todas
        return false;
    } 
    
    public void removeSearch(int indexRow){
        this.list.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow); 
    }
    
    public void addSearch(Search model){
        this.list.add(model);
        
        int ultimoIndex=this.getRowCount()-1;
        
        
        this.fireTableRowsInserted(ultimoIndex, ultimoIndex);
        
    }
    
    public void addSearchAll(List<Search> model){
        
        int oldSize=this.getRowCount();
        
        
        this.list.addAll(model);
        
        
        this.fireTableRowsInserted(oldSize, this.getRowCount()-1);
        
    }
    
    public Search getSearch(int index){
        return this.list.get(index);
    }
    
    public void clean(){
        this.list.clear();
        fireTableDataChanged();
    }
    
    public boolean isEmpty(){
        return this.list.isEmpty();
    }
}
