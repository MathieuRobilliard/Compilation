package liste;

import global.Variable;

public class ListeVariable extends Liste<Variable> {

	public ListeVariable(Variable actuel, Liste<Variable> prochain) {
		super(actuel, prochain);
	}

}
