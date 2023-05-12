package sur.softsurena.hilos;

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
public class hiloImpresionFacturaIT {
    
    public hiloImpresionFacturaIT() {
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
     * Test of run method, of class hiloImpresionFactura.
     */
    @Test
    public void testRun() {
        hiloImpresionFactura instance = null;
        instance.run();
    }

    /**
     * Test of terminar method, of class hiloImpresionFactura.
     */
    @Test
    public void testTerminar() {
        hiloImpresionFactura instance = null;
        instance.terminar();
    }

    /**
     * Test of detenElHilo method, of class hiloImpresionFactura.
     */
    @Test
    public void testDetenElHilo() {
        hiloImpresionFactura instance = null;
        instance.detenElHilo();
    }

    /**
     * Test of iniciarElHilo method, of class hiloImpresionFactura.
     */
    @Test
    public void testIniciarElHilo() {
        hiloImpresionFactura instance = null;
        instance.iniciarElHilo();
    }
    
}
