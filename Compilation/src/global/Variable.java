package global;

import expressionArithmetique.Nom;

public class Variable {
	
	private Nom nom;
	private Type type;
	
	public Variable(Nom nom, Type type) {
		this.nom = nom;
		this.type = type;
	}
	
	public Nom getVariableNom() {
		return this.nom;
	}
	
	public Type getVariableType() {
		return this.type;
	}

}
