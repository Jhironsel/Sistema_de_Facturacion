package sur.softsurena.formularios;

import java.awt.event.ActionEvent;
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
public class frmFacturasNGTest {

    public frmFacturasNGTest() {
        System.out.println("ESTOY AQUI CONSTRUCTOR");
        System.out.println("sur.softsurena.formularios.frmFacturasNGTest.<init>()");
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        System.out.println("sur.softsurena.formularios.frmFacturasNGTest.setUpClass()");
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        System.out.println("sur.softsurena.formularios.frmFacturasNGTest.tearDownClass()");
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        System.out.println("sur.softsurena.formularios.frmFacturasNGTest.setUpMethod()");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        System.out.println("sur.softsurena.formularios.frmFacturasNGTest.tearDownMethod()");
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetIdCliente() {
        System.out.println("sur.softsurena.formularios.frmFacturasNGTest.testGetIdCliente()");
        frmFacturas instance = null;
        Integer expResult = null;
        Integer result = instance.getIdCliente();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testSetIdCliente() {
        System.out.println("sur.softsurena.formularios.frmFacturasNGTest.testSetIdCliente()");
        Integer idCliente = null;
        frmFacturas instance = null;
        instance.setIdCliente(idCliente);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetInstance() {
        System.out.println("sur.softsurena.formularios.frmFacturasNGTest.testGetInstance()");
        frmFacturas expResult = null;
        frmFacturas result = frmFacturas.getInstance();
        assertEquals(result, expResult);
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testActionPerformed() {
        System.out.println("sur.softsurena.formularios.frmFacturasNGTest.testActionPerformed()");
        ActionEvent actionEvent = null;
        frmFacturas instance = null;
        instance.actionPerformed(actionEvent);
    }

}