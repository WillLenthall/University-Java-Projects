package will.DSAApp;
import java.util.EmptyStackException;

public class LinkedStack implements Stack {
	private LinkedLinearList list = new LinkedLinearList();

	public LinkedStack() // creates an empty LinkedStack
	{

	}
	
	public boolean isEmpty() // returns true if stack is empty
	{
		return list.isEmpty();
	}

	public Object peek() // returns top element of stack
	{
		if (isEmpty()) throw new EmptyStackException(); //throws exception if stack is empty
		return list.get(0);
	}

	public void push(Object object) // adds new element to top of stack
	{
		list.add(0, object);
	}

	public Object pop() // removes top element of stack and returns it
	{
		if (isEmpty()) throw new EmptyStackException(); // throws exception if stack is empty
			
		else
		{
			Object topObject = list.remove(0);
			return topObject;
		}
	}
	public int size()
	{
		return list.size();
	}

}

