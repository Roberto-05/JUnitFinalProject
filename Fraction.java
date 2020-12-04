package fraction;

public class Fraction {
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator, int denominator) {
		if(denominator == 0) {
			throw new IllegalArgumentException("The denominator with the value of 0 is not permitted");
		}
		
		if(denominator < 0) {
			numerator = numerator * -1;
			denominator = denominator * -1;
		}
		
		this.numerator = numerator;
		this.denominator = denominator;		
	}
	
	public Fraction add(Fraction fraction) {
		if(fraction == null) {
			throw new IllegalArgumentException("Cannot perform math operations on a null fraction object!");
		}
		int den = fraction.getDen() * this.getDen();
		int num = (fraction.getNum() * this.getDen()) + (this.getNum() * fraction.getDen());
		
		return simplify(new Fraction(num, den));
	}
	
	public int getNum() {
		return this.numerator;
	}
	
	public int getDen() {
		return this.denominator;
	}
	
	public boolean equals(Fraction fraction) {
		double cur_fractionValue = fractionRealValue(this);
		double new_fractionValue = fractionRealValue(fraction);
		
		if(cur_fractionValue == new_fractionValue) {
			return true;
		} else {
			return false;
		}
	}
	
	public int compareTo(Fraction fraction) {
      int res = this.compareTo(fraction);
		return res;
	}
	
	public Fraction multiply(Fraction fraction) {
		if(fraction == null) {
			throw new IllegalArgumentException("Cannot perform math operations on a null fraction object!");
		}
		
		int newNum = fraction.getNum() * this.getNum();
		int newDen = fraction.getDen() * this.getDen();
		
		Fraction newFraction = new Fraction(newNum, newDen);
		
		return newFraction;
	}
	
	public double realValue() {
		return (double) this.numerator / (double) this.denominator;
	}
	
	public double fractionRealValue(Fraction fraction) {
		return (double) fraction.getNum() / (double) fraction.getDen();
	}
	
	public Fraction simplify(Fraction fraction) {
		int simplify = 1;
		int limit;
		if(fraction.getDen() > 0) limit = fraction.getDen();
		else limit = -1 * fraction.getDen();
		for(int x = 1; x < limit; x++) {
			if(fraction.getNum() % x == 0 && fraction.getDen() % x == 0) simplify = x;
		}
		return new Fraction(fraction.getNum()/simplify, fraction.getDen()/simplify);
	}
	
	@Override
	public String toString() {
		Fraction simplifiedFraction = simplify(this);
		String str = simplifiedFraction.getNum() + "/" + simplifiedFraction.getDen();
			
		return str;
	}
	
}
