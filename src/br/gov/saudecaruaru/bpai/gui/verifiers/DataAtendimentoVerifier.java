/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;


import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
import br.gov.saudecaruaru.bpai.gui.TelaCadastroI;
import br.gov.saudecaruaru.bpai.util.DateUtil;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
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
       
       
//       if(proRealizado.getDataNascimentoPaciente()==null){
//           MessagesErrors.erro(component,txtField,"Preencha a data de nascimento!"); 
//           txtField.setBackground(Color.WHITE);
//           return true;
//       }
       //VALIDA O FORMATO DA DATA
       if(!DateUtil.isValidBrDate(valor)){
           MessagesErrors.erro(component,txtField,fieldName+" INCORRETO!"
                   +"\n FORMATO INVALIDO"); 
           return false;
       }
       
     
       
       SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      
      try{
            format.setLenient(false);
            dataInicio = format.parse(DataAtendimentoVerifier.DATA_INICIO);
            dataAtend = format.parse(valor);
       }catch(ParseException e){
         MessagesErrors.erro(component,txtField,fieldName+" INVÁLIDA!"); 
 
           return false;
       }
      
       Date competencia = DateUtil.parserStringToDate("yyyyMM", proRealizado.getProcedimentoRealizadoPK().getCompetencia());
       Date dataAtendMesAno = DateUtil.parserStringToDate("MM/yyyy", valor.substring(3));
       
       
       if(dataAtend.before(dataInicio)){
           MessagesErrors.erro(component,txtField,fieldName+" DEVE SER MAIOR QUE "+DataAtendimentoVerifier.DATA_INICIO
                   +"!" );  
           return false;
       }
       
       if(proRealizado.getDataNascimentoPaciente()!=null){
            String valorDtNas = proRealizado.getDataNascimentoPaciente();
            Date dataNasc = DateUtil.parserStringToDate("yyyyMMdd", valorDtNas);
            if(dataAtend.before(dataNasc)){
                MessagesErrors.erro(component,txtField," DATA DE NASCIMENTO MAIOR QUE A DATA DE ATENDIMENTO!");
                return false;
            }
       }
       txtField.setBackground(Color.WHITE);
      
       return true;
    }
    
}
