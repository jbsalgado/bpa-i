/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.validators;


import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.gui.TelaCadastroI;
import br.gov.saudecaruaru.bpai.util.DateUtil;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Junior Pires
 */
public class DataAtendimentoVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;
    private JTextField fieldDatanasc;
    private TelaCadastroI t;
    
    private static final String DATA_INICIO = "30/09/2007";
    
    public DataAtendimentoVerifier(Component component,String fieldName,TelaCadastroI t,JTextField fieldDatanasc) {
        this.fieldName = fieldName;
        this.component = component;
        this.t = t;
        this.fieldDatanasc = fieldDatanasc;
    }
    
    

    @Override
    public boolean verify(JComponent input) {
       Date dataInicio;
       Date dataAtend;
       
       JTextField txtField = (JTextField) input;
       
       ProcedimentoRealizado proRealizado = t.getProcedimentoRealizado();
       
       String valor = txtField.getText();
       String valorDtNas = proRealizado.getDataNascimentoPaciente();
       
       SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      
      try{
            format.setLenient(false);
            dataInicio = format.parse(DataAtendimentoVerifier.DATA_INICIO);
            dataAtend = format.parse(valor);
       }catch(ParseException e){
         JOptionPane.showMessageDialog(this.component,fieldName+" INVÁLIDA!"
                   ,"Erro de validação!", JOptionPane.ERROR_MESSAGE);
         txtField.setBackground(Color.RED); 
           return false;
       }
      
       Date competencia = DateUtil.parserStringToDate("yyyyMM", proRealizado.getProcedimentoRealizadoPK().getCompetencia());
       Date dataAtendMesAno = DateUtil.parserStringToDate("MM/yyyy", valor.substring(3));
       Date dataNasc = DateUtil.parserStringToDate("yyyyMMdd", valorDtNas);
       
       if(dataAtend.before(dataInicio)){
           JOptionPane.showMessageDialog(this.component,fieldName+" DEVE SER MAIOR QUE "+DataAtendimentoVerifier.DATA_INICIO
                   +"!"
                   ,"Erro de validação!", JOptionPane.ERROR_MESSAGE);
         txtField.setBackground(Color.RED); 
           return false;
       }else if(dataAtend.before(dataNasc)){
         JOptionPane.showMessageDialog(this.component," DATA DE NASCIMENTO MAIOR QUE A DATA DE ATENDIMENTO!"
                   ,"Erro de validação!", JOptionPane.ERROR_MESSAGE);
         txtField.setBackground(Color.RED); 
           return false;
       }
//       else if(dataAtendMesAno.after(competencia)){
//         JOptionPane.showMessageDialog(this.component," A DATA DE ATENDIMENTO NÃO DEVE SER MAIOR QUE A COMPETÊNCIA ATUAL!"
//                   ,"Erro de validação!", JOptionPane.ERROR_MESSAGE);
//         txtField.setBackground(Color.RED); 
//           return false;
//       }
       txtField.setBackground(Color.WHITE);
      
       return true;
    }
    
}
