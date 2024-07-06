package sur.softsurena.formularios;

import javax.swing.JLabel;
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
public class frmAcercaDeNGTest {

    private frmAcercaDe acercaDe;

    public frmAcercaDeNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        acercaDe = new frmAcercaDe(null, false);
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
    public void testSomeMethod() {

        assertNotNull(
                acercaDe,
                "El formulario de acercaDe no inicia o instancia."
        );
        
        acercaDe.setVisible(true);

        assertTrue(
                acercaDe.isVisible(),
                "No puede colocarse visible."
        );

        
        acercaDe.dispose();

        assertFalse(
                acercaDe.isVisible(),
                "No puede cerrarse el formulario frmAcercaDe."
        );

    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetJlDesarrollador() {
        JLabel jlDesarrollador = acercaDe.getJlDesarrollador();
        assertNotNull(
                jlDesarrollador.getIcon(), 
                "Mi foto no aparece."
        );
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetJlLogo() {
        JLabel jlLogo = acercaDe.getJlLogo();
        assertNotNull(
                jlLogo.getIcon(), 
                "Error en el logo de acercaDe."
        );
    }

}
