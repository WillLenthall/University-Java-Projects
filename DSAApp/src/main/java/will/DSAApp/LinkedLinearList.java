package will.DSAApp;

public class LinkedLinearList implements LinearList {
	
	protected LinkNode head;
	protected int size;
	
	
	// Constructs an empty list
	public LinkedLinearList()
	{
	head = null;
	}

	
	
	
	
	// returns true if the list is empty
	public boolean isEmpty()
	{
		if (head == null)
			{
				return true;
			}
		else return false;
	}
	
	// returns the size of the list
	public int size()
	{
		return size;
	}
	
	// checks that index value given is between zero and the size -1
	private void checkIndex(int index)
	{
		if (index<0 || (index>=size && index != 0))
			throw new IndexOutOfBoundsException
			("index = " + index + " size = " + size);
	}
	
	// returns the object a the value of the given index
	public Object get(int index)
	{
		checkIndex(index);
		LinkNode current = head;
		for (int i=0; i<index; i++)
			{
				current = current.next;
			}
		return current.object;
		
	}
	
	// returns the index of the first occurrence of the given object
	// returns -1 if the list does not contain the object
	public int indexOf(Object object)
	{
		LinkNode current = head;
		int index = 0;
		while (current!= null && !current.object.equals(object))
		{
			current = current.next;  //move on to the next node
			index++;
		}
		if (current == null) //list empty or iterated through entire list
			{return -1;}
		else 
			{return index;}

	}
	
	// adds an object to the list at a given index
	public void add(int index, Object object)
	{
		checkIndex(index);
		
		if (index == 0) // inserting at the front
		{
			head = new LinkNode(object, head);
		}
		
		else // inserting further into the list
		{
			LinkNode current = head;
			for (int i=0; i<index-1; i++) // finding the node before desired index
			{
				current = current.next;
			}
			current.next = new LinkNode(object, current.next); //inserting at desired index

		}
		size++; //updating new size of list
	}
	
	// removes the object at the given index
	public Object remove(int index)
	{
		checkIndex(index);
		Object removedObject;
		if (index ==0) // removing the head
		{
			removedObject = head.object; // returns the head object
			head = head.next; // makes the next node the head
			
		}
		else // removing from further into the list
		{
			LinkNode current = head;
			for (int i=0; i<index-1; i++) //finding the index of the node before the node to be removed
			{
				current = current.next;
			}
			removedObject = current.next.object; // returns the desired node
			current.next = current.next.next; // removes pointers to the removed node
		}
			size--; // updates the list size
			return removedObject; 

			
	}
	
	
	public String outputList()
	{
		LinkNode current = head;
		StringBuffer s = new StringBuffer("[");
		
		if(current == null) // sets s to [null] if the list is empty
		{
			s.append("null]");			
		}
		else
		{
		for (int i = 0; i<size; i++)
			{
				s.append(current.toString() + ", ");
				current = current.next;
			}
		}
		if (size>0) // removes the final ", " and adds "]"
		{
			s.delete(s.length() - 2, s.length());
			s.append("]");
		}
		return new String (s); // creates and returns an equivalent String
	}

}
