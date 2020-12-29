import DoublyLinkedList.DoublyLinkedList;
import DoublyLinkedList.List;


public class Test {

	public static void main(String[] args) {
		List<Integer> axa= new DoublyLinkedList<Integer>();
		axa.add(5);
		
		axa.add(6);
		 
		axa.add(7);
		 
		axa.add(8);
		 
		axa.add(9);
		 
		List<Integer> listA = new DoublyLinkedList<Integer>();
		listA.add(15);
		listA.add(16);
		listA.add(17);
		listA.add(18);
		listA.add(19);
		listA.add(20);
		List<Integer> listB = new DoublyLinkedList<Integer>();
		listB.add(200);
		listB.add(300);
		listB.add(400);
		listB.add(500);
		listB.add(600);
		listB.add(700);
		
		axa.addAll(1,listA);
		axa.get(0);
		 
		axa.add(10,67);
		 
		axa.addAll(listB);
		 
		System.out.println(axa.size());
		//axa.clear(); it works.
		 
		axa.remove(17);
		System.out.println(axa.isEmpty());
		
	}

}
