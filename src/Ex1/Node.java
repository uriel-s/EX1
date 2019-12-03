package Ex1;
public class Node {

	private Node left;
	private Node right;
	private function function;
	private  Operation Operation;

	public Node (function f) {
		this.function=f;
		this.left=null;
		this.right=null;
		this.Operation=null;
	}



	public Node (Operation operation, Node n1, Node n2) {
		this.function=null;
		this.left=n1;
		this.right=n2;
		this.Operation=operation;

	}







	public function getFunction() {
		return function;
	}



	public void setFunction(function function) {
		this.function = function;
	}



	public Operation getOperation() {
		return Operation;
	}



	public void setOperation(Operation operation) {
		Operation = operation;
	}



	public Node getLeft() {
		return left;
	}



	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}}

