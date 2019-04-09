package tp5;

import javax.management.RuntimeErrorException;
import java.util.*;

public class Dijkstra {

	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];
	private Stack<Edge> path;
	

	public Dijkstra (Graph g) {
		this.graph = g;
	}

	public static Graph findPath (Node s, Node d, Graph g) {

		//dijkstraTable = new HashMap[graph.getNodes().size()];
		//path = new Stack<Edge>();



		// A compléter
		/*for(int i=0;i<graph.getNodes().size();i++) {
			dijkstraTable[i] = new HashMap<Node, Edge>();
		}*/

		Set<Node> settledNodes = new HashSet<>();
		Set<Node> unsettledNodes = new HashSet<>();

		unsettledNodes.add(d);

		while (unsettledNodes.size() != 0) {
			Node currentNode = s;
			unsettledNodes.remove(currentNode);
			for (Map.Entry< Node, Integer> adjacencyPair: currentNode.getAdjacentNodes().entrySet()) {
				Node adjacentNode = adjacencyPair.getKey();
				Integer edgeWeight = adjacencyPair.getValue();
				if (!settledNodes.contains(adjacentNode)) {
					calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
					unsettledNodes.add(adjacentNode);
				}
			}
			settledNodes.add(currentNode);
		}

		return g;
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
	private static void calculateMinimumDistance(Node evaluationNode,
												 Integer edgeWeigh, Node sourceNode) {
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
		return "Hello";
	}

	public void afficherTable () {
		// A completer
		
	}
}
