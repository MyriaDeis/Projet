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
        //incident sur la station Reaumur Sebastopol
        Station.getLstation().get("Reaumur Sebastopol").setIncident(true);
    }
   
    /**
     * Test of fastestWay method, of class Ligne.
     */
    @Test
    public void testFastestWay() {
        System.out.println("fastestWay");
        String depart = "La Defense";
        String arrivee = "Place d'Italie";
        ArrayList<Fragment> expResult = new ArrayList<Fragment>();
        expResult.add(new Fragment(1, "La Defense", "Charles de Gaulle", 5, false));
        expResult.add(new Fragment(6, "Charles de Gaulle", "Montparnasse", 15, false));
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
        String depart = "La Defense";
        String arrivee = "Place d'Italie";
        ArrayList<Fragment> expResult = new ArrayList<Fragment>();
        expResult.add(new Fragment(1, "La Defense", "Charles de Gaulle", 5, false));
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
        String depart = "La Defense";
        String inter = "Republique";
        String arrivee = "Place d'Italie";
        ArrayList<Fragment> expResult = new ArrayList<Fragment>();
        expResult.add(new Fragment(1, "La Defense", "Charles de Gaulle", 5, false));
        expResult.add(new Fragment(2, "Charles de Gaulle", "Villiers", 6, false));
        expResult.add(new Fragment(2, "Villiers", "Barbes", 10, false));
        expResult.add(new Fragment(2, "Barbes", "Stalingrad", 8, false));
        expResult.add(new Fragment(5, "Stalingrad", "Gare du Nord", 6, false));
        expResult.add(new Fragment(5, "Gare du Nord", "Republique", 6, false));
        expResult.add(new Fragment(5, "Republique", "Bastille", 12, false));
        expResult.add(new Fragment(5, "Bastille", "Place d'Italie", 13, false));
        ArrayList result = Ligne.personalWay(depart, inter, arrivee);
        System.out.println("expected : "+expResult.toString());
        System.out.println("was : "+result.toString());
        assertEquals(expResult.toString(), result.toString());
    }

}
