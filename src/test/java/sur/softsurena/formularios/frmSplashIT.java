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
public class frmSplashIT {
    
    public frmSplashIT() {
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
     * Test of getUsuario method, of class frmSplash.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        frmSplash instance = null;
        String expResult = "";
        String result = instance.getUsuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsuario method, of class frmSplash.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        String usuario = "";
        frmSplash instance = null;
        instance.setUsuario(usuario);
    }

    /**
     * Test of getPerfil method, of class frmSplash.
     */
    @Test
    public void testGetPerfil() {
        System.out.println("getPerfil");
        frmSplash instance = null;
        int expResult = 0;
        int result = instance.getPerfil();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPerfil method, of class frmSplash.
     */
    @Test
    public void testSetPerfil() {
        System.out.println("setPerfil");
        int perfil = 0;
        frmSplash instance = null;
        instance.setPerfil(perfil);
    }

    /**
     * Test of getClave method, of class frmSplash.
     */
    @Test
    public void testGetClave() {
        System.out.println("getClave");
        frmSplash instance = null;
        String expResult = "";
        String result = instance.getClave();
        assertEquals(expResult, result);
    }

    /**
     * Test of setClave method, of class frmSplash.
     */
    @Test
    public void testSetClave() {
        System.out.println("setClave");
        String clave = "";
        frmSplash instance = null;
        instance.setClave(clave);
    }
    
}
