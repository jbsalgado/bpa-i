/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import br.gov.saudecaruaru.bpai.data.BICnesAreaDAO;
import br.gov.saudecaruaru.bpai.data.BICnesMicroareaDAO;
import java.io.*;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juniorpires
 */
public class ArquivoCnes{
    
    private File arquivo;

    public ArquivoCnes(String path) {
        this.arquivo = new File(path);
    }
    
    public String salvarDadosSiab(){
        
        boolean flag = true;
        
        List<BICnesArea> areas = new ArrayList<BICnesArea>();
        List<BICnesMicroarea> microareas = new ArrayList<BICnesMicroarea>();
        
        //ler os dados do arquivo e preenche as listas com eles
        this.lerArquivoSiab(areas, microareas);
        
        //insere os dados lidos no banco de dados
        BICnesAreaDAO areaDAO = new BICnesAreaDAO();
        //percorre a lista de objetos e insere ou atualiza cada um dos objetos no banco
        for (BICnesArea bICnesArea : areas) {
            try{
                areaDAO.merge(bICnesArea);
            }catch(Exception ex){
                Logger.getLogger(ArquivoCnes.class.getName()).log(Level.SEVERE, bICnesArea.getCnes(), ex);
                flag = false;
            }
        }
        
        //insere os dados lidos no banco de dados
        BICnesMicroareaDAO microareaDAO = new BICnesMicroareaDAO();
        //percorre a lista de objetos e insere ou atualiza cada um dos objetos no banco
        for (BICnesMicroarea bICnesMicroarea : microareas) {
            try{
                 microareaDAO.merge(bICnesMicroarea);
            }catch(Exception ex){
                Logger.getLogger(ArquivoCnes.class.getName()).log(Level.SEVERE, bICnesMicroarea.getCodigoMicroarea(), ex);
                flag=false;
            }
        }
        
        String msg ="";
        if(flag){
            msg = "Importação realizada com sucesso!";
        }else{
            msg = "Um erro ocorreu, contate os desenvolvedores";
        }
        
        return msg;
    }
    private void lerArquivoSiab(List<BICnesArea> areas,List<BICnesMicroarea> microareas){
        //List<BICnesArea> areas = new ArrayList<BICnesArea>();
        //List<BICnesMicroarea> microareas = new ArrayList<BICnesMicroarea>();
        //List<String> listLinhas = new ArrayList<String>();
        if(areas!=null && microareas!=null){
        try {
            //fluxo de conexao para caracteres, que se conecta com um arquivo de texto
            FileReader fileReader = new FileReader(this.arquivo);
            
            //para uma leitura mais eficiente 
            BufferedReader reader = new BufferedReader(fileReader);
            
            //para armazenar cada linha lida
            String line = null;
            
            while((line = reader.readLine())!=null){
                
                //Divide a linha em um vetor de strings usando como delimitador a virgula ( , ) 
                String[] listLinha = line.split(",");
                
                //se o campo de controle for 1 (equivale a área)
                if(listLinha[0].equals("1")){
                    

                    CnesArea area = new CnesArea();
                    //vetor com a referencia dos campos da classe CnesArea (Reflection)
                    Field[] fields = CnesArea.class.getDeclaredFields();
                    
                    //se a quantidade de campos lidos do arquivo 
                    //e  a quantidade de campos da classe forem iguais
                    if(fields.length==listLinha.length){
                        //ler a linha e preenche o objeto com os valores lidos (Reflection)
                        for(int i=0;i<listLinha.length;i++){
                            try {
                                //torna o campo acessivel caso seja privado
                                fields[i].setAccessible(true);
                                //insere o valor lido no atributo do objeto
                                fields[i].set(area,listLinha[i]);
                            } catch (IllegalArgumentException ex) {
                                Logger.getLogger(ArquivoCnes.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalAccessException ex) {
                                Logger.getLogger(ArquivoCnes.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        //insere os dados do objeto do Tipo CnesArea em um objeto BICnesArea
                        //entao adiciona o objeto a lista de objetos
                        areas.add(new BICnesArea(area));
                }
                }
                
                 //se o campo de controle for 2 (equivale a microarea)
                 if(listLinha[0].equals("2")){
                    
                    CnesMicroarea microArea = new CnesMicroarea();
                    //vetor com a referencia dos campos da classe CnesMicroarea (Reflection)
                    Field[] fields = CnesMicroarea.class.getDeclaredFields();
                    
                    //se a quantidade de campos lidos do arquivo 
                    //e  a quantidade de campos da classe forem iguais
                    if(fields.length==listLinha.length){
                        //ler uma linha
                        for(int i=0;i<listLinha.length;i++){
                            try {
                                //torna o campo acessivel caso seja privado
                                fields[i].setAccessible(true);
                                //insere o valor lido no atributo do objeto
                                fields[i].set(microArea,listLinha[i]);
                            } catch (IllegalArgumentException ex) {
                                Logger.getLogger(ArquivoCnes.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalAccessException ex) {
                                Logger.getLogger(ArquivoCnes.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        //insere os dados do objeto do Tipo CnesMicroarea em um objeto BICnesMicroarea
                        //entao adiciona o objeto a lista de objetos
                        microareas.add(new BICnesMicroarea(microArea));
                }
                }
            }
            
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoCnes.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(ArquivoCnes.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
      
        
        
        
        }  
    }
    
    
    
    
}
