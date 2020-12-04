// Keng Xiong
// Jacob Newcomb
// Jessica Ho
// Roberto Suarez

/*
 * Fraction class Java source file:
 * 
 * This source file contains the constructor and methods for Fraction objects.
 */

package fraction;

public class Fraction { // Class for Fractions
	private int numerator; // Classwide variable for numerator
	private int denominator; // Classwide variable for denominator
	
	public Fraction(int numerator, int denominator) { // Constructor for Fraction
		if(denominator == 0) { // Checks if denominator is 0, because you cannot divide by 0
			throw new IllegalArgumentException("The denominator with the value of 0 is not permitted"); 
		}
		
		if(denominator < 0) { // If the denominator is negative:
			numerator = numerator * -1;
			denominator = denominator * -1; /*you multiply both num and den by -1, because this would move the negative sign to the top of the fraction,
            								which makes the rest of the program work smoother. Also, if both num and den are negative, this will
            								cancel out the negatives for both of them, leaving the faction positive.*/
		}
		
		int simplify = 1; // Variable used to keep track of GCF (Greatest Common Factor)
		for(int i = 1; i <= denominator; i++) { // For every i value between 1 and the value of the denominator:
			if(numerator % i == 0 && denominator % i == 0) { // Check if i divides evenly into num and den, and if it does:
				simplify = i; // Set GCF to i
			}
		}
		
		this.numerator = numerator / simplify;
		this.denominator = denominator / simplify; // Then you divide the num and the den by the GCF, which simplifies the fraction.	
	}
	
	public Fraction add(Fraction fraction) { // Method used to add fractions together
		if(fraction == null) { // Checks if fraction passed in is a null pointer
			throw new IllegalArgumentException("Cannot perform math operations on a null fraction object!");
		}
		
		int den = fraction.getDen() * this.getDen();
		int num = (fraction.getNum() * this.getDen()) + (this.getNum() * fraction.getDen()); /* These two lines emulate making the denominators of both fractions
																					         equal, and then multiplies the numerators of each fraction by the others
																					         denominator to compensate and keep the true values of both fractions the
																					         same. Then, they're numerators get added together. This is legal because
																					         both of their denominators are equal*/
		
		return simplify(new Fraction(num, den)); // Returns the non-simplified fraction through the simplify method defined later in the program.
	}
	
	public int getNum() { // This method is used to retrieve the numerator of this fraction
		return this.numerator;
	}
	
	public int getDen() { // This method is used to retrieve the denominator of this fraction
		return this.denominator;
	}
	
	public boolean equals(Fraction fraction) { // This method checks if this fraction and another fraction are equal
		double cur_fractionValue = fractionRealValue(this); // Converts this fraction's num and den into a floating point number
		double new_fractionValue = fractionRealValue(fraction); // Converts the other fraction's num and den into a floating point number
		
		if(cur_fractionValue == new_fractionValue) { // If the two values are the same:
			return true; // Return true.
		} else { // Otherwise,
			return false; // Return false.
		}
	}
	
	public int compareTo(Fraction fraction) { // This method compares the two fractions to each other,
		int numeratorCheck = this.getNum() - fraction.getNum();
		
		if(numeratorCheck != 0) { // first by numerator,
			return numeratorCheck;
		}
		
		return this.getDen() - fraction.getDen(); // And then by denominator.
	}
	
	public Fraction multiply(Fraction fraction) { // This method is used to multiply this fraction and another fraction together
		if(fraction == null) { // Checks if fraction passed in is a null pointer
			throw new IllegalArgumentException("Cannot perform math operations on a null fraction object!");
		}
		
		int newNum = fraction.getNum() * this.getNum();
		int newDen = fraction.getDen() * this.getDen(); // These two lines multiply the two fraction's numerators and denominators to get the product.
				
		return new Fraction(newNum, newDen); // Then, we create a new fraction to contain the num and den we just found (this will automatically simplify it as well) and then return it
	}
	
	public double realValue() { // This method is used to receive a floating point value that is equal to num/den
		return (double) this.numerator / (double) this.denominator;
	}
	
	public double fractionRealValue(Fraction fraction) { // This method is used to receive a floating point value that is equal to num/den for another fraction
		return (double) fraction.getNum() / (double) fraction.getDen();
	}
	
	public Fraction simplify(Fraction fraction) { // This method is used to simplify the fraction's num and den (outside of the constructor)
		int simplify = 1; // GCF
		int limit; // Used for upper limit of eventual for loop
		
		if(fraction.getDen() > 0) { // If the denominator is positive, set limit equal to den 
			limit = fraction.getDen(); 
		} else { // If the denominator is negative, set limit to the absolute value of the den
			limit = -1 * fraction.getDen(); 
		}
		
		for(int i = 1; i <= limit; i++) { // For every i value between 1 and the value of limit:
			if(fraction.getNum() % i == 0 && fraction.getDen() % i == 0) { // Check if i divides into num and dem equally. if it does, set GCF to i
				simplify = i;
			}
		} // This will naturally find the GCF over the course of the for loop
		
		return new Fraction(fraction.getNum()/simplify, fraction.getDen()/simplify); // Returns a fraction with the sent num and den, divided by the GCF
	}
	
	@Override
	public String toString() { // toString for the fraction class
		Fraction simplifiedFraction = simplify(this); // Simplifies fraction if not already simplified
		String fractionToString = simplifiedFraction.getNum() + "/" + simplifiedFraction.getDen(); // Sets str to contain traditional representation for writing out a fraction
			
		return fractionToString; // Returns string
	}
	
}
