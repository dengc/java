// Name: Chufan Deng
// USC loginid:chufande
// CS 455 PA2
// Spring 2017


import java.util.ArrayList;

/**
   A polynomial. Polynomials can be added together, evaluated, and
   converted to a string form for printing.
*/
public class Polynomial {

	private ArrayList<Term> poly;

	/**

      REPRESENTATION INVARIANT:
    * No coeff of terms is 0 in poly
	* poly's size should not be negative
	* for a non-zero poly all the terms must be in decreasing order by exponent.
    */

    /**
       Creates the 0 polynomial
    */
    public Polynomial() {

		poly = new ArrayList<Term>();

		assert isValidPolynomial();
    }


    /**
       Creates polynomial with single term given
     */
    public Polynomial(Term term) {

		poly = new ArrayList<Term>();

		if(term.getCoeff()!= 0){
			poly.add(term);
		}

		assert isValidPolynomial();
    }


    /**
       Returns the Polynomial that is the sum of this polynomial and b
       (neither poly is modified)
     */
    public Polynomial add(Polynomial b) {

		assert isValidPolynomial();
	 	assert b.isValidPolynomial();

		Polynomial newPoly = new Polynomial();

		int i =0;
		int j =0;

		//compare until at least one ArrayList is added in the sumlist, it takes O(n+m)
		while(i<poly.size() && j<b.poly.size()){
			if(poly.get(i).getExpon() > b.poly.get(j).getExpon()){
				newPoly.poly.add(poly.get(i));
				i++;
			}
			else if(poly.get(i).getExpon() < b.poly.get(j).getExpon()){
				newPoly.poly.add(b.poly.get(j));
				j++;
			}
			else{
				Term newTerm = new Term((poly.get(i).getCoeff() + b.poly.get(j).getCoeff()),b.poly.get(j).getExpon());
				if(newTerm.getCoeff()!=0){
					newPoly.poly.add(newTerm);
				}
				i++;
				j++;
			}
		}

		//if there are items in b left needed to be added
		if(j<b.poly.size()){

			for(int x =j; x<b.poly.size(); x++){
				newPoly.poly.add(b.poly.get(x));
			}
		}
		//if there are items in this.array left needed to be added
		if(i<poly.size()){

			for(int x=i; x<poly.size(); x++){
				newPoly.poly.add(poly.get(x));
			}
		}

		assert newPoly.isValidPolynomial();
		return newPoly;
    }


    /**
       Returns the value of the poly at a given value of x.
     */
    public double eval(double x) {

		assert isValidPolynomial();

		double polyValue =0.0;

		for(int i=0;i<poly.size();i++){

			polyValue+= poly.get(i).getCoeff()*Math.pow(x, poly.get(i).getExpon());
	 	}

		return polyValue;
    }


    /**
       Return a String version of the polynomial with the
       following format, shown by example:
       zero poly:   "0.0"
       1-term poly: "3.2x^2"
       4-term poly: "3.0x^5 + -x^2 + x + -7.9"

       Polynomial is in a simplified form (only one term for any exponent),
       with no zero-coefficient terms, and terms are shown in
       decreasing order by exponent.
    */
    public String toFormattedString() {

		assert isValidPolynomial();

		String pString="";

		// zero poly
		if(poly.size()==0){
			pString = "0.0";
		}

		//more-term poly
		else{
			for(int i=0; i<poly.size(); i++){
				if(poly.get(i).getExpon()==0){
					pString += poly.get(i).getCoeff();
					break;
				}
				else if (poly.get(i).getExpon()==1 && poly.get(i).getCoeff() == 1) {
					pString += "x";
				}
				else if (poly.get(i).getExpon()==1 && poly.get(i).getCoeff() == -1) {
					pString += "-x";
				}
				else if(poly.get(i).getExpon()==1){
					pString += poly.get(i).getCoeff() + "x";
				}
				else if(poly.get(i).getCoeff() == 1){
					pString += "x^" + poly.get(i).getExpon();
				}
				else if(poly.get(i).getCoeff() == -1){
					pString += "-x^" + poly.get(i).getExpon();
				}
				else{
					pString += poly.get(i).getCoeff() + "x^" + poly.get(i).getExpon();
				}
				//if touch the last term
				if(i >= poly.size()-1){
					break;
				}
				else {
					pString +=" + ";
				}
			}
		}

		return pString;
    }


    // **************************************************************
    //  PRIVATE METHOD(S)

    /**
       Returns true iff the poly data is in a valid state.
    */
    private boolean isValidPolynomial() {

		// No coeff of terms is 0 in poly
		for(int i=0; i<poly.size(); i++){
			if(poly.get(i).getCoeff()==0){
				return false;
			}
		}

		//poly's size should not be negative
		if(poly.size()<0){
			return false;
		}

		//for a non-zero poly all the terms must be in decreasing order by exponent.
		if(poly.size()>1){
			for(int i=0; i<poly.size()-1; i++){
				if(poly.get(i).getExpon() <= poly.get(i+1).getExpon()){
					return false;
				}
			}
		}

		return true;
    }

}
