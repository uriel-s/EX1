package Ex1;

import java.io.IOException;
import java.util.concurrent.CompletionException;
import java.util.function.Function;

public class  ComplexFunction implements complex_function{
	function root;
	function right;
	Operation Operation;


	// constructors
	public ComplexFunction() {
		this.root= this.right=null;
		this.Operation=null;
	}

	public ComplexFunction(Operation op, function l ,function r)
	{

		this.root=l; 
		this.right=r; 
		this.Operation =op;

	}

	public ComplexFunction(function f) {
		this.root=f;

	}


	// complecfunction funcs


	public String toString () {
		String s= "";
		if(this.root instanceof Monom ||this.root instanceof Polynom ) 
		{
			if(this.Operation!=null)s+=  this.Operation.toString()+ "(" ;
			s+= this.root.toString();
		}
		if (this.root instanceof ComplexFunction )
		{
			if(this.Operation!=null)s+=  this.Operation.toString()+ "(" ;
			s+=  root.toString();
		}
		if(this.right instanceof Monom||this.right instanceof Polynom)
			s+=","+ right.toString()+")";
		if (this.right instanceof ComplexFunction ) 
			s+= ","+right.toString()+")";	

		return s;

	}


	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public function initFromString(String s) {
		//checking if the String is lligal;
		if(legalString(s)==false  ) throw new IllegalArgumentException("illigal input :(");
		ComplexFunction cp = new ComplexFunction();

		//set the operation of the complexFunction
		if (FindOp(s)==null) { Polynom p=  new Polynom() ;
			p=	(Polynom) p.initFromString(s);
	    	cp.root=p;
	    	cp.right=null;
	    	cp.Operation=null;
		
	    	return cp;
	
		}
		 
			cp.Operation=Operation.valueOf(FindOp(s));
		s = s.substring(FindOp(s).length());


		int center = FindCenter(s);
		String SRoot=s.substring(1,center);
		String SRight=s.substring(center+1,s.length()-1);

		//set the root of the complexFunction
		cp.root=initFromString(SRoot);
		cp.right=initFromString(SRight);

		return cp;
	}

	public boolean legalString(String s) {
		int counter1=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='(') counter1=counter1+2;
			if(s.charAt(i)==')') counter1--;
			if(s.charAt(i)==',') counter1--;
			if(counter1<0) return false;
		}
		if (counter1==0)return true;
		return false; 
	}
	public int FindCenter(String s) {
		int i=0;
		int j=1;
		while(s.charAt(i)!='('&& i<s.length()-1)		i++;
		while(j>0) 
		{
			i++;
			if(s.charAt(i)=='(')  j++;
			if(s.charAt(i)==',')  j--;

		}

		return i;
	}




	public  String FindOp(String s) { 

		String tmp="";
		if(s.charAt(0)!='P'&&s.charAt(0)!='T'&&s.charAt(0)!='D'&&s.charAt(0)!='M'&&s.charAt(0)!='C'&&s.charAt(0)!='N'&&s.charAt(0)!='E')return null;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='(') return tmp;
			tmp+=s.charAt(i);

		}

		return tmp;
		//		if (tmp=="Plus")return s;
		//		if (tmp=="Times")return Operation.Times;
		//		if (tmp=="Divid")return Operation.Divid;
		//		if (tmp=="Max")return Operation.Max;
		//		if (tmp=="Min")return Operation.Min;
		//		if (tmp=="Comp")return Operation.Comp;
		//else throw new IllegalArgumentException("illigal input");
	}	







	//didnt tested yet
	@Override

	public function copy() {

		ComplexFunction cp = new ComplexFunction(); 
		cp.root=this.root.copy();
		cp.Operation=this.Operation;
		if(this.right!=null) cp.right=this.right.copy();	
		return cp;
	}

	@Override
	// didnt finished
	public void plus(function f1) {
		ComplexFunction f = (ComplexFunction) this.copy();
		this.root=f;
		this.right=f1;
		this .Operation=Operation.Plus;

	}

	@Override
	public void mul(function f1) {
		ComplexFunction f = (ComplexFunction) this.copy();
		this.root=f;
		this.right=f1;
		this .Operation=Operation.Times;


	}

	@Override
	public void div(function f1) {
		ComplexFunction f = (ComplexFunction) this.copy();
		this.root=f;
		this.right=f1;
		this .Operation=Operation.Divid;

	}

	@Override
	public void max(function f1) {
		ComplexFunction f = (ComplexFunction) this.copy();
		this.root=f;
		this.right=f1;
		this .Operation=Operation.Max;

	}

	@Override
	public void min(function f1) {
		ComplexFunction f = (ComplexFunction) this.copy();
		this.root=f;
		this.right=f1;
		this .Operation=Operation.Min;

	}

	@Override
	public void comp(function f1) {
		ComplexFunction f = (ComplexFunction) this.copy();
		this.root=f;
		this.right=f1;
		this .Operation=Operation.Comp;
	}

	@Override
	public function left() {
		return this.root.copy();
	}

	@Override
	public function right() {
		return this.right();
	}

	@Override
	public Operation getOp() {

		return this.Operation;
	}




}
