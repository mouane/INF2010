package tp5;

public class Edge {

	private Node source;
	private Node destination;
	private int distance;
	
	public Edge () {}

	public Edge(Node s, Node d, int dist) {
		this.source = s;
		this.destination = d;
		this.distance = dist;
		// A completer
	}
     
         public Edge(Node s, Node d) {
		this.source = s;
		this.destination = d;
		// A completer
                // La distance de Manhattan est la somme des valeurs absolues de la distance horizontale et de la distance verticale.
                // https://en.wikipedia.org/wiki/Taxicab_geometry

	}
         public Edge (Edge edge) {
        	 this.destination = new Node(edge.destination); 
        	 this.source = new Node(edge.destination);
         }
            
	
	public Node getSource() {
		return source;
	}
	public void setSource(Node source) {
		this.source = source;
	}
	public Node getDestination() {
		return destination;
	}
	public void setDestination(Node destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	
	
}
