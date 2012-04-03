/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structurereseau;

import java.util.ArrayList;

/**
 *
 * @author Djeremai
 */
public class Ligne {
    
    private ArrayList<Fragment> lfrag;
    private int numero;

    public Ligne(int numero) {
        this.lfrag = new ArrayList<Fragment>();
        this.numero = numero;
    }
    
    public void addFragment(Station s, Fragment f, int tps) {
        Fragment frag = new Fragment(f.getLligne(), f.getArrivee(), s, tps, false);   
        s.addFragment(f);
        lfrag.add(lfrag.indexOf(f), frag);
    }
    
    public void addFragment(Fragment f){
        lfrag.add(f);
    }
    
}
