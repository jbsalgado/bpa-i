/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

/**
 *
 * @author Junior Pires
 */
public interface Observer {
    public void update(Subject sub,Object arg);
}
