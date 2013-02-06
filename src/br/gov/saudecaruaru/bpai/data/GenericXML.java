/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

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
import org.apache.log4j.Logger;

/**
 *
 * @author Albuquerque
 */
public class GenericXML<T extends Serializable >  {
    
    private XStream stream= new XStream(new DomDriver());
    private Logger logger;
    private Class<T> classType;
    
    public GenericXML(){
      classType=  (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
      this.stream.alias(classType.getSimpleName().toLowerCase()+"_lista", List.class);
     this.stream.alias(classType.getSimpleName(), classType);
     this.stream.processAnnotations(classType);
     this.logger=Logger.getLogger(classType);
    }
    
    public boolean salvar(List<T> object,String filePath){
        boolean sucess=false;
        try {
            FileOutputStream out=new FileOutputStream(filePath);
            out.write(this.stream.toXML(object).getBytes());
            out.close();
            sucess=true;
        } catch (FileNotFoundException ex) {
            logger.error("erro ao exceutar o o método salvar(List<T> object,String filePath) "+ex.getMessage());
            return false;
        }catch (IOException ex) {
            logger.error("erro ao exceutar o o método salvar(List<T> object,String filePath) "+ex.getMessage());
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
            logger.error("erro ao exceutar o o método carregar(String filePath) "+ex.getMessage());
        } catch (IOException ex) {
            logger.error("erro ao exceutar o o método carregar(String filePath) "+ex.getMessage());
        }
        finally{
            return list;
        }
    }

}
