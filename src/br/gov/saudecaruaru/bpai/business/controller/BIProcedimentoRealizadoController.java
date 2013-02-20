/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.Procedimento;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizadoPK;
import br.gov.saudecaruaru.bpai.data.BIProcedimentoRealizadoDAO;
import br.gov.saudecaruaru.bpai.data.ProcedimentoRealizadoDAO;
import br.gov.saudecaruaru.bpai.util.Criptografia;
import br.gov.saudecaruaru.bpai.util.ModelUtil;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Albuquerque
 */
public class BIProcedimentoRealizadoController extends BasecController<BIProcedimentoRealizado> {

    private static Logger logger = Logger.getLogger(BIProcedimentoRealizado.class);

    public BIProcedimentoRealizadoController() {
        super(new BIProcedimentoRealizadoDAO());
    }

    public List<ProcedimentoRealizado> findAllOnlyHeader(String competencia) {
        return ((BIProcedimentoRealizadoDAO) this.getDao()).findAllOnlyHeader(competencia);
    }

    public List<ProcedimentoRealizado> findAllOnlyHeaderEqual(BIProcedimentoRealizado p) {
        return ((BIProcedimentoRealizadoDAO) this.getDao()).findAllOnlyHeaderEqual(p);
    }

    public String getNextFolha(BIProcedimentoRealizado BIProcedimentoRealizado) {
        return ((BIProcedimentoRealizadoDAO) this.getDao()).getNextFolha(BIProcedimentoRealizado);
    }

    public boolean findAllProcedimentosConsolidadosAndSave(String competenciaMovimento, String cnesUnidade, ProcedimentoRealizadoDAO procedimentoDao, int maxResults) {
        //folha a ser gerada
        boolean sucess = false;
        try {
            //variáveis para controlar a paginação e geraçãod e folha
            int folha = 1;
            int size = maxResults;
            int offset = 0;
            int seq = 1;
            String COMPETENCIA = null;
            String CNES = null;
            BIProcedimentoRealizadoDAO dao = (BIProcedimentoRealizadoDAO) this.getDao();
            //list para armazenar os procedimentos consolidados
            List<ProcedimentoRealizado> list = null;
            while (size == maxResults) {
                list = dao.findAllConsolidados(competenciaMovimento, cnesUnidade, offset, maxResults);
                size = list.size();
                //gerar a sequência e a folha
                for (int i = 0; i < size; i++) {

                    ProcedimentoRealizadoPK p = list.get(i).getProcedimentoRealizadoPK();
                    //pega o CBO e o CNES, quando mudarem, a folha e sequêcia são reiniciadas
                    String tCompetencia = p.getCompetencia();
                    String tCNES = p.getCnesUnidade();

                    //mudou de Competência ou CNES
                    if ((CNES == null ? false : !CNES.equals(tCNES)) || (COMPETENCIA == null ? false : !COMPETENCIA.equals(tCompetencia))) {
                        //zera a sequência
                        seq = 1;
                        //inicia uma nova folha
                        folha = 1;
                    }
                    p.setNumeroFolha(ModelUtil.completar("" + folha, 3, '0'));
                    p.setSequenciaFolha(ModelUtil.completar("" + seq, 2, '0'));
                    //incrementa a folha e inicia uma nova sequencia
                    if (seq == ProcedimentoRealizado.MAXIMA_QUANTIDADE_SEQUENCIA) {
                        //verifica se a quantidade de folhas chegou ao limite
                        if (folha == ProcedimentoRealizado.MAXIMA_QUANTIDADE_FOLHA) {
                            folha = 0;
                        }
                        //incrementa a folha
                        folha++;
                        seq = 0;
                    }
                    //incrementa a sequência
                    seq++;
                    //guarda os valores
                    COMPETENCIA = tCompetencia;
                    CNES = tCNES;
                }
                //salva a lista no banco de dados
                procedimentoDao.save(list);
                list.clear();
                //incrementa a paginacao
                offset += maxResults;
            }
            sucess = true;
        } catch (Exception ex) {
            ex.getStackTrace();
            logger.error("Ao executar o método findAllProcedimentosConsolidadosAndSave " + ex.getMessage());
        } finally {
            return sucess;
        }
    }

    public boolean findAllProcedimentosConsolidadosPorIdadeAndSave(String competenciaMovimento, String cnesUnidade, ProcedimentoRealizadoDAO procedimentoDao, int maxResults) {
        //folha a ser gerada
        boolean sucess = false;
        try {
            //variáveis para controlar a paginação e geraçãod e folha
            int folha = 1;
            int size = maxResults;
            int offset = 0;
            int seq = 1;
            String COMPETENCIA = null;
            String CNES = null;
            BIProcedimentoRealizadoDAO dao = (BIProcedimentoRealizadoDAO) this.getDao();
            //list para armazenar os procedimentos consolidados
            List<ProcedimentoRealizado> list = null;
            boolean primeiraVez = true;

            while (size == maxResults) {
                list = dao.findAllConsolidadosPorIdade(competenciaMovimento, cnesUnidade, offset, maxResults);
                size = list.size();
                //gerar a sequência e a folha
                for (int i = 0; i < size; i++) {

                    ProcedimentoRealizadoPK p = list.get(i).getProcedimentoRealizadoPK();
                    //pega o CBO e o CNES, quando mudarem, a folha e sequêcia são reiniciadas
                    String tCompetencia = p.getCompetencia();
                    String tCNES = p.getCnesUnidade();
                    if (primeiraVez) {
                        //executa somente uma vez
                        folha = Integer.parseInt(procedimentoDao.getNextFolha(p.getCnesUnidade(), p.getCompetencia(), p.getCboMedico()));
                        primeiraVez = false;
                    }
                    //mudou de CBO ou CNES
                    if ((CNES == null ? false : !CNES.equals(tCNES)) || (COMPETENCIA == null ? false : !COMPETENCIA.equals(tCompetencia))) {
                        //zera a sequência
                        seq = 1;
                        //inicia uma nova folha
                        folha = Integer.parseInt(procedimentoDao.getNextFolha(p.getCnesUnidade(), p.getCompetencia(), p.getCboMedico()));;
                    }
                    p.setNumeroFolha(ModelUtil.completar("" + folha, 3, '0'));
                    p.setSequenciaFolha(ModelUtil.completar("" + seq, 2, '0'));
                    //incrementa a folha e inicia uma nova sequencia
                    if (seq == ProcedimentoRealizado.MAXIMA_QUANTIDADE_SEQUENCIA) {
                        //verifica se a quantidade de folhas chegou ao limite
                        if (folha == ProcedimentoRealizado.MAXIMA_QUANTIDADE_FOLHA) {
                            folha = 0;
                        }
                        //incrementa a folha
                        folha++;
                        seq = 0;
                    }
                    //incrementa a sequência
                    seq++;
                    //guarda os valores
                    COMPETENCIA = tCompetencia;
                    CNES = tCNES;
                }
                //salva a lista no banco de dados
                procedimentoDao.save(list);
                list.clear();
                //incrementa a paginacao
                offset += maxResults;
            }
            sucess = true;
        } catch (Exception ex) {
            ex.getStackTrace();
            logger.error("Ao executar o método findAllProcedimentosConsolidadosAndSave " + ex.getMessage());
        } finally {
            return sucess;
        }
    }

    public boolean findAllProcedimentosIndividuaisAndSave(String competenciaMovimento, String cnesUnidade, ProcedimentoRealizadoDAO procedimentoDao, int maxResults) {
        boolean sucess = false;
        try {
            BIProcedimentoRealizadoDAO dao = (BIProcedimentoRealizadoDAO) this.getDao();

            int folha = 1;
            int size = maxResults;
            int offset = 0;
            int seq = 1;
            String CBO = null;
            String CNES = null;
            String CNS = null;
            List<ProcedimentoRealizado> list = null;
            boolean primeiraVez = true;

            while (size == maxResults) {
                list = dao.findAllProcedimentosIndividuais(competenciaMovimento, cnesUnidade, offset, maxResults);
                size = list.size();
                size = list.size();
                //gerar a sequência e a folha
                for (int i = 0; i < size; i++) {
                    ProcedimentoRealizadoPK p = list.get(i).getProcedimentoRealizadoPK();
                    //pega o CBO e o CNES, quando mudarem, a folha e sequêcia são reiniciadas
                    String tCBO = p.getCboMedico();
                    String tCNES = p.getCnesUnidade();
                    String tCNS = p.getCnsMedico();
                    //procura saber a ultima folha gerada de acordo com a competencia,unidade e cbo
//                   if (primeiraVez){
//                       //executa somente uma vez
//                       folha=Integer.parseInt(procedimentoDao.getNextFolha(p.getCnesUnidade(), p.getCompetencia(), p.getCboMedico()));
//                       primeiraVez=false;
//                   }

                    //mudou de CBO ou CNES
                    if ((CNES == null ? false : !CNES.equals(tCNES))
                            || (CBO == null ? false : !CBO.equals(tCBO))
                            || (CNS == null ? false : !CNS.equals(tCNS))) {
                        //zera a sequência
                        seq = 1;
                        //inicia uma nova folha
                        folha = 1;//Integer.parseInt(procedimentoDao.getNextFolha(p.getCnesUnidade(), p.getCompetencia(), p.getCboMedico()));
                    }
                    p.setNumeroFolha(ModelUtil.completar("" + folha, 3, '0'));
                    p.setSequenciaFolha(ModelUtil.completar("" + seq, 2, '0'));
                    //incrementa a folha e inicia uma nova sequencia
                    if (seq == ProcedimentoRealizado.MAXIMA_QUANTIDADE_SEQUENCIA) {
                        //verifica se a quantidade de folhas chegou ao limite
                        if (folha == ProcedimentoRealizado.MAXIMA_QUANTIDADE_FOLHA) {
                            folha = 0;
                        }
                        //incrementa a folha
                        folha++;
                        seq = 0;
                    }
                    //incrementa a sequência
                    seq++;
                    //guarda os valores
                    CBO = tCBO;
                    CNES = tCNES;
                    CNS = tCNS;
                }
                primeiraVez = true;
                //salva os procedimentos no banco de dados do BPA
                procedimentoDao.save(list);
                //incremeta a linha que deve ser buscada
                offset += maxResults;
                list.clear();
            }
            sucess = true;
        } catch (Exception ex) {
            ex.getStackTrace();
            logger.error("Ao executar o método findAllProcedimentosIndividuaisAndSave " + ex.getMessage());
        } finally {
            return sucess;
        }
    }

    public List<BIProcedimentoRealizado> parserProcedimentoRealizadoToBIProcedimentoRealizado(List<ProcedimentoRealizado> list) {
        List<BIProcedimentoRealizado> l = new ArrayList<BIProcedimentoRealizado>();
        for (ProcedimentoRealizado p : list) {
            l.add(new BIProcedimentoRealizado(p));
        }
        return l;
    }

    /**
     * Recebe uma lista de ProcedimentoRealizado e 
     * devolve uma lista de BIProcedimentoRealizado
     */
    public List<ProcedimentoRealizado> parserBIProcedimentoRealizadoToProcedimentoRealizado(List<BIProcedimentoRealizado> list) {
        List<ProcedimentoRealizado> l = new ArrayList<ProcedimentoRealizado>();
        for (BIProcedimentoRealizado p : list) {
            l.add(new ProcedimentoRealizado(p));
        }
        return l;
    }

    /**
     * Devolve todas as competências movimento que
     * estão presentes na produção digitada
     */
    public List<String> getTodasCompetenciaMovimento() {
        return ((BIProcedimentoRealizadoDAO) this.getDao()).getAllCompetenciaMovimento();
    }

    /**
     * Devolve todas as unidades que tem produção digitada.
     */
    public List<String> getAllUnidade() {
        return ((BIProcedimentoRealizadoDAO) this.getDao()).getAllUnidade();
    }

    /**
     * Devolve todos os procedimentos que ainda não estão
     * cadastrados na tabela S_PA (BIProcedimento).
     * O código do procedimento vem sem o dígito verificador.
     */
    public List<String> getAllCodigoProcedimentoSemReferencia(String competencia) {
        return ((BIProcedimentoRealizadoDAO) this.getDao()).getAllCodigoProcedimentoSemReferencia(competencia);
    }

    /**
     * Concatena todos os codigos do procedimento mais a tamanho
     * de list e gera um hash com MD5
     * @param list
     * @return um md5 se a lista passada não for nulla ou vazia, caso contrário devolve null
     */
    public static String calcularToken(List<BIProcedimentoRealizado> list) {
        if (list == null ? false : !list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            long soma=0;
            for (BIProcedimentoRealizado pro : list) {
                sb.append(pro.getCodigoProcedimento());
                soma+=pro.getQuantidadeRealizada();
            }
            //quantidade dos registros
            sb.append(list.size());
            //total de procedimentos realizados
            sb.append(soma);
            return Criptografia.md5(sb.toString());
        }
        return null;
    }
}
