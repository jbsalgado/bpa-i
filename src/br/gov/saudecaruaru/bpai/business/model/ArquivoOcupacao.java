/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import br.gov.saudecaruaru.bpai.data.ConectionFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juniorpires
 */
public class ArquivoOcupacao {
    public static final String CODIGO="COD_OCUP";
    public static final String NOME="NOME_OCUP";
    private File arquivo;

    public ArquivoOcupacao(String path) {
        this.arquivo = new File(path);
    }
    
    
    public List<BIOcupacao> lerArquivoOcupacao(){
        List<BIOcupacao> list= new ArrayList<BIOcupacao>();
        try{
            Connection co=ConectionFactory.getConnection(this.arquivo.getParent());
            String sql="SELECT "+ArquivoOcupacao.CODIGO+","+ArquivoOcupacao.NOME+" FROM "+this.arquivo.getName();
            Statement stmt=co.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            int cont=0;
            while(resultSet.next())
            {
                BIOcupacao ocupacao = new BIOcupacao();
                ocupacao.setCodigo(resultSet.getString(ArquivoOcupacao.CODIGO));
                ocupacao.setNome(resultSet.getString(ArquivoOcupacao.NOME));
                System.out.println(ocupacao.getNome());
                //adicioa na lista
                cont++;
                list.add(ocupacao);
            }
            System.out.println(sql);
            resultSet.close();
            co.close();
        
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
         return list;
        }
    }
    

}
