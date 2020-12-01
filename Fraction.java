package fraction;

public class Fraction {
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator, int denominator) {
		if(denominator == 0) {
			throw new IllegalArgumentException("The denominator with the value of 0 is not permitted"); // NOTE for IllegalArgumentJupiter.java
		}
		
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public Fraction add(Fraction fraction) {
		if(fraction == null) {
			throw new IllegalArgumentException("Cannot perfomr math operations on a null fraction object!"); // NOTE for IllegalArgumentJupiter.java
		}
		
		return null; // CPLT method stub for add
	}
	
	public int getNum() {
		return this.numerator;
	}
	
	public int getDen() {
		return this.denominator;
	}
	
	public boolean equals(Fraction fraction) {
		return false; // CPLT method stub for equals
	}
	
	public int compareTo(Fraction fraction) {
		return 0; // CPLT method stub for multiply
	}
	
	public Fraction multiply(Fraction fraction) {
		if(fraction == null) {
			throw new IllegalArgumentException("Cannot perform math operations on a null fraction object!"); // NOTE for IllegalArgumentJupiter.java
		}
		
		return null; // CPLT method stub for multiply
	}
	
	public double realValue() {
		return 0.0; // CPLT method stub for realValue
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
