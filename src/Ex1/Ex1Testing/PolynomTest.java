package Ex1.Ex1Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Ex1.Polynom;
import Ex1.Monom;
public class PolynomTest {

	@Test
	public void testAddp() {
		Polynom e1 = new Polynom("2x^3+7x");
		Polynom e2 = new Polynom("x^3");
		e1.add(e2);
		Polynom e3 = new Polynom("3x^3+7x");
		assertEquals(e1, e3);

	}
	@Test
	public void testAddm() {
		Polynom e1 = new Polynom("2x^3+7x");
		Monom e2 = new Monom("x^3");
		e1.add(e2);
		Polynom e3 = new Polynom("3x^3+7x");
		assertEquals(e1, e3);

	}
	@Test
	public void testSubp() {
		Polynom e1 = new Polynom("2x^3+7x");
		Polynom e2 = new Polynom("x^3");
		e1.substract(e2);
		Polynom e3 = new Polynom("x^3+7x");
		assertEquals(e1, e3);

	}
	@Test
	public void testMultp() {
		Polynom e1 = new Polynom("2x^3+7x");
		Polynom e2 = new Polynom("x^3");
		e1.multiply(e2);
		Polynom e3 = new Polynom("2x^6+7x^4");
		assertEquals(e3,e1);

	}
	@Test
	public void testArrange() {
		Polynom e1 = new Polynom("7x+2x^3");	
		Polynom e2 = new Polynom("x^3+x^3+7x");
		assertEquals(e2,e1);    
	}
	@Test
	public void testMultm() {
		Polynom e1 = new Polynom("2x^3+7x+0");
		Monom e2 = new Monom("x^3");
		e1.multiply(e2);
		Polynom e3 = new Polynom("2x^6+7x^4");
		assertEquals(e3,e1);

	}
	@Test
	public void testBuild() {
		Polynom e1 = new Polynom("2x^3+7x+0");
		String str =e1.toString();
		String s ="+2.0x^3+7.0x^1";
		boolean b=s.equals(str);
		assertTrue(b);

	}
	@Test
	public void testf() {
		Polynom e1 = new Polynom("2x^3+7x");
		double x=e1.f(3);
		assertEquals(75, x, 0.0000001);
	}
	@Test
	public void testIsZero() {
		Polynom e1 = new Polynom("0x^3+7x+5");
		Polynom e2 = new Polynom("0x^3+0x+5x-5x");
		boolean b1 = e1.isZero();
		boolean b2 = e2.isZero();
		assertTrue(b2);
		assertFalse(b1);
	}
	@Test
	public void testderiviate() {
		Polynom e1 = new Polynom("2x^3+7x+5");
		Polynom e2 = new Polynom("6x^2+7");
		e1=(Polynom)e1.derivative();
		assertEquals(e2, e1);
	}
	@Test
	public void testRoot() {
		Polynom c=new Polynom("x^2-3x");
		double ans=c.root(1, 4, 0.00000001);
		assertEquals(3, ans, 0.00000001);
	}
	@Test
	public void testArea() {
		Polynom c=new Polynom("4x^6-5x^5+1");
		double ans=c.area(-1, 0, 0.0001);
		assertEquals(2.405, ans, 0.001);
	}
	@Test
	public void testEquals() {
		Polynom c=new Polynom("4x^6-5x^5+1");
		Polynom c1=new Polynom("4x^6-5x^5+1");
		Polynom c2=new Polynom("4x^6-5x^5+2");
		boolean b= c.equals(c1);
		boolean r= c.equals(c2);
		assertTrue(b);
		assertFalse(r);

	}
}
