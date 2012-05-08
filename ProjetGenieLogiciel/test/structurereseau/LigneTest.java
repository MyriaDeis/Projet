/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structurereseau;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.*;
import static org.junit.Assert.*;
import principal.GestionFichier;

/**
 *
 * @author Djeremai
 */
public class LigneTest {
    
    public LigneTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Station.initialiseReseau();
        //incident sur le fragment chatelet-bastille
        Ligne l1 = Ligne.getlLignes().get(1);
        System.out.println("l1 : "+l1.getNumero());
        l1.getLfrag().get(2).setIncident(true);
        //incident sur la station Réaumur Sébastopol et Barbès
        Station.getLstation().get("Réaumur Sébastopol").setIncident(true);
    }
   
    /**
     * Test of fastestWay method, of class Ligne.
     */
    @Test
    public void testFastestWay() {
        System.out.println("fastestWay");
        String depart = "La Défense";
        String arrivee = "Place d'Italie";
        ArrayList<Fragment> expResult = new ArrayList<Fragment>();
        expResult.add(new Fragment(1, "La Défense", "Charles de Gaulle", 5, false));
        expResult.add(new Fragment(1, "Charles de Gaulle", "Châtelet", 2, false));
        expResult.add(new Fragment(4, "Châtelet", "Montparnasse", 13, false));
        expResult.add(new Fragment(6, "Montparnasse", "Place d'Italie", 5, false));
        ArrayList result = Ligne.fastestWay(depart, arrivee);
        assertEquals(expResult.toString(), result.toString());

    }

    /**
     * Test of bestWay method, of class Ligne.
     */
    @Test
    public void testBestWay() {
        System.out.println("bestWay");
        String depart = "La Défense";
        String arrivee = "Place d'Italie";
        ArrayList<Fragment> expResult = new ArrayList<Fragment>();
        expResult.add(new Fragment(1, "La Défense", "Charles de Gaulle", 5, false));
        expResult.add(new Fragment(6, "Charles de Gaulle", "Montparnasse", 15, false));
        expResult.add(new Fragment(6, "Montparnasse", "Place d'Italie", 5, false));
        ArrayList result = Ligne.bestWay(depart, arrivee);
        assertEquals(expResult.toString(), result.toString());

    }

    /**
     * Test of personalWay method, of class Ligne.
     */
    @Test
    public void testPersonalWay() {
        System.out.println("personalWay");
        String depart = "La Défense";
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
        ArrayList result = Ligne.personalWay(depart, inter, arrivee);
        assertEquals(expResult.toString(), result.toString());
    }

}
