/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.util;

import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizadoPK;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Albuquerque
 */
public class ProcedimentoRealizadoTableModelHeader extends AbstractTableModel{

    private String[] columns= new String[]{"CNES","COMPETÊNCIA","CNS DO PROFISSIONAL","PROFISSIONAL","CBO","FOLHA"};
    
    private List<ProcedimentoRealizado> list;

    public ProcedimentoRealizadoTableModelHeader(List<ProcedimentoRealizado> list) {
        this.list = list;
    }
    
   
    
    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProcedimentoRealizado p=this.list.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getProcedimentoRealizadoPK().getCnesUnidade();
                
            case 1: return p.getProcedimentoRealizadoPK().getCompetencia();
                
            case 2: return p.getProcedimentoRealizadoPK().getCnsMedico();
                
            case 3: return p.getNomeProfissional();
                
            case 4: return p.getProcedimentoRealizadoPK().getCboMedico();
                
            case 5: return p.getProcedimentoRealizadoPK().getNumeroFolha();
                
            default:
                    return "Ops!!! Erro";
        }
    }
    
    public ProcedimentoRealizado getCloneElementList(int rowIndex){
          ProcedimentoRealizado p=this.list.get(rowIndex);
        try {
            ProcedimentoRealizado pClone =(ProcedimentoRealizado) p.clone();
            pClone.setProcedimentoRealizadoPK((ProcedimentoRealizadoPK) p.getProcedimentoRealizadoPK().clone());
            return pClone;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ProcedimentoRealizadoTableModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    public List<ProcedimentoRealizado> getList() {
        return list;
    }
    
    public List<ProcedimentoRealizado> getListWithOutEmptyElements(){
        List<ProcedimentoRealizado> listNotEmpty = new ArrayList<ProcedimentoRealizado>();
         for(ProcedimentoRealizado p : this.list){
            if(p.getProcedimentoRealizadoPK().getCnesUnidade()!=null){
               listNotEmpty.add(p);
            }
        }
          return listNotEmpty;
    }
    public ProcedimentoRealizado getCloneElementListEmpty() {
        for(ProcedimentoRealizado p : this.list){
            if(p.getProcedimentoRealizadoPK().getCnesUnidade()==null){
                try {
                    ProcedimentoRealizado pClone =(ProcedimentoRealizado) p.clone();
                     pClone.setProcedimentoRealizadoPK((ProcedimentoRealizadoPK) p.getProcedimentoRealizadoPK().clone());
                    return pClone;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(ProcedimentoRealizadoTableModel.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
            }
        }
        return null;
       
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
    
     @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //pega o produto da linha
        ProcedimentoRealizado model = this.list.get(rowIndex);
 
        //verifica qual valor vai ser alterado
        switch(columnIndex){
            case 0: model.getProcedimentoRealizadoPK().setCnesUnidade(aValue.toString());
                    break;
            case 1:
                    model.getProcedimentoRealizadoPK().setCompetencia(aValue.toString());
                    break;
            case 2:
                    model.getProcedimentoRealizadoPK().setCnsMedico(aValue.toString());
                    break;
            case 3: model.setNomeProfissional(aValue.toString());
                    break;
            case 4: model.getProcedimentoRealizadoPK().setCboMedico(aValue.toString());
                    break;
            case 5:
                    model.getProcedimentoRealizadoPK().setNumeroFolha(aValue.toString());
                    break;
            default:
                    ;
        }
 
        //avisa que os dados mudaram
        fireTableCellUpdated(rowIndex, columnIndex); 
    }
    
    public void setValueAt(ProcedimentoRealizado aValue, int rowIndex) {
        //pega o produto da linha
        this.list.set(rowIndex, aValue);
 
 
        //avisa que os dados mudaram
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
        fireTableCellUpdated(rowIndex, 5);
        fireTableCellUpdated(rowIndex, 6);
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //no nosso caso todas vão ser editáveis, entao retorna true pra todas
        return false;
    } 
    
    public void removeProcedimentoRealizado(int indexRow){
        this.list.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow); 
    }
    
    public void addProcedimentoRealizado(ProcedimentoRealizado model){
        this.list.add(model);
        
        int ultimoIndex=this.getRowCount()-1;
        
        
        this.fireTableRowsInserted(ultimoIndex, ultimoIndex);
        
    }
    
 
    
   
    
    public ProcedimentoRealizado getProcedimentoRealizado(int index){
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
