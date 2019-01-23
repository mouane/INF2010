package POO;

import java.util.Comparator;
import java.util.Arrays;

public class Etudiant {
	final int N = 10;
	private String Matr;
	private String nom;
	private String prenom;	
	private String email; 
	private int section; 	
	private int n_des_notes;
	private NoteCours [] notes;
	
	
	
	 public Etudiant(String Matr,String nom, int section) {
              //completer
		 this.Matr = Matr;
		 this.nom = nom;
		 this.prenom = null;
		 this.section = section;
		 this.email = null;
		 this.section =0;
		 this.n_des_notes = 0;
		 notes= new NoteCours[N];
		
		
		 
	    }
        
         
	
	public void AjouterNote(String sigle, String titre, int note){ 
		
			NoteCours temp = new NoteCours();
			temp.sigle = sigle;
			temp.titre = titre;
			temp.note= note;
			
			this.notes[n_des_notes] = temp;
					
			this.n_des_notes++;
		
	}
	
	public double NoteMoyenne(){
		//completer
		double somme =0, noteMoyenne =0;
		for(int i =0; i<n_des_notes; i++) {
			somme+= notes[i].note;
		}
		noteMoyenne = somme/n_des_notes;
		return noteMoyenne;
	}

	public String getMatr() {
		return this.Matr;
	}

	public void setMatr(String matr) {
		this.Matr = matr;
	}

        public String getEmail() {
                   //completer
        return this.email;
	}

	public void setEmail(String email) {
                      //completer
		this.email = email;
	}

	public String getNom() {
		//completer
		return this.nom;
	}
    
	
	public void setNom(String nom) {
		//completer
		this.nom = nom;
	}

	public String getPrenom() {
		//completer
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		//completer
		this.prenom = prenom;
	}
	
	public int getSection() {
		return section  ;
	}
	
    public String toString() {
        // completer
    	String etudiant = "L'etudiant matricule: " + this.Matr + " nom: " 
    			+ this.nom + " section " + this.section;
    	return etudiant;
    			
    }
    
    public boolean equals(Object etudiant_x) {

    
    	if(etudiant_x==null) {
    		return false;
    	}
    	else if(etudiant_x == this) {
    		return true;
    	}
    	else if(etudiant_x.getClass() == this.getClass()) {
    		if(((Etudiant) etudiant_x).getMatr() == this.Matr &&((Etudiant) etudiant_x).getNom() == this.nom &&((Etudiant) etudiant_x).getSection()== this.section) {
        		return true;
        	}
    		else {
    			return false;
    		}
    	
    	}
    	
    	else return false;
    	
    }
    
   
}
