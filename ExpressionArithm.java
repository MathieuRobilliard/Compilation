//Expression Arithmetiques
abstract class ExpressionArithm {
	
}

//Constantes
abstract class Constante extends ExpressionArithm{
	Constante k;
}

class integer extends Constante {
	
	int val;
	
	integer (int k) {
		this.val = k;
	}
}

class bool extends Constante {
	boolean val;
	
	bool (boolean k) {
		this.val = k;
	}
}
//Fin Constantes

//Operateurs Binaires

abstract class Bop extends ExpressionArithm{
	ExpressionArithm e1, e2;
}

class Ajouter extends Bop {
	Ajouter(ExpressionArithm e1, ExpressionArithm e2) 
	{
			this.e1 = e1;
			this.e2 = e2;
	}			
}
class Supprimer extends Bop {
	Supprimer(ExpressionArithm e1, ExpressionArithm e2) 
	{
			this.e1 = e1;
			this.e2 = e2;
	}		
}
class Multiplier extends Bop {
	Multiplier(ExpressionArithm e1, ExpressionArithm e2) 
	{
			this.e1 = e1;
			this.e2 = e2;
	}		
}
class Diviser extends Bop {
	Diviser(ExpressionArithm e1, ExpressionArithm e2) 
	{
			this.e1 = e1;
			this.e2 = e2;
	}		
}
class Et extends Bop {
	Et(ExpressionArithm e1, ExpressionArithm e2) 
	{
			this.e1 = e1;
			this.e2 = e2;
	}		
}
class Ou extends Bop {
	Ou(ExpressionArithm e1, ExpressionArithm e2) 
	{
			this.e1 = e1;
			this.e2 = e2;
	}		
}
class PlusPetit extends Bop {
	PlusPetit(ExpressionArithm e1, ExpressionArithm e2) 
	{
			this.e1 = e1;
			this.e2 = e2;
	}		
}
class PlusPetitEgal extends Bop {
	PlusPetitEgal(ExpressionArithm e1, ExpressionArithm e2) 
	{
			this.e1 = e1;
			this.e2 = e2;
	}		
}
class Egal extends Bop {
	Egal(ExpressionArithm e1, ExpressionArithm e2) 
	{
			this.e1 = e1;
			this.e2 = e2;
	}		
}
class PlusGrand extends Bop {
	PlusGrand(ExpressionArithm e1, ExpressionArithm e2) 
	{
			this.e1 = e1;
			this.e2 = e2;
	}		
}
class PlusGrandEgal extends Bop {
	PlusGrandEgal(ExpressionArithm e1, ExpressionArithm e2) 
	{
			this.e1 = e1;
			this.e2 = e2;
	}		
}
class Different extends Bop {
	Different(ExpressionArithm e1, ExpressionArithm e2) 
	{
			this.e1 = e1;
			this.e2 = e2;
	}		
}
//Fin Operateurs Binaires

// Operateurs Unaires

abstract class Uop extends ExpressionArithm{
	ExpressionArithm e;
}
class Negatif extends Uop {
	Negatif(ExpressionArithm e) 
	{
			this.e = e;
	}		
}
class Inverse extends Uop {
	Inverse(ExpressionArithm e) 
	{
			this.e = e;

	}		
}
// Fin Operateurs Unaires

