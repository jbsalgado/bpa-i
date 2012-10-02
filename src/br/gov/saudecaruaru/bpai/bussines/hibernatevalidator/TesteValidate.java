/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.bussines.hibernatevalidator;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class TesteValidate {

 public static void main(String[] args) {
  //Nome menor que 5, email invalido
  Cliente cliente = new Cliente("00000000000");
  
  ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        
  Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
  
  
  for(ConstraintViolation<Cliente> error : constraintViolations){
   System.out.println(error.getMessage());
  }
 }
}