package sur.softsurena.formularios;

import java.io.File;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import xy.ui.testing.util.TestingUtils;

public class frmLoginNGTest {

    private frmLogin login;

    public frmLoginNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        login = new frmLogin("es");
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        login.dispose();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(
            description = """
                          Test swing de login.
                          """
    )
    public void testParametros() throws Exception {
        
        TestingUtils.assertSuccessfulReplay(
                new File("testSwing/testParametros.stt")
        );
    }

    @Test(
            description = """
                          Verifica si el frmLogin carga con el idioma español.
                          """,
            dependsOnMethods = "testParametros"
    )
    public void testTestClase() {
        assertNotNull(
                login,
                "No se cargó correctamente el formulario."
        );

        login.setVisible(true);

        assertTrue(
                login.isVisible(),
                "La ventana no puede ponerse visible."
        );

        login.getTxtUsuario().setText("sysdba");
        login.getTxtClave().setText("1");

        login.getBtnAceptar().doClick();

        assertTrue(
                login.isActive(),
                "Login no responde."
        );

        login.dispose();
    }
}
