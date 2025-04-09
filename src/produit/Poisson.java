package produit;

public class Poisson extends Produit{
	
	private String datePeche;
	
	public Poisson(String datePeche) {
		super("poisson", Unite.PIECE);
		this.datePeche = datePeche;
	}
	
	@Override
	public String descriptionProduit() {
		return "poisson p�ch�s "+ datePeche +".";
	}

	@Override
	public double calculerPrix(double prix) {
		return prix;
	}
}