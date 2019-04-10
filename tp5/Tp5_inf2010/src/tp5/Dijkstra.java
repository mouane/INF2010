package tp5;

import java.util.*;

public class Dijkstra {

	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];
	//private Map<Edge, Node> dijkstraTableInverse[];
	private Stack<Edge> path = new Stack<Edge>();
	private Vector<Edge>edgeList = new Vector<Edge>();
	private Vector<Node>bestNodes = new Vector<Node>();
	

	public Dijkstra (Graph g) {
		this.graph = g;
	}
	public void findPath (Node s, Node d) {

		dijkstraTable = new Map[graph.getNodes().size()];
		for(int i=0;i<graph.getNodes().size();i++) {
			dijkstraTable[i] = new HashMap<Node, Edge>();
		}

	
		
		
		
		// A completer
		
		final int INFINITY = 99999;
		
		for(int i=0;i < graph.getNodes().size();++i) {
			graph.getNodes().get(i).setDistance(INFINITY);
		}

		s.setDistance(0);
		s.found = true;
		
		//la liste avec les edges de la source
		ArrayList<Edge> list = new ArrayList<Edge>(graph.getEdgesGoingFrom(s));
				
		//l'update autour du noeud source
		for(int i=0;i<list.size();++i) {
			
			int tmpIndex = graph.getNodes().indexOf(list.get(i).getDestination());
			// On update la distance des noeuds qui sont la destination du noeud source
			// modifie le node et non le edge
			graph.getNodes().get(tmpIndex).setDistance(list.get(i).getDistance() + s.getDistance());
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
					if( (node.found == false) && (node.getDistance() < min) ) {
						min = node.getDistance();
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
				int distanceNoeud = bestNode.getDistance();
				if( (distanceEdge + distanceNoeud) < graph.getNodes().get(tmpIndex).getDistance()) {
					graph.getNodes().get(tmpIndex).setDistance(list.get(i).getDistance() + bestNode.getDistance());
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
	}/*https://www.baeldung.com/java-dijkstra */

	private static Node getLowestDistanceNode(Set < Node > unsettledNodes) {
		Node lowestDistanceNode = null;
		int lowestDistance = Integer.MAX_VALUE;
		for (Node node: unsettledNodes) {
			int nodeDistance = node.getLongitude();
			if (nodeDistance < lowestDistance) {
				lowestDistance = nodeDistance;
				lowestDistanceNode = node;
			}
		}
		return lowestDistanceNode;
	}

	private Edge getMinimum (Edge e1, Edge e2) {
		// A completer
		if(e1 == null && e2 == null) {
			throw new java.lang.Error("Objet Nul");
		}else{
			if (e2.getDistance() > e1.getDistance()) {
				return e1;
			} else {
				return e2;
			}
		}

	}

	/*
	https://www.baeldung.com/java-dijkstra
	*/
	private static void calculateMinimumDistance(Node evaluationNode,Integer edgeWeigh, Node sourceNode) {
		Integer sourceDistance = sourceNode.getDistance();
		if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
			evaluationNode.setDistance(sourceDistance + edgeWeigh);
			LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
			shortestPath.add(sourceNode);
			evaluationNode.setShortestPath(shortestPath);
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

	public void afficherTable () {
		// A completer
		
	}
}
