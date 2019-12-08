package Ex1;

public class maintets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Polynom p1 =new Polynom("0");
		Polynom p2 = new Polynom("2x^2+x");
		Polynom p3 = new Polynom("3x^12");

		ComplexFunction cp1 = new ComplexFunction(Operation.Plus, p1 , p2);
		ComplexFunction cp = new ComplexFunction(p1);
		cp1.plus(p3);



		System.out.println("this is cp"+cp.toString());
		System.out.println("this is cp1: "+cp1);
		


	}

}
