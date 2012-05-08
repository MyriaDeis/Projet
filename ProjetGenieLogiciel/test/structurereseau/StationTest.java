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
        Station.initialiseReseau();
        Station s1 = new Station("stat", true, 4); 
        Station s2 = new Station("stat2", true, 5); 
    }
    

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
/*
    @Test
    public void testTempsEntre2Stations() {
    	ArrayList<Station> list = (ArrayList<Station>) Station.getLstation().values();
    	Station s1 = list.get((int) (Math.random() * list.size())), s2 = null;
    	while (! s1.equals(s2)) {
    		s2 = list.get((int) (Math.random() * list.size()));
    	}
		assertEquals(s1.tempsEntre2Stations(s2), s2.tempsEntre2Stations(s1));
    }
  */  
    @Test
	public void testStationsProches() { // �a marche nickel !
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
  
    /**
     * Test of fastestWay method, of class Ligne.
     */
    @Test
    public void testFastestWay() {
        System.out.println("fastestWay");
        assertEquals(true, Station.fastestWay("Bobigny", "Gare du Nord").containsAll(Station.fastestWay("Gare du Nord", "Bobigny")));
/*      String depart = "La Défense";
        String arrivee = "Place d'Italie";
        ArrayList<Fragment> expResult = new ArrayList<Fragment>();
        expResult.add(new Fragment(1, "La Défense", "Charles de Gaulle", 5, false));
        expResult.add(new Fragment(6, "Charles de Gaulle", "Montparnasse", 15, false));
        expResult.add(new Fragment(6, "Montparnasse", "Place d'Italie", 5, false));
        ArrayList<Fragment> result = Station.fastestWay(depart, arrivee);*/
    }

    /**
     * Test of bestWay method, of class Ligne.
     */
    @Test
    public void testBestWay() {
        System.out.println("bestWay");
        assertEquals(true, Station.bestWay("Bobigny", "Gare du Nord").containsAll(Station.bestWay("Gare du Nord", "Bobigny")));
/*      String depart = "La Défense";
        String arrivee = "Place d'Italie";
        ArrayList<Fragment> expResult = new ArrayList<Fragment>();
        expResult.add(new Fragment(1, "La Défense", "Charles de Gaulle", 5, false));
        expResult.add(new Fragment(6, "Charles de Gaulle", "Montparnasse", 15, false));
        expResult.add(new Fragment(6, "Montparnasse", "Place d'Italie", 5, false));
        ArrayList<Fragment> result = Station.bestWay(depart, arrivee);
        assertEquals(expResult.toString(), result.toString());
*/

    }

    /**
     * Test of personalWay method, of class Ligne.
     */
    @Test
    public void testPersonalWay() {
        System.out.println("personalWay");
        assertEquals(true, Station.personalWay("Bobigny", "Stalingrad", "Gare du Nord").containsAll(Station.personalWay("Gare du Nord", "Stalingrad", "Bobigny")));
/*      String depart = "La Défense";
        String inter = "République";
        String arrivee = "Place d'Italie";
        ArrayList<Fragment> expResult = new ArrayList<Fragment>();
        expResult.add(new Fragment(1, "La Défense", "Charles de Gaulle", 5, false));
        expResult.add(new Fragment(2, "Charles de Gaulle", "Villiers", 6, false));
        expResult.add(new Fragment(2, "Villiers", "Barbès", 10, false));
        expResult.add(new Fragment(2, "Barbès", "Stalingrad", 8, false));
        expResult.add(new Fragment(5, "Stalingrad", "Gare du Nord", 6, false));
        expResult.add(new Fragment(5, "Gare du Nord", "République", 6, false));
        expResult.add(new Fragment(5, "République", "Bastille", 12, false));
        expResult.add(new Fragment(5, "Bastille", "Place d'Italie", 13, false));
        ArrayList<Fragment> result = Station.personalWay(depart, inter, arrivee);
        assertEquals(expResult.toString(), result.toString());
*/
    }
}
