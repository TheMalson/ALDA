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
		currentNode = list1.head.getNext();
		
		
		//Rest of the Elements
		
		for(Node currN = currentNode; currN.getNext()!=null;currN = currN.getNext()) {
			
			comparisonNode = list2.head; 
			
			//Case 1: Node has to be on first position in list2
			
			if(currN.getValue()<=comparisonNode.getValue()) {							
				
				list2.addNode(currN.getValue());
							
			} else if(comparisonNode.getNext()!=null) {	
						
				for(Node compN = comparisonNode; compN.getNext()!=null;compN=compN.getNext()) {
					
					
					//Case 2: Node has to be in the middle	
					
					if(currN.getValue()<=compN.getNext().getValue()) {
						
						list2.addNodeMiddle(currN.getValue(),compN,compN.getNext());
						compN=compN.getNext();
						break;
						
					} else {  //Case 3: Node has to be at the end
						
						list2.addNodeEnd(currN.getValue());
						break;
					}
								
				} 
				
			} else { //Case 3: Node has to be at the end
				
				list2.addNodeEnd(currN.getValue());
			}
			
			if(currN.getNext()==null) {
				break;
			}
			
		}
		
		
	}
	
	public static void printList(IntList list) {
		for(Node n = list.head; n.getNext()!=null; n=n.getNext()) {
			System.out.println(n.getValue());
			if(n.getNext()==null) {
				System.out.println(n.getNext().getValue());	
			}
		}
		
	}
	


}
