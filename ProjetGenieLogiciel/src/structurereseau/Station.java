/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structurereseau;

import java.io.*;
import java.io.ObjectInputStream;
import java.util.*;
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

    private static ArrayList<ArrayList<Fragment>> recherche;

    public Station(String name, boolean incident, int tps_arret) {
        this.name = name;
        this.lfrag = new HashSet<Fragment>();
        this.incident = incident;
        this.tps_arret = tps_arret;
        Station.lstation.put(name, this);
    }

 /*
 * methode initialiseCarte utilise un fichier de sauvegarde pour initialiser le reseau si il est present, sinon il
 * le cree puis le sauvegarde
 */  
    public static void initialiseCarte(){
        File reseau = new File("carte");
        if(reseau.exists()){
            GestionFichier.loadReseau();           
        }else{
            initialiseReseau();
            GestionFichier.saveReseau();
        }
    }
    
    public static void initialiseReseau(){
        //ligne 1 - fragments
            Fragment f1 = new Fragment(1, "La Defense", "Charles de Gaulle", 5, false);
            Fragment f1bis = new Fragment(1, "Charles de Gaulle", "La Defense", 5, false);
            Fragment f2 = new Fragment(1, "Charles de Gaulle", "Chatelet", 2, false);
            Fragment f2bis = new Fragment(1, "Chatelet", "Charles de Gaulle", 2, false);
            Fragment f3 = new Fragment(1, "Chatelet", "Bastille", 9, false);
            Fragment f3bis = new Fragment(1, "Bastille", "Chatelet", 9, false);
            Fragment f4 = new Fragment(1, "Bastille", "Nation", 7, false);
            Fragment f4bis = new Fragment(1, "Nation", "Bastille", 7, false);
            Fragment f5 = new Fragment(1, "Nation", "Chateau de Vincennes", 10, false);
            Fragment f5bis = new Fragment(1, "Chateau de Vincennes", "Nation", 10, false);
            //ligne 2 - fragments
            Fragment f6 = new Fragment(2, "Porte Dauphine", "Charles de Gaulle", 4, false);
            Fragment f6bis = new Fragment(2, "Charles de Gaulle", "Porte Dauphine", 4, false);
            Fragment f7 = new Fragment(2, "Charles de Gaulle", "Villiers", 6, false);
            Fragment f7bis = new Fragment(2, "Villiers", "Charles de Gaulle", 6, false);
            Fragment f8 = new Fragment(2, "Villiers", "Barbes", 10, false);
            Fragment f8bis = new Fragment(2, "Barbes", "Villiers", 10, false);
            Fragment f9 = new Fragment(2, "Barbes", "Stalingrad", 8, false);
            Fragment f9bis = new Fragment(2, "Stalingrad", "Barbes", 8, false);
            Fragment f10 = new Fragment(2, "Stalingrad", "Pere Lachaise", 7, false);
            Fragment f10bis = new Fragment(2, "Pere Lachaise", "Stalingrad", 7, false);
            Fragment f11 = new Fragment(2, "Pere Lachaise", "Nation", 4, false);
            Fragment f11bis = new Fragment(2, "Nation", "Pere Lachaise", 4, false);
            //ligne 3 - fragments
            Fragment f12 = new Fragment(3, "Pont de Levallois", "Villiers", 9, false);
            Fragment f12bis = new Fragment(3, "Villiers", "Pont de Levallois", 9, false);
            Fragment f13 = new Fragment(3, "Villiers", "Reaumur Sebastopol", 12, false);
            Fragment f13bis = new Fragment(3, "Reaumur Sebastopol", "Villiers", 12, false);
            Fragment f14 = new Fragment(3, "Reaumur Sebastopol", "Republique", 4, false);
            Fragment f14bis = new Fragment(3, "Republique", "Reaumur Sebastopol", 4, false);
            Fragment f15 = new Fragment(3, "Republique", "Pere Lachaise", 8, false);
            Fragment f15bis = new Fragment(3, "Pere Lachaise", "Republique", 8, false);
            Fragment f16 = new Fragment(3, "Pere Lachaise", "Gallieni", 6, false);
            Fragment f16bis = new Fragment(3, "Gallieni", "Pere Lachaise", 6, false);
            //ligne 4 - fragments
            Fragment f17 = new Fragment(4, "Porte de Clignancourt", "Barbes", 5, false);
            Fragment f17bis = new Fragment(4, "Barbes", "Porte de Clignancourt", 5, false);
            Fragment f18 = new Fragment(4, "Barbes", "Gare du Nord", 3, false);
            Fragment f18bis = new Fragment(4, "Gare du Nord", "Barbes", 3, false);
            Fragment f19 = new Fragment(4, "Gare du Nord", "Reaumur Sebastopol", 5, false);
            Fragment f19bis = new Fragment(4, "Reaumur Sebastopol", "Gare du Nord", 5, false);
            Fragment f20 = new Fragment(4, "Reaumur Sebastopol", "Chatelet", 3, false);
            Fragment f20bis = new Fragment(4, "Chatelet", "Reaumur Sebastopol", 3, false);
            Fragment f21 = new Fragment(4, "Chatelet", "Montparnasse", 13, false);
            Fragment f21bis = new Fragment(4, "Montparnasse", "Chatelet", 13, false);
            Fragment f22 = new Fragment(4, "Montparnasse", "Porte d'Orleans", 6, false);
            Fragment f22bis = new Fragment(4, "Porte d'Orleans", "Montparnasse", 6, false);
            //ligne 5 - framgents
            Fragment f23 = new Fragment(5, "Bobigny", "Stalingrad", 10, false);
            Fragment f23bis = new Fragment(5, "Stalingrad", "Bobigny", 10, false);
            Fragment f24 = new Fragment(5, "Stalingrad", "Gare du Nord", 6, false);
            Fragment f24bis = new Fragment(5, "Gare du Nord", "Stalingrad", 6, false);
            Fragment f25 = new Fragment(5, "Gare du Nord", "Republique", 6, false);
            Fragment f25bis = new Fragment(5, "Republique", "Gare du Nord", 6, false);
            Fragment f26 = new Fragment(5, "Republique", "Bastille", 12, false);
            Fragment f26bis = new Fragment(5, "Bastille", "Republique", 12, false);
            Fragment f27 = new Fragment(5, "Bastille", "Place d'Italie", 13, false);
            Fragment f27bis = new Fragment(5, "Place d'Italie", "Bastille", 13, false);
            //ligne 6 - fragments
            Fragment f28 = new Fragment(6, "Charles de Gaulle", "Montparnasse", 15, false);
            Fragment f28bis = new Fragment(6, "Montparnasse", "Charles de Gaulle", 15, false);
            Fragment f29 = new Fragment(6, "Montparnasse", "Place d'Italie", 5, false);
            Fragment f29bis = new Fragment(6, "Place d'Italie", "Montparnasse", 5, false);
            Fragment f30 = new Fragment(6, "Place d'Italie", "Nation", 15, false);
            Fragment f30bis = new Fragment(6, "Nation", "Place d'Italie", 15, false);
            //ligne 1 - stations
            Station ladef = new Station("La Defense", false, 5);
            ladef.addFragment(f1);
            ladef.addFragment(f1bis);
            Station charl = new Station("Charles de Gaulle", false, 3);
            charl.addFragment(f1);
            charl.addFragment(f1bis);
            charl.addFragment(f2);
            charl.addFragment(f2bis);
            charl.addFragment(f6);
            charl.addFragment(f6bis);
            charl.addFragment(f7);
            charl.addFragment(f7bis);
            charl.addFragment(f28);
            charl.addFragment(f28bis);
            Station chatel = new Station("Chatelet", false, 2);
            chatel.addFragment(f2);
            chatel.addFragment(f2bis);
            chatel.addFragment(f3);
            chatel.addFragment(f3bis);
            chatel.addFragment(f20);
            chatel.addFragment(f20bis);
            chatel.addFragment(f21);
            chatel.addFragment(f21bis);
            Station basti = new Station("Bastille", false, 3);
            basti.addFragment(f3);
            basti.addFragment(f3bis);
            basti.addFragment(f4);
            basti.addFragment(f4bis);
            basti.addFragment(f26);
            basti.addFragment(f26bis);
            basti.addFragment(f27);
            basti.addFragment(f27bis);
            Station natio = new Station("Nation", false, 5);
            natio.addFragment(f4);
            natio.addFragment(f4bis);
            natio.addFragment(f5);
            natio.addFragment(f5bis);
            natio.addFragment(f11);
            natio.addFragment(f11bis);
            natio.addFragment(f30);
            natio.addFragment(f30bis);
            Station chateau = new Station("Chateau de Vincennes", false, 1);
            chateau.addFragment(f5); 
            //ligne 1
            Ligne une = new Ligne(1);
            une.addFragment(f1);
            une.addFragment(f1bis);
            une.addFragment(f2);
            une.addFragment(f2bis);
            une.addFragment(f3);
            une.addFragment(f3bis);
            une.addFragment(f4);
            une.addFragment(f4bis);
            une.addFragment(f5);
            une.addFragment(f5bis);
            //ligne 2 - stations
            Station ported = new Station("Porte Dauphine", false, 4);
            ported.addFragment(f6);
            ported.addFragment(f6bis);
            Station villi = new Station("Villiers", false, 5);
            villi.addFragment(f7);
            villi.addFragment(f7bis);
            villi.addFragment(f8);
            villi.addFragment(f8bis);
            villi.addFragment(f12);
            villi.addFragment(f12bis);
            villi.addFragment(f13);
            villi.addFragment(f13bis);
            Station barbe = new Station("Barbes", false, 5);
            barbe.addFragment(f8);
            barbe.addFragment(f8bis);
            barbe.addFragment(f9);
            barbe.addFragment(f9bis);
            barbe.addFragment(f17);
            barbe.addFragment(f17bis);
            barbe.addFragment(f18);
            barbe.addFragment(f18bis);
            Station stali = new Station("Stalingrad", false, 5);
            stali.addFragment(f9);
            stali.addFragment(f9bis);
            stali.addFragment(f10);
            stali.addFragment(f10bis);
            stali.addFragment(f23);
            stali.addFragment(f23bis);
            stali.addFragment(f24);
            stali.addFragment(f24bis);
            Station perel = new Station("Pere Lachaise", false, 5);
            perel.addFragment(f10);
            perel.addFragment(f10bis);
            perel.addFragment(f11);
            perel.addFragment(f11bis);
            perel.addFragment(f15);
            perel.addFragment(f15bis);
            perel.addFragment(f16);         
            perel.addFragment(f16bis);         
            //ligne 2
            Ligne deux = new Ligne(2);
            deux.addFragment(f6);
            deux.addFragment(f6bis);
            deux.addFragment(f7);
            deux.addFragment(f7bis);
            deux.addFragment(f8);
            deux.addFragment(f8bis);
            deux.addFragment(f9);
            deux.addFragment(f9bis);
            deux.addFragment(f10);
            deux.addFragment(f10bis);
            deux.addFragment(f11);
            deux.addFragment(f11bis);
            //ligne 3 - stations
            Station pontl = new Station("Pont de Levallois", false, 5);
            pontl.addFragment(f12);
            pontl.addFragment(f12bis);
            Station reaum = new Station("Reaumur Sebastopol", false, 5);
            reaum.addFragment(f13);
            reaum.addFragment(f13bis);
            reaum.addFragment(f14);
            reaum.addFragment(f14bis);
            reaum.addFragment(f19);
            reaum.addFragment(f19bis);
            reaum.addFragment(f20);
            reaum.addFragment(f20bis);
            Station repub = new Station("Republique", false, 5);
            repub.addFragment(f14);
            repub.addFragment(f14bis);
            repub.addFragment(f15);
            repub.addFragment(f15bis);
            repub.addFragment(f25);
            repub.addFragment(f25bis);
            repub.addFragment(f26);
            repub.addFragment(f26bis);
            Station galli = new Station("Gallieni", false, 5);
            galli.addFragment(f16);
            galli.addFragment(f16bis);
            
            //ligne 3
            Ligne trois = new Ligne(3);
            trois.addFragment(f12);
            trois.addFragment(f12bis);
            trois.addFragment(f13);
            trois.addFragment(f13bis);
            trois.addFragment(f14);
            trois.addFragment(f14bis);
            trois.addFragment(f15);
            trois.addFragment(f15bis);
            trois.addFragment(f16);
            trois.addFragment(f16bis);
            //ligne 4 - stations
            Station portec = new Station("Porte de Clignancourt", false, 5);
            portec.addFragment(f17);
            portec.addFragment(f17bis);
            Station garen = new Station("Gare du Nord", false, 5);
            garen.addFragment(f18);
            garen.addFragment(f18bis);
            garen.addFragment(f19);
            garen.addFragment(f19bis);
            garen.addFragment(f24);
            garen.addFragment(f24bis);
            garen.addFragment(f25);
            garen.addFragment(f25bis);
            Station monpa = new Station("Montparnasse", false, 5);
            monpa.addFragment(f21);
            monpa.addFragment(f21bis);
            monpa.addFragment(f22);
            monpa.addFragment(f22bis);
            monpa.addFragment(f28);
            monpa.addFragment(f28bis);
            monpa.addFragment(f29);
            monpa.addFragment(f29bis);
            Station porteo = new Station("Porte d'Orleans", false, 5);
            porteo.addFragment(f22);
            porteo.addFragment(f22bis);
            
            //ligne 4
            Ligne quatre = new Ligne(4);
            quatre.addFragment(f17);
            quatre.addFragment(f17bis);
            quatre.addFragment(f18);
            quatre.addFragment(f18bis);
            quatre.addFragment(f19);
            quatre.addFragment(f19bis);
            quatre.addFragment(f20);
            quatre.addFragment(f20bis);
            quatre.addFragment(f21);
            quatre.addFragment(f21bis);
            quatre.addFragment(f22);
            quatre.addFragment(f22bis);
            //ligne 5 - stations
            Station bobig = new Station("Bobigny", false, 5);
            bobig.addFragment(f23);          
            bobig.addFragment(f23bis);          
            Station place = new Station("Place d'Italie", false, 5);
            place.addFragment(f27);
            place.addFragment(f27bis);
            place.addFragment(f29);
            place.addFragment(f29bis);
            place.addFragment(f30);
            place.addFragment(f30bis);
            
            //ligne 5
            Ligne cinq = new Ligne(5);
            cinq.addFragment(f23);
            cinq.addFragment(f23bis);
            cinq.addFragment(f24);
            cinq.addFragment(f24bis);
            cinq.addFragment(f25);
            cinq.addFragment(f25bis);
            cinq.addFragment(f26);
            cinq.addFragment(f26bis);
            cinq.addFragment(f27);
            cinq.addFragment(f27bis);
            
            //ligne 6
            Ligne six = new Ligne(6);
            six.addFragment(f28);
            six.addFragment(f28bis);
            six.addFragment(f29);
            six.addFragment(f29bis);
            six.addFragment(f30);
            six.addFragment(f30bis);

    }

/*
 * en principe termin�
 */
    public static void chemin(ArrayList<Fragment> parcours, String depart, String arrivee) { // parcours : effectu� jusqu'� pr�sent
		Station but = lstation.get(arrivee);
		if (parcours == null) { // on commence la recherche
			Station dep = lstation.get(depart);
			recherche = new ArrayList<ArrayList<Fragment>>();
			for (Fragment f : dep.lfrag) {
				if (f.getDepart().compareTo(dep.name) == 0) {
					ArrayList<Fragment> tmp = new ArrayList<Fragment>();
					tmp.add(f);
					chemin(tmp, depart, arrivee);
				}
			}
		} else {
			if (parcours.get(parcours.size() - 1).getArrivee().compareTo(but.name) == 0) { // condition d'arr�t : chemin trouv� entre les 2 stations
				// ajout de ce parcours � " tous "
				recherche.add(parcours);
			} else {
				// sinon on explore les fragments suivants
				Station s_tmp = lstation.get(parcours.get(parcours.size() - 1).getArrivee());
				for (Fragment f : s_tmp.lfrag) {
					// 																		.. et si on n'est pas d�j� pass� par ce fragment
					if (parcours.get(parcours.size() - 1).getArrivee().compareTo(f.getDepart()) == 0 && !(parcours.contains(f))) {
						ArrayList<Fragment> copieParcours = parcours;
						copieParcours.add(copieParcours.size(), f);
						chemin(copieParcours, depart, arrivee);
					}
				}
			}
		}
	}
    
	public static ArrayList<Fragment> fastestWay(String depart, String arrivee) {
		int temps_parcours = 2222, tmp;
		ArrayList<Fragment> itineraire = new ArrayList<Fragment>();
		chemin(null, depart, arrivee);
		for (ArrayList<Fragment> l : recherche) {
			tmp = 0;
			for (Fragment f : l)
				tmp += f.getTps_parcours();
			if (tmp < temps_parcours) {
				temps_parcours = tmp;
				itineraire = l;
			}
		}
		return itineraire;
	}
	
/*
 * itin�raire avec le moins de changements de ligne
 */
	public static ArrayList<Fragment> bestWay(String depart, String arrivee) {
		int nb_chgt = 5555, tmp = 0;
		ArrayList<Fragment> itineraire = new ArrayList<Fragment>();
		chemin(null, depart, arrivee);
		for (ArrayList<Fragment> l : recherche) {
			tmp = l.size();
			if (tmp < nb_chgt) {
				itineraire = l;
				nb_chgt = tmp;
			}
		}
		return itineraire;
	}
/*
 * itin�raire personnalis� (et le plus rapide)
 */
	public static ArrayList<Fragment> personalWay(String depart, String inter, String arrivee) {
		Station desiree = lstation.get(inter);
		boolean passeParDesiree;
		int temps_parcours = 2222, tmp;
		ArrayList<Fragment> itineraire = new ArrayList<Fragment>();
		
		chemin(null, depart, arrivee);
		for (ArrayList<Fragment> l : recherche) {
			passeParDesiree = false;
			tmp = 0;
			for (Fragment f : l) {
				tmp += f.getTps_parcours();
				if (f.getArrivee().compareTo(desiree.name) == 0)
					passeParDesiree = true;
			}
			if (tmp < temps_parcours && passeParDesiree) {
				temps_parcours = tmp;
				itineraire = l;
			}
		}
		return itineraire;
	}
	
	public static Station recherche(String nom){
        Station st = lstation.get(nom);      
        return st;        
    }
    
    public ArrayList<Station> stationsProches() {
    	ArrayList<Station> tmp = new ArrayList<Station>();
    	for (Fragment f : lfrag){
            if(f.getDepart().compareTo(this.getName())==0)
    		tmp.add(recherche(f.getArrivee()));
        }
    	return tmp;
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
    public static Station geolocalisation(){
        Random generator = new Random();
        Object[] values = (Station.getLstation().values().toArray());
        return (Station)(values[generator.nextInt(values.length)]);
    }
    
    public static String afficheTrajet(ArrayList<Fragment> trajet){
        String res = "Aucun chemin disponible";
        if(!trajet.isEmpty()){
            int ligneCourante = trajet.get(0).getLligne();
            res="Prenez la ligne "+ligneCourante+" en diretion de "+trajet.get(0).getArrivee();
            for(int i =1;i<trajet.size();i++){
                if(trajet.get(i).getLligne()!=ligneCourante){
                    ligneCourante = trajet.get(i).getLligne();
                    res+="\nArrive a "+trajet.get(i).getDepart()+" prenez la lignne "+ligneCourante+" en direction de "+trajet.get(i).getArrivee();
                }else
                    res+="\nVous passez par "+trajet.get(i).getArrivee();
            }
        }
        return res;
    }
    
     public String avertIncident() {
    	String ret = "La station fonctionne normalement";
    	if (this.isIncident()) {
    		ret = ("Incident en cours dans la station " + this.name);
    	}
    	return ret;
    }
      
     public static int tempsEntre2Stations(String s1, String s2) {
                ArrayList<Fragment> itineraire = Ligne.fastestWay(s1, s2);
                if (itineraire.size() == 0)
                        return -1;
                else {
                        int res = 0;
                        for (Fragment f : itineraire)
                                res += f.getTps_parcours();
                        return res;
                }
        }
}
