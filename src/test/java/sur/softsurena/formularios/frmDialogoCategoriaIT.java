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
public class frmDialogoCategoriaIT {
    
    public frmDialogoCategoriaIT() {
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
     * Test of getNombreCategoria method, of class frmDialogoCategoria.
     */
    @Test
    public void testGetNombreCategoria() {
        System.out.println("getNombreCategoria");
        frmDialogoCategoria instance = null;
        String expResult = "";
        String result = instance.getNombreCategoria();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombreCategoria method, of class frmDialogoCategoria.
     */
    @Test
    public void testSetNombreCategoria() {
        System.out.println("setNombreCategoria");
        String nombreCategoria = "";
        frmDialogoCategoria instance = null;
        instance.setNombreCategoria(nombreCategoria);
    }

    /**
     * Test of isAceptar method, of class frmDialogoCategoria.
     */
    @Test
    public void testIsAceptar() {
        System.out.println("isAceptar");
        frmDialogoCategoria instance = null;
        boolean expResult = false;
        boolean result = instance.isAceptar();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAceptar method, of class frmDialogoCategoria.
     */
    @Test
    public void testSetAceptar() {
        System.out.println("setAceptar");
        boolean aceptar = false;
        frmDialogoCategoria instance = null;
        instance.setAceptar(aceptar);
    }
    
}
