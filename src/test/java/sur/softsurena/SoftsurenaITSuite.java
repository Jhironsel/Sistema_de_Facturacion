package sur.softsurena;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author jhironsel
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    sur.softsurena.swingWorker.SwingWorkerITSuite.class, 
    sur.softsurena.hilos.HilosITSuite.class, 
    sur.softsurena.FirebirdEventos.FirebirdEventosITSuite.class, 
    sur.softsurena.formularios.FormulariosITSuite.class})
public class SoftsurenaITSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
