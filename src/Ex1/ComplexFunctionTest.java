package Ex1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComplexFunctionTest {

	private static final String ComplexFunction = null;
	Polynom p1 =new Polynom("2x^2");
	Polynom p2 = new Polynom("2");
	Polynom p3 = new Polynom("25.x^1+5x^2");

	ComplexFunction cp1 = new ComplexFunction(p1);
	ComplexFunction cp2 = new ComplexFunction(Operation.Plus,p1,p2);
	ComplexFunction cp3 = new ComplexFunction(Operation.Plus,p1,cp2);
	ComplexFunction cp4 = new ComplexFunction(Operation.Plus,cp2,p1);
	ComplexFunction cp5 = new ComplexFunction(Operation.Plus,cp3,cp3);
	ComplexFunction cp6 = new ComplexFunction(Operation.Plus,cp5,cp5);
	ComplexFunction cp10 = new ComplexFunction(Operation.Plus,p1,cp4);
	ComplexFunction cp7 = new ComplexFunction(Operation.Max,p1,cp4);


	@Test
	void testToString() {
		String expected1 ="+2.0x^2";
		String expected2 ="Plus(+2.0x^2,+2.0x^0)";
		String expected3 ="Plus(+2.0x^2,Plus(+2.0x^2,+2.0x^0))"; 
		assertEquals(expected1, cp1.toString());
		assertEquals(expected2, cp2.toString());
		assertEquals(expected3, cp3.toString());

	}

	@Test
	void testF() {
		double x =3;
		double polynom  = 2* Math.pow(x, 2);
		double ans = polynom+2;
		double expected1= cp2.f(x);
		double expected2= cp3.f(x);
		double expected3= cp5.f(x);
		assertEquals(ans, expected1);
		ans=expected1 + polynom;
		assertEquals(ans, expected2);
		ans=expected2 +expected2;
		assertEquals(ans, expected3);
		double expected4= cp7.f(2);
		assertEquals(expected4, cp4.f(2));


	}

	@Test
	void testInitFromString() {
		ComplexFunction expected1 = new ComplexFunction();	
		ComplexFunction expected2 = new ComplexFunction();	
		ComplexFunction expected3 = new ComplexFunction();	

		expected1=(ComplexFunction) expected1.initFromString("2x^2");
		expected2=(ComplexFunction) expected2.initFromString("Plus(+2.0x^2,+2.0x^0)");
		expected3=(ComplexFunction) expected3.initFromString("Plus(+2.0x^2,Plus(+2.0x^2,+2.0x^0))");

		assertEquals(expected1.toString(), cp1.toString());
		assertEquals(expected2.toString(), cp2.toString());
		assertEquals(expected3.toString(), cp3.toString());


	}

	@Test
	void testCopy() {
		ComplexFunction expected1 =(ComplexFunction) cp1.copy();
		ComplexFunction expected2 = (ComplexFunction) cp4.copy();	
		ComplexFunction expected3 =(ComplexFunction) cp6.copy()	;	

		assertEquals(expected1.toString(), cp1.toString());
		assertEquals(expected2.toString(), cp4.toString());
		assertEquals(expected3.toString(), cp6.toString());


	}

		@Test
		void testPlus() {
			Polynom help = new Polynom("3x^2+1");
			ComplexFunction expected1 =new ComplexFunction();
			expected1.plus(cp1);
		
		}
	

		
		//	@Test
	//	void testMul() {
	//		fail("Not yet implemented");
	//	}
	//
	//	@Test
	//	void testDiv() {
	//		fail("Not yet implemented");
	//	}
	//
	//	@Test
	//	void testMax() {
	//		fail("Not yet implemented");
	//	}
	//
	//	@Test
	//	void testMin() {
	//		fail("Not yet implemented");
	//	}
	//
	//	@Test
	//	void testComp() {
	//		fail("Not yet implemented");
	//	}
	//
	//	@Test
	//	void testLeft() {
	//		fail("Not yet implemented");
	//	}
	//
	//	@Test
	//	void testRight() {
	//		fail("Not yet implemented");
	//	}
	//
	//	@Test
	//	void testGetOp() {
	//		fail("Not yet implemented");
	//	}
	//
	//	@Test
	//	void testEquals() {
	//		fail("Not yet implemented");
	//	}
	//
}
