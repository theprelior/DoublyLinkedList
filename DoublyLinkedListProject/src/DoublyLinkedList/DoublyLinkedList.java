package DoublyLinkedList;



public class DoublyLinkedList<Type> implements List<Type> {
	/**
	 * Creates head and tail nodes to work with doubly-linkedlist.
	 */
	protected Node<Type> head;
	protected Node<Type> tail;
	
	/**
	 * The method returs first node that is in the node.
	 */
	private Node<Type> first() {
		return head.next;
	}
	/**
	 * The method returs last node that is in the node.
	 */
	private Node<Type> last() {
		return tail;
	}

  
	
	/**
	 * Constructs an empty EmptyLinkedList.
	 */
	public DoublyLinkedList() {
		
		 head = new Node<Type>(null, null,null);
		tail= new Node<Type>(null, null,null);
	}

	
	
	@Override
	public void add(Type t) {	
		Node<Type> newNode=new Node<>(t, null,null); //Creates the new node which is include the data<t>.
		
		if(isEmpty()) {           //Control the head of the node.It will add the node on the head of node if it's empty.
			head.next=newNode;					
			newNode.previous=head;
			newNode.next=null;
			tail=newNode;
			
		}
		else {
			tail.next=newNode;    //Otherwise it will add the node at the end of the node.
			newNode.previous=tail;
			newNode.next=null;
			tail=newNode;
		}
		
		
	}

	//the method need , if the inde bigger then section.
	@Override
	public int add(int index, Type t ) {
	    int followSize = 0 ;                          //We need it if we want to add the data in specified position.Because,the nodes are not included index.
	   
	    //The follow size starts 0 so the head will be 0 by the way.
	    
	    Node<Type> newNode=new Node<>(t,null,null);   //Creating a new node which is data--->t.
	   
	    Node<Type> curr = first();                     //Getting current node to find index and add the data in specified position.
	    
	    int lastsize=size()-1;
	    
	    if(!isEmpty()) {							   //Control of the node, is empty or not ?
	    	
	    	while(curr.next!=null) {				   //It will turn far to the tail.
	    		
	    		if(followSize==index) {                //When it's founded the index it will change with new node.
	    			
	    			curr.previous.next=newNode;
	    			newNode.previous=curr.previous;
	    			newNode.next=curr;					//After that, it will shift on right like an array.
	    			curr.previous=newNode;
	    			
	    			
	    			return followSize ;
	    		}
	    		followSize++;                          
	    		curr=curr.next;							//They need move together bocause of counting.
	    	}
	    }
	    else if(isEmpty()){
	    	head.next=newNode;
			newNode.previous=head;                     //If the node is clear then the node will be head.
			newNode.next=null;
			tail=newNode;
			return followSize;
	    }
	    if(index==lastsize) {
	        
	    	newNode.previous=tail.previous;
	    	newNode.next=tail;							//The section will be add the node if the index is equal the last index	    												//
	    	tail.previous.next=newNode; 				//So,I need here to shift last index on right.
	    	tail.previous=newNode;						//Tail will not change.Changing value is before the tail.
	    	return index;
	    	
	    }
	   else if(lastsize<index) {
	    	add(t);										//Otherwise we should control if the index value bigger than 
	    	return index;								//the size of node. We need to add at the tail that node.If we don't do that, it will throw the error or nothing.
	    }												//So,in here it will add the node at the tail.
	    return index;
	}
     
	
	
	/*
	 * The method will add the list at the end of the list of tail in order.
	 */
	@Override
	public void addAll(List<Type> list) {
		
		DoublyLinkedList<Type> newList = (DoublyLinkedList<Type>) list;  //Construct the list.
		Node<Type> newListNode=newList.first();							 //Gets the list's node. On the other hand, we can call the head of the list.
		Node<Type> newListNodeTail=newList.last();            			 //Gets the list's tail node.
		tail.next=newListNode; 											 //Adds current tail's next to the List. So, they are merged.
		tail=newListNodeTail;											 //Updates new tail node with that's changed new node.
		
		 
		
	}
	/*
	 * The method will add the list at the index which is wanted in order.
	 */
	@Override
	public int addAll(int index, List<Type> list) {                      //Getting starts list of index with list.
		// TODO Auto-generated method stub
		DoublyLinkedList<Type> newList = (DoublyLinkedList<Type>) list;  //Construct the list.
	
		Node<Type> newListNode=newList.first();						     //Determines the node's head.
		
		Node<Type> newListNodeTail=newList.last();						 //Determines the node's tail.
		
		Node<Type> curr = first();										 //Determines the previous node's head.
		
		int counter = 0;												 //We need counter to find index.
		
		int lastSize=size();											 //We need the size of the previous node to use find size and index equal or not.
		
		if(index != 0 && index != lastSize) {	                        //It will enter while loop if the index does not equal to the previous node head's and tail's index.
		while(curr!=null) {
			
																		//I control that is because the user can add the list at the head or at the tail.
			if(counter==index) {									   
				curr.previous.next=newListNode;							//So, when it finds the index that is given it adds the list after that index, and then the added list tail's keep holds of the old ones.
				newListNodeTail.next=curr;
			}
			counter++;
			curr=curr.next;
		}
		}
		else if(index==0) {
			head=newListNode;
			newListNodeTail.next=curr;								//It will add the new list at the previous list head's.
			curr.previous=newListNodeTail;
		}
		else if(index==lastSize) {									//It will add the new list at the end of the previous list. Meaning the tail.
			tail.next=newListNode;
			tail=newListNodeTail;
			
		}
		return index;
		
	}

	
	
	/*
	 * It will return the item that is called by index in list.
	 * */
	@Override
	public Type get(int index) {
		Node<Type> curr = first();
		int followSize=0;					//To follow the index that is called.
		while(curr!=null) {
			
			
			if(followSize==index) {
				return curr.data;            //When found the index, It will return the data of the index.
			}
			followSize++;
			curr=curr.next;
		}
		return null;
	}
	
	

	/*
	 * Clears the head of list.
	 * All list's node will be cleared.
	 * */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = new Node<>(null, null,null);		//Clearing the head of node.So, it will clear all nodes which is start the head.
	}

	
	/*
	 *Removes the node according to by the index. 
	 *If the index higher than the lastsize it will return null.
	 */
	@Override
	public Type remove(int index) {
		Node<Type> curr = first();             //Calls the node.
		int followSize=0;					   //Creating the variable to follow and find the index.
		int lastSize=size()-1;				   //Creating the variable of the last size and make it balance with <code>followsize</code>.
		if(index!=0 && index!=lastSize) {	   //This makes the control because the index valuable can head or tail.So,we don't want to get into that while loop.
		while(curr!=null) {
			
			
			if(followSize==index) {
				curr.next.previous=curr.previous;
				curr.previous.next=curr.next;    //When it finds the index of the node then it will remove.
				curr.previous=null;
				curr.next=null;
				return curr.data;
				
			}
			followSize++;
			curr=curr.next;
		}
		}
		else if(index==0) {
			
			curr.next.previous=head;			//We remove the index without removing the others.The others can be removed if we remove the head .
			head.next=curr.next;
			return curr.data;
		}
		else if(lastSize==index) {
			tail.previous.next=null;
			tail=tail.previous;					//We already know the tail node that's why directly adds the node in here.
			return tail.data;
		}
		return null;
		
		
	
	}
	
	/*
	 * Returns the size of node to user.
	 * It counts all node one by one.After finish node it returns the count value.
	 * */

	@Override
	public int size() {
		Node<Type> curr = first();
		int cnt = 0;
		while(curr != null) {
			cnt++;
			curr=curr.next;}
		return cnt;
	}

	/*
	 * Returns true or false.
	 * Returns true, if the data which is called in the node.
	 * Returns false, if the data which is called not in the node.
	 * */
	
	@Override
	public boolean contains(Type t) {
		Node<Type> curr = first();
		while(curr != null) {
			
			if(curr.data.equals(t)) {
				return true;
			}
			curr=curr.next;
		}
		return false;
	}
	
	/*
	 * Returns true or false.
	 * It controls the head of the node. if <code>head.next</code> is showing null then it means the node is empty.
	 * */

	@Override
	public boolean isEmpty() {
	
		if(head.next==null) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Returns a String representation of this list
	 * Empty list: "-->null"
	 * Single node: "-->node-->null"
	 */
	public String toString() {
		String s = "-->";
		
		Node<Type> curr = first();
		while(curr!=null) {
			s = s + curr.data.toString() + "-->";
  		curr = curr.next;
		}
		s = s + "null";
		return s;
	}
	

	
}
