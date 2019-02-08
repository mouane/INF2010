package POO;

public class CadreDiplome extends Article {
	private String categorie;
	private String couleur;
	public CadreDiplome(String NumProduit, String nom, double prix, String couleur,String categorie){
		//completer
		super(NumProduit, nom, prix);
		this.categorie= categorie;
		this.couleur = couleur;
	}
	
	public CadreDiplome(String NumProduit, String nom, double prix,String categorie){
		//completer
		super(NumProduit, nom, prix);
		this.categorie= categorie;
	}
	
	@Override
	public String getArticleType() {
		//completer
		String type = super.getArticleType() + "Cadre de Diplome ";
		return type;
	}

	public String getCategorie() {
		//completer
		return this.categorie;
	}

	public void setCategorie(String categorie) {
                   //completer
		this.categorie = categorie;
	}
	
}
