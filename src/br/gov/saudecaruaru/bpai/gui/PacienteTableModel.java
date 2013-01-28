/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;


import br.gov.saudecaruaru.bpai.business.model.BIFamilia;
import br.gov.saudecaruaru.bpai.business.model.BIPaciente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Junior Pires
 */
public class PacienteTableModel extends AbstractTableModel {  
      
    private List pacientes;  
      
    public PacienteTableModel(List portes) {  
        this.pacientes = portes;  
    }  
      
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {  
        BIPaciente paciente = (BIPaciente) pacientes.get(rowIndex);  
          
        if (paciente != null) {  
              
            switch (columnIndex) {  
                case 0: return paciente.getCns();  
                case 1: return paciente.getNome();  
                case 2: {
                            if(paciente.getFamilia()!=null){
                                return paciente.getFamilia().getId();
                            }else
                                return "";
                        }
                  
            }  
        }  
          
        return null;  
    }  
  
    @Override
    public int getRowCount() {  
        if (pacientes != null) {  
            return this.pacientes.size();  
        }  
          
        return 0;  
    }  
  
    @Override
    public int getColumnCount() {  
        return 3;  
    }  
      
    public BIPaciente getPaciente(int row) {  
        if (row >= 0) {  
            return (BIPaciente) this.pacientes.get(row);  
        }  
          
        return null;  
    }  
}