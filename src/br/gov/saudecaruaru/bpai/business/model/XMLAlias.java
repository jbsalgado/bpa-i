/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.util.Map;

/**
 *
 * @author Albuquerque
 */
public interface XMLAlias {
    
    public Map<String,String> getAliasAttributes();
    
    public Map<String,String> getAliasFields();
    
    public Map<String,Class> getAlias();
}
