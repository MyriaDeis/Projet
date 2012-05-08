/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structurereseau;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Djeremai
 */
public class Ligne implements Serializable{
    
    private static HashMap<Integer,Ligne> lLignes = new HashMap<Integer, Ligne>();
    private ArrayList<Fragment> lfrag;
    private int numero;

    public Ligne(int numero) {
        this.lfrag = new ArrayList<Fragment>();
        this.numero = numero;
        lLignes.put(numero, this);
    }
    
    /*public void addFragment(Station s, Fragment f, int tps) {
        Fragment frag = new Fragment(f.getLligne(), f.getArrivee(), s, tps, false);   
        s.addFragment(f);
        lfrag.add(lfrag.indexOf(f), frag);
    }*/
    
    public void addFragment(Fragment f){
        lfrag.add(f);
    }

    public int getNumero() {
        return numero;
    }

    
    public static HashMap<Integer, Ligne> getlLignes() {
        return lLignes;
    }

    
    public static void setlLignes(HashMap<Integer, Ligne> lLignes) {
        Ligne.lLignes = lLignes;
    }

    public ArrayList<Fragment> getLfrag() {
        return lfrag;
    }

    public static ArrayList<Fragment> fastestWay(String depart, String arrivee){
            return null;
    }

    public static ArrayList<Fragment> bestWay(String depart, String arrivee){
            return null;
    }

    public static ArrayList<Fragment> personalWay(String depart, String inter, String arrivee){
            return null;
    }

}



