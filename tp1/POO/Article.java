package POO;

public class Article {	
	private final String NumProduit; 
	private String nom;
	private double Prix_net;


        public Article(String NumProduit, String nom){
                    //completer
        	this.NumProduit= NumProduit;
        	this.nom = nom;
        	this.Prix_net = 0.00;
	}
	
	public Article(String np, String nom, double prix){		
		//completer
		this.NumProduit = np;
		this.nom = nom;
		this.Prix_net = prix;
		
	}
	

	public String getNumProduit() {
		//completer
		return this.NumProduit;
	}	
	public String getNom() {
		//completer
		return this.nom;
	}
	public void setNom(String nom) {
		//completer
		this.nom = nom;
	}
	public double getPrixNet() {
		//completer
		return this.Prix_net;
	}
		

	public void setPrixNet(double prix_net) {
		//completer
		this.Prix_net = prix_net;
	}
	public double getVAT(){ // lol TVA ?
		//completer
		return this.Prix_net;
		
	}
	public double getPrix(int count){
		//completer
		return this.Prix_net;
	}
	public String getArticleType(){
		//completer
		String type = "Cet article est de type: ";
		return type;
	}
	public String toString() {
		//completer
		String article = "L'article : " + this.nom + " avec le numero: " + this.NumProduit + " coute : " + this.Prix_net +"$";
		return article;
	}
}
