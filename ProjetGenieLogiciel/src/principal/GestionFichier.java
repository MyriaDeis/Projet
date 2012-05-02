/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.*;
import java.util.HashMap;
import structurereseau.Ligne;
import structurereseau.Station;

/**
 *
 * @author Djeremai
 */
public class GestionFichier {
    
    public static boolean saveReseau(){
        try {
            ObjectOutputStream st = new ObjectOutputStream(new FileOutputStream(new File("carte")));
            st.writeObject(Ligne.getlLignes());
            st.writeObject(Station.getLstation());
            st.close();
        } catch (Exception ex) {
            System.out.println("Probleme ouverture fichier"+ex);
            return false;
        }
        System.out.println("Fichier carte sauvegardé");
        return true;
    }
    
    public static boolean loadReseau() {
        try {
            ObjectInputStream st = new ObjectInputStream(new FileInputStream(new File("carte")));
            Ligne.setlLignes((HashMap<Integer,Ligne>)st.readObject());
            Station.setLstation((HashMap<String,Station>)st.readObject());
            st.close();
        } catch (Exception ex) {
            System.out.println("Probleme ouverture fichier");
            return false;
        }
        System.out.println("Fichier carte chargé");
        return true;
    }
}
