package sur.softsurena.FirebirdEventos;

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
public class FirebirdEventosIT {
    
    public FirebirdEventosIT() {
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
     * Test of registro method, of class FirebirdEventos.
     */
    @Test
    public void testRegistro() {
        System.out.println("registro");
        String user = "";
        String clave = "";
        String dominio = "";
        String pathBaseDatos = "";
        int puerto = 0;
        FirebirdEventos instance = new FirebirdEventos();
        boolean expResult = false;
        boolean result = instance.registro(user, clave, dominio, pathBaseDatos, puerto);
        assertEquals(expResult, result);
    }
    
}
