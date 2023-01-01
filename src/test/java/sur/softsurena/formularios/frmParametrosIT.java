package sur.softsurena.formularios;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sur.softsurena.entidades.Servidor;

/**
 *
 * @author jhironsel
 */
public class frmParametrosIT {
    
    public frmParametrosIT() {
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
     * Test of cargarParamentos method, of class frmParametros.
     */
    @Test
    public void testCargarParamentos() {
        System.out.println("cargarParamentos");
        String zona = "";
        frmParametros instance = new frmParametros();
        Servidor expResult = null;
        Servidor result = instance.cargarParamentos(zona);
        assertEquals(expResult, result);
    }
    
}
