package Ex1;

public class maintets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Monom m =new Monom("x");
		Polynom p = new Polynom("2x^2");
	ComplexFunction cp3 = new ComplexFunction(Operation.Plus, m , p);
//		ComplexFunction cp2= new ComplexFunction(Operation.Plus, m , cp1);
	
	ComplexFunction cp1 = new ComplexFunction(p);
	ComplexFunction cp2 = new ComplexFunction();
	cp2= (ComplexFunction) cp1.copy();
    cp1.root.setFunction(m);
	  System.out.println(cp2);
	  System.out.println(cp1);
	  System.out.println(cp3);

	}

}
