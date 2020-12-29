package DoublyLinkedList;
/**
 * A list is collection of sequenced items that can be access using an index.
 * Lists may contain duplicate items.
 * Lists support positional access by index and searching.
 */
public interface List<Type> {
	//interfaces have no constructors
	
	/**
	 * Adds item <code>t</code> to the end of the list.
	 * @param t Item to be added.
	 */
	void add(Type t);
	
	/**
	 * Adds item <code>t</code> to the list at the specified position.
	 * All items at index >= <code>index</code> will be shifted rightwards. 
	 * @param index Index where item will be added.
	 * @param t Item to be added.
	 */
	int add(int index, Type t);
	
	/**
	 * Adds all items in <code>list</code> to the end of <code>this</code> in order. 
	 * @param list List to be merged with <code>this</code>.
	 */
	void addAll(List<Type> list);
	
	/**
	 * Adds all items in <code>list</code> to <code>this</code> in order.
	 * @param index Starting index for adding the items <code>list</code>
	 * @param list List to be merged with <code>this</code>.
	 */
	int addAll(int index, List<Type> list);
	
	/**
	 * Returns the item at the specified index.
	 * @param index Index of the item to be returned.
	 * @return Item at the specified index or null if index invalid.
	 */
	Type get(int index);
	
	/**
	 * Clears the list to become empty.
	 */
	void clear();
	/**
	 * Remove the node which is the index<code>index</code>.
	 * @return Item data at the removed index.
	 */
	Type remove(int index);
	/**
	 * Returns the number of node items.
	 */
	int size();
	/**
	 * Returns true or false.
	 * If the data in the node or not.
	 */
	boolean contains(Type t);
	/**
	 * Return true or false.
	 * If the node is empty or not.
	 */
	boolean isEmpty();
	
	//public void print(); //it has to be deleted.
	}

