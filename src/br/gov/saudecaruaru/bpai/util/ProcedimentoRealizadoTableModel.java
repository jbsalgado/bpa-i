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
public class ProcedimentoRealizadoTableModel extends AbstractProcedimentoRealizadoTableModel{

   

    public ProcedimentoRealizadoTableModel(List<ProcedimentoRealizado> list) {
        super(list);
        String[] columns= new String[]{"Seq.","CNS Usuário", "Nome","Dt.Nasc",
                                            "Sexo","Munic.Residência","Dt.Atendimento",
                                            "Procedimento","QTD.","CID","Car.Atend.",
                                            "Núm.Autor.","Raça/Cor","Etnia","Nacionalidade"};
        this.setColumns(columns);
    }


    @Override
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
                
            case 7: return p.getCodigoProcedimento();
                
            case 8: return p.getQuantidadeRealizada();
                
            case 9: return p.getCidDoencaprocedimento();
                
            case 10: return p.getCaracterizacaoAtendimento();
                
            case 11: return p.getNumeroAutorizacao();
                
            case 12: return p.getRacaPaciente();
                
            case 13: return p.getEtniaPaciente();
            
            case 14: return p.getNacionalidadePaciente();
                
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
            case 7:
                    model.setCodigoProcedimento(aValue.toString());
                    break;
            case 8:
                    model.setQuantidadeRealizada(Double.valueOf(aValue.toString()));
                    break;
            case 9:
                    model.setCidDoencaprocedimento(aValue.toString());
                    break;
            case 10:
                    model.setCaracterizacaoAtendimento(aValue.toString());
                    break;
            case 11:
                    model.setNumeroAutorizacao(aValue.toString());
                    break;
            case 12:
                    model.setRacaPaciente(aValue.toString());
                    break;
            case 13:
                    model.setEtniaPaciente(aValue.toString());
                    break;
            case 14:
                    model.setNacionalidadePaciente(aValue.toString());
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
        fireTableCellUpdated(rowIndex, 7);
        fireTableCellUpdated(rowIndex, 8);
        fireTableCellUpdated(rowIndex, 9);
        fireTableCellUpdated(rowIndex, 10);
        fireTableCellUpdated(rowIndex, 11);
        fireTableCellUpdated(rowIndex, 12);
        fireTableCellUpdated(rowIndex, 13);
        fireTableCellUpdated(rowIndex, 14);
        fireTableCellUpdated(rowIndex, 15);
    }
    
}
