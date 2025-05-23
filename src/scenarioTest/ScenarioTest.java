package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Sanglier;
import villagegaulois.Etal;


public class ScenarioTest {

	public static void acheterProduit(Etal[] marche, String produit, int quantiteSouhaitee) {
		int quantiteRestante = quantiteSouhaitee;
		for (int i = 0; i < marche.length && quantiteRestante != 0; i++) {
			Etal etal = marche[i];
			int quantiteDisponible = etal.contientProduit(produit, quantiteRestante);
			if (quantiteDisponible != 0) {
				int prix = etal.acheterProduit(quantiteDisponible);
				String chaineProduit = accorderNomProduit(produit, quantiteDisponible);
				System.out.println("A l'étal n° " + (i + 1) + ", j'achete " + quantiteDisponible + " " + chaineProduit
						+ " et je paye " + prix + " sous.");
				quantiteRestante -= quantiteDisponible;
			}
		}
		String chaineProduit = accorderNomProduit(produit, quantiteSouhaitee);
		System.out.println("Je voulais " + quantiteSouhaitee + " " + chaineProduit + ", j'en ai acheté "
				+ (quantiteSouhaitee - quantiteRestante) + ".\n");
	}


	private static String accorderNomProduit(String produit, int quantiteSouhaitee) {
		String chaineProduit = produit;
		if (quantiteSouhaitee > 1) {
			chaineProduit = produit + "s";
		}
		return chaineProduit;
	}

	public static void main(String[] args) {
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix",9);
		Gaulois obelix = new Gaulois("Obélix",20);
		Gaulois asterix = new Gaulois("Asterix", 6);
		
		Sanglier sanglier4 = new Sanglier(500, asterix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier1 = new Sanglier(2000, obelix);


		Sanglier[] sangliersAsterix = {sanglier4, sanglier3};
		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};

		Etal[] marche = new Etal[3];
		
		Etal<Sanglier> etalSanglier1 = new Etal<Sanglier>();
		Etal<Sanglier> etalSanglier2 = new Etal<Sanglier>();
		Etal<Poisson> etalPoisson = new Etal<Poisson>();
		
		marche[0] = etalSanglier1;
		marche[1] = etalSanglier2;
		marche[2] = etalPoisson;
		
		etalSanglier1.installerVendeur(obelix, sangliersObelix, 8);
		etalSanglier2.installerVendeur(asterix, sangliersAsterix, 10);
		etalPoisson.installerVendeur(ordralfabetix, poissons, 7);

		System.out.println(marche[0].etatEtal());
		System.out.println(marche[1].etatEtal());
		System.out.println(marche[2].etatEtal());
		
		ScenarioTest.acheterProduit(marche, "sanglier", 3);
		
		System.out.println(marche[0].etatEtal());
		System.out.println(marche[1].etatEtal());
		System.out.println(marche[2].etatEtal());
 		
	}

}