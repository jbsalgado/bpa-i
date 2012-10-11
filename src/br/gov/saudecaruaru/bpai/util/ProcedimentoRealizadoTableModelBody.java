/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.util;

import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import java.util.List;

/**
 *
 * @author Albuquerque
 */
public class ProcedimentoRealizadoTableModelBody  extends AbstractProcedimentoRealizadoTableModel{
 

    public ProcedimentoRealizadoTableModelBody(List<ProcedimentoRealizado> list) {
        super(list);
         String[] columns= new String[]{"SEQ","CNS","PACIENTE","DT. NASCIMENTO","SEXO","MUNICÍPIO","DT. ATENDIMENTO"};
        this.setColumns(columns);
    }
    
    

    
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProcedimentoRealizado p=this.getList().get(rowIndex);
        switch(columnIndex){
            case 0: return p.getProcedimentoRealizadoPK().getSequenciaFolha();
                
            case 1: return p.getCnsPaciente();
                
            case 2: return p.getNomePaciente();
                
            case 3: return DateUtil.parseToDayMonthYear(p.getDataNascimentoPaciente(),true);
                
            case 4: return p.getSexoPaciente();
                
            case 5: return p.getCodigoIBGECidadePaciente();
                
            case 6: return  DateUtil.parseToDayMonthYear(p.getDataAtendimento(),true);
                
            default:
                    return "Ops!!! Erro";
        }
    }
    
     @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //pega o produto da linha
        ProcedimentoRealizado model = this.getList().get(rowIndex);
 
        //verifica qual valor vai ser alterado
        switch(columnIndex){
            case 0: model.getProcedimentoRealizadoPK().setSequenciaFolha(aValue.toString());
                    break;
            case 1:
                    model.setCnsPaciente(aValue.toString());
                    break;
            case 2:
                    model.setNomePaciente(aValue.toString());
                    break;
            case 3: model.setDataNascimentoPaciente(aValue.toString());
                    break;
            case 4: model.setSexoPaciente(aValue.toString());
                    break;
            case 5:
                    model.setCodigoIBGECidadePaciente(aValue.toString());
                    break;
            case 6:
                    model.setDataAtendimento(aValue.toString());
                    break;
            default:
                    ;
        }
 
        //avisa que os dados mudaram
        fireTableCellUpdated(rowIndex, columnIndex); 
    }
    
    @Override
    public void setValueAt(ProcedimentoRealizado aValue, int rowIndex) {
        //pega o produto da linha
        this.getList().set(rowIndex, aValue);
 
 
        //avisa que os dados mudaram
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
        fireTableCellUpdated(rowIndex, 5);
        fireTableCellUpdated(rowIndex, 6);
    }
}
