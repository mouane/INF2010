package ADT;

import java.util.Random;

public class Compteur implements Comparable<Compteur> {

    private final String nom;        // nom du compteur
    private int compteur = 0;        // initialisation la valeur courant est 0

    
    public Compteur(String id) {
         // completer
    	nom = id;
    } 

   
    public void increment() {
         // completer
    	compteur++;
    } 

   
    public int score() {
         // completer
    	return compteur;
    } 

   
    public String toString() {
         // completer
    	String s= "Nom:  " + nom + " Score:  "+ score();
    	return s;
    	
    } 

  
    public int compareTo(Compteur x) {
                 // completer
    	return Integer.compare(compteur, x.score());
    	//return compteur-x.score();
    }
    
	
      
        private static Random random=new Random(10000);
    
      //Retourne un nombre entier aléatoire uniformément dans [0,n[
	 public static int uniform(int n) {
	                         // completer
		 return random.nextInt(n);
	    }


   
    public static void main(String[] args) { 
        int n = 6;
        int essais = 60000;

        // Creation n compteurs
        Compteur[] Compteur = new Compteur[n];
        for(int i =0; i<n; i++) {
        	String id = Integer.toString(i);
        	Compteur[i]= new Compteur(id);
        }
       
 
         // incrémente les compteurs d'essais au hasard
        for(int i =0; i<essais; i++) {
        	Compteur[uniform(n)].increment();
        }

        // Affichage des resultat
        int somme = 0;
        for (int i=0; i<n; i++) {
        	somme += Compteur[i].score();
        	System.out.println(Compteur[i].toString());
        }
        System.out.println("Score final: "+ somme);
    } 
} 
