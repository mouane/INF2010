
public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		
		// Partie 1: A completer : Création du graphe
		
		
		// Partie 2: A completer : Implémentation de l’algorithme Dijkstra
		
		Dijkstra d = new Dijkstra(g);
		
		d.findPath(/* Spécifiez les paramètres */);
		
		d.afficherTable();

		// Partie 3 : Afficher le chemin le plus court
		System.out.println(d.afficherCourtChemin(/* Spécifiez les paramètres */));
	
	}
}
