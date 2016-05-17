package liste;

import global.Instruction;

public class ListeInstructions extends Liste<Instruction> {

	public ListeInstructions(Instruction actuel, Liste<Instruction> prochain) {
		super(actuel, prochain);
	}

}
