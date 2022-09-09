package sur.softsurena.TestSwing;

import java.io.File;
import java.io.IOException;
import xy.ui.testing.Tester;
import xy.ui.testing.editor.TestEditor;
import xy.ui.testing.util.TestingUtils;

public class Rapido {

    private Rapido() {
    }

    public static void main(String[] args) throws IOException, Exception {

        
//        TestingUtils.assertSuccessfulReplay(new File("testCliente.stt"));
        
        Tester tester = new Tester();
        tester.loadFromFile(new File("rapido.stt"));

        TestEditor testEditor = new TestEditor(tester);

        TestingUtils.closeAllTestableWindows(tester);

        TestingUtils.purgeAllReportsDirectory();

        testEditor.open();

        //tester.replayAll();

        
    }
}
