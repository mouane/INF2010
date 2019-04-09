package tp5;

import java.util.List;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();

		// Partie 1: A completer : Création du graphe
		/*
		//Graphe Fig 1
		Node A = new Node(1, "A");
		Node B = new Node(2, "B");
		Node C = new Node(3, "C");
		Node D = new Node(4, "D");
		Node E = new Node(5, "E");
		Node F = new Node(6, "F");
		Node G = new Node(7, "G");

		//Ajout des nodes
		List<Node> nodeGraph = g.getNodes();
		g.setNodes(nodeGraph);*/

		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		Node F = new Node("F");
		Node G = new Node("G");

		A.addDestination(B,2);
		A.addDestination(C,1);

		//AB = new Edge(A,B,2);
		//AC = new Edge(A,C,1);

		B.addDestination(A,2);
		B.addDestination(E,3);
		B.addDestination(C,1);
		B.addDestination(D,1);

		//BA = new Edge(B,A,2);
		//BE = new Edge(B,E,3);
		//BC = new Edge(B,C,1);
		//BD = new Edge(B,D,1);

		C.addDestination(D,4);
		C.addDestination(B,2);
		C.addDestination(E,3);
		C.addDestination(F,5);
		C.addDestination(A,1);

		//CD = new Edge(C,D,4);
		//CB = new Edge(C,B,2);
		//CE = new Edge(C,E,3);
		//CF = new Edge(C,F,5);
		//CA = new Edge(C,A,1);

		D.addDestination(B,1);
		D.addDestination(C,1);
		D.addDestination(F,1);
		D.addDestination(G,1);

		//DB = new Edge(D,B,1);
		//DC = new Edge(D,C,4);
		//DF = new Edge(D,F,6);
		//DG = new Edge(D,G,5);

		E.addDestination(B,3);
		E.addDestination(C,3);
		E.addDestination(F,1);

		//EB = new Edge(E,B,3);
		//EC = new Edge(E,C,3);
		//EF = new Edge(E,F,1);

		F.addDestination(C,5);
		F.addDestination(C,6);
		F.addDestination(C,1);
		F.addDestination(C,2);

		//FC = new Edge(F,C,5);
		//FD = new Edge(F,D,6);
		//FE = new Edge(F,E,1);
		//FG = new Edge(F,G,2);

		G.addDestination(C,1);
		G.addDestination(C,2);

		//GD = new Edge(G,D,5);
		//GF = new Edge(G,F,2);


		/*
		Edge AB, AC,BA,BE,BC,BD,CD,CB,CE,CF,CA,DB,DC,DF,DG,EB,EC,EF,FC,FD,FE,FG,GD,GF;

		AB = new Edge(A,B,2);
		AC = new Edge(A,C,1);

		BA = new Edge(B,A,2);
		BE = new Edge(B,E,3);
		BC = new Edge(B,C,1);
		BD = new Edge(B,D,1);

		CD = new Edge(C,D,4);
		CB = new Edge(C,B,2);
		CE = new Edge(C,E,3);
		CF = new Edge(C,F,5);
		CA = new Edge(C,A,1);

		DB = new Edge(D,B,1);
		DC = new Edge(D,C,4);
		DF = new Edge(D,F,6);
		DG = new Edge(D,G,5);

		EB = new Edge(E,B,3);
		EC = new Edge(E,C,3);
		EF = new Edge(E,F,1);

		FC = new Edge(F,C,5);
		FD = new Edge(F,D,6);
		FE = new Edge(F,E,1);
		FG = new Edge(F,G,2);

		GD = new Edge(G,D,5);
		GF = new Edge(G,F,2);

		List<Edge> edgeGraph = g.getEdges();
		g.setEdges(edgeGraph);*/

		g.addNode(A);
		g.addNode(B);
		g.addNode(C);
		g.addNode(D);
		g.addNode(E);
		g.addNode(F);
		g.addNode(G);



		// Partie 2: A completer : Implémentation de l’algorithme Dijkstra


		
		Dijkstra d = new Dijkstra(g);
		//Node debut = A;
		//Node fin = G ;
		List<Node> shortestPathForNodeAG = Arrays.asList(A,G);
		for(int i =0; i<shortestPathForNodeAG.size();i++){
			System.out.println(shortestPathForNodeAG.get(i).getShortestPath());
		}
		g = d.findPath(A,G,g);

		for(int i =0; i<g.getNodes().size();i++){
			System.out.println(g.getNodes().iterator().next().getName());
		}
/*
		for (Node node : g.getNodes()) {
			System.out.println(node.getName());
			//System.out.println(node.getShortestPath());
		}*/


		//d.findPath(A,G,g);
		
		d.afficherTable();

		// Partie 3 : Afficher le chemin le plus court
		System.out.println(d.afficherCourtChemin(A,G));
	
	}
}
