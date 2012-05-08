/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;
import java.util.Scanner;
import structurereseau.Fragment;
import structurereseau.Station; 
import structurereseau.Ligne;
/**
 *
 * @author Djeremai
 */
public class Main {
     public static void main(String[] args){
     	Station.initialiseCarte();
        Station statCourante = Station.geolocalisation();
        Scanner sc = new Scanner(System.in);
        int chx =0;
        while(chx !=8){
            System.out.println("\nBienvenue dans ItiMiage, le logiciel d'itineraire du metro de Paris");
            System.out.println("Vous etes actuellement a "+statCourante.getName());
            System.out.println("Que desirez-vous faire ?");
            System.out.println("1-Itineraire le plus rapide vers une station");
            System.out.println("2-Itineraire le plus facile vers une station");
            System.out.println("3-Itineraire personnalise");
            System.out.println("4-Connaitre l'etat d'une ligne");
            System.out.println("5-Connaitre l'etat d'une station");
            System.out.println("6-Connaitre les stations les plus proches");
            System.out.println("7-Connaitre le temps de trajet entre deux stations");
            System.out.println("8-Quitter");
               try{
                    chx = sc.nextInt();
                    switch(chx) {

                    case 1 :
                            System.out.println("A quelle station voulez-vous arriver?");
                            String s = sc.next();
                            s+=sc.nextLine();
                            System.out.println(Station.afficheTrajet(Ligne.fastestWay(statCourante.getName(), s)));
                            break;
                    case 2 : 
                            System.out.println("A quelle station voulez-vous arriver?");
                            String sa = sc.next();
                            sa+=sc.nextLine();
                            System.out.println("Itineraire avec le moins de changment de ligne possible :\n");
                            System.out.println(Station.afficheTrajet(Ligne.bestWay(statCourante.getName(), sa)));
                            break;
                    case 3 :
                            System.out.println("A quelle station voulez-vous arriver?");
                            String st = sc.next();
                            st+=sc.nextLine();
                            System.out.println("Par quelle station voulez-vous passer?");
                            String perso = sc.next();
                            perso+=sc.nextLine();
                            System.out.println(Station.afficheTrajet(Ligne.personalWay(statCourante.getName(), perso, st)));
                            break;
                    case 4 :
                            System.out.println("Quelle est la ligne dont vous voulez connaitre l'etat?");
                            String sl = sc.next();
                            sl+=sc.nextLine();
                            System.out.println(Ligne.getlLignes().get(Integer.parseInt(sl)).avertIncident());
                            break;
                    case 5 :
                            System.out.println("Quelle est la station dont vous voulez connaitre l'etat?");
                            String so = sc.next();
                            so+=sc.nextLine();
                            System.out.println(so);
                            System.out.println(Station.getLstation().get(so).avertIncident());
                            break;
                    case 6 :
                            ArrayList<Station> fstation = statCourante.stationsProches();
                            System.out.println("Stations proches de "+statCourante.getName()+" :\n");
                            for (int i = 0; i < fstation.size(); i++) {
                                System.out.println(fstation.get(i).getName()+"\n");
                            }

                            break;
                    case 7 :
                            System.out.println("Quelle est la station dont vous voulez partir?");
                            String sdep = sc.next();
                            sdep+=sc.nextLine();
                            System.out.println("Quelle est la station ou vous voulez arriver?");
                            String sarr = sc.next();
                            sarr+=sc.nextLine();
                            int tps = Station.tempsEntre2Stations(sdep, sarr);
                            System.out.println("Entre la station " + sdep + " et la station " + sarr + ", il y a " + tps + " minutes de trajet");
                            break;
                    case 8 :
                            System.out.println("La ville de Paris vous remercie d'avoir utilise ItiMiage");
                            System.out.println("A la prochaine");
                            break;
                    default :
                            System.out.println("Erreur de saisie");
                            break;
                    }
                }catch (Exception e){
                    System.out.println("Probleme avec une station entree");
                }
        }
    }
}
