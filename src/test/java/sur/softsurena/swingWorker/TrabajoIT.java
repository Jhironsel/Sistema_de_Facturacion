package sur.softsurena.swingWorker;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sur.softsurena.formularios.frmLogin;

/**
 *
 * @author jhironsel
 */
public class TrabajoIT {
    
    public TrabajoIT() {
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
     * Test of getPerfil method, of class Trabajo.
     */
    @Test
    public void testGetPerfil() {
        System.out.println("getPerfil");
        Trabajo instance = null;
        int expResult = 0;
        int result = instance.getPerfil();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPerfil method, of class Trabajo.
     */
    @Test
    public void testSetPerfil() {
        System.out.println("setPerfil");
        int perfil = 0;
        Trabajo instance = null;
        instance.setPerfil(perfil);
    }

    /**
     * Test of getUsuario method, of class Trabajo.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        Trabajo instance = null;
        String expResult = "";
        String result = instance.getUsuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsuario method, of class Trabajo.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        String usuario = "";
        Trabajo instance = null;
        instance.setUsuario(usuario);
    }

    /**
     * Test of getClave method, of class Trabajo.
     */
    @Test
    public void testGetClave() {
        System.out.println("getClave");
        Trabajo instance = null;
        String expResult = "";
        String result = instance.getClave();
        assertEquals(expResult, result);
    }

    /**
     * Test of setClave method, of class Trabajo.
     */
    @Test
    public void testSetClave() {
        System.out.println("setClave");
        String clave = "";
        Trabajo instance = null;
        instance.setClave(clave);
    }

    /**
     * Test of getLogin method, of class Trabajo.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        Trabajo instance = null;
        frmLogin expResult = null;
        frmLogin result = instance.getLogin();
        assertEquals(expResult, result);
    }

    /**
     * Test of doInBackground method, of class Trabajo.
     */
    @Test
    public void testDoInBackground() throws Exception {
        System.out.println("doInBackground");
        Trabajo instance = null;
        Double expResult = null;
        Double result = instance.doInBackground();
        assertEquals(expResult, result);
    }

    /**
     * Test of process method, of class Trabajo.
     */
    @Test
    public void testProcess() {
        System.out.println("process");
        List<Integer> chunks = null;
        Trabajo instance = null;
        instance.process(chunks);
    }

    /**
     * Test of done method, of class Trabajo.
     */
    @Test
    public void testDone() {
        System.out.println("done");
        Trabajo instance = null;
        instance.done();
    }
    
}
