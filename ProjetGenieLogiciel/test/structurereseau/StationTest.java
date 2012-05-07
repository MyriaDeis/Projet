/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structurereseau;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.*;
import static org.junit.Assert.*;
import principal.GestionFichier;

/**
 *
 * @author Djeremai
 */
public class StationTest {
    
    public StationTest() {
    }
    
    @Before
    public void setUp() {
        Station s1 = new Station("stat", true, 4); 
        Station s2 = new Station("stat2", true, 5); 
        GestionFichier.saveReseau();
    }
    

    /**
     * Test of saveStation method, of class Station.
     *//*
    @Test
    public void testSaveStation() {
        System.out.println("saveStation");
        Station.saveStation();
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
    /**
     * Test of recherche method, of class Station.
     */
    @Test
    public void testRecherche() {
        System.out.println("recherche");
        String nom = "stat";
        
        String expResult = "stat";
        Station result = Station.recherche(nom);
        assertEquals(expResult, result.getName());
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
        
    }

    @Test
    public void testTempsEntre2Stations() {
    	ArrayList<Station> list = (ArrayList<Station>) Station.getLstation().values();
    	Station s1 = list.get((int) (Math.random() * list.size())), s2 = null;
    	while (! s1.equals(s2)) {
    		s2 = list.get((int) (Math.random() * list.size()));
    	}
		assertEquals(s1.tempsEntre2Stations(s2), s2.tempsEntre2Stations(s1));
    }
    
    @Test
	public void testStationsProches() { // ça marche nickel !
    	ArrayList<Station> tmp;
    	for (Station s : Station.getLstation().values()) {
    		tmp = new ArrayList<Station>();
    		for (Fragment f : s.getLfrag())
    			tmp.add(Station.recherche(f.getDepart()));
    		assertEquals(s.stationsProches().containsAll(tmp), tmp.containsAll(s.stationsProches()));
    	}
	}
    
    @Test
    public void testChemin() {
    	
    }
}
