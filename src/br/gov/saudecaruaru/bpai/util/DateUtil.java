/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.util;

import br.gov.saudecaruaru.bpai.gui.validators.DataAtendimentoVerifier;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Junior Pires
 */
public class DateUtil {
    
    public static int getAge(Date dataNasc,Date data){
        
        Calendar dateOfBirth = new GregorianCalendar();
        Calendar today = new GregorianCalendar();
       
        dateOfBirth.setTime(dataNasc);
        
        today.setTime(data);
        
        // Cria um objeto calendar com a data atual
       
        
        // Obtém a idade baseado no ano
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        
        dateOfBirth.add(Calendar.YEAR, age);
        
        //se a data de hoje é antes da data de Nascimento, então diminui 1(um)
        if (today.before(dateOfBirth)) {
            age--;
        }
        return age;
    }
    
     public static int getAge(String dataNasc,String data){
          SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
          Date dateNasc;
          Date date;
      
      try{
            format.setLenient(false);
            
            dateNasc = format.parse(dataNasc);
            date = format.parse(data);
            return getAge(dateNasc,date);
       }catch(ParseException e){
        e.printStackTrace();
        return 0;
       }
        
     }
     
     
      public static Date parserStringToDate(String formato,String date){
         //formato ex: dd/MM/yyyy
         SimpleDateFormat format = new SimpleDateFormat(formato);
         
         //int index = 10 - formato.length();
         format.setLenient(false);
         
        try {
            return format.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
