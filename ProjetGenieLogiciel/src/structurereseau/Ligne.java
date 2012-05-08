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
        ArrayList<ArrayList<Fragment>> chemins=Ligne.findWays(depart, arrivee);

        if(chemins.size()!=0){
            int sizeMin=-1;
            int ind=0;
            for(int i=0; i<chemins.size(); i++){
                int temp=0;
                for(Fragment f:chemins.get(i)){
                    Station statDepart=Station.recherche(f.getDepart());
                    temp+=f.getTps_parcours()+statDepart.getTps_arret(); //tsp darret
                }
                if(sizeMin>temp || sizeMin==-1){
                    ind=i;
                    sizeMin=temp;
                }

            }
            return chemins.get(ind);
        }
        else
            return null;
    }

    public static ArrayList<Fragment> bestWay(String depart, String arrivee){
        ArrayList<ArrayList<Fragment>> chemins=Ligne.findWays(depart, arrivee);

        if(chemins.size()!=0){
            int changementMin=-1;
            int ind=0;
            for(int i=0; i<chemins.size(); i++){
                int temp=0;
                int ligne=chemins.get(i).get(0).getLligne();
                for(Fragment f:chemins.get(i)){
                    if(f.getLligne()!=ligne){
                        temp++;
                        ligne=f.getLligne();
                    }
                }
                if(changementMin>temp || changementMin==-1){
                    ind=i;
                    changementMin=temp;
                }
            }
            return chemins.get(ind);
        }
        else
            return null;
    }

    public static ArrayList<Fragment> personalWay(String depart, String inter, String arrivee){
        //retourne null si aucun chemin
        ArrayList<Fragment> chemin=Ligne.bestWay(depart, inter);
        ArrayList<Fragment> chemin2=Ligne.bestWay(inter, arrivee);
        if(chemin!=null && chemin2!=null){
            chemin.addAll(chemin2);
            return chemin;
        }
        else
            return null;
    }



    public static ArrayList<ArrayList<Fragment>> findWays(String depart, String search){
        Station stat=Station.recherche(depart);
        ArrayList<ArrayList<Fragment>> chemins=new ArrayList<ArrayList<Fragment>>();
        for(Fragment f:stat.getLfrag()){
            Station statArr=Station.recherche(f.getArrivee());
            if(f.getDepart().compareTo(depart)==0 && !f.isIncident() && !statArr.isIncident()){
                ArrayList<Fragment> chemin=new ArrayList<Fragment>();
                Ligne.findWaysReccur(f, search, chemins, chemin);
            }
        }
        return chemins;
    }

    private static void findWaysReccur(Fragment troncon, String search, ArrayList<ArrayList<Fragment>> chemins, ArrayList<Fragment> chemin){
        chemin.add(troncon);
        if(troncon.getArrivee().compareTo(search)==0)
            chemins.add(chemin);
        else{
            Station stat=Station.recherche(troncon.getArrivee());
            for(Fragment f:stat.getLfrag()){
                Station statArr=Station.recherche(f.getArrivee());
                if(f.getDepart().compareTo(troncon.getArrivee())==0 && !f.isIncident() && !statArr.isIncident()){ //incident
                    ArrayList<Fragment> cheminClone=(ArrayList<Fragment>)chemin.clone();
                    Ligne.findWaysReccur(f, search, chemins, cheminClone);
                }
            }
        }

    }
    
    public String avertIncident() {
    	String ret = "Pas d'incident sur la ligne.";
    	for(int i = 0; i < lfrag.size(); i++) {
    		if (lfrag.get(i).isIncident() || Station.recherche(lfrag.get(i).getDepart()).isIncident() || Station.recherche(lfrag.get(i).getArrivee()).isIncident()) {
    			ret = ("Incident en cours sur la ligne " + this.numero);
    		}	
    	}
    	return ret;
    }
}



