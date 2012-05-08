/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structurereseau;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Djeremai
 */
public class Fragment implements Serializable{
    
    private int lligne;
    private String depart;
    private String arrivee;
    private int tps_parcours;
    private boolean incident;

    public Fragment(int lligne, String depart, String arrivee, int tps_parcours, boolean incident) {
        this.lligne = lligne;
        this.depart = depart;
        this.arrivee = arrivee;
        this.tps_parcours = tps_parcours;
        this.incident = incident;
    }

 
    public boolean isIncident() {
        return incident;
    }

    public int getTemps(){
        return tps_parcours;
    }

    public void setIncident(boolean incident) {
        this.incident = incident;
    }

    public String getArrivee() {
        return arrivee;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public int getLligne() {
        return lligne;
    }

    public int getTps_parcours() {
        return tps_parcours;
    }
    
    public String toString(){
        return depart+" -> "+arrivee;
    }
    
}
