package sixt_package;

import java.util.Random;

public class main6 {

	public static void main(String[] args) {
		
		IntList list1 = new IntList();
		Random r = new Random();
		
		for(int i=0;i<20;i++) {							//Create 20 rdm numbers
			list1.addNode((r.nextInt(21)+40));
		}
		
		IntList list2 = new IntList();
		
		System.out.println("Eine Liste wurde generiert");
		printList(list1);
		
		listInsert(list1, list2);
		
		System.out.println("Liste wurde sortiert");
		printList(list2);

	}
	
	public static void listInsert(IntList list1, IntList list2) {
		
		Node currentNode;
		Node comparisonNode;
		
		//First List Element
		list2.addNode(list1.head.getValue());
		list2.head.setNext(null);
		currentNode = list1.head;
		
		
		//Rest of the Elements
		do {
		
			currentNode = currentNode.getNext();
			comparisonNode = list2.head; 
			boolean caseTrue = false;
			
			//Case 1: Node has to be on first position in list2
			
			if(currentNode.getValue()<=comparisonNode.getValue()) {							
				
				list2.addNode(currentNode.getValue());
				caseTrue =true;			
			} 
			
			//Case 2: Node has to be in the middle	
			
			else if(comparisonNode.getNext()!=null) {	
						
				for(Node compN = comparisonNode; compN.getNext()!=null;compN=compN.getNext()) {
										
					if(currentNode.getValue()<=compN.getNext().getValue()) {
						
						list2.addNodeMiddle(currentNode.getValue(),compN,compN.getNext());
						compN=compN.getNext();
						caseTrue=true;
						break;
						
					} 
								
				} 
				
			} 
			
			//Case 3: Node has to be at the end
			
			if(caseTrue==false) { 
				
				list2.addNodeEnd(currentNode.getValue());
			}
			
								
		} while (currentNode.getNext()!=null);
		
	}
	
	public static void printList(IntList list) {
		Node head = list.head;
		
		System.out.println(head.getValue());
		
		do {
			head = head.getNext();
			System.out.println(head.getValue());
			
		} while (head.getNext()!=null);
		
	}
	


}
