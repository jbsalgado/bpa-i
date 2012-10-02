/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.bussines.hibernatevalidator;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;


import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Junior Pires
 */
@Constraint(validatedBy = CepValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cep {
   
  String message() default "Cep inválido";
  Class<?>[] groups() default { };
  Class<? extends Payload>[] payload() default { };
  
  int min() default 1;
 
}
