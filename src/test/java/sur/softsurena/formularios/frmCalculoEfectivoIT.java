package sur.softsurena.formularios;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jhironsel
 */
public class frmCalculoEfectivoIT {
    
    public frmCalculoEfectivoIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getResp method, of class frmCalculoEfectivo.
     */
    @Test
    public void testGetResp() {
        System.out.println("getResp");
        frmCalculoEfectivo instance = null;
        int expResult = 0;
        int result = instance.getResp();
        assertEquals(expResult, result);
    }
    
}
