package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;

public class Etal<T extends IProduit> implements IEtal{
	private Gaulois vendeur;
	private T[] produits;
	private int quantiteDebutMarche;
	private int quantite;
	private boolean etalOccupe = false;
	private double prix;
	private int nbProduit = 0;

	public boolean isEtalOccupe() {
		return etalOccupe;
	}

	public Gaulois getVendeur() {
		return vendeur;
	}

	public int getQuantite() {
		return quantite;
	}
	
	public void installerVendeur(Gaulois vendeur, T[] produit, int prix){
		this.produits=produit;
		this.vendeur=vendeur;
		this.prix=prix;
	}

	@Override
	public int contientProduit(String produit, int quantiteSouhaitee) {
		int quantiteAVendre = 0;
		if (nbProduit != 0 && this.produits[0].getNomProduit().equals(produit)) {
			if (nbProduit >= quantiteSouhaitee) {
				quantiteAVendre = quantiteSouhaitee;
			} else {
				quantiteAVendre = nbProduit;
			}
		}
		return quantiteAVendre;
	}
	
	
	@Override
	public int acheterProduit(int quantiteSouhaite) {
		int prixPaye = 0;
		int limite = nbProduit - quantiteSouhaite;
		if (limite < 0) limite = 0;

		for (int i = nbProduit - 1; i >= limite; i--) {
		    prixPaye += produits[i].calculerPrix(prix);
		}

		if (nbProduit >= quantiteSouhaite) {
			nbProduit -= quantiteSouhaite;
		} else {
			nbProduit = 0;
		}
		return prixPaye;
	}

	@Override
	public String etatEtal() {
		StringBuilder chaine = new StringBuilder(vendeur.getNom());
		if (nbProduit > 0) {
			chaine.append(" vend ");
			chaine.append(nbProduit + " produits :");
			for (int i = 0; i < nbProduit; i++) {
				chaine.append("\n- " + produits[i].descriptionProduit());
			}
		} else {
			chaine.append(" n'a plus rien à vendre.");
		}
		chaine.append("\n");
		return chaine.toString();
	}

}
