package global;

import liste.ListeFonction;
import liste.ListeInstructions;
import liste.ListeVariable;


public class Programme {

	private ListeVariable variables;
	private ListeFonction defs;
	private ListeInstructions instructions;
	
	public Programme(ListeVariable variables, ListeFonction defs, ListeInstructions instructions) {
		this.variables = variables;
		this.defs = defs;
		this.instructions = instructions;
	}
	
	public ListeVariable getVariables() {
		return this.variables;
	}
	
	public ListeFonction getDefinitions() {
		return this.defs;
	}
	
	public ListeInstructions getFonctionInstructions() {
		return this.instructions;
	}
	
}
