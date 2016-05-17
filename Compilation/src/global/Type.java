package global;

public class Type {

	private String nom;
	private Type liste;
	
	public Type(String type) {
		this.nom = type;
		this.liste = null;
	}
	
	public Type(Type type) {
		this.nom = "liste";
		this.liste = type;
	}
	
	public String getTypeNom() {
		return this.nom;
	}
	
	public boolean est_type_liste() {
		return this.liste == null;
	}
}
