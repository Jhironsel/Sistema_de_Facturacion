package sur.softsurena.formularios;

import java.io.File;
import javax.swing.JTable;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import xy.ui.testing.Tester;
import xy.ui.testing.util.TestingUtils;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmProductosNGTest {

    public frmProductosNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050"
        );
        assertTrue(
                Conexion.verificar().getEstado(),
                "Error al conectarse..."
        );
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        Conexion.getCnn().close();
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
                          Test que se verificar el formulario de productos del
                          sistema.
                          """
    )
    public void testGetInstance() {
        assertNotNull(
                frmProductos.getInstance(),
                "Error al instanciar frmProductos."
        );
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testLlenarTablaProductos() {
        String criterioBusqueda = "";
        JTable tabla = frmProductos.llenarTablaProductos(criterioBusqueda);

        assertNotNull(
                tabla,
                "La tabla de producto se encuentra nula."
        );

        assertTrue(
                tabla.getRowCount() == 0,
                """
                La tabla de producto contiene informacion.
                """
        );
    }

    @Test(
            enabled = false,
            priority = 1,
            description = """
                          """
    )
    public void testInsertProducto() throws Exception {

        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testInsertProducto.stt")
        );

    }

    @Test(
            enabled = false,
            priority = 2,
            description = """
                          """
    )
    public void testUpdateProducto() throws Exception {

        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testUpdateProducto.stt")
        );

    }

    @Test(
            enabled = false,
            priority = 3,
            description = """
                          """
    )
    public void testDeleteProducto() throws Exception {

        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testDeleteProducto.stt")
        );

    }

}
