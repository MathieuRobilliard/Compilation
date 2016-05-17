package global;

import liste.ListeInstructions;
import liste.ListeVariable;

import expressionArithmetique.Nom;


public class Fonction {

	private Nom nom;
	private Type type;
	private ListeVariable args;
	private ListeInstructions instructions;
	
	public Fonction(Nom nom, ListeVariable args, ListeInstructions instructions) {
		this.nom = nom;
		this.args = args;
		this.instructions = instructions;
		this.type = null;
	}
	
	public Fonction(Nom nom, ListeVariable args, ListeInstructions instructions, Type type) {
		this(nom, args, instructions);
		this.type = type;
	}
	
	public boolean checkType() {
		return this.type == null;
	}
	
	public Nom getFonctionnom() {
		return this.nom;
	}
	
	public Type gettype() {
		return this.type;
	}
	
	public ListeVariable getFonctionargs() {
		return this.args;
	}
	
	public ListeInstructions getFonctioninstructions() {
		return this.instructions;
	}
	
}
