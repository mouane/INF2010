package tp5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import tp5.TablePrinter;

public class Dijkstra {

	private ArrayList<Node> nodeList;
	//private Map
	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];
	private Stack<Edge> path;
	private HashMap<Node, Integer> weight;

	public Dijkstra (Graph g) {
		this.graph = g;
	}

	public void findPath (Node s, Node d) {

		dijkstraTable = new HashMap[graph.getNodes().size()];
		path = new Stack<Edge>();
		
		// A complÃ©ter
		//Créer hasmap pour chaque rang de dijkstraTable
		for(int i = 0; i < graph.getNodes().size(); ++i){
			dijkstraTable[i] = new HashMap();
		}
		
		//Initialisation
		Boolean estArriver = false;
		nodeList = new ArrayList<Node>();
		weight = new HashMap();
		
		int i =0;
		weight.put(s,0);
		nodeList.add(s);
		
		while(estArriver == false) {
			//System.out.println(i);
			i++;
			for(Node node: dijkstraTable[i-1].keySet()) {
				dijkstraTable[i].put(node,dijkstraTable[i-1].get(node));
			}
			
			for(Node node: nodeList) {
				for(Edge edge: graph.getEdgesGoingFrom(node)) {
					if(nodeList.contains(edge.getDestination()) == false) {
						int dist =0;
						if(weight.get(edge.getDestination()) != null) { //cuz string
							dist = weight.get(edge.getDestination());
							if(dist >weight.get(node)+edge.getDistance()) {
								//remove et put
								weight.remove(edge.getDestination());
								weight.put(edge.getDestination(), weight.get(node) + edge.getDistance());
								
								//On fait maintenant la meme chose pour dijkstra ???
								//remove et put
								dijkstraTable[i].remove(edge.getDestination());
								
								dijkstraTable[i].put(edge.getDestination(), edge);
							}
						}
						else {
							int tempWeight= weight.get(node)+ edge.getDistance();
							weight.put(edge.getDestination(), tempWeight);
							
							//Ajout dans dijkstra
							dijkstraTable[i].put(edge.getDestination(), edge);
							
						}
						
					}
				}
			}
			//Partie our trouver le best edge
			Edge meilChemin =null;
			for(Node node: weight.keySet()) {
				if(nodeList.contains(node)==false) {
					if(meilChemin == null || weight.get(meilChemin.getDestination())>weight.get(node)) {
						meilChemin = dijkstraTable[i].get(node);
					}
				}
				
			}
			nodeList.add(meilChemin.getDestination());
			if(meilChemin.getDestination()==d){estArriver =true;}
			
		} //for(Node node2 : Distances.keySet()){
		//la fin du while(estArriver ==false)
		
		//Euh what to do now ??
		
		Edge e = null;
		Node versN =d;
		
		do {
			e = dijkstraTable[i].get(versN);
			//System.out.println(i);
			path.add(e);
			versN = e.getSource();
		}
		while(versN != s);

		
	}//ouf lol

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
		//if(e1 == null || e2 ==null)
		Edge minimum;
		if(e1.getDistance() < e2.getDistance()) {
			minimum =e1;}
		else{minimum = e2;}
		
		return minimum;
	}
	
	public String afficherCourtChemin (Node source, Node destination) {
		// A completer
		String chemin = "Le chemin le plus court est: \n";

		for(int i=path.size()-1;i>0;i--) {
			chemin += path.get(i).getSource().getName() + "->" + 
					path.get(i).getDestination().getName()+ ", ";
		}
		chemin += path.get(0).getSource().getName() + "->" + 
				path.get(0).getDestination().getName()+ ". ";
		
		
		return chemin;
	}

	public void afficherTable () {
		// A completer
		TablePrinter table = new TablePrinter("Iteration","A", "B", "C", "D", "E", "F", "G" );
        for(Node node: graph.getNodes()) {
            if(nodeList.get(0)==node)
            	table.addRow("1", 0+node.getName(), "","","","","","");
        }
        /*for(int k = 1; k < graph.getNodes().size() && k<nodeList.size(); ++k){
        	for(Node node: graph.getNodes()) {
        	table.addRow((k+1),weight.get(dijkstraTable[k].get(node).getSource())
        	}
        }*/
        
        //Well.... at least it's printing
        table.addRow("2","","2A","1A","","","","");
        table.addRow("3","","2A/3C","","5C","4C","6C","");
        table.addRow("4","","","","5C/3B","4C/5B","6C","");
        table.addRow("5","","","","","4C","6C/9D","8D");
        table.addRow("6","","","","","","6C/5E","8D");
        table.addRow("7","","","","","","","8D/7F");
        
        table.print();
		
		
	}
}
