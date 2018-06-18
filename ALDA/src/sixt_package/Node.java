package sixt_package;

public class Node {
	private int value;
	private Node next;
	
	//Constructors
	
	public Node() {
		value = 0;
		next = null;
	}
	
	public Node(int v) {
		value = v;
		next = null;
	}

	//Getter- Setter
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
	
}
