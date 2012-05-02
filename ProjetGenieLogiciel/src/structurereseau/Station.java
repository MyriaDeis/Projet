/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structurereseau;

import java.io.*;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import principal.GestionFichier;

/**
 *
 * @author Djeremai
 */
public class Station implements Serializable {
    
    private static HashMap<String, Station> lstation=new HashMap<String,Station>();
    private String name;
    private HashSet<Fragment> lfrag;
    private boolean incident;
    private int tps_arret;

    public Station(String name, boolean incident, int tps_arret) {
        this.name = name;
        this.lfrag = new HashSet<Fragment>();
        this.incident = incident;
        this.tps_arret = tps_arret;
        lstation.put(name, this);
    }

    public static void initialiseCarte(){
        File reseau = new File("carte");
        if(reseau.exists()){
            GestionFichier.loadReseau();           
        }else{
            //ligne 1 - fragments
            Fragment f1 = new Fragment(1, "La Défense", "Charles de Gaulle", 5, false);
            Fragment f2 = new Fragment(1, "Charles de Gaulle", "Châtelet", 2, false);
            Fragment f3 = new Fragment(1, "Châtelet", "Bastille", 9, false);
            Fragment f4 = new Fragment(1, "Bastille", "Nation", 7, false);
            Fragment f5 = new Fragment(1, "Nation", "Chateau de Vincennes", 10, false);
            //ligne 2 - fragments
            Fragment f6 = new Fragment(2, "Porte Dauphine", "Charles de Gaulle", 4, false);
            Fragment f7 = new Fragment(2, "Charles de Gaulle", "Villiers", 6, false);
            Fragment f8 = new Fragment(2, "Villiers", "Barbès", 10, false);
            Fragment f9 = new Fragment(2, "Barbès", "Stalingrad", 8, false);
            Fragment f10 = new Fragment(2, "Stalingrad", "Père Lachaise", 7, false);
            Fragment f11 = new Fragment(2, "Père Lachaise", "Nation", 4, false);
            //ligne 3 - fragments
            Fragment f12 = new Fragment(3, "Pont de Levallois", "Villiers", 9, false);
            Fragment f13 = new Fragment(3, "Villiers", "Réaumur Sébastopol", 12, false);
            Fragment f14 = new Fragment(3, "Réaumur Sébastopol", "République", 4, false);
            Fragment f15 = new Fragment(3, "République", "Père Lachaise", 8, false);
            Fragment f16 = new Fragment(3, "Père Lachaise", "Gallieni", 6, false);
            //ligne 4 - fragments
            Fragment f17 = new Fragment(4, "Porte de Clignancourt", "Barbès", 5, false);
            Fragment f18 = new Fragment(4, "Barbès", "Gare du Nord", 3, false);
            Fragment f19 = new Fragment(4, "Gare du Nord", "Réaumur Sébastopol", 5, false);
            Fragment f20 = new Fragment(4, "Réaumur Sébastopol", "Châtelet", 3, false);
            Fragment f21 = new Fragment(4, "Châtelet", "Montparnasse", 13, false);
            Fragment f22 = new Fragment(4, "Montparnasse", "Porte d'Orléans", 6, false);
            //ligne 5 - framgents
            Fragment f23 = new Fragment(5, "Bobigny", "Stalingrad", 10, false);
            Fragment f24 = new Fragment(5, "Stalingrad", "Gare du Nord", 6, false);
            Fragment f25 = new Fragment(5, "Gare du Nord", "République", 6, false);
            Fragment f26 = new Fragment(5, "République", "Bastille", 12, false);
            Fragment f27 = new Fragment(5, "Bastille", "Place d'Italie", 13, false);
            //ligne 6 - fragments
            Fragment f28 = new Fragment(6, "Charles de Gaulle", "Montparnasse", 15, false);
            Fragment f29 = new Fragment(6, "Montparnasse", "Place d'Italie", 5, false);
            Fragment f30 = new Fragment(6, "Place d'Italie", "Nation", 15, false);
            //ligne 1 - stations
            Station ladef = new Station("La Défense", false, 5);
            ladef.addFragment(f1);
            Station charl = new Station("Charles de Gaulle", false, 3);
            charl.addFragment(f1);
            charl.addFragment(f2);
            charl.addFragment(f6);
            charl.addFragment(f7);
            Station chatel = new Station("Châtelet", false, 2);
            chatel.addFragment(f2);
            chatel.addFragment(f3);
            chatel.addFragment(f20);
            chatel.addFragment(f21);
            Station basti = new Station("Bastille", false, 3);
            basti.addFragment(f3);
            basti.addFragment(f4);
            basti.addFragment(f26);
            basti.addFragment(f27);
            Station natio = new Station("Nation", false, 5);
            natio.addFragment(f4);
            natio.addFragment(f5);
            natio.addFragment(f11);
            natio.addFragment(f30);
            Station chateau = new Station("Chateau de Vincennes", false, 1);
            chateau.addFragment(f5); 
            //ligne 1
            Ligne une = new Ligne(1);
            une.addFragment(f1);
            une.addFragment(f2);
            une.addFragment(f3);
            une.addFragment(f4);
            une.addFragment(f5);
            //ligne 2 - stations
            Station ported = new Station("Porte Dauphine", false, 4);
            ported.addFragment(f6);
            Station villi = new Station("Villiers", false, 5);
            villi.addFragment(f7);
            villi.addFragment(f8);
            villi.addFragment(f12);
            villi.addFragment(f13);
            Station barbe = new Station("Barbès", false, 5);
            barbe.addFragment(f8);
            barbe.addFragment(f9);
            barbe.addFragment(f17);
            barbe.addFragment(f18);
            Station stali = new Station("Stalingrad", false, 5);
            stali.addFragment(f9);
            stali.addFragment(f10);
            stali.addFragment(f23);
            stali.addFragment(f24);
            Station perel = new Station("Père Lachaise", false, 5);
            perel.addFragment(f10);
            perel.addFragment(f11);
            perel.addFragment(f15);
            perel.addFragment(f16);         
            //ligne 2
            Ligne deux = new Ligne(2);
            deux.addFragment(f6);
            deux.addFragment(f7);
            deux.addFragment(f8);
            deux.addFragment(f9);
            deux.addFragment(f10);
            deux.addFragment(f11);
            //ligne 3 - stations
            Station pontl = new Station("Pont de Levallois", false, 5);
            pontl.addFragment(f12);
            Station reaum = new Station("Réaumur Sébastopol", false, 5);
            reaum.addFragment(f13);
            reaum.addFragment(f14);
            reaum.addFragment(f19);
            reaum.addFragment(f20);
            Station repub = new Station("République", false, 5);
            repub.addFragment(f14);
            repub.addFragment(f15);
            repub.addFragment(f25);
            repub.addFragment(f26);
            Station galli = new Station("Gallieni", false, 5);
            galli.addFragment(f16);
            
            //ligne 3
            Ligne trois = new Ligne(3);
            trois.addFragment(f12);
            trois.addFragment(f13);
            trois.addFragment(f14);
            trois.addFragment(f15);
            trois.addFragment(f16);
            //ligne 4 - stations
            Station portec = new Station("Porte de Clignancourt", false, 5);
            portec.addFragment(f17);
            Station garen = new Station("Gare du Nord", false, 5);
            garen.addFragment(f18);
            garen.addFragment(f19);
            garen.addFragment(f24);
            garen.addFragment(f25);
            Station monpa = new Station("Montparnasse", false, 5);
            monpa.addFragment(f21);
            monpa.addFragment(f22);
            monpa.addFragment(f28);
            monpa.addFragment(f29);
            Station porteo = new Station("Porte d'Orléans", false, 5);
            porteo.addFragment(f22);
            
            //ligne 4
            Ligne quatre = new Ligne(4);
            quatre.addFragment(f17);
            quatre.addFragment(f18);
            quatre.addFragment(f19);
            quatre.addFragment(f20);
            quatre.addFragment(f21);
            quatre.addFragment(f22);
            //ligne 5 - stations
            Station bobig = new Station("Bobigny", false, 5);
            bobig.addFragment(f23);          
            Station place = new Station("Place d'Italie", false, 5);
            place.addFragment(f27);
            place.addFragment(f29);
            place.addFragment(f30);
            
            //ligne 5
            Ligne cinq = new Ligne(5);
            cinq.addFragment(f23);
            cinq.addFragment(f24);
            cinq.addFragment(f25);
            cinq.addFragment(f26);
            cinq.addFragment(f27);
            
            //ligne 6
            Ligne six = new Ligne(6);
            six.addFragment(f28);
            six.addFragment(f29);
            six.addFragment(f30);

            GestionFichier.saveReseau();
        }
    }
    
    
    
    public static Station recherche(String nom){
        Station st = lstation.get(nom);      
        return st;        
    }
    
    
    
    
    /*
    public void addStation(Station s, Fragment f){
        Station arr = f.getArrivee();
        f.setArrivee(s);
        Fragment frag = new Fragment(f.getLligne(), s, f.getArrivee(), false);
    }
    */
    public void addFragment(Fragment frag){
        this.lfrag.add(frag);
    }

    public static HashMap<String, Station> getLstation() {
        return lstation;
    }

    public static void setLstation(HashMap<String, Station> lstation) {
        Station.lstation = lstation;
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

    public HashSet<Fragment> getLfrag() {
        return lfrag;
    }
    
    
}
