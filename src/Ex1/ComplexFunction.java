package Ex1;

public class  ComplexFunction implements complex_function{
	private Node root;

	// constructors
	public ComplexFunction( ) {
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
	public String toString () {
		String s="";
		s=s+root.getFunction().toString();
		if(root.getLeft()!=null) s+=preOrder(root.getLeft());
		if(root.getRight()!=null) s+=preOrder(root.getRight());


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

	@Override
	public function copy() {


		ComplexFunction f = new ComplexFunction(); 
		f.root= new Node(this.root.getFunction());
		f.root.setLeft(this.root.getLeft());
		f.root.setRight(this.root.getRight());
		f.root.setOperation(this.root.getOperation());
		return f;
	}

	@Override
	public void plus(function f1) {
		ComplexFunction cp = new ComplexFunction(Operation.Plus, f1, this);

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
