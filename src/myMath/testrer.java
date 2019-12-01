package myMath;

public class testrer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
   Polynom p=new Polynom("4x^2+7");
   Monom p2=new Monom("12x");
   Polynom_able p3=new Polynom("+3x^2+8x");

  p.multiply(p3);
System.out.println(p);
	}

}
