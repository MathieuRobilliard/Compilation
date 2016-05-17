package expressionArithmetique;

import global.ExpressionArithm;


public class Nom implements ExpressionArithm {

	private String nom;
	
	public Nom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
}
