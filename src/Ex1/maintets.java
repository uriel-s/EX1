package Ex1;

public class maintets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Monom m =new Monom("x");
		Polynom p = new Polynom("2x^2");
		ComplexFunction cp1 = new ComplexFunction(Operation.Plus, p , p);
		ComplexFunction cp = new ComplexFunction(m);
		cp1.plus(p);
		//ComplexFunction cp1 = new ComplexFunction(p);
		//ComplexFunction cp2 = new ComplexFunction(m);
		//cp2= (ComplexFunction) cp1.copy();
		//System.out.println(cp1);
		//System.out.println(cp2);
		//ystem.out.println(cp3);


		System.out.println(cp1);
		//	System.out.println(m);
		//System.out.println(p);
		//System.out.println(cp);


	}

}
