package POO;

public class Main {
	public static void main(String[] args) {		
		Etudiant e = new Etudiant("1897453","John",3);
		Etudiant f = new Etudiant("1897413","John",3);
		
			
		e.AjouterNote("INF2010", "Structures de données et algorithmes", 4);		
		e.AjouterNote("LOG2810", "Structures discrètes", 5);
		e.AjouterNote("INF2610", "Noyau d'un système d'exploitation", 3);
		System.out.println(e.equals(f));
		System.out.println(e.toString());
		System.out.println(f.toString());
		
		
 
                



	}
}
