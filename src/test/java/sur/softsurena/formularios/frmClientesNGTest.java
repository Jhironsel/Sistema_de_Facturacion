package sur.softsurena.formularios;

import java.io.File;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;
import xy.ui.testing.Tester;
import xy.ui.testing.util.TestingUtils;

@Test(enabled = false)
public class frmClientesNGTest {

    public frmClientesNGTest() {
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
        //frmClientes instance = frmClientes.getInstance();
        //instance.getBtnCancelar().doClick();
    }

    //--------------------------------------------------------------------------
    @Test(
        enabled = false,
            priority = 0,
            description = """
                          Prueba Swing.
                          """
    )
    public void testSwingProvinciaMunicipioDistrito() throws Exception{
        
        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testProvinciaMunicipioDistrito.stt")
        );
    }

    //--------------------------------------------------------------------------
    @Test(
        enabled = false,
            priority = 1,
            description = """
                          Prueba Swing.
                          """
    )
    public void testSwingInsertCliente() throws Exception{
        
        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testInsertCliente.stt")
        );
    }
    
    //--------------------------------------------------------------------------
    @Test(
        enabled = false,
            priority = 2,
            description = """
                          Prueba Swing.
                          """
    )
    public void testSwingUpdateCliente() throws Exception{
        
        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testUpdateCliente.stt")
        );
    }
    
    //--------------------------------------------------------------------------
    @Test(
        enabled = false,
            priority = 3,
            description = """
                          Prueba Swing.
                          """
    )
    public void testSwingDeleteCliente() throws Exception{
        
        TestingUtils.assertSuccessfulReplay(
                new Tester(),
                new File("testSwing/testBorrarCliente.stt")
        );
    }
    //--------------------------------------------------------------------------
}

/**
 * El <b>btnNuevo</b> de cumplir lo siguiente:<br>
 * 1) Debe cambiar el valor de v_nuevo a true; X<br>
 * 2) Debe cambiar el TabPane de Cliente a Mantenimiento y presentar el <br>
 * formulario limpio. X<br>
 * 3) Debe deshabilitar los botones de nuevo, modificar borrar y buscar. X<br>
 * 4) Debe habilitar los botones de guardar y cancelar. X<br>
 * 5) Debe siempre limpiar las tablas de formulario de registro. X<br>
 * 6) Debe siempre limpiar los comboBox de provincia, municipio y distritos <br>
 * municipal. X<br>
 * 7) Debe siempre limpiar los comboBox de Estado civil, sexo y Tipo persona.
 * X<br>
 * 8) <br>
 *
 *
 * El <b>btnModificar</b> debe cumplir lo siguiente:<br>
 * 1) Debe ejecutarse el metodo validarRegistro(), si este devuelve TRUE<br>
 * Debe devolverse el flojo de control. X<br>
 * 2) Debe cambiar el valor de v_nuevo a false; X<br>
 * 3) Debe validar que un registros este seleccionado. X<br>
 * 4) Debe cambiar el TabPane de Clientes a Mantenimiento. <br>
 * 5) Presentar el formulario de registros con los datos de registros <br>
 * seleccionado a modificar. X<br>
 * 6) Debe habilitar los botones de guardar y cancelar. X<br>
 * 7) Debe de ajustarse el ancho de las columnas de las tablas como Correo,<br>
 * Direcciones y Telefono.
 *
 *
 * El <b>btnBorrar</b> debe cumplir lo siguiente:<br>
 * 1) Debe utilizar el metodo validarRegistro(). <br>
 * 2) Debe mostrar un cuadro de dialogo que diga <br>
 * ¿Esta Seguro de Eliminar Registro del Cliente?<br>
 * y mostrar la opciones de Si o No.<br>
 * 3) Si selecciona que NO debe devolver el flujo de control. <br>
 * 4) En caso contrario se procede a obtener el idCliente<br>
 * del registro de la tabla tblClientes.<br>
 * 5) Se manda a llamar el metodo borrarCliente(idCliente) y se <br>
 * obtiene un objecto de la clase Resultados la cual con el <br>
 * metodo getMensaje() obtenemos como resultado de la operacion <br>
 * un mensaje del metodo. 6) Evaluamos el resultado del mensaje con la variable
 * estatica de la <br>
 * clase Cliente CLIENTE_BORRADO_CORRECTAMENTE. 7) Mostramos el resultado de la
 * operacion en un JOpcionPane 8) Reperamos el ancho de las columnas de la tabla
 * tblClientes.
 *
 *
 *
 * El <b>btnBuscar</b> debe cumplir lo siguiente:<br>
 * 1) Debe iniciarlizar la variable v_hilo, para cuando el<br>
 * JOpcionPane se muestre gane el focus el componente.<br>
 * 2) El campo Cedula debe limpiarse.<br>
 * 3) Debe mostrarse la ventana pidiendo que digite la <br>
 * cedula a buscar.<br>
 * 4) Se interrumpe el hilo de ejecucion del paso 1. X<br>
 * 5) Si la opcion es no, se cancela el proceso. X<br>
 * 6) Si la opcion es si, se valida que se halla digitado<br>
 * una cedula completa.<br>
 * 7) En caso de que no es una cedula completa se muestra<br>
 * un mensaje de error.<br>
 * 8) Si la cedula es correcta se manda a consultar la cedula<br>
 * digitada.<br>
 * 9) En caso de no encontrarla mostrar el mensaje que diga: <br>
 * "El Cliente No Existe!" 10) Si
 *
 *
 * El <b>btnGuardar</b> debe cumplir lo siguiente:<br>
 * 1) Validamos que el campo de la cedula sea correcto. X<br>
 * 2) Mostramos mensaje de error si el campo primer nombre está en blanco. X<br>
 * 3) Mostramos mensaje de error si el campo de apellidos está en blanco. X<br>
 * 4) Mostramos mensaje de error si el campo de fecha es nulo. X<br>
 * 5) Mostramos mensaje de error si la fecha del campo fecha nacimiento está
 * <br>
 * por encima de la fecha actual. X<br>
 * 6) Nos aseguramos que la tabla de direcciones contenga por lo menos <br>
 * un registro. 7) Nos aseguramos que exista una forma de contacto con el
 * cliente.<br>
 * 8) Investigamos si existe un identificador o Id en la base de datos, <br>
 * Relacionado con la cedula suministrada.<br>
 * 9) Vamos a validar por caso: <br>
 * Si es Nuevo:<br>
 * 1) Y el identificador es diferente de -1 entonces existe un registro <br>
 * previo del cliente en la base de datos.<br>
 * Si es Modificar:<br>
 * 2) Y el identificador es igual a -1 entonces no existe un usuario <br>
 * con dicha cedula, lo que implica es que el cliente va a modificar su<br>
 * cedula anterior.<br>
 *
 *
 * El <b>btnCancelar</b> debe cumplir lo siguiente: <br>
 * 1) Debe de eliminar el formulario de mantenimiento. X <br>
 * 2) Debe solo prensentar el formulario de registros de los clientes. X <br>
 *
 *
 *
 *
 * El <b>btnAgregarCorreo</b> debe cumplir lo siguiente:<br>
 * 1) Debe validar que sea un correo valido. X<br>
 * 2) <br>
 *
 *
 *
 * El <b>btnAgregarDirecciones</b> debe cumplir lo siguiente: <br>
 * 1) Valida que se haya seleccionado una pronvincia. X<br>
 * 2) Valida que se haya seleccionado un municipio. X<br>
 * 3) Se valida que se haya digitado una dirección. X<br>
 * 4) Se obtiene el identificador del usuario si se va <br>
 * a modificar el registro. En caso contrario se obtiene -1.<br>
 * 5) Se obtienen las claves primarias de provincia, municipio y <br>
 * distritos municipales de los comboBox de estos. 6) Se prepara el objecto
 * direccion para ser agregado a la variable<br>
 * de campo global v_direccionesList. 7) Se prepara un arreglo de objecto
 * llamado registroDirecciones el <br>
 * cual servira para agregar la direccion completa a la BD.<br>
 * 8) Se obtiene el modelo de la tabla de direcciones de la variable <br>
 * tblDireccion con el metodo getModel().<br>
 * 9) Se agregar el registro de la variable registroDireccion a la variable<br>
 * de campo v_dtmDireccion.<br>
 * 10) Y se setea el modelo a la tabla de direcciones tblDireccion.<br>
 * 11) Se colocan los jComboBox en el indice 0 de Provincia, Municipio y <br>
 * Distrito Municipal. 12) Los jComboBox de Municipio y Distritos Municipal se
 * deshabilitan. 13) El campo direccion se blanquea. 14) Se Reparan el ancho de
 * las columnas.
 */
