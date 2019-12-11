package Ex1;

import java.util.Comparator;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class Wimplements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{
	public static final Monom ZERO = new Monom(0,0);
	public static final Monom MINUS1 = new Monom(-1,0);
	public static final double EPSILON = 0.0000001;
	public static int counter = 0;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();
	public static Comparator<Monom> getComp() {return _Comp;}

	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	public double get_coefficient() {
		return this._coefficient;
	}
	public int get_power() {
		return this._power;
	}
	/** 
	 * this method returns the derivative monom of this.
	 * @return
	 */
	public Monom derivative() {
		if(this.get_power()==0) {return getNewZeroMonom();}
		return new Monom(this.get_coefficient()*this.get_power(), this.get_power()-1);
	}
	public double f(double x) {
		double ans=0;
		double p = this.get_power();
		ans = this.get_coefficient()*Math.pow(x, p);
		return ans;
	} 
	public boolean isZero() {return this.get_coefficient() == 0;}

	public boolean equals(Monom m) {
		if(m.isZero()&&this.isZero())return true;
		double a=this.get_coefficient();
		double b=m.get_coefficient();
		double c=Math.abs(a-b);
		if(c<EPSILON && this.get_power()==m.get_power()) {
			return true;
		}
		return false;
	}
	// ****** add your code below *********


	public Monom(String s) {
		s=s.toLowerCase();
		s=s.replaceAll("\\s","");
		if(s=="0") {
			this.set_coefficient(0);
			this.set_power(0);
			return;
		}

		if(s.charAt(0)=='0'&&s.charAt(1)=='x') {
			this.set_coefficient(0);
			this.set_power(0);
			return;
		}



		if(s.charAt(0)=='+' ) 
			s=s.substring(1);


		if(s.equals("x"))
		{
			this.set_coefficient(1);
			this.set_power(1);   

			return;
		}
		else if(s.equals("-x"))
		{
			this.set_coefficient(-1);
			this.set_power(1);   

			return;
		}



		if(s.charAt(0)=='-'&&s.charAt(1)=='x' ) 
		{
			if(s.charAt(2)!='^') 			throw new RuntimeException("input isnt good ");	

			this.set_coefficient(-1);
			s=s.substring(3);
			int b=Sumpower(s);
			this.set_power(b);


			return;
		}
		if(s.charAt(0)=='x') { 
			if(s.charAt(1)!='^')	throw new RuntimeException("input isnt good ");	

			this.set_coefficient(1);
			s=s.substring(2);
			int b=Sumpower(s);
			this.set_power(b);

		}




		else if (isNumeric(s)) 
		{

			this.set_coefficient(Double.valueOf(s)) ; 

			this.set_power(0);




		}



		else {


			int b=0;
			double a=0;
			if (s.charAt(0) == '-'&&s.charAt(1)>='0'&&s.charAt(1)<='9') {
				s=s.substring(1); 
				a=Sumcoefficient(s);
				a=a*(-1);

			}


			else { a=  Sumcoefficient(s);
			}

			this.set_coefficient(a);



			s=s.substring(counter);


			if(s.length()!=0 && s.length()!=1)
			{
				s=s.substring(2);
				b=Sumpower(s);

				this.set_power(b);
			}
			else if(s.length()==1)  b=1;


			this.set_power(b);
		}
	}



	public  double Sumcoefficient(String s) {

		String s1 = s;
		if(s.charAt(0)<'0'||s.charAt(0)>'9') {
			System.out.println(s.charAt(0));
			System.out.println(s);
			throw new RuntimeException("input isnt good ");	
		}
		counter=0;

		while (s.charAt(0)>='0'&&s.charAt(0)<='9' ||s.charAt(0)=='.') 	{
			counter ++;
			s=s.substring(1);
		}
		if (s.charAt(0)!='x') 
			throw new RuntimeException("input isnt good ");

		s1=s1.substring(0, counter);
		double a = Double.valueOf(s1);


		return a ;

	}

	public  int Sumpower(String s) {

		Integer b;
		if (s.isEmpty()) return 1;

		else  b = Integer.valueOf(s);

		while(s.length()>0)
		{
			if(s.charAt(0)<'0'||s.charAt(0)>'9')
				//				

				throw new RuntimeException("input isnt good ");

			s=s.substring(1);
		}


		return b;


	}
	//this code take from https://stackoverflow.com/questions/36490757/regex-for-polynomial-expression
	public static boolean isNumeric(String strNum) {
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}
	public void add(Monom m) {
		if(m.get_power()!= this.get_power()) {
			throw new RuntimeException("ERROR: THE POWER OF THE GIVEN MONOM CANOT ADDED TO THE CORRENT MONOM");			
		}
		else
			this.set_coefficient(this._coefficient + m.get_coefficient());
	}

	public void multiply(Monom d) {
		this.set_coefficient(this._coefficient * d.get_coefficient());
		this.set_power(this._power + d.get_power());	 
	}

	public String toString() {
		String ans="";
		if(this.get_coefficient()>=0) {
			ans = "+"+this.get_coefficient() +"x^" + this.get_power();	
		}
		else {
			ans = this.get_coefficient() +"x^" + this.get_power();	
		}
		return ans;
	}
	// you may (always) add other methods.

	//****** Private Methods and Data *******


	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		if(p<0) {throw new RuntimeException("ERR the power of Monom should not be negative, got: "+p);}
		this._power = p;
	}
	private static Monom getNewZeroMonom() {return new Monom(ZERO);}

	public double _coefficient; 
	public int _power;
	@Override
	public function initFromString(String s) {
		Monom m = new Monom(s);
		return m;
	}

	@Override
	public function copy() {
		Monom m = new Monom("0");
		m.set_coefficient(this.get_coefficient());;
		m.set_power(this.get_power());
		return m;
	}


}