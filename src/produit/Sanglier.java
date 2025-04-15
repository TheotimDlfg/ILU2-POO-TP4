package produit;
import personnages.Gaulois;

public class Sanglier extends Produit{
	private int poids;
	private Gaulois chasseur;
	
	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier", Unite.KILOGRAMME);
		this.poids = poids;
		this.chasseur = chasseur;
	}
	
	@Override
	public String descriptionProduit() {
		return nom + " de "+ poids +" chassé par "+ chasseur.getNom() + ".";
	}

	@Override
	public int calculerPrix(int prix) {
		return (int) Math.round((poids / 1000.0) * prix);
	}
}