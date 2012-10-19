/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.util;

import br.gov.saudecaruaru.bpai.data.BIProcedimentoRealizadoDAO;
import br.gov.saudecaruaru.bpai.data.ProcedimentoDAO;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albuquerque
 */
public class ModelUtil {
    
    public static final String PACOTE_MODEL="br.gov.saudecaruaru.bpai.business.model";
    public static final String COMPETENCIA_MAIS_RECENTE=new ProcedimentoDAO().getMaxCompetencia();
    
    public static Map<String, Object> getRestrictions(Object object){
        Class classes=object.getClass();

        //Cria um map para armazenar os valores
        Map<String, Object> restrictions= new HashMap<String, Object>();
        //verifica se o objeto está dentro do pacote model
        if(classes.getPackage().getName().equals(ModelUtil.PACOTE_MODEL)){
            for(Field f: classes.getDeclaredFields()){
                f.setAccessible(true);
                //para cada campo declarado na classe vai varrê-lo
                try {
                    //verifica se o campo possui valor/referência
                    Object obj=f.get(object);
                    if(obj!=null){
                        if(f.isAnnotationPresent(javax.persistence.EmbeddedId.class)||f.isAnnotationPresent(javax.persistence.Column.class) ){
                            //verifica se o campo é um objeto de alguma classe do pacote model
                            //se for,vai chamar o método novamente
                            if(obj.getClass().getPackage().getName().equals(ModelUtil.PACOTE_MODEL)){
                                //pega o map devolvido e monta o nome dos atributos com o valor
                                Map<String, Object> m= ModelUtil.getRestrictions(obj);
                                for(String key: m.keySet()){
                                    restrictions.put(f.getName()+"."+key, m.get(key));
                                }
                            }
                            else{
                                restrictions.put(f.getName(), f.get(object));
                            }
                        
                     }
                        
                    }
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ModelUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ModelUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return restrictions;
    }
    
    public static Map<String,String > getMapSearch(List list,String fieldId,String fieldDescription){
        HashMap<String, String> map= new HashMap<String, String>();
        if(!list.isEmpty()){
            for(Object object: list){
                if(object!=null){
                    String str1=ModelUtil.getValueField(object, fieldId);
                    String str2=ModelUtil.getValueField(object, fieldDescription);
                    if(str1!=null && str2!=null){
                        map.put(str1, str2);
                    }
                }
            }
        }
        return map;
    }
    
    public static List<Search> getListSearch(List list,String fieldId,String fieldDescription){
        List<Search> listSearch= new ArrayList<Search>();
        if(!list.isEmpty()){
            for(Object object: list){
                if(object!=null){
                    String str1=ModelUtil.getValueField(object, fieldId);
                    String str2=ModelUtil.getValueField(object, fieldDescription);
                    if(str1!=null && str2!=null){
                        listSearch.add(new Search(str1, str2.toUpperCase()));
                    }
                }
            }
        }
        return listSearch;
    }
    
    public static String getValueField(Object object,String field) {
        String value=null;
        if(object!=null){
            Object objectField=object;
            
            String[] vetId=field.replace(".", ";").split(";");
            
            //caso campo seja de vários níveis, vai percorrê-lo. Exemplo: endereco.cidade.cep
            if(vetId.length>1){
                for(int i=0;i<vetId.length;i++){
                    field=vetId[i];
                    //vai pegar a classe, depois o campo e o objeto que ela guarda
                    if(i>0){
                        try {
                              Field f=objectField.getClass().getDeclaredField(vetId[i-1]);
                              f.setAccessible(true);
                              objectField=f.get(objectField);
                        } catch (NoSuchFieldException ex) {
                            Logger.getLogger(ModelUtil.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SecurityException ex) {
                            Logger.getLogger(ModelUtil.class.getName()).log(Level.SEVERE, null, ex);
                        }catch (IllegalArgumentException ex) {
                            Logger.getLogger(ModelUtil.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(ModelUtil.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            try {
                
                Class classes=objectField.getClass();
                Field fId=classes.getDeclaredField(field);
                
                fId.setAccessible(true);
                Object ob1=fId.get(objectField);
                value= ob1!=null?ob1.toString():null;
                
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(ModelUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(ModelUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
             catch (IllegalArgumentException ex) {
                Logger.getLogger(ModelUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ModelUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return value;
    }
    
    public static String completar(String str,int tamanho, Character caractere){
        if((str == null ? false: !(str.length()>=tamanho))){
            StringBuilder s= new StringBuilder();
            for(int i=str.length();i<tamanho;i++){
                s.append(caractere);
            }
            s.append(str);
            return s.toString();
        }
        return str;
    }
}
