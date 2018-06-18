package sixt_package;

public class IntList {
	public Node head;
	
	//Constructor
	
	public IntList() {
		head = null;
	}
	
	//Methods
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addNode(int value) {
		Node next = new Node(value);
		next.setNext(head);
		head = next;
	}
	
	public void addNode(int value, Node next) {
		Node newNode = new Node(value);
		newNode.setNext(next);
	}
	
}
