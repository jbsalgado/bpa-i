/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.validators;


import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    private JTextField textFieldMes;
    private JTextField textFieldAno;
    private JTextField textFieldDtNasc;
    
    private static final String DATA_INICIO = "30/09/2007";
    
    public DataAtendimentoVerifier(Component component,String fieldName,JTextField textFieldMes,JTextField textFieldano,JTextField textFielDtNasc) {
        this.fieldName = fieldName;
        this.component = component;
        this.textFieldAno =  textFieldano;
        this.textFieldMes = textFieldMes;
        this.textFieldDtNasc = textFielDtNasc;
    }
    
    

    @Override
    public boolean verify(JComponent input) {
       Date dataInicio;
       Date dataNasc;
       Date dataAtend;
       JTextField txtField = (JTextField) input;
       String valor = txtField.getText();
       String valorDtNas = textFieldDtNasc.getText();
       
       SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      
      try{
            format.setLenient(false);
            dataInicio = format.parse(DataAtendimentoVerifier.DATA_INICIO);
            dataNasc = format.parse(valorDtNas);
            dataAtend = format.parse(valor);
       }catch(ParseException e){
         JOptionPane.showMessageDialog(this.component,fieldName+" INVÁLIDA!"
                   ,"Erro de validação!", JOptionPane.ERROR_MESSAGE);
         txtField.setBackground(Color.RED); 
           return false;
       }
      
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
       txtField.setBackground(Color.WHITE);
       return true;
    }
    
}
