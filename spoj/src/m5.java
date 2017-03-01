import java.io.BufferedReader;
import java.io.InputStreamReader;

class m5
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = bf.readLine();
		int t = Integer.parseInt(line);
		while(t-->0)
		{
			String kline = bf.readLine();
			printNextPal(kline);			
		}
	}
	private static void printNextPal(String kline)
	{
		double m = kline.length();
		StringBuffer fh = new StringBuffer(kline.substring(0, (int)Math.ceil(m/2d)));
		StringBuffer fhr = new StringBuffer(fh);
		fhr.reverse();
		StringBuffer sh = new StringBuffer(kline.substring((int)Math.floor(m/2d), (int)m));
		
		//System.out.println("half 1: "+fh);
		//System.out.println("half 2: "+sh);
		
		if (fhr.toString().compareTo(sh.toString()) <= 0)
		{
			// add one to fh
			AddOne(fh);
		}
		
		//System.out.println("last char: "+fh.charAt(fh.length()-1));
		if (m%2==1 && fh.length()>fhr.length())
		{
			fh.deleteCharAt(fh.length()-1);
			System.out.print(fh);	
			fh.reverse();
			System.out.println(fh);
		}
		else{		
			System.out.print(fh);
			if (m%2==1 || fh.length()>fhr.length()) { 
				fh.deleteCharAt(fh.length()-1);
			}
			fh.reverse();
			System.out.println(fh);
		}
	}
	
	private static void AddOne(StringBuffer n)
	{
		//System.out.println("adding 1 to: "+n);
		boolean carr = true;
		byte d = 0;
		int pos = n.length()-1;
		while(pos >= 0 && carr)
		{
			d = Byte.parseByte(""+n.charAt(pos));
			if (d == 9)
			{
				carr = true;
				d = 0;
			}
			else 
			{
				carr = false;
				d ++;
			}
			n.setCharAt(pos, (""+d).charAt(0));
			pos--;
		}
		if (carr) n.insert(0, 1);
		//if (pos > 0) n.insert(n.substring(0, pos));
	}
}