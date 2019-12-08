package Ex1.Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex1.ComplexFunction;
import Ex1.Monom;
import Ex1.Operation;
import Ex1.Polynom;
import Ex1.function;

class ComplexFunctionTest {	
	Monom m =new Monom("2x^2");
	Polynom p = new Polynom("2x^2");
	ComplexFunction cp1 = new ComplexFunction(Operation.Plus, m , p);
	ComplexFunction cp2= new ComplexFunction(Operation.Plus, m , cp1);

	@Test
	void testComplexFunctionFunction() {
		
		function p1 = new Polynom("2x^2");
		ComplexFunction cp = new ComplexFunction(p1); 
		
		System.out.println(cp);
		System.out.println(cp1);
		System.out.println(cp2);

		System.out.println("cp");
		

	}
	//
	//	@Test
	//	void testComplexFunctionOperationFunctionFunction() {
	//		fail("Not yet implemented");
	//	}
	//
	@Test
	void testCopy() {
		ComplexFunction cp3 = new ComplexFunction();
		cp3 = (ComplexFunction) cp1.copy();
		System.out.println(cp2);
	}
	//
	//}
}