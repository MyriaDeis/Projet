/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structurereseau;

import java.util.HashSet;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Djeremai
 */
public class StationTest {
    
    public StationTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of recherche method, of class Station.
     */
    @Test
    public void testRecherche() {
        System.out.println("recherche");
        String nom = "";
        Station expResult = null;
        Station result = Station.recherche(nom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLstation method, of class Station.
     */
    @Test
    public void testGetLstation() {
        System.out.println("getLstation");
        HashSet expResult = null;
        HashSet result = Station.getLstation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveStation method, of class Station.
     */
    @Test
    public void testSaveStation() {
        System.out.println("saveStation");
        Station.saveStation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFragment method, of class Station.
     */
    @Test
    public void testAddFragment() {
        System.out.println("addFragment");
        Fragment f = null;
        Station instance = null;
        instance.addFragment(f);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isIncident method, of class Station.
     */
    @Test
    public void testIsIncident() {
        System.out.println("isIncident");
        Station instance = null;
        boolean expResult = false;
        boolean result = instance.isIncident();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIncident method, of class Station.
     */
    @Test
    public void testSetIncident() {
        System.out.println("setIncident");
        boolean incident = false;
        Station instance = null;
        instance.setIncident(incident);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Station.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Station instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTps_arret method, of class Station.
     */
    @Test
    public void testGetTps_arret() {
        System.out.println("getTps_arret");
        Station instance = null;
        int expResult = 0;
        int result = instance.getTps_arret();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
