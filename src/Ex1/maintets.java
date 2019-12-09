package Ex1;
import Ex1.complex_function;
public class maintets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				Polynom p1 =new Polynom("2x^2");
				Polynom p2 = new Polynom("2");
ComplexFunction cp1 = new ComplexFunction(p1);
ComplexFunction cp2 = new ComplexFunction(Operation.Plus,p1,p2);
ComplexFunction cp3 = new ComplexFunction(Operation.Plus,p1,cp2);
ComplexFunction cp4 = new ComplexFunction(Operation.Plus,cp2,p1);
ComplexFunction cp10 = new ComplexFunction(Operation.Plus,p1,cp4);
ComplexFunction cp5= (ComplexFunction) cp3.copy();
ComplexFunction cp6= (ComplexFunction) cp5.copy();
ComplexFunction cp7= (ComplexFunction) cp6.copy();
ComplexFunction cp8= (ComplexFunction) cp7.copy();
ComplexFunction cp9= (ComplexFunction) cp8.copy();
ComplexFunction cp11= new ComplexFunction();

//cp1=(ComplexFunction) cp1.initFromString("Plus(Plus(+1.0x^0,+2.0x^0),+1.0x^0)");
double x= cp4.f(3.3);



System.out.println("this is cp1 "+cp1);

System.out.println("this is cp2 "+cp2);
System.out.println("this is cp3"+cp3);
//System.out.println("this is cp1 "+cp1);
//System.out.println("this is cp5 "+cp5);
//System.out.println("this is cp6 "+cp6);
//System.out.println("this is cp6 "+cp9);
System.out.println("this is cp10 "+cp10);


	
	}

}
