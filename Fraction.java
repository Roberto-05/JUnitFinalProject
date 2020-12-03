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
      //simplify the fractions, compare the denominator, then make sure they can be added
		int numA = (fraction.getNum() + this.getNum());
 
		return null; // TODO method stub for add
	}
	
	public int getNum() {
		return this.numerator;
	}
	
	public int getDen() {
		return this.denominator;
	}
	
	public boolean equals(Fraction fraction) {
   
   //need to simplify the fractions in case it isn't in simplified form
      if(fraction.getNum() == this.getNum()){
            if(fraction.getDen() == this.getDen()){
               return true;
            }
            else{
               return false;
            }
         }
         else{
            return false;
         }

		return false; // TODO method stub for equals
	}
	
	public int compareTo(Fraction fraction) {
      int res = this.fraction.compareTo(fraction);
		return res; // TODO method stub for multiply
	}
	
	public Fraction multiply(Fraction fraction) {
		if(fraction == null) {
			throw new IllegalArgumentException("Cannot perform math operations on a null fraction object!"); // TODO for IllegalArgumentJupiter.java
		}
		
		return null; // TODO method stub for multiply
	}
	
	public double realValue() {
		return (double) this.numerator / (double) this.denominator;
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
