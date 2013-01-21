/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;


import br.gov.saudecaruaru.bpai.business.model.BIFamilia;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Junior Pires
 */
public class FamiliaTableModel extends AbstractTableModel {  
      
    private List portes;  
      
    public FamiliaTableModel(List portes) {  
        this.portes = portes;  
    }  
      
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {  
        BIFamilia familia = (BIFamilia) portes.get(rowIndex);  
          
        if (familia != null) {  
              
            switch (columnIndex) {  
                case 0: return familia.getSegmento();  
                case 1: return familia.getArea();  
                case 2: return familia.getMicroArea();  
                case 3: return familia.getFamilia();  
            }  
        }  
          
        return null;  
    }  
  
    @Override
    public int getRowCount() {  
        if (portes != null) {  
            return this.portes.size();  
        }  
          
        return 0;  
    }  
  
    @Override
    public int getColumnCount() {  
        return 4;  
    }  
      
    public BIFamilia getPorte(int row) {  
        if (row >= 0) {  
            return (BIFamilia) this.portes.get(row);  
        }  
          
        return null;  
    }  
}