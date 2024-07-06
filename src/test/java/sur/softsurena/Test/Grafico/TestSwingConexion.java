package sur.softsurena.Test.Grafico;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import static sur.softsurena.utilidades.Utilidades.LOG;
import xy.ui.testing.Tester;
import xy.ui.testing.editor.TestEditor;
import xy.ui.testing.util.TestingUtils;

public class TestSwingConexion {

    private TestSwingConexion() {
    }

    public static void main(String[] args) throws IOException, Exception {
        editTestSwing("testSwing/testInsertCliente.stt");
        
//        Tester tester = new Tester();
        
//        TestingUtils.assertSuccessfulReplay(
//                new File("testSwing/testParametros.stt")
//        );
        
//        TestingUtils.assertSuccessfulReplay(
//                new File("testSwing/testInsertUsuario.stt")
//        );
    }

    public static void editTestSwing(String ruta) {

        //Crear un objecto de la clase Tester
        Tester tester = new Tester();

        try {
            tester.loadFromFile(new File(ruta));
        } catch (IOException ex) {
            LOG.getLogger(
                    TestSwingConexion.class.getName()
            ).log(
                    Level.SEVERE,
                    "Error al cargar este documento de prueba.",
                    ex
            );
        }
        
        //The main window that allows to edit and execute test specifications.
        TestEditor testEditor = new TestEditor(tester);

        //Abre el editor
        testEditor.setLastTesterFile(new File(ruta));
        testEditor.open();
    }
}
