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
public class hiloMetodosIT {
    
    public hiloMetodosIT() {
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
     * Test of detener method, of class hiloMetodos.
     */
    @Test
    public void testDetener() {
        System.out.println("detener");
        hiloMetodos instance = new hiloMetodosImpl();
        instance.detener();
    }

    /**
     * Test of iniciar method, of class hiloMetodos.
     */
    @Test
    public void testIniciar() {
        System.out.println("iniciar");
        hiloMetodos instance = new hiloMetodosImpl();
        instance.iniciar();
    }

    /**
     * Test of correr method, of class hiloMetodos.
     */
    @Test
    public void testCorrer() {
        System.out.println("correr");
        hiloMetodos instance = new hiloMetodosImpl();
        instance.correr();
    }

    public class hiloMetodosImpl implements hiloMetodos {

        public void detener() {
        }

        public void iniciar() {
        }

        public void correr() {
        }
    }
    
}
