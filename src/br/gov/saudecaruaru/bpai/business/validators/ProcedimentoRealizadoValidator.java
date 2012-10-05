/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.validators;

import br.gov.saudecaruaru.bpai.business.controller.DiversasController;
import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.model.*;
import br.gov.saudecaruaru.bpai.data.*;
import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Junior Pires
 */
public class ProcedimentoRealizadoValidator implements Validator{
    private ProcedimentoRealizado procedimentoRealizado;
    private ProcedimentoRealizadoDAO prDao;
    private ProcedimentoDAO pDao;
    private DiversasDAO diversasDao;
    
    
    public ProcedimentoRealizadoValidator(ProcedimentoRealizado procedimentoRealizado) {
        this.procedimentoRealizado = procedimentoRealizado;
        this.prDao = new ProcedimentoRealizadoDAO();
        this.pDao = new ProcedimentoDAO();
        this.diversasDao = new DiversasDAO();
        
    }
    
    public String validExisteCBO(){
        
        return validExisteCBO(procedimentoRealizado.getProcedimentoRealizadoPK().getCboMedico());
    }
    
    private String validExisteCBO(String cbo){
        DiversasPK diversasPK = new DiversasPK(Diversas.TABELA_PROFISSAO,cbo);
        Diversas diversas = new Diversas(diversasPK);
        if(diversasDao.findEqual(diversas)==null){
            return "CBO INCORRETO!";
        }
        return "";
    }
    
    
    private String validExisteProcedimento(String codProcedimento){
      
      //pega os sete primeiros digitos (que representam o codigo do procedimento)
      String codProc = codProcedimento.substring(0,9);
       //pega o oitavo digito (que representam o digito verificador)
      Character digitoVerificador = codProcedimento.charAt(9);  
      
      Procedimento  procedimento= new   Procedimento();
      ProcedimentoPK procedimentoPk = new   ProcedimentoPK();
      procedimento.setProcedimentoPk(procedimentoPk);
     
     
      procedimento.getProcedimentoPk().setId(codProc);
      procedimento.setDigitoVerificador(digitoVerificador);
      //procedimento.getProcedimentoPk().setCompetencia(proRealizado.getProcedimentoRealizadoPK().getCompetencia());
      
     
      //faz a busca pelo Procedimento  digitado, se nao encontra notifica ao usuário
      if(pDao.findAllEqual(procedimento).isEmpty()){
          return "PROCEDIMENTO NÃO ENCONTRADO!";
      }
      
      return "";
    }
    
    
    
     public String validExisteProcedimento(){
         return validExisteProcedimento(this.procedimentoRealizado.getCodigoProcedimento());
     }
    
     
    public String validProcedimentoIdadeMaxMin(String codProcedimento,int idade){
        //pega os sete primeiros digitos (que representam o codigo do procedimento)
      String codProc = codProcedimento.substring(0,9);
       //pega o oitavo digito (que representam o digito verificador)
      Character digitoVerificador = codProcedimento.charAt(9);  
      
      Procedimento  procedimento= new   Procedimento();
      ProcedimentoPK procedimentoPk = new   ProcedimentoPK();
      procedimento.setProcedimentoPk(procedimentoPk);
     
     
      procedimento.getProcedimentoPk().setId(codProc);
      procedimento.setDigitoVerificador(digitoVerificador);
      //procedimento.getProcedimentoPk().setCompetencia(proRealizado.getProcedimentoRealizadoPK().getCompetencia());
      
      //faz a busca pelo Procedimento  digitado
      List<Procedimento> listProcedimentos = pDao.findAllEqual(procedimento);
      
      if(listProcedimentos!=null){
          Procedimento procedimentoAchado = listProcedimentos.get(0);
          
          
          int idadeMaxima = procedimentoAchado.getIdadeMaximaPaciente();
          int idadeMinima = procedimentoAchado.getIdadeMinimaPaciente();
          
          if((idade<idadeMinima) || (idade>idadeMaxima)){
               return  "PROCED. INCOMPATIVEL COM A IDADE!"+"\n IDADE MÍNIMA: "+idadeMinima+"\n IDADE MÁXIMA: "+idadeMaxima;
                        }
          
      }
      
      return "";
    }
    public String validProcedimentoIdadeMaxMin(){
        return validProcedimentoIdadeMaxMin(this.procedimentoRealizado.getCodigoProcedimento(), Integer.parseInt(this.procedimentoRealizado.getIdadePaciente()));
    }
    
    
    private String validProcedimentoECbo(String codProc,String cbo){
        if(!temProcedimentoECbo(codProc,cbo)){
            return "PROCED. INCOMPATIVEL COM CBO!";
        }
        
        return "";
    }
    
    public String validaProcedimentoECbo(){
        return validProcedimentoECbo(this.procedimentoRealizado.getCodigoProcedimento().substring(0, 9), this.procedimentoRealizado.getProcedimentoRealizadoPK().getCboMedico());
    }
    
    public String validProcedimentoTipo(String codProcedimento){
        //pega os sete primeiros digitos (que representam o codigo do procedimento)
      String codProc = codProcedimento.substring(0,9);
       //pega o oitavo digito (que representam o digito verificador)
      Character digitoVerificador = codProcedimento.charAt(9);  
      
      Procedimento  procedimento= new   Procedimento();
      ProcedimentoPK procedimentoPk = new   ProcedimentoPK();
      procedimento.setProcedimentoPk(procedimentoPk);
     
     
      procedimento.getProcedimentoPk().setId(codProc);
      procedimento.setDigitoVerificador(digitoVerificador);
      //procedimento.getProcedimentoPk().setCompetencia(proRealizado.getProcedimentoRealizadoPK().getCompetencia());
      
     
      List<Procedimento> listProcedimentos = pDao.findAllEqual(procedimento);
      
      if(!listProcedimentos.isEmpty()){
          Procedimento procedimentoAchado = listProcedimentos.get(0);
           if(!procedimentoAchado.isBPA() && !procedimentoAchado.isBPI()){
               return "TIPO INVÁLIDO INVÁLIDO! (PERMITIDO SOMENTE BPA OU BPI)";
           }
      }
       return "";
    }
    
    public String validProcedimentoTipo(){
        return validProcedimentoTipo(this.procedimentoRealizado.getCodigoProcedimento());
    }
    
    
    private String validCompetencia(String competencia){
        List<GestorCompetencia> competenciaAtual = new GestorCompetenciaDAO().findAll();
        if(!competenciaAtual.isEmpty()){
              int dif = Integer.parseInt(competenciaAtual.get(0).getCompetenciaMovimento())-Integer.parseInt(competencia);
                    //é permitido até 4 meses do mes atual 
                     // (implementar posteriormente a diferenca entre objetos DATE)
                    if(dif>4 || dif<0){  
                        return " COMPETÊNCIA INVÁLIDA!";
                    }
        }
        
        return "";
    }
    
     public String validCompetencia(){
         return validCompetencia(this.procedimentoRealizado.getProcedimentoRealizadoPK().getCompetencia());
     }
     
     
     
     private String validExisteDoenca(String codDoenca){
         if(!codDoenca.isEmpty()){
                Doenca d = new Doenca(codDoenca);

                if(new DoencaDAO().findEqual(d)==null){
                    return "DOENÇA NÃO CADASTRADA!";
                }
         }
         return "";
     }
     
     public String existeDoenca(){
         return validExisteDoenca(this.procedimentoRealizado.getCidDoencaprocedimento());
     }
     
     private String validProcedimentoExigeDoenca(String codProcedimento,String codDoenca){
       if(codDoenca.isEmpty()){  
                ProcedimentoDoenca procedimentoDoenca = new ProcedimentoDoenca(new ProcedimentoDoencaPK(codProcedimento.substring(0, 9),null, null));
                if(!new ProcedimentoDoencaDAO().findAllEqual(procedimentoDoenca).isEmpty()){
                        return "PROCED. EXIGE CID!";
                    }
       }
        return "";
     }
     
     public String validProcedimentoDoenca(){
         return validProcedimentoExigeDoenca(this.procedimentoRealizado.getCodigoProcedimento(), this.procedimentoRealizado.getCidDoencaprocedimento());
     }
     
     
     
     private String validDoencaPertenceSubCategoria(String codDoenca){
         if(!codDoenca.isEmpty()){  
                Doenca d = new DoencaDAO().findEqual(new Doenca(codDoenca));
                if(d!=null){
                    if(d.getSubcategoria()=='N')    
                        return "PROCED. NÃO PERTENCA A UMA SUBCATEGORIA";
                }
         }
        return "";
     }
     
     public String validDoencaPertenceSubCategoria(){
         return validDoencaPertenceSubCategoria(this.procedimentoRealizado.getCidDoencaprocedimento());
     }
     
     private String validDoencaIncompativelProcedimento(String codProcedimento,String codDoenca){
       if(!codDoenca.isEmpty()){  
                ProcedimentoDoenca procedimentoDoenca = new ProcedimentoDoenca(new ProcedimentoDoencaPK(codProcedimento.substring(0, 9),codDoenca, null));
                if(new ProcedimentoDoencaDAO().findAllEqual(procedimentoDoenca).isEmpty()){
                        return "PROCED. INCOMPATIVEL COM CID!";
                    }
       }
        return "";
     }
     
     public String validDoencaIncompativelProcedimento(){
         return validDoencaIncompativelProcedimento(this.procedimentoRealizado.getCodigoProcedimento(), this.procedimentoRealizado.getCidDoencaprocedimento());
     }
     
     
     private String validExisteEtnia(String etnia){
        if(!etnia.isEmpty()){
            DiversasPK diversasPK = new DiversasPK(Diversas.TABELA_ETNIA,etnia);
            Diversas diversas = new Diversas(diversasPK);
            if(diversasDao.findEqual(diversas)==null){
                return "ETNIA NÃO ENCONTRADA";
            }
        
        }
        return "";
    }
     
     public  String validExisteEtnia(){
         return validExisteEtnia(this.procedimentoRealizado.getEtniaPaciente());
     }
     
    private String validExisteMunicipio(String municipio){
        if(municipio!=null){
    
            //pega os dois primeiros digitos (que representam o Estado do municipio)
            String codUf=municipio.substring(0, 2);
            //pega os quatro ultimos digitos (que representam o codigo do municipio)
            String codMun = municipio.substring(2);
            Municipio m = new Municipio(new MunicipioPK(codUf, codMun));
            if(new MunicipioDAO().findEqual(m)==null){
                return "MUNICIPIO NÃO ENCONTRADO";
            }
        
        }
        return "";
    }
    public String validExisteMunicipio(){
        return validExisteMunicipio(this.procedimentoRealizado.getCodigoIBGECidadePaciente());
    }
    
     private String validExisteNacionalidade(String nac){
       
            DiversasPK diversasPK = new DiversasPK(Diversas.TABELA_PAIS,nac);
            Diversas diversas = new Diversas(diversasPK);
            if(diversasDao.findEqual(diversas)==null){
                return "PAÍS NÃO ENCONTRADO";
            }
        
        
        return "";
    }
    
    public String validExisteNacionalidade(){
        return validExisteNacionalidade(this.procedimentoRealizado.getNacionalidadePaciente());
    }
    
    private String validQuantidadeMaximaProcedimento(String codProcedimento,double quantidade){
          //pega os sete primeiros digitos (que representam o codigo do procedimento)
      String codProc = codProcedimento.substring(0,9);
       //pega o oitavo digito (que representam o digito verificador)
      Character digitoVerificador = codProcedimento.charAt(9);  
      
      Procedimento  procedimento= new   Procedimento();
      ProcedimentoPK procedimentoPk = new   ProcedimentoPK();
      procedimento.setProcedimentoPk(procedimentoPk);
     
     
      procedimento.getProcedimentoPk().setId(codProc);
      procedimento.setDigitoVerificador(digitoVerificador);
      //procedimento.getProcedimentoPk().setCompetencia(proRealizado.getProcedimentoRealizadoPK().getCompetencia());
      
      //faz a busca pelo Procedimento  digitado
      List<Procedimento> listProcedimentos = pDao.findAllEqual(procedimento);
      
      if(listProcedimentos!=null){
          Procedimento procedimentoAchado = listProcedimentos.get(0);
          
          
          double quantidadeMaxima = procedimentoAchado.getQuantidadeMaximaExecucao();
          
          
          if(quantidade>quantidadeMaxima){
               return  "ERRO! QUANTIDADE MÁXIMA PERMITIDA "+quantidadeMaxima;
          }
      }
      return "";
    }
        
     public String validQuantidadeMaximaProcedimento(){
         return validQuantidadeMaximaProcedimento(this.procedimentoRealizado.getCodigoProcedimento(),this.procedimentoRealizado.getQuantidadeRealizada());
     }
    
     
     
    
    
    
    
      private boolean temProcedimentoECbo(String codProc,String cbo){
        ProcedimentoCbo procedimentoCbo = new ProcedimentoCbo(new ProcedimentoCboPK(codProc, cbo, null));
        ProcedimentoCboDAO pcd = new ProcedimentoCboDAO();
        
        if(pcd.findAllEqual(procedimentoCbo).isEmpty()){
            return false;
        }
        return true;
    }

    
    @Override
    public List<String> runValidate() {
        List<String> listErrors = new ArrayList<String>();
        
        for(Method m :this.getClass().getMethods()){
            try {
                    if(m.getName().startsWith("valid")){
                        String msg = (String) this.getClass().getMethod(m.getName()).invoke(this);
                        if(!msg.isEmpty()){
                            listErrors.add(msg);
                        }
                    
                    }
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(ProcedimentoRealizadoValidator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(ProcedimentoRealizadoValidator.class.getName()).log(Level.SEVERE, null, ex);
            }catch (IllegalAccessException ex) {
                    Logger.getLogger(ProcedimentoRealizadoValidator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ProcedimentoRealizadoValidator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                    Logger.getLogger(ProcedimentoRealizadoValidator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         return listErrors;
    }
    
    
    
    
}
