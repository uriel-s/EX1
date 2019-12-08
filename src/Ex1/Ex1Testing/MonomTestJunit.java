package Ex1.Ex1Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

import org.junit.jupiter.api.Test;

import Ex1.Monom;

class MonomTestJunit {
	public static final double EPSILON = 0.0000001;



	@Test
	void testDerivative() 
	{
		Monom m1=new Monom(4, 2);	
		Monom m2=new Monom(1, 2);	
		Monom m3=new Monom(4, 0);
		Monom expected1= m1.derivative();
		Monom expected2= m2.derivative();
		Monom expected3= m3.derivative();

		Monom actual= new Monom(8,1);
		assertEquals(expected1._coefficient, actual._coefficient,EPSILON);
		assertEquals(expected1._power, actual._power);

		actual= new Monom(2,1);
		assertEquals(expected2._coefficient, actual._coefficient,EPSILON);
		assertEquals(expected2._power, actual._power);

		actual= new Monom(0,0);
		assertEquals(expected3._coefficient, actual._coefficient,EPSILON);
		assertEquals(expected3._power, actual._power);

	}

	@Test
	void testF() {
		Monom m1=new Monom(1, 1);
		Monom m2=new Monom(2, 0);
		Monom m3=new Monom(2, 2);
		double expected1 =1;
		double expected2 =2;
		double expected3 =18;

		double actual3=m3.f(3);
		double actual1=m1.f(1);
		double actual2=m1.f(2);


		assertEquals(expected1, actual1,0);
		assertEquals(expected2, actual2,EPSILON);
		assertEquals(expected3, actual3,EPSILON);

	}

	@Test
	void testIsZero() {
		Monom m1=new Monom(1, 1);	
		Monom m2=new Monom(0, 0);	
		Monom m3=new Monom(0, 2);	
		Monom  m4 =new Monom(1,2);
		
		assumeFalse(m4.isZero());
		
		assumeFalse(m1.isZero());
		assumeTrue(m2.isZero());
		assumeTrue(m3.isZero());

	}

	@Test
	void testEqualsMonom() {
		Monom m1 =new Monom(0,0);
		Monom m2 =new Monom(0.0000,2);
		Monom m3 =new Monom(10,0);
		assumeTrue(m2.equals(m1));
		assumeFalse(m3.equals(m2));
	}

	@Test
	void testMonomString() {
		Monom m1= new Monom("2x^2");
		Monom m2= new Monom(2,2);
		assertEquals(m1._coefficient, m2._coefficient,EPSILON);
		assertEquals(m1._power, m2._power);
	}

	@Test
	void testAdd() {
		Monom m1=new Monom("2x^2");
		Monom m2 = new Monom("-2x^2");		
		Monom m3 =new Monom("0");
		m1.add(m2);	
		assumeTrue(m1.isZero());
	}

	@Test
	void testMultiply() {
		Monom m1=new Monom("2x^2");
		Monom m2 = new Monom("2x^2");
		m2.multiply(m1);
		assertEquals(m2._coefficient,4,EPSILON);
		assertEquals(m2._power,4);
		m2.multiply(m2);
		assertEquals(m2._coefficient,16,EPSILON);
		assertEquals(m2._power,8);
		m2.multiply(new Monom(0,0));
		assumeTrue(m2.isZero());
	}
	//	@Test
	//	void testCopy() {
	//		Monom m1 = new Monom("12.5x^3");
	//		Monom Monom2 = new Monom("0");
	//		m2.copy(m1);
	//	}



}
