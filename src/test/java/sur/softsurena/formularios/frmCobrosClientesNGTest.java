package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmCobrosClientesNGTest {

    public frmCobrosClientesNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
    }

    @AfterClass
    public void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetNombreCajero() {
        frmCobrosClientes instance = null;
        String expResult = "";
        String result = instance.getNombreCajero();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testSetNombreCajero() {
        String nombreCajero = "";
        frmCobrosClientes instance = null;
        instance.setNombreCajero(nombreCajero);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetIdTurno() {
        frmCobrosClientes instance = null;
        int expResult = 0;
        int result = instance.getIdTurno();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testSetIdTurno() {
        int idTurno = 0;
        frmCobrosClientes instance = null;
        instance.setIdTurno(idTurno);
    }

}