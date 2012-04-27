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
    
    private HashSet<Ligne> lligne;
    private Station depart;
    private Station arrivee;
    private int tps_parcours;
    private boolean incident;

    public Fragment(HashSet<Ligne> lligne, Station depart, Station arrivee, int tps_parcours, boolean incident) {
        this.lligne = lligne;
        this.depart = depart;
        this.arrivee = arrivee;
        this.tps_parcours = tps_parcours;
        this.incident = incident;
    }

    
    
    public boolean isIncident() {
        return incident;
    }

    public void setIncident(boolean incident) {
        this.incident = incident;
    }

    public Station getArrivee() {
        return arrivee;
    }

    public void setArrivee(Station arrivee) {
        this.arrivee = arrivee;
    }

    public Station getDepart() {
        return depart;
    }

    public void setDepart(Station depart) {
        this.depart = depart;
    }

    public HashSet<Ligne> getLligne() {
        return lligne;
    }
    
    
    
}
