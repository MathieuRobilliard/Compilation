
public class Graphe {

	public Graphe() {
		// TODO Auto-generated constructor stub
	}

	public void colorierGraphe()
	
	public void colorier()
	
	/*TODO*/
	public boolean existeTrivial(Graphe g, int nbCouleur)
	/* renvoie vrai s'il existe un sommet tel que son nombre d'arretes est inferieur a nbCouleur*/
	
	public Sommet recupTrivial(Graphe g, int nbCouleur)
	/* recupere le premier sommet qui marche*/
	
	public int nbArrSommet(Graphe g, Sommet s)
	/* renvoie le nombre d'arretes reliées au sommet, sert pour existeTrivial, recupTrivial etc...*/
	
	public Sommet[] ou Arraylist<Sommet> RelieSommet(Graphe g, Sommet s)
	/* Renvoie la liste des sommets reliés par une arrête à s , je te laisse choisir pour le type de liste*/
	
	public void retirerSommet(Graphe g, Sommet s)
	/* Retire le sommet de ls, la liste des sommets du graphe */
	
	public recupSpiller(Graphe g)
	/* comme recupTrivial sauf que l'on prend le sommet qui a le plus d'arretes*/
	
}
