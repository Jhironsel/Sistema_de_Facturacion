package sur.softsurena.formularios;

import javax.swing.JTable;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;

public class frmClientesNGTest {
    
    public frmClientesNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
                "1",
                "BaseDeDatos.db",
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
            enabled = true,
            description = "Test que realiza la instacia de la clase del formulario de cliente.",
            priority = 0
    )
    public void testGetInstance() {
        assertNotNull(
                frmClientes.getInstance(),
                "La instacia del formulario es nulo."
        );
    }

    @Test(
            enabled = true,
            description = "Verificando las propiedades de la tabla de clientes.",
            priority = 1
    )
    public void testLlenarTablaClientes() {
        JTable tabla = frmClientes.llenarTablaClientes(-1, "");
        assertTrue(
                tabla.getRowCount()>0,
                "La tabla de cliente no contiene valores."
        );
        
        assertTrue(
                tabla.getColumnCount() == 9, 
                "La tabla de cliente tiene un numero de columna diferente de 9."
        );
        
    }
    
}
