package tp5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

public class Dijkstra {

	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];
	private Map<Edge, Node> dijkstraTableInverse[];
	private Stack<Edge> path;
	private Vector<Edge> edgeList;
	private Vector<Node> bestNodes;
	

	public Dijkstra (Graph g) {
		this.graph = g;
	}

	public void findPath (Node s, Node d) {

		dijkstraTable = new HashMap[graph.getNodes().size()];
		for(int i=0;i<graph.getNodes().size();i++) {
			dijkstraTable[i] = new HashMap<Node, Edge>();
		}
		//dijkstraTableInverse = new HashMap[graph.getNodes().size()];
		path = new Stack<Edge>();
		edgeList = new Vector<Edge>();
		bestNodes = new Vector<Node>();
		
		//4C dans le tableau a la place de 4D a la palce E5.
		
		// A compléter
		
		final int INFINITY = 99999;
		
		for(int i=0;i < graph.getNodes().size();++i) {
			graph.getNodes().get(i).distance = INFINITY;
		}

		s.distance = 0;
		s.found = true;
		
		//la liste avec les edges de la source
		ArrayList<Edge> list = new ArrayList<Edge>(graph.getEdgesGoingFrom(s));
				
		//l'update autour du noeud source
		for(int i=0;i<list.size();++i) {
			
			int tmpIndex = graph.getNodes().indexOf(list.get(i).getDestination());
			// On update la distance des noeuds qui sont la destination du noeud source
			// modifie le node et non le edge
			graph.getNodes().get(tmpIndex).distance = list.get(i).getDistance() + s.distance;
		}
		
		
		int currentLength = 0;
		int iteration = 0;
		Edge edgeA_A = new Edge(s,s,0);
		dijkstraTable[iteration].put(s, edgeA_A);	//pk il chiale ici??????
		//dijkstraTableInverse[iteration].put(edgeA_A, s);
		edgeList.add(edgeA_A);
		path.add(edgeA_A);
		bestNodes.add(s);
		
		iteration++;
		
		for(;d.found == false;iteration++) {
			
			int min = INFINITY;
			
			// Trouver le prochain noeud
			Node bestNode = new Node();
			int bestNodeIndex = 0;
			{	int i = 0;
				//on parcours tous les nodes
				for(Node node : graph.getNodes()) {
					//si le node n'est pas dans l'ensemble et si sa valeur est plus petite
					if( (node.found == false) && (node.distance < min) ) {
						min = node.distance;
						bestNode = node; // El bestos nodos
						bestNodeIndex = i;
					}
					i++;
				}
			}			

			bestNodes.add(bestNode);
			
			//le node trouvee fait partie de l'ensemble.
			graph.getNodes().get(bestNodeIndex).found = true;
			
			Edge bestEdge = new Edge();
			int minEdgeValue = INFINITY;

			//il faut trouver le edge min et l'ajouter au path
			for(int i = 0; i<graph.getEdges().size(); i++) {
				if( (graph.getEdges().get(i).getDestination() == bestNode) && 			//est-ce que la destination est bonne 
						(graph.getEdges().get(i).getDistance() <= minEdgeValue) &&		//on cherche le meilleur edge
						(graph.getEdges().get(i).getSource().found == true)		 			//on verifie si la source est trouvee
						
						) {
					
					minEdgeValue = graph.getEdges().get(i).getDistance();
					bestEdge = graph.getEdges().get(i);
				}
			}
			
			//put DestinationNode, edge
			edgeList.add(bestEdge);
			//dijkstraTable[iteration].put(bestNode, bestEdge);
			//dijkstraTableInverse[iteration].put(bestEdge, bestNode);
			
			//ajout du edge au path
			int iteration2 = iteration;

				while( edgeList.get(iteration2-1).getDestination() != bestEdge.getSource() ) {
					path.pop();
					iteration2--;
					if(iteration2 < 0 || path.size() <= 1 )
						break;
				}
				
			
			//on a besoin de faire un seul add toujours...
			
				path.add(bestEdge);
			
			//la liste avec les edges du bestNode
			list = new ArrayList<Edge>(graph.getEdgesGoingFrom(bestNode));
			
			//l'update
			for(int i=0;i<list.size();++i) {
				//List<Node> tmpNodeList = graph.getNodes();
				//retourne l'index du noeud de destination
				int tmpIndex = graph.getNodes().indexOf(list.get(i).getDestination());
				// On update la distance des noeuds qui sont la destination du noeud source
				// modifie le node et non le edge
				
				//il faut v�rifier si la nouvelle somme est plus petite et si oui on update.
				int distanceEdge = list.get(i).getDistance();
				int distanceNoeud = bestNode.distance;
				if( (distanceEdge + distanceNoeud) < graph.getNodes().get(tmpIndex).distance) {
					graph.getNodes().get(tmpIndex).distance = list.get(i).getDistance() + bestNode.distance;
					//dijkstraTable[iteration].put(graph.getNodes().get(tmpIndex), list.get(i));
				}
			}
			
			//on parcours tous les nodes
			for(int i=0;i<graph.getNodes().size();i++) {
				for(int j=0;j<list.size();j++) {
					if(graph.getNodes().get(i) == list.get(j).getDestination())
						dijkstraTable[iteration].put( graph.getNodes().get(i), list.get(j) );
				}
			}
			
		}
		
		
	}

	private Node getMinimum(Map<Node, Edge> map) {
		Edge min = null;
		for (Node Key : map.keySet()) {
			if ( min == null || map.get(Key).getDistance() < min.getDistance()) {
				min = map.get(Key); 
			}
		}
		return min.getDestination();
	}

	private Edge getMinimum (Edge e1, Edge e2) {
		// A completer
		if( e1.getDistance() < e2.getDistance() ) {
			return e1;
		}
		else {
			return e2;
		}
	}
	
	public String afficherCourtChemin (Node source, Node destination) {
		// A completer
		String chemin = "Voici le chemin le plus court: \n";

		for(int i=1;i<path.size();i++) {
			chemin += path.get(i).getSource().getName() + "->" + 
					path.get(i).getDestination().getName()+ ", ";
		}
		
		return chemin;
	}
	
	public String afficherEdgeList() {
		String chemin = "";

		for(int i=0;i<edgeList.size();i++) {
			chemin += edgeList.get(i).getSource().getName() + "->" + 
					edgeList.get(i).getDestination().getName()+ ", ";
		}
		
		return chemin;
	}

	public void afficherTable () {
		// A completer
		String table = "Table de Dijkstra: \n" +
		"A	B	C	D	E	F	G	\n";
		
		//on parcours chaque iteration de la table
		for(int i=0;i<graph.getNodes().size();i++) {
			
			//on parcours toutes les nodes diff�rents
			for(int j=0;j<graph.getNodes().size();j++) {

 
				switch ( graph.getNodes().get(j).getName() ) {
				
					case "A":
						if(dijkstraTable[i].get(graph.getNodes().get(j)) != null) {
							if(dijkstraTable[i].get(graph.getNodes().get(j)).getDistance() != 99999 ) {
								table += dijkstraTable[i].get(graph.getNodes().get(j)).getDistance() + dijkstraTable[i].get(graph.getNodes().get(j)).getSource().getName() + "	";
							}
							else {
								table += ".	";
							}
						}
						break;
					case "B":
						if(dijkstraTable[i].get(graph.getNodes().get(j)) != null) {
							if(dijkstraTable[i].get(graph.getNodes().get(j)).getDistance() != 99999 ) {
								table += dijkstraTable[i].get(graph.getNodes().get(j)).getDistance() + dijkstraTable[i].get(graph.getNodes().get(j)).getSource().getName() + "	";
							}
							else {
								table += ".	";
							}
						}
						break;
					case "C":
						if(dijkstraTable[i].get(graph.getNodes().get(j)) != null) {
							if(dijkstraTable[i].get(graph.getNodes().get(j)).getDistance() != 99999 ) {
								table += dijkstraTable[i].get(graph.getNodes().get(j)).getDistance() + dijkstraTable[i].get(graph.getNodes().get(j)).getSource().getName() + "	";
							}
							else {
								table += ".	";
							}
						}
						break;
					case "D":
						if(dijkstraTable[i].get(graph.getNodes().get(j)) != null) {
							if(dijkstraTable[i].get(graph.getNodes().get(j)).getDistance() != 99999 ) {
								table += dijkstraTable[i].get(graph.getNodes().get(j)).getDistance() + dijkstraTable[i].get(graph.getNodes().get(j)).getSource().getName() + "	";
							}
							else {
								table += ".	";
							}
						}
						break;
					case "E":
						if(dijkstraTable[i].get(graph.getNodes().get(j)) != null) {
							if(dijkstraTable[i].get(graph.getNodes().get(j)).getDistance() != 99999 ) {
								table += dijkstraTable[i].get(graph.getNodes().get(j)).getDistance() + dijkstraTable[i].get(graph.getNodes().get(j)).getSource().getName() + "	";
							}
							else {
								table += ".	";
							}
						}
						break;
					case "F":
						if(dijkstraTable[i].get(graph.getNodes().get(j)) != null) {
							if(dijkstraTable[i].get(graph.getNodes().get(j)).getDistance() != 99999 ) {
								table += dijkstraTable[i].get(graph.getNodes().get(j)).getDistance() + dijkstraTable[i].get(graph.getNodes().get(j)).getSource().getName() + "	";
							}
							else {
								table += ".	";
							}
						}
						break;
					case "G":
						if(dijkstraTable[i].get(graph.getNodes().get(j)) != null) {
							if(dijkstraTable[i].get(graph.getNodes().get(j)).getDistance() != 99999 ) {
								table += dijkstraTable[i].get(graph.getNodes().get(j)).getDistance() + dijkstraTable[i].get(graph.getNodes().get(j)).getSource().getName() + "	";
							}
							else {
								table += ".	";
							}
						}
						break;
			
			
				}
			}//for2
			table += "\n";
			
			
		}
		
		
		System.out.println(table);
	}
}
















