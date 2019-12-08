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
			s+= right.toString();	

		return s;

	}


	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public function initFromString(String s) {
		if(legalString(s)==false  ) throw new IllegalArgumentException("illigal input");
		ComplexFunction cpf = new ComplexFunction();
		String tmp="";
		while(s.charAt(i)!='(')
		{		

		}	

		Polynom p = new Polynom("x");
		return p;
	}

	public boolean legalString(String s) {
		int counter1=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==')') counter1=counter1+2;
			if(s.charAt(i)=='(') counter1--;
			if(s.charAt(i)==';') counter1--;
			if(counter1<0) return false;
		}
		if (counter1==0)return true;
		return false; 
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
