package Ex1;

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
	//eror 

	public String toString () {
		String s= "";
if(this.root instanceof Monom ||this.root instanceof Polynom ) s+= root.toString();
if (this.root instanceof ComplexFunction ) s+=root.toString();
if(this.right instanceof Monom||this.right instanceof Polynom) s+= right.toString();
if (this.right instanceof ComplexFunction ) s+=right.toString();	
		
		return s;
	
}

		//			String	s=inOrder(this);
		//			return s;
		//		}
		//		public String inOrder (function f) {
		//			String s="";
		//			s=s+this.root.toString();
		//			if(this.right!=null) s+=inOrder(this.right);
		//			return s;
		//		}
		



		@Override
		public double f(double x) {
			// TODO Auto-generated method stub
			return 0;
		}


		@Override
		public function initFromString(String s) {
			// TODO Auto-generated method stub
			return null;
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
			// TODO Auto-generated method stub

		}

		@Override
		public void div(function f1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void max(function f1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void min(function f1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void comp(function f1) {
			// TODO Auto-generated method stub

		}

		@Override
		public function left() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public function right() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Operation getOp() {
			// TODO Auto-generated method stub
			return null;
		}




	}
