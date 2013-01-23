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
      
    private List familias;  
      
    public FamiliaTableModel(List portes) {  
        this.familias = portes;  
    }  
      
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {  
        BIFamilia familia = (BIFamilia) familias.get(rowIndex);  
          
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
        if (familias != null) {  
            return this.familias.size();  
        }  
          
        return 0;  
    }  
  
    @Override
    public int getColumnCount() {  
        return 4;  
    }  
      
    public BIFamilia getFamilia(int row) {  
        if (row >= 0) {  
            return (BIFamilia) this.familias.get(row);  
        }  
          
        return null;  
    }  
}