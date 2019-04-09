package tp5;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Graph {

	//private List<Node> nodes; // Noeuds
	private List<Edge> edges; // Les arcs
	
	public Graph() {
		// A compléter
		this.edges = this.getEdges();

		this.nodes = this.getNodes();
	}
	
	public List<Edge> getEdgesGoingFrom(Node source) {
		// A complèter
		List<Edge> out = new ArrayList<Edge>();
		for (Edge e : edges) {// ou alors on utilise une boucle for ? avec pointe = edges.get(i).getSource(); // On regarde le debut de cette edge/*if(pointe == source){outgoing.add(edges.get(i));}*/
			if(e.getSource() == source){
				out.add(e);}
		}
		return out;
		
	}
	public List<Edge> getEdgesGoingTo(Node dest) {
		// A complèter
		List<Edge> in = new ArrayList<Edge>();
		for (Edge e : edges) {
			if(e.getDestination() == dest && e.getSource() != dest){
				in.add(e);}
		}
		return in;
	}
	
	// Accesseurs
	/*
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	*/
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	private Set<Node> nodes = new HashSet<>();



	public void addNode(Node nodeA) {

		nodes.add(nodeA);

	}



	public Set<Node> getNodes() {

		return nodes;

	}



	public void setNodes(Set<Node> nodes) {

		this.nodes = nodes;

	}

}

