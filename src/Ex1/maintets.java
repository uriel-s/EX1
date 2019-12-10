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



//System.out.println("this is cp1 "+cp1);

//System.out.println("this is cp2 "+cp2);
//System.out.println("this is cp3"+cp3);
////System.out.println("this is cp1 "+cp1);
////System.out.println("this is cp5 "+cp5);
////System.out.println("this is cp6 "+cp6);
////System.out.println("this is cp6 "+cp9);
//System.out.println("this is cp10 "+cp10);

ComplexFunction	expected1= new ComplexFunction(cp1);
ComplexFunction	expected2= new ComplexFunction(cp6);
//System.out.println(expected1);
//System.out.println(expected2.f(14));

boolean b = expected2.equals(expected2);
System.out.println(b);	
System.out.println(expected2.f(14));
System.out.println(expected1.f(14));

	}

}




//
//Polynom right1= new Polynom() ;
//Polynom root1= new Polynom() ;
//ComplexFunction cp1 =new  ComplexFunction();
////if(this.Operation==null)
////{
//	if(( this.root instanceof Monom||this.root instanceof Polynom)&&(this.right instanceof Monom||this.right instanceof Polynom)) 
//	{	right1=(Polynom) this.right.copy();
//	root1=(Polynom) this.root.copy();
//double ans = right1.f(x)+root1.f(x);
//System.out.println(ans);	 
//return ans;
//	}
//	if(( this.root instanceof Monom||this.root instanceof Polynom)&&(this.right instanceof ComplexFunction)) 
//	{	root1=(Polynom) this.root;
//	cp1=(ComplexFunction) this.right;
//	return root1.f(x)+cp1.f(x);
//	}
//	if(( this.right instanceof Monom||this.right instanceof Polynom)&&(this.root instanceof ComplexFunction)) 
//	{
//		right1=(Polynom) this.right;
//		cp1=(ComplexFunction) this.root;
//		return right1.f(x)+cp1.f(x);
//
//	}
