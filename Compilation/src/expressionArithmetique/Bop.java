package expressionArithmetique;

import global.ExpressionArithm;

public abstract class Bop implements ExpressionArithm {

	protected ExpressionArithm partieGauche, partieDroite;
	
	public Bop(ExpressionArithm partieGauche, ExpressionArithm partieDroite) {
		this.partieGauche = partieGauche;
		this.partieDroite = partieDroite;
	}
	
	public ExpressionArithm getpartieGauche() {
		return this.partieGauche;
	}
	
	public ExpressionArithm getpartieDroite() {
		return this.partieDroite;
	}
	
}
