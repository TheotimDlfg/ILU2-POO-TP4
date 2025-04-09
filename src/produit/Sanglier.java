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
		return nom + " de "+ poids +" chass� par "+ chasseur + ".";
	}

	@Override
	public double calculerPrix(double prix) {
		return (poids * prix) / 1000;
	}
}