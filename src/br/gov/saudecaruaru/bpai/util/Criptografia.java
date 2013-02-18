/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albuquerque
 */
public class Criptografia {
    
    private static final char[] hexaDigitos="0123456789abcdef".toCharArray();
    
    public static String md5(String value){
        String resposta=null;
        try {
            MessageDigest digest=MessageDigest.getInstance("MD5");
            digest.update(value.getBytes());
            StringBuilder sb= new StringBuilder(32);
            for (byte b: digest.digest()) {
                sb.append(hexaDigitos[(b >> 4) & 0x0f]);
        sb.append(hexaDigitos[b & 0x0f]);
            }
            resposta=sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            return resposta;
        }
    }
    
}
