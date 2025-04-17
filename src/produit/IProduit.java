package produit;

public interface IProduit {

	String getNomProduit();

	String descriptionProduit();

	public default int calculerPrix(int prix) {
		return prix;
	}

}