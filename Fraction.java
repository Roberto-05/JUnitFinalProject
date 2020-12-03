package fraction;

public class Fraction {
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator, int denominator) {
		if(denominator == 0) {
			throw new IllegalArgumentException("The denominator with the value of 0 is not permitted");
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
		Fraction thisCopy = simplify(this);
		fraction = simplify(fraction);
		
		if (fraction.getNum() == this.getNum()) {
			if (fraction.getDen() == this.getDen()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

		return false;
	}
	
	public int compareTo(Fraction fraction) {
      int res = this.fraction.compareTo(fraction);
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
	
	public Fraction simplify(Fraction fraction) {
		int simplify = 1;
		for(int x = 1; x < fraction.getDen(); x++) {
			if(fraction.getNum() % x == 0 && fraction.getDen() % x == 0) simplify = x;
		}
		return new Fraction(fraction.getNum()/simplify, fraction.getDen()/simplify);
	}
	
	@Override
	public String toString() {
		StringBuilder sbDen, sbNum;
		String str = "";
		String tempNum = String.valueOf(this.numerator);
		String tempDen = String.valueOf(this.denominator);
		if(this.denominator < 0) {
			sbDen = new StringBuilder(tempDen);
			sbDen.deleteCharAt(0);
			tempDen = sbDen.toString();
			
			str = "-" + tempNum + "/" + tempDen;
		} else if (this.numerator < 0 && this.denominator < 0){
			 sbNum = new StringBuilder(tempNum);
			 sbNum.deleteCharAt(0);
			 tempNum = sbNum.toString();
			 
			 sbDen = new StringBuilder(tempDen);
			 sbDen.deleteCharAt(0);
			 tempDen = sbDen.toString();
			 
			 str = tempNum + "/" + tempDen;
		} else {
			str = tempNum + "/" + tempDen; 
		}
		
		return str;
	}
	
}
