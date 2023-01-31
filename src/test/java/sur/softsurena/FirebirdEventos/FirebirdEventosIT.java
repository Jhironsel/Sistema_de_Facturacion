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
        String user = "jhironsel";
        String clave = "123uasd";
        String dominio = "localhost";
        String pathBaseDatos = "/home/jhironsel/BaseDatos/BaseDeDatos3.fdb";
        int puerto = 3050;
        FirebirdEventos instance = new FirebirdEventos();
        boolean expResult = true;
        boolean result = instance.registro(user, clave, dominio, pathBaseDatos, puerto);
        assertEquals(expResult, result);
    }
    
}
