package tp5;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Node {

	private int id;
	private String name;
	private int longitude;
	private int altitude;

	private Integer distance = Integer.MAX_VALUE;

	Map<Node, Integer> adjacentNodes = new HashMap<>();

	private List<Node> shortestPath = new LinkedList<>();

	public List<Node> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public void addDestination(Node destination, int distance) {
		adjacentNodes.put(destination, distance);
	}

	public Node(String name) {
		this.name = name;
	}
	
	public Node(int id, String n, int longitude, int altitude) {
		this.id = id;
		this.name = n;
		this.longitude = longitude;
		this.altitude = altitude;
	}

        public Node(int id, String n) {
		this.id = id;
		this.name = n;
		this.longitude = 0; 
		this.altitude = 0;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	
	@Override
	public int hashCode() {
		return id;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getLaltitude() {
		return altitude;
	}

	public void setLaltitude(int laltitude) {
		this.altitude = laltitude;
	}

	public Map<Node, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}
}
