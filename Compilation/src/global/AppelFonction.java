package global;

import liste.ListeExpression;
import expressionArithmetique.Nom;

public class AppelFonction implements ExpressionArithm, Instruction {
	
	private Nom id;
	private ListeExpression args;

	public AppelFonction(Nom id, ListeExpression args) {
		this.id = id;
		this.args = args;
	}
	
	public Nom getNom() {
		return this.id;
	}
	
	public ListeExpression getArgs() {
		return this.args;
	}

}
