package expressionArithmetique;

import global.ExpressionArithm;

public abstract class Uop implements ExpressionArithm {

	protected ExpressionArithm exp;
	
	public Uop(ExpressionArithm exp) {
		this.exp = exp;
	}
	
	public ExpressionArithm getExpression() {
		return this.exp;
	}
	
}
