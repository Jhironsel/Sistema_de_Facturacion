/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package sur.softsurena.hilos;

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
@Suite.SuiteClasses({sur.softsurena.hilos.hiloIpIT.class, sur.softsurena.hilos.hiloMetodosIT.class, sur.softsurena.hilos.hiloRespardarIT.class, sur.softsurena.hilos.hiloImpresionFacturaIT.class, hilos.miHiloIT.class, sur.softsurena.hilos.hiloRestaurarIT.class})
public class HilosITSuite {

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
