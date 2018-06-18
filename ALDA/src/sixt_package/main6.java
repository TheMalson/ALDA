package sixt_package;

import java.util.Random;

public class main6 {

	public static void main(String[] args) {
		
		IntList list1 = new IntList();
		Random r = new Random();
		
		for(int i=0;i<20;i++) {							//Create 20 rdm numbers
			list1.addNode((r.nextInt(21)+40));
		}
		
		

	}
	
	public static void listInsert(IntList list1, IntList list2) {
		
		Node currentNode;
		Node comparisonNode;
		
		//First List Element
		list2.addNode(list1.head.getValue());
		currentNode = list1.head.getNext();
		comparisonNode = list2.head; 
		
		//Next Nodes
		
		for(Node t = currentNode; t!=null;t = t.getNext()) {
			
			for(Node c = comparisonNode; c.getNext()!=null | c.getNext().getValue()<=currentNode.getValue();c=c.getNext()) {
				
				list2.addNode(t.getValue(),c.getNext());
				
				
			}
			
		}
		
		
	}

}
