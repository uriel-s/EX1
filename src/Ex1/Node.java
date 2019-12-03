package Ex1;
//yair the loosersa
public class Node {

	private Node left;
	private Node right;
	private function function;
	private  Operation Operation;

	public Node (function f) {
		this.function=f;
		this.left=null;
		this.right=null;

	}
	
	
	
	public Node (Operation op, Node n1, Node n2) {
		this.func=null;
		this.left=n1;
		this.right=n2;

	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public function getFunc() {
		return func;
	}
	public void setFunc(function func) {
		this.func = func;
	}
	public Operation getOpp() {
		return opp;
	}
	public void setOpp(Operation opp) {
		this.opp = opp;
	}

	
}
