

public class PlayerDeckList<E>
{
	private class Node<E>
	{
		private E data; 		//Data at the node
		private Node<E> next; 	// the link to the next node 
	
		
		//CONSTRUCTOR
		public Node(E data, Node<E> next) 
		{
			this.data = data;
			this.next = next;
		}
		
		//This calls the other constructor to create the Node
		public Node(E data) 
		{
			this(data, null); 
		}
	}
		
//Data and Method for the Liked List
		private Node<E> head; //Reference to the head of the LL
		private int size;     //How many nodes are there in LL
	
//DEFAULT Constructor WHEN lINKED LIST IS CREATED
public PlayerDeckList()
	{
		this.head = new Node<E>(null); //The head has no data or next value at the beginning 
		this.size = 0;                 //When the LL is created there are no other nodes
	}
		
	
public void add(int index, E item) 
	{
		//This method adds an element to the LL
		//Depending on the index, it adds to the first location using addFirst()
		//or adds after a node using addAfter()
		if(index < 0|| index > size) { //Checking for valid index
		System.out.println("Invalid Index!");
		return;
		}
		else if(index == 0){
			//We are adding at the first location 
			addFirst(item);
			
		}
		else{
			//We are gong to add after some node, we need the reference of that node (Helper method)
			Node<E> node = getNode(index);
			addAfter(node,item);
		}
		
		}


      public void addAfter(Node<E> node, E item) {
		// Add the item after the reference "node"
		node.next = new Node<E>(item, node.next);
		size++;
		
	}



	private Node<E> getNode(int index) 
	{
		if(index < 0|| index > size) { //Checking for valid index
			System.out.println("Invalid Index!");
			return null;
			}
		// This method loop over the LL, return the reference of the Node at index
		Node<E> node = head; //This is a reference copy of the head
		for(int i =0; i <index && node != null; i++) 
		{
			node = node.next;
		}
		
		return node; //return the references
	}



	private void addFirst(E item) {
		// We create a node, with item as data, and head.next as the next
		//The we update the head.next to point this newly created node
		//Finally we increment the size
		Node<E> temp = new Node<E>(item, head.next);
		head.next = temp;
		
		//head.next = new Node<E>(item, head.next);
		size++;
			
	}



	public E remove(int index) {
		// This met6hod removes and element from the LL at a given index 
		//Check if index is valid 
		
		if(index < 0|| index > size) { //Checking for valid index
			System.out.println("Invalid Index!");
			return null;
			}
		else if(index ==0 ) {
			return removeFirst();
		}
		else {
			Node<E> node = getNode(index);
			return removeAfter(node);
		}
		
	}

	private E removeAfter(Node<E> node)
	{
		Node<E> temp = node.next;
		if(temp != null) 
		{   
			node.next = temp.next;
			size--;
			return temp.data;
		}
		return null;
	}



	private E removeFirst()
	{
		// Delete the first Node
		Node<E> temp = head;
		if(temp != null) 
		{
			head = head.next;
			size--;
			return temp.data;
			
		}
		return null;
	}



	
	public E get(int index) 
	{
		if(index < 0|| index >= size) { //Checking for valid index
			System.out.println("Invalid Index!");
			return null;
			}
		    Node<E> temp = getNode(index);
	     	//System.out.println("data at index :"+ index + " = "+temp.data); //Prints out data at indicated index
		    
	     	return temp.data;
	
		   
		
	}

	
	public E set(int index, E newValue) 
	{
		if(index < 0|| index > size) 
		{ //Checking for valid index
			System.out.println("Invalid Index!");
			return null;
		}
		remove(index); //removes existant place 
		add(index, newValue); 
		return null;
		 		
	}

	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	//implement toString() to print the LL data
	public String toString()
	{
		String s = "[";
		Node<E> p = head; //This reference will be used to iterate over the LL
		if(p != null)
		{	 //When there is no head, check the error
			while(p.next != null) 
			{
			s += p.next.data + " -> ";  //Adds the data to the String
			p = p.next;					//Go to the next Node
			}
		}
		//End of the LL
		s += "]";
		return s;
		
	}
	
}
	
	
	
	
