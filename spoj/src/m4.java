import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

class m4
{
	public static void main (String[]args) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = bf.readLine();
		int t = Integer.parseInt(line);
		while (t-->0)
		{
			line = bf.readLine();
			LinkedList<String> rpn = getRpn(line);
			
			// print rpn
			while(!rpn.isEmpty())
			{
				System.out.print(rpn.pollLast());
			}
			System.out.println();
		}
	}
	
	private static LinkedList<String> getRpn(String exp)
	{
		LinkedList<String> operands = new LinkedList<String>();
		LinkedList<String> rpn = new LinkedList<String>();
		
		int pos = 0;
		while(pos<exp.length())
		{
			String current = ""+exp.charAt(pos);
			//System.out.println("current: "+ current);
			
			if (current.equals("(") ||
				current.equals("+" )||
				current.equals("-" )||
				current.equals("*" )||
				current.equals("/" )||
				current.equals("^"))
			{
			//	System.out.println("pushed: "+ current);
				operands.push(current);
			}
			else if (current.equals(")"))
			{
				String top = operands.poll();
				if (!top.equals("("))
				{					
					rpn.push(top);
					operands.pop();
				}				
			}
			else
			{				
				String top = operands.peek();				
				rpn.push(current);	
					
				if (!operands.isEmpty() && !top.equals("("))
				{
					//System.out.println(""+operands.isEmpty() + top);
					rpn.push(operands.poll());
				}
			}
			pos++;
		}
		
		return rpn;
	}
}