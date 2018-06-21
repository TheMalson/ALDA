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
		
	public void addNodeMiddle (int value, Node pre, Node suc) {
		Node newNode = new Node(value);
		pre.setNext(newNode);
		newNode.setNext(suc);
	}
	
	public void addNodeEnd (int value) {
		Node newNode = new Node(value);
		Node tail = new Node();
		
		for(Node i = head; i.getNext()!=null;i=i.getNext()) {
			tail = i;
		}
		tail.setNext(newNode);
	}
}
