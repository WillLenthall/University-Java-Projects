package will.DSAApp;

public class PostFixConverter {
	private boolean valid = false;
	private String output;
	
	public PostFixConverter(String input)
	{
		if (input.length()>20 || input.length()<3) // checks that input does not exceed 20 characters
		{
			//System.out.println("Input length cannot exceed 20");
			output = "Input length cannot be less than 3 or exceed 20";
		}
		else if (!input.matches("^[a-zA-Z+*/() ]*+$")) // checks that all characters are valid
		{
			//System.out.println("Only include Letters and the operators: + * /");
			output = "Only include Letters and the operators: + * /";
		}
		else
		{
			valid = true;
		}
	}
	
	public String converter(String input)
	{
		if (valid == true)
		{
		
	LinkedStack operatorsStack = new LinkedStack();
	LinkedStack resultStack = new LinkedStack();
			for (int i = 0; i < input.length(); i++) // iterates through String
			{
				char c = input.charAt(i);			// current character
								

				if ((c>='a' && c<='z') || (c>='A' && c<='Z')) //adds characters to the results stack
				{					
					resultStack.push(c);
				}
				
				else if (c == '(') // adds '(' to operator stack
				{
					operatorsStack.push(c);
				}
				
				
				else if (c==')')
				{
					while (resultStack.size()>1 && !operatorsStack.peek().toString().equals("("))  // Checks the last operator is not an opening bracket
					{
						String operator = operatorsStack.pop().toString(); // gets the operator
						String first = resultStack.pop().toString(); 	// gets the two operands
						String second = resultStack.pop().toString();
						
						String newResult = second + first + operator; // Concatenates into postfix
						resultStack.push(newResult); // adds the postfix expression to the results stack
														
					}
					operatorsStack.pop(); // removes '(' from the stack
				}
				
				else if (c == '*' || c == '/' || c == '+')
				{
					while(operatorsStack.size()>0 && !operatorsStack.peek().toString().equals("(") && getOpPriority(c) <= getOpPriority(operatorsStack.peek()))
					{
						String operator = operatorsStack.pop().toString(); // gets the operator
						String first = resultStack.pop().toString(); 	// gets the two operands
						String second = resultStack.pop().toString();
						
						String newResult = second + first + operator; // Concatenates into postfix
						resultStack.push(newResult); // adds the postfix expression to the results stack
														
					}
					operatorsStack.push(c);
				}				
			}
			while (!operatorsStack.isEmpty())
			{
				String operator = operatorsStack.pop().toString().toString(); // gets the operator
				String first = resultStack.pop().toString(); 	// gets the two operands
				String second = resultStack.pop().toString();
				
				String newResult = second + first + operator; // Concatenates into postfix
				resultStack.push(newResult); // adds the postfix expression to the results stack
			}
			output = resultStack.pop().toString();
			}
			return output; // returns the result
		}
	
	
	
	public int getOpPriority(Object object) // returns a value to help apply the BODMAS hierarchy
	{
		if (object.equals("+"))
		{
			return 1;
		}
		else if (object.equals("*") || object.equals("/"))
		{
			System.out.println("2");
			return 2;
		}
		else if (object.equals(")") || object.equals("("))
		{
			return 3;
		}
		else return 0;
	}
	public boolean getValid()
	{
		return valid;
	}
	


}
