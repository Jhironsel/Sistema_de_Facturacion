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
public class frmAutorizacionIT {
    
    public frmAutorizacionIT() {
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
     * Test of isAceptado method, of class frmAutorizacion.
     */
    @Test
    public void testIsAceptado() {
        System.out.println("isAceptado");
        frmAutorizacion instance = null;
        boolean expResult = false;
        boolean result = instance.isAceptado();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAceptar method, of class frmAutorizacion.
     */
    @Test
    public void testSetAceptar() {
        System.out.println("setAceptar");
        String idUsuario = "";
        String clave = "";
        frmAutorizacion instance = null;
        instance.setAceptar(idUsuario, clave);
    }
    
}
