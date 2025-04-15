package scenarioTest;

import personnages.Gaulois;
import produit.Produit;
import produit.Poisson;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegaulois.IVillage;

public class Scenario {

	public static void main(String[] args) {

		// TODO Partie 4 : creer de la classe anonyme Village
		
		IVillage village = new IVillage() {

		    private IEtal[] marche = new IEtal[3]; // 3 étals comme dans le TP
		    private int nbEtal = 0;

		    @Override
		    public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produits, int prix) {
		        if (nbEtal < marche.length) {
		            etal.installerVendeur(vendeur, produits, prix);
		            marche[nbEtal++] = etal;
		            return true;
		        }
		        return false;
		    }

		    @Override
		    public void acheterProduit(String produit, int quantiteSouhaitee) {
		        int quantiteRestante = quantiteSouhaitee;
		        int quantiteAchetee = 0;
		        int prixTotal = 0;

		        for (int i = 0; i < nbEtal && quantiteRestante > 0; i++) {
		            int quantiteDispo = marche[i].contientProduit(produit, quantiteRestante);
		            if (quantiteDispo > 0) {
		                int prix = marche[i].acheterProduit(quantiteDispo);
		                System.out.println("A l'étal n° " + (i + 1) + ", j'achète " + quantiteDispo + " " + produit + " et je paye " + prix + " sous.");
		                quantiteRestante -= quantiteDispo;
		                quantiteAchetee += quantiteDispo;
		                prixTotal += prix;
		            }
		        }

		        System.out.println("Je voulais " + quantiteSouhaitee + " " + produit + ", j'en ai acheté " + quantiteAchetee + ".");
		    }

		    @Override
		    public String toString() {
		        StringBuilder s = new StringBuilder();
		        for (int i = 0; i < nbEtal; i++) {
		            s.append(marche[i].etatEtal()).append("\n");
		        }
		        return s.toString();
		    }
		};
		
		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 7);

		System.out.println(village);

		village.acheterProduit("sanglier", 3);

		System.out.println(village);
	}

}