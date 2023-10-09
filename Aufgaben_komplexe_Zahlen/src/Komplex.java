
/**
 * 
 * The class Komplex represents a complex number.
 * The variables RE and IM represent the real and the imaginary part of the complex number respectively. 
 * 
 * 
 * @author  Minh Duc Vu, Bogdan, Hannah
 * 
 */
public class Komplex {

	/** RE represents the real part of the complex number*/
	private double RE;
	
	/** IM represents the imaginary part of the complex number*/
	private double IM;

	/**
	 * Constructor of the class Komplex. 
	 * 
	 * @param re double value, sets the value of the real part.
	 * @param im double value, sets the value of the imaginary part.
	 */
	public Komplex(double re, double im) {
		RE = re;
		IM = im;
	}

	/**
	 * Adds the given complex number a to the current complex number.
	 * 
	 * @param a Komplex value, contains the complex number a. 
	 * 
	 * @return void
	 */
	public void addiere(Komplex a) {
		this.RE += a.RE;
		this.IM += a.IM;
	}
	
	/**
	 * 
	 * Multiplies the given complex number a with the curent complex number.
	 * 
	 * @param z Komplex value, contains the complex number z.
	 * 
	 * @return void
	 */
	public void multipliziere(Komplex a) {
		double RE_Speicher;
		double IM_Speicher;
		RE_Speicher = (this.RE * a.RE) - (this.IM * a.IM);	// the values for the real value and the imaginary value have to be saved before returning them
		IM_Speicher = (this.RE * a.IM) + (this.IM * a.RE);	// otherwise they will interfere with each other
		this.RE = RE_Speicher;
		this.IM = IM_Speicher;

	}

	/**
	 * Returns the absolute value of the current complex number as a double value.
	 * 
	 * @return double 
	 */
	public double getBetrag() {
		return Math.sqrt(RE * RE + IM * IM);
	}

	/**
	 * Returns the current complex number as a String.
	 * 
	 * @return String
	 */
	public String toString() {
		if (IM < 0)										// depending on whether the real part or the imaginary part of the complex number is 0 and whether the imaginary part is negative
			return (RE + " - " + IM * -1 + "i");		// the complex number will be returned as a different String.
		if (IM == 0)
			return ("" + RE);
		if (IM == 1)
			return (RE + " + " + "i");
		return (RE + " + " + IM + "i");
	}

	/**
	 * Returns the squareroot of the current complex number as an array. 
	 * If both the real and the imaginary value are 0, the returned array will be empty.
	 * 
	 * @return Komplex[]
	 */
	public Komplex[] getWurzel() {
		double x = this.getBetrag();					// x contains the absolute of the current complex number.
		double winkel = Math.atan(IM / RE);				// winkel contains the angle of the current complex number
		Komplex[] Wurzel;
		Komplex rueckgabe;
		if ((RE<0 && IM <0 )|| (RE<0 && IM>0))			// Adjusts the result of the calculation depending on in which quadrant the complex number is in. 
			winkel += Math.PI;
		else if (IM < 0 && RE >0)
			winkel = +(2 * Math.PI);

		if (winkel == 0) {								// If both RE and IM are 0, an empty array will be returned. 
			Wurzel = new Komplex[0];
			return Wurzel;
		}

		Wurzel = new Komplex[2];
		for (int i = 0; i <= 2; i++) {
			rueckgabe = new Komplex(x * Math.sin((winkel * (2 * Math.PI * i) / 2)),
					x * Math.cos((winkel * (2 * Math.PI * i) / 2)));
			Wurzel[i] = rueckgabe;
		}
		return Wurzel;
	}

	/**
	 * Returns the sum of the current complex number and the given current number as a complex number. 
	 * 
	 * @param z Komplex value, contains the complex number z.
	 * @return
	 */
	public Komplex getSumme(Komplex z) {
		Komplex a = new Komplex(this.RE, this.IM);
		a.addiere(z);
		return a;
	}

	/**
	 * Returns the product of the current complex number and the given current number as a complex number.
	 * 
	 * @param z Komplex value, contains the complex number z.
	 * @return
	 */
	public Komplex getProdukt(Komplex z) {
		Komplex a = new Komplex(this.RE, this.IM);
		a.multipliziere(z);
		return a;
	}
}
