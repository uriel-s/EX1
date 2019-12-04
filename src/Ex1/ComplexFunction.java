package Ex1;

public class  ComplexFunction implements complex_function{
	private Node root;
	

	public ComplexFunction(function f) {
		root= new Node(f);

	}

	public ComplexFunction(Operation op, function f1,function f2)
	{

		Node left = new Node(f1);
		Node right = new Node(f2);
		root = new Node(op,left,right);
	
	}
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void plus(function f1) {

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
