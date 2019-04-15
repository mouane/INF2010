package tp5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Dijkstra {

private Graph graph;
private Map<Node, Edge> dijkstraTable[];
private Stack<Edge> path;
private List<Node> nodePath;
private Map<Node, Integer> Distances;


public Dijkstra (Graph g) {
	this.graph = g;
}

public void findPath (Node s, Node d) {
	dijkstraTable = new HashMap[graph.getNodes().size()];
	for(int i = 0; i < graph.getNodes().size(); ++i){
		dijkstraTable[i] = new HashMap();
	}
	path = new Stack<Edge>();
	nodePath = new ArrayList<Node>();
	Distances = new HashMap();

	//add start node to nodePath with cost of 0
	int iteration = 0;
	Distances.put(s, 0);
	nodePath.add(s);
	Boolean Arrived = false;
	while(!Arrived){
		iteration++;
		for(Node n : dijkstraTable[iteration-1].keySet()){
			dijkstraTable[iteration].put(n,dijkstraTable[iteration-1].get(n));
		}
		//update distances:
		//for every edge the most recent node added to path presents
		for(Node n : nodePath){
			for(Edge e : graph.getEdgesGoingFrom(n)){
				//if its' destination hasn't been visited
				if(!(nodePath.contains(e.getDestination()))){
					int knownDistance = 0;
					//if we already have a way to get there
					if(Distances.get(e.getDestination()) != null){
						knownDistance = Distances.get(e.getDestination());
						//if the current option is shorter
						if(Distances.get(n) + e.getDistance() < knownDistance){
							//update the distance table
							Distances.remove(e.getDestination());
							Distances.put(e.getDestination(),Distances.get(n) + e.getDistance());
							//map node -> edge
							dijkstraTable[iteration].remove(e.getDestination());
							dijkstraTable[iteration].put(e.getDestination(), e);
						}
					}
					else{//this is the first time we find a way to get to this node
						Distances.put(e.getDestination(),Distances.get(n) + e.getDistance());
						//map node -> edge
						dijkstraTable[iteration].put(e.getDestination(), e);
					}
				}
				//else destination has been visited
			}//end for
		}
		//decide which edge is best to use next:
		Edge best = null;
		//go through the Distances
		for(Node m : Distances.keySet()){
			//go through nodes that haven't been visited
			if(!(nodePath.contains(m))){
				//if its better than what we have
				if(best == null || Distances.get(m) < Distances.get(best.getDestination())){
					//the best edge is now the one to get to that node
					best = dijkstraTable[iteration].get(m);
				}
			}
		}
		//write that down
		nodePath.add(best.getDestination());
		if(best.getDestination()==d){
			Arrived = true;
		}
	}//end while
	//fill path using nodePath and Map
	Edge toAdd = null;
	Node It = d;
	while(It != s){
		toAdd = dijkstraTable[iteration].get(It);
		path.add(toAdd);
		It = toAdd.getSource();
	}
}//end findPath

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
	if(e1.getDistance() < e2.getDistance())
		return e1;
	return e2;
}

public String afficherCourtChemin (Node source, Node destination) {
	String s = "";
	findPath(source, destination);
	int cost = 0;
	for(Edge e : path){
		s = e.getDestination().getName() + " -> " + s;
		cost+=e.getDistance();
	}
	return ("Le chemin le plus court entre les nodes " + source.getName() + " et " + destination.getName() + " est :\n" + source.getName() + " -> " +s.substring(0, s.length()-4)+ " et a une distance parcourue de " + cost + '\n');
}

public void afficherTable () {
	List<Node> shown = new ArrayList<Node>();
	System.out.print("Iter"+'\t');//Iter in top left corner
	for(Node n : graph.getNodes()){
		System.out.print(n.getName()+'\t');//columns for every node
	}
	System.out.print('\n');
	//special case for first iteration the "edge" leading to start node isnt in dijkstra table
	System.out.print(1+"\t");//first iteration
	for(Node n : graph.getNodes()){//for every node in the graph
		if(nodePath.get(0)==n){
			System.out.print(0+n.getName()+'\t');
		}
		else{
			System.out.print("-\t");
		}
	}
	System.out.print('\n');
	for(int k = 1; k < graph.getNodes().size() && k<nodePath.size(); ++k){//for every iteration of dijkstra after the first
		System.out.print((k+1)+"\t");//iteration number
		for(Node n : graph.getNodes()){//for every node in the graph
			if(dijkstraTable[k].get(n) == null){//if we don't have a way to get there
				System.out.print("-\t");
			}
			else{//show the best way to get there currently (distance + node to use to get there)
				if(!shown.contains(n)){//don't keep displaying the best way if you've already used it
					System.out.print((Distances.get(dijkstraTable[k].get(n).getSource())+dijkstraTable[k].get(n).getDistance()) + dijkstraTable[k].get(n).getSource().getName()+'\t');
					if(nodePath.get(k)==n){//this is the node we went to
						shown.add(n);
					}
				}
				else{
					System.out.print("-\t");
				}
			}
		}
		System.out.print('\n');
	}
}
}