package expressionArithmetique;

import global.ExpressionArithm;

public class Constante implements ExpressionArithm {
	
	private boolean bool;
	private int val;
	private boolean est_bool;
	
	public Constante(boolean val){
		this.bool = val;
		this.val = 0;
		this.est_bool = true;
	} 
	
	public Constante(int val){
		this.bool = false;
		this.val = val;
		this.est_bool = false;
	} 
	
	public boolean est_bool() {
		return this.est_bool;
	}
	
	public boolean getBoolValeur() {
		return this.bool;
	}
	
	public int getIntValeur() {
		return this.val;
	}
	
}
