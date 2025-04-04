package produit;

public enum Unite {
	GRAMME("g"), KILOGRAMME("kg"), LITRE("l"), CENTILITRE("cl"), MILLILITRE("ml"), PIECE("piece"); 
	
	private String unite;
	
	private Unite(String unite) {
		this.unite = unite;
	}
}
