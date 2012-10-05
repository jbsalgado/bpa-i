/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.util;

import br.gov.saudecaruaru.bpai.gui.verifiers.DataAtendimentoVerifier;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
          SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
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
            return null;
        }
    }
      
      
    public static String parseToYearMonthDay(String date){
        String dateParsing = null;
        String[] strings;
        //obtem cada campo da data com o metodo split
        strings = date.split("/");       
        //inverte a ordem dos campos para Y/m/d
        dateParsing = strings[2]+strings[1]+strings[0];
        
        
        return dateParsing;
    }
     
     //metodo onde é passado uma string de data no formato YYYYMMdd e é
     // retornado no formato ddMMYYYY ou dd/MM/YYYY caso o flag seja true
     public static String parseToDayMonthYear(String date,boolean flag){
        String dateParsing="";
        
       
        
        if(date!=null){
            if(date.length()==8){
             String year = date.substring(0, 4); 
             String month = date.substring(4, 6); 
             String day = date.substring(6, 8);     
                if(flag==true){
                    dateParsing = day+"/"+month+"/"+year;
                }
                else{
                    dateParsing = day+month+year;
                }    

            }
       }
        return dateParsing;
    }
     
     
     public static boolean isValidBrDate(String date){
       Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3}$"); 
       Matcher m = p.matcher(date);
       if(!m.find()){
         return false;
       }
       return true;
     }
}
