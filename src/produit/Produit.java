package produit;

public abstract class Produit implements IProduit {
	protected String nom;
	protected Unite unite;
	
	protected Produit(String nom, Unite unite) {
		this.nom = nom;
		this.unite = unite;
	}
	
	@Override
	public String getNomProduit() {
		return nom;
	}
	
	@Override
	public abstract String descriptionProduit();
}