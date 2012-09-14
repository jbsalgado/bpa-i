/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.test;

import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoServicoController;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Albuquerque
 */
public class ProcedimentoServicoControllerTest extends TestCase{
    
    private static  ProcedimentoServicoController pro;
    
    public ProcedimentoServicoControllerTest() {
    }

    @BeforeClass
    public static void setUpClass(){
        try{
            pro= new ProcedimentoServicoController();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        pro=null;
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCount() {
        int size=pro.findAll().size();
        System.out.println("Número de Registros: "+size);
        assertEquals(9161, size);
    }
}
