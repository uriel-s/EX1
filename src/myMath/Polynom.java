package myMath;

import java.util.*;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{

	public ArrayList<Monom> pol = new ArrayList<Monom>();
	Monom_Comperator c =new Monom_Comperator();
	/**
	 * Zero (empty polynom)
	 */
	public Polynom() {
		pol.add(0,Monom.ZERO);

	}
	/**
	 * init a Polynom from a String such as:
	 *  {"x", "3+1.4X^3-34x", "(2x^2-4)(-1.2x-7.1)", "(3-3.4x+1)((3.1x-1.2)-(3X^2-3.1))"};
	 * @param s: is a string represents a Polynom
	 */
	//code tooken from https://stackoverflow.com/questions/36490757/regex-for-polynomial-expression
	public Polynom(String s) {


		Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			Monom m = new Monom(matcher.group(1));
			pol.add(m);
		}
		this.pol.sort(c);
		this.arrange();
		
	}
	@Override
	public double f(double x) {
		double sum=0;
		for(int i=0 ; i < pol.size() ; i++) {
			sum += pol.get(i).f(x);
		}
		return sum;
	}

	@Override
	public void add(Polynom_able p1) {
		Polynom_able help= new Polynom();
		help=p1.copy();
		Iterator<Monom> monom1 = help.iteretor();
		while(monom1.hasNext()) {
			this.pol.add(monom1.next());
		}
		this.arrange();
	} 
	public void arrange() {
		for (int i = 0; i < this.pol.size()-1; i++) {
			for (int j = i+1; j < this.pol.size(); j++) {
				if(pol.get(i).get_power() == pol.get(j).get_power()) {
					pol.get(i).add(pol.get(j));
					pol.remove(j);
					j--;
				}
			}
		}
		for ( int i= 0; i < this.pol.size(); i++) {
			if(pol.get(i).get_coefficient()== 0) {
				pol.remove(i);

			}
		}
		for ( int i= 0; i < this.pol.size(); i++) {
			if(pol.get(i).get_coefficient()== 0) {
				pol.remove(i);

			}
		}	 
	}


	@Override
	public void add(Monom m1) {
		for(int i=0 ; i < pol.size() ; i++) {
			if(pol.get(i).get_power() == m1.get_power()) {
				Monom t=new Monom(pol.get(i).get_coefficient()+m1.get_coefficient(), m1.get_power());
				pol.set(i, t);
				return;
			}
		}
		pol.add(m1);
	// add arrgane to this func
		this.arrange();
		this.pol.sort(c);
		return;

	}
	@Override
	public void substract(Polynom_able p1) {
		Polynom_able help=new Polynom();
		help =p1.copy();
		Iterator<Monom> monom1 = help.iteretor();
		while(monom1.hasNext()) {
			Monom t = new Monom(monom1.next());
			double d = t.get_coefficient()*(-1);
			Monom b = new Monom(d,t.get_power());
			this.pol.add(b);
		}	
		this.arrange();
	}

	@Override
	public void multiply(Polynom_able p1) {
		Polynom help=new Polynom();
		Polynom ans=new Polynom("");
		help=(Polynom)(p1);
		Monom m =new Monom(0,0);
		for (int i = 0; i <help.pol.size(); i++) {
			for (int j = 0; j <this.pol.size(); j++) {
				m= new Monom(help.pol.get(i));
				m.multiply(this.pol.get(j));
				ans.add(m);
			}
		}
		this.pol= new ArrayList<Monom>(ans.pol);
		this.arrange();
		
		
	}

	@Override
	public boolean equals(Polynom_able p1) {
		Iterator<Monom> monom = this.iteretor();
		Iterator<Monom> monom1 = p1.iteretor();
		while(monom1.hasNext()) {
			if(!(monom1.next().equals(monom.next()))) 
				return false;
		}
		return true;	 
	}

	@Override
	public boolean isZero() {
		Iterator<Monom> monom = this.iteretor();
		while(monom.hasNext()) {
			if(monom.next().get_coefficient()!=0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public double root(double x0, double x1, double eps) {
		if(f(x0)==0) {return x0;}
		if(f(x1)==0) {return x1;}
		if(f(x1)*f(x0) > 0 || x1<=x0 || eps <= 0) 
		{throw new RuntimeException("ERROR: illigal one or more parameters");}
		double a=x0;
		double b= x1;
		double m = (x0 + x1)/2;
		if(Math.abs(f(m))<eps) {return m;}
		if(f(m)*f(b)<0) {
			return this.root(m,b,eps);
		}
		else
			return this.root(a,m,eps);	
	}

	@Override
	public Polynom_able copy() {
		Polynom p= new Polynom();
		Iterator<Monom> i=this.iteretor();
		while(i.hasNext()) {
			Monom temp=new Monom(i.next());
			p.add(temp);
		}
		return p;		
	}

	@Override
	public Polynom_able derivative() { 
		Polynom_able pm = new Polynom();
		Polynom_able help=this.copy();
		Polynom p=new Polynom();
		Iterator<Monom> monom = help.iteretor();
		while(monom.hasNext()) {
			Monom m=new Monom(0,0);
			m=	monom.next().derivative();
			p.add(m);
		}
		pm=p;
		return pm;
	}

	@Override
	/**
	 * this function calculate the area according to Rieman's integral
	 */
	public double area(double x0, double x1, double eps) {
		if(x0==x1) {return 0;}	
		if(x0 > x1 || eps<=0 || eps>(x1-x0)) {throw new RuntimeException("ERROR: illigal one or more parameters");} 
		double d=0;
		for(double i=x0; i<=x1; i+=eps) {
			if(f(i)>=0) {
			d+= Math.abs(this.f(i)*eps);
			}
		}
		return d;
	}

	@Override
	public Iterator<Monom> iteretor() {
		return this.pol.iterator();
	}

	@Override
	public void multiply(Monom m1) {
		for(int i=0 ; i < pol.size() ; i++) {
			double a = m1.get_coefficient()*pol.get(i).get_coefficient();
			int b = m1.get_power() + pol.get(i).get_power();
			Monom t=new Monom(a,b);
			pol.set(i, t);

		}
		this.arrange();
	}
	public String toString() {
		if(pol.size()==0) {
			return "0";
		}
		String str="";
		for(int i= 0;i<this.pol.size();i++) {
			str+=pol.get(i).toString();
		}
		return str;
	}

}