package Ex1.Ex1Testing;

import Ex1.Monom;
import Ex1.Polynom;
import Ex1.Polynom_able;

public class PolynomTester {
	public static void main(String[] args) {
		test1();
		test2();
		 test3();
	}
	public static void test1() {
		Polynom p1 = new Polynom();
		String[] monoms = {"124x^55-2x^3333+12.1x","12x"};
		for(int i=0;i<monoms.length;i++) {
		Polynom m = new Polynom(monoms[i]);
		  p1.add(m);
		  }
		System.out.println(p1);

		double aa = p1.area(0, 1, 0.0001);
		p1.substract(p1);
		System.out.println(p1);
		System.out.println(aa);
	}
	public static void test2() {
		System.out.println("******test 2*******");
		Polynom p1 = new Polynom(), p2 =  new Polynom();
		String[] monoms1 = {"2", "-x","-3.2x^2","4","-1.5x^2"};
		String[] monoms2 = {"5", "1.7x","3.2x^2","-3","-1.5x^2"};
		for(int i=0;i<monoms1.length;i++) {
			Monom m = new Monom(monoms1[i]);
			p1.add(m);
		}
		for(int i=0;i<monoms2.length;i++) {
			Monom m = new Monom(monoms2[i]);
			p2.add(m);
		}
		System.out.println("p1: "+p1);
		System.out.println("p2: "+p2);
		p1.add(p2);
		System.out.println("p1+p2: "+p1);
		p1.multiply(p2);
		System.out.println("(p1+p2)*p2: "+p1);
	}


	public static void test3() {
		System.out.println("****test3****");
		Polynom a=new Polynom("0x^3+0x^2");
		Polynom a1=new Polynom("4x^2+7");
		Polynom_able a2=new Polynom("+3x^2+8x");
		
		a1.add(a2);
		System.out.println(a1.toString());
		
		a1.substract(a2);
		System.out.println(a1.toString());
		System.out.println(a2);
		
		a1.multiply(a2);
		System.out.println("this is  pol*pol func" +a1.toString());
		
		Polynom_able p=a1.copy();
        Polynom w = (Polynom)p;
        System.out.println(w.toString());
        Monom s=new Monom("3x^2");
        a1.add(s);
        System.out.println(a1.equals(p));
        
        System.out.println(a.isZero());
        
        p=a1.derivative();
        System.out.println(p.toString());
        
        double area=p.area(0, 1, 0.0001);
        System.out.println(area);
        
        Monom m1=new Monom(2, 3);
        a1.add(m1);
        System.out.println(a1.toString());
        a1.multiply(m1);
        System.out.println(a1.toString());
        
        Polynom c=new Polynom("x^2-3x");
        double ans=c.root(1, 4, 0.00000001);
        double v=c.f(5);
        System.out.println(ans);
        System.out.println(v);
        
Monom mm1= new Monom ("2x^2");
Polynom p12= new Polynom("2x^2");
	boolean b=	p12.equals(mm1);
		
	}
	
	
	
}
