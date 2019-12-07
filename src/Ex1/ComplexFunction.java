package Ex1;

public class  ComplexFunction implements complex_function{
	 Node root;

	// constructors
	public ComplexFunction() {
		this.root= null;

	}

	public ComplexFunction(Operation op, Node l ,Node r)
	{

		this.root.setLeft(l); 
		this.root.setRight(r); 
		this.root.setOperation(op);
		this.root.setFunction(null);
	}



	public ComplexFunction(function f) {
		root= new Node(f);

	}

	public ComplexFunction(Operation op, function f1,function f2)
	{

		Node left = new Node(f1); 
		Node right = new Node(f2);
		root = new Node(op,left,right);

	}

	// complecfunction funcs
	//eror 
	
	public String toString () {
		String s="";
		s=s+this.root.getFunction().toString();
		if(this.root.getLeft()!=null) s+=preOrder(this.root.getLeft());
		if(this.root.getRight()!=null) s+=preOrder(this.root.getRight());


		return s;


	}



	public String preOrder (Node n) {
		String s="";
		s=s+n.getFunction().toString();
		if(n.getLeft()!=null)s=s+preOrder(n.getLeft()); 
		if(n.getRight()!=null)s=s+preOrder(n.getRight()); 

		return s;


	}


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
		cp.root= new Node(this.root.getFunction());
		cp.root.setLeft(this.root.getLeft());
		cp.root.setRight(this.root.getRight());
		cp.root.setOperation(this.root.getOperation());
		return cp;
	}

	@Override
	// didnt finished
	public void plus(function f1) {
		ComplexFunction temp = new ComplexFunction();
		ComplexFunction cp = new ComplexFunction(Operation.Plus, this, f1);

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
