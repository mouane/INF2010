package tp5;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		
		// Partie 1: A completer : Création du graphe
		//Graphe Fig 1
				Node A = new Node(1, "A");
				Node B = new Node(2, "B");
				Node C = new Node(3, "C");
				Node D = new Node(4, "D");
				Node E = new Node(5, "E");
				Node F = new Node(6, "F");
				Node G = new Node(7, "G");
				
				//List<Node> nodeGraph = g.getNodes();
				//g.setNodes(nodeGraph);
				
				ArrayList<Node> nodeGraph = new ArrayList<Node>();
				
				nodeGraph.add(A);
				nodeGraph.add(B);
				nodeGraph.add(C);
				nodeGraph.add(D);
				nodeGraph.add(E);
				nodeGraph.add(F);
				nodeGraph.add(G);
				
				g.setNodes(nodeGraph);
				
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

				ArrayList<Edge> edgeGraph = new ArrayList<Edge>();
						//g.getEdges();
				//g.setEdges(edgeGraph);
				
				edgeGraph.add(AB);
				edgeGraph.add(AC);
				
				edgeGraph.add(BA);
				edgeGraph.add(BE);
				edgeGraph.add(BC);
				edgeGraph.add(BD);
				
				edgeGraph.add(CD);
				edgeGraph.add(CB);
				edgeGraph.add(CE);
				edgeGraph.add(CF);
				edgeGraph.add(CA);
				
				edgeGraph.add(DB);
				edgeGraph.add(DC);
				edgeGraph.add(DF);
				edgeGraph.add(DG);
				
				edgeGraph.add(EB);
				edgeGraph.add(EC);
				edgeGraph.add(EF);
				
				edgeGraph.add(FC);
				edgeGraph.add(FD);
				edgeGraph.add(FE);
				edgeGraph.add(FG);
				
				edgeGraph.add(GD);
				edgeGraph.add(GF);
				
				g.setEdges(edgeGraph);
				
				
			
				
				
		// Partie 2: A completer : Implémentation de l’algorithme Dijkstra
		
		Dijkstra d = new Dijkstra(g);
		
		d.findPath(A,G);
		
		d.afficherTable();

		// Partie 3 : Afficher le chemin le plus court
		System.out.println(d.afficherCourtChemin(A,G));
	
	}
}
