package ADT;

import java.util.Random;
import java.lang.Math;

public class Simulation {
	 private static Random random;  

	 //Retourne un nombre réel aléatoire uniformément dans [0,1[
	    public static double uniform() {
	        //completer
	    	//Random r = new Random();
	    	//double valeur = 0 + r.nextInt(1 - 0);
	    	//double valeur = Math.random();
	    	//double valeur = new Random().nextDouble();
	    	//System.out.println("valeur uniform" + valeur);
	    	//return valeur ;
	    	return new Random().nextDouble();
	    }

	 
	 
	 //Retourne un nombre entier aléatoire uniformément dans [0,n[
	    public static int uniform(int n) {
	        //completer
	    	//Random r = new Random();
	    	//int valeur = r.nextInt(n);
	    	//int valeur = (int) Math.random()*n;
	    	//System.out.println("valeur uniform  " + valeur);
	    	//return valeur;
	    	return random.nextInt(n);
	    }

	//Retourne un entier long aléatoire uniformément dans [0, n[.
        // Vous pouviez trouver le code https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#longs-long-long-long-
    public static long uniform(long n) {
        if (n <= 0L) throw new IllegalArgumentException("Argument doit etre positive: " + n);


        long r = random.nextLong();
        long m = n - 1;

        
        if ((n & m) == 0L) {
            return r & m;
        }

      
        long u = r >>> 1;
        while (u + m - (r = u % n) < 0L) {
            u = random.nextLong() >>> 1;
        }
        return r;
    }
    
    //Retourne avec succès un booléen true si p suit d'une distribution de Bernoulli
    public static boolean bernoulli(double p) {
       //completer
    	//return (p>= 0 && p<=1);
    	return p>=0.5;
    	//return ( p < uniform());
    	
    	//if(p<uniform(n))
    	
    }
    
    public static Compteur max(Compteur x, Compteur y) {
      // completer
    	if(x.score()>y.score()) {
    		return x;
    	}
    	return y;
    	
    }
	
	 public static void main(String[] args) {
	        int n = 10;
	        Compteur pile = new Compteur("pile");
	        Compteur face = new Compteur("face");
	       
              //Les instructions du simulation
                   //completer
              //afficher la différence entre les score des compteur
	        for (int i =0; i<n;i++) {
	        	double random = uniform();
	        	if(Simulation.bernoulli(random)) {
	        		pile.increment();
	        	}else {
	        		face.increment();
	        	}
	        }
	        System.out.println("Affichage de la diff�rence entre les score des compteurs " +Math.abs((pile.score()-face.score())));
	        
	        Compteur pile_c = new Compteur("pile");
	        Compteur face_c = new Compteur("face");
		        
	          //Les instructions du simulation
                   //completer
                   //afficher le maximum entre les score des compteur
	        for (int i =0; i<n;i++) {
	        	double random = uniform();
	        	if(Simulation.bernoulli(random)) {
	        		pile.increment();
	        	}else {
	        		face.increment();
	        	}
	        }
	        System.out.println("Affichage de maximum entre les scores des compteurs: " +   max(pile,face).score());
	        }
	    
	        
	    }



