package liste;

public abstract class Liste<Indice> {

	Indice actuel;
	Liste<Indice> prochain;
	
	public Liste(Indice actuel, Liste<Indice> prochain) {
		this.actuel = actuel;
		this.prochain = prochain;
	}
	
	public Indice Actuel() {
		return this.actuel;
	}
	
	public Liste<Indice> Prochain() {
		return this.prochain;
	}
	
}
