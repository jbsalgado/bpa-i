/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.util;

import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Albuquerque
 */
public class ProcedimentoRealizadoTableModel extends AbstractTableModel{

    private String[] columns= new String[]{"CNS Usuário", "Nome","Dt.Nasc",
                                            "Sexo","Munic.Residência","Dt.Atendimento",
                                            "Procedimento","QTD.","CID","Car.Atend.",
                                            "Núm.Autor.","Raça/Cor","Etnia","Nacionalidade"};
    
    private List<ProcedimentoRealizado> list;
    
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
            case 0: return p.getCnsPaciente();
                
            case 1: return p.getNomePaciente();
                
            case 2: return p.getCodigoIBGECidadePaciente();
                
            case 3: return p.getProcedimentoRealizadoPK().getDataAtendimento();
                
            case 4: return p.getProcedimentoRealizadoPK().getCodigoProcedimento();
                
            case 5: return p.getQuantidadeRealizada();
                
            case 6: return p.getCidDoencaprocedimento();
                
            case 7: return p.getCaracterizacaoAtendimento();
                
            case 8: return p.getNumeroAutorizacao();
                
            case 9: return p.getRacaPaciente();
                
            case 10: return p.getEtniaPaciente();
            
            case 11: return p.getNacionalidadePaciente();
                
            default:
                    return "Ops!!! Erro";
        }
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
            case 0:
                    model.setCnsPaciente(aValue.toString());
                    break;
            case 1:
                    model.setNomePaciente(aValue.toString());
                    break;
            case 2:
                    model.setCodigoIBGECidadePaciente(aValue.toString());
                    break;
            case 3:
                    model.getProcedimentoRealizadoPK().setDataAtendimento(aValue.toString());
                    break;
            case 4:
                    model.getProcedimentoRealizadoPK().setCodigoProcedimento(aValue.toString());
                    break;
            case 5:
                    model.setQuantidadeRealizada(Double.valueOf(aValue.toString()));
                    break;
            case 6:
                    model.setCidDoencaprocedimento(aValue.toString());
                    break;
            case 7:
                    model.setCaracterizacaoAtendimento(aValue.toString());
                    break;
            case 8:
                    model.setNumeroAutorizacao(aValue.toString());
                    break;
            case 9:
                    model.setRacaPaciente(aValue.toString());
                    break;
            case 10:
                    model.setEtniaPaciente(aValue.toString());
                    break;
            case 11:
                    model.setNacionalidadePaciente(aValue.toString());
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
        fireTableCellUpdated(rowIndex, 7);
        fireTableCellUpdated(rowIndex, 8);
        fireTableCellUpdated(rowIndex, 9);
        fireTableCellUpdated(rowIndex, 10);
        fireTableCellUpdated(rowIndex, 11);
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
    
    public void addProcedimentoRealizadoAll(List<ProcedimentoRealizado> model){
        
        int oldSize=this.getRowCount();
        
        
        this.list.addAll(model);
        
        
        this.fireTableRowsInserted(oldSize, this.getRowCount()-1);
        
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
