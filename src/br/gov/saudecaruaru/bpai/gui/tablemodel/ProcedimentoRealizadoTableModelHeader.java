/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.tablemodel;

import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import java.util.List;

/**
 *
 * @author Albuquerque
 */
public class ProcedimentoRealizadoTableModelHeader extends AbstractProcedimentoRealizadoTableModel{


    public ProcedimentoRealizadoTableModelHeader(List<ProcedimentoRealizado> list) {
        super(list);
        String[] columns= new String[]{"CNES","COMPETÊNCIA","CNS DO PROFISSIONAL","PROFISSIONAL","CBO","FOLHA"};
        this.setColumns(columns);
    }

   
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProcedimentoRealizado p=this.getList().get(rowIndex);
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

    
  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //pega o produto da linha
        ProcedimentoRealizado model = this.getList().get(rowIndex);
 
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
