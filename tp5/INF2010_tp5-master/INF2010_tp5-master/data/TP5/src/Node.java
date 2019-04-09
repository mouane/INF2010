
public class Node {

	private int id;
	private String name;
	private int longitude;
	private int altitude;
	//ajout d'un attribut
	public int distance;
	public boolean found;
	
	public Node() {
		this.id 	= 0;
		this.name = "0";
		this.longitude = 0;
		this.altitude = 0;
		this.found = false;
	};
	
	public Node(int id, String n, int longitude, int altitude) {
		this.id = id;
		this.name = n;
		this.longitude = longitude;
		this.altitude = altitude;
		this.found = false;
	}

        public Node(int id, String n) {
		this.id = id;
		this.name = n;
		this.longitude = 0; 
		this.altitude = 0;
		this.found = false;
	}
        public Node(Node node) {
    		this.id = node.id;
    		this.name = node.name;
    		this.longitude = node.longitude; 
    		this.altitude = node.altitude;
    		this.found = node.found;
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
}
