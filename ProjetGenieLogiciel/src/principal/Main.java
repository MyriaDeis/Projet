/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import structurereseau.Fragment;
import structurereseau.Station;

/**
 *
 * @author Djeremai
 */
public class Main {
     public static void main(String[] args){
        Station.initialiseCarte();
        System.out.println(Station.getLstation().get("La Défense").getName());
    }
}
