/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structurereseau;

import java.io.*;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Djeremai
 */
public class Station implements Serializable {
    
    private static HashSet<Station> lstation=new HashSet<Station>();
    private String name;
    private ArrayList<Fragment> lfrag;
    private boolean incident;
    private int tps_arret;

    public Station(String name, boolean incident, int tps_arret) {
        this.name = name;
        this.incident = incident;
        this.tps_arret = tps_arret;
        lstation.add(this);
        saveStation();
    }

    public static void saveStation(){
        try {
            ObjectOutputStream st = new ObjectOutputStream(new FileOutputStream(new File("carte")));
            st.writeObject(Station.lstation);
            st.close();
        } catch (Exception ex) {
            System.out.println("Probleme ouverture fichier"+ex);
        }
    }
    
    public static Station recherche(String nom){
        Station st = null;
        for(Station s:lstation){
            if(s.getName().compareTo(nom)==0){
                st= s;
            }
        }
        return st;        
    }

    public static HashSet<Station> loadLstation() {
        try {
            ObjectInputStream st = new ObjectInputStream(new FileInputStream(new File("carte")));
            Station.lstation=(HashSet<Station>)st.readObject();
            st.close();
        } catch (Exception ex) {
            System.out.println("Probleme ouverture fichier");
        }
        return Station.lstation;
    }
    
    
    /*
    public void addStation(Station s, Fragment f){
        Station arr = f.getArrivee();
        f.setArrivee(s);
        Fragment frag = new Fragment(f.getLligne(), s, f.getArrivee(), false);
    }
    */
    public void addFragment(Fragment f){
        this.lfrag.add(f);
    }

    public static HashSet<Station> getLstation() {
        return lstation;
    }
    
    
    public boolean isIncident() {
        return incident;
    }

    public void setIncident(boolean incident) {
        this.incident = incident;
    }

    public String getName() {
        return name;
    }

    public int getTps_arret() {
        return tps_arret;
    }

    public ArrayList<Fragment> getLfrag() {
        return lfrag;
    }
    
    
}
