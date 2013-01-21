/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.XMLAlias;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albuquerque
 */
public class GenericXML<T extends Serializable >  {
    
    private XStream stream= new XStream(new DomDriver());
    private Class<T> classType;
    
    public GenericXML(){
      classType=  (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
      this.stream.alias(classType.getSimpleName().toLowerCase()+"_lista", List.class);
     this.stream.alias(classType.getSimpleName(), classType);
     this.stream.processAnnotations(classType);
    }
    
    public boolean salvar(List<T> object,String filePath){
        boolean sucess=false;
        try {
            FileOutputStream out=new FileOutputStream(filePath);
            out.write(this.stream.toXML(object).getBytes());
            out.close();
            sucess=true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenericXML.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }catch (IOException ex) {
            Logger.getLogger(GenericXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            return sucess;
        }
    }
    
    public List<T> carregar(String filePath){
        List<T> list= new ArrayList<T>();
        try {
            BufferedReader input= new BufferedReader(new FileReader(filePath));
            list= (List<T>)this.stream.fromXML(input);
            input.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenericXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenericXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            return list;
        }
    }

}
