/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.bussines.hibernatevalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CepValidator implements
            ConstraintValidator<Cep, String> {
 
  private Pattern pattern = 
          Pattern.compile("[0-9]{5}-[0-9]{3}");
 
  private int min;
  @Override
  public void initialize(Cep constraintAnnotation) {
     min= constraintAnnotation.min();
  }
 
  @Override
  public boolean isValid(String value, 
           ConstraintValidatorContext context) {
    Matcher m = pattern.matcher(value);
    if(min<30)
        return true;
    return m.matches();
  }
 
}

