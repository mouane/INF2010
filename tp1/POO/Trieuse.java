package POO;


import java.util.Arrays;
import java.util.Comparator;


public class Trieuse {
   
    public static final Comparator<Etudiant> Par_nom    = new NomOrdre();
    public static final Comparator<Etudiant> Par_section = new SectionOrdre();
    


    private static class NomOrdre implements Comparator<Etudiant> {
        public int compare(Etudiant x, Etudiant y) {
           // completer
        	return x.getNom().compareTo(y.getNom());
        	
        }
    }


    private static class SectionOrdre implements Comparator<Etudiant> {
        public int compare(Etudiant x, Etudiant y) {
             // completer
        	return Integer.compare(x.getSection(), y.getSection());

        }
    }
                
          // Ajouter des méthodes  ParNom() et ParSection()
    public static void ParNom(Etudiant[] etudiants){
    	//completer
    	Arrays.sort(etudiants, Par_nom);
    }
    public static void ParSection(Etudiant[] etudiants) {
    	//completer
    	Arrays.sort(etudiants, Par_section);
    }
  
               

   
    public static void main(String[] args) {

       
        Etudiant e = new Etudiant("1897453","John",3);
		
			
        e.AjouterNote("INF2010", "Structures de données et algorithmes", 4);		
        e.AjouterNote("LOG2810", "Structures discrètes", 5);
        e.AjouterNote("INF2610", "Noyau d'un système d'exploitation", 3);
        System.out.println("Notes");
        System.out.println("----------");
        e.afficherEnsembleDesNotes();
        System.out.println("Moyenne des notes: "+ e.NoteMoyenne());
        System.out.println("----------");
        //System.out.println(e.NoteMoyenne());
        

        Etudiant John     = new Etudiant("1797453","John",  2);
        Etudiant Caroline = new Etudiant("1897053","Caroline",    1);
        Etudiant Antoine  = new Etudiant("1297453","Antoine",  2);
        Etudiant Karl     = new Etudiant("1797433","Karl",   1);
        Etudiant Ahmed    = new Etudiant("1897453","Ahmed",    2);
        Etudiant Sam      = new Etudiant("1977411","Sam",  3);
       
        Etudiant[] etudiants = {
            John, Antoine, Caroline, Karl, Ahmed, Sam
        };

         // Completer le pseudo-code pour trie les etudiants par nom -section 
        System.out.println("Par le nom en ordre d�croissant ");
        System.out.println("----------");
               // Completer
        ParNom(etudiants);
        for (Etudiant etudiants_array: etudiants){
        	System.out.println(etudiants_array.getNom());
        }
        System.out.println("----------");
        



        System.out.println("Par section en ordre d�croissant");
        System.out.println("----------");
                 // Completer
        ParSection(etudiants);
        for (Etudiant etudiants_array: etudiants){
        	System.out.println(etudiants_array.getNom()+ " avec la section: "+ etudiants_array.getSection());
        }
        System.out.println("----------");

        //return true;
        Etudiant carlos = new Etudiant("1698853","carlos", 3);
        Etudiant Ines = new Etudiant("1897456","Ines", 2);


        System.out.println("carlos == Ines:        " + (carlos == Ines));
        System.out.println("carlos == carlos:      " + (carlos.equals(carlos)));
        System.out.println("carlos.equals(Ines):   " + (carlos.equals(Ines)));

        

    }
}

