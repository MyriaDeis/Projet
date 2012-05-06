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

    public static void printWays(){
        ArrayList<ArrayList<Fragment>> chemins=Ligne.findWays("La Défense", "Place d'Italie");
        System.out.println("il y a "+chemins.size()+" de chemin");
        for(ArrayList<Fragment> chemin:chemins){
            System.out.println("Chemin : ");
            for(Fragment frag:chemin){
                System.out.print(frag+" => ");
            }
            System.out.println("\n");
        }
    }

    public static ArrayList<ArrayList<Fragment>> findWays(String depart, String search){
        Station stat=Station.recherche(depart);
        ArrayList<ArrayList<Fragment>> chemins=new ArrayList<ArrayList<Fragment>>();
        for(Fragment f:stat.getLfrag()){
            if(f.getDepart().compareTo(depart)==0){
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
                if(f.getDepart().compareTo(troncon.getArrivee())==0){
                    ArrayList<Fragment> cheminClone=(ArrayList<Fragment>)chemin.clone();
                    Ligne.findWaysReccur(f, search, chemins, cheminClone);
                }
            }
        }

    }
    
}
