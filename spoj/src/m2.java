import java.io.BufferedReader;
import java.io.InputStreamReader;

class m2
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l = br.readLine();
		int c = Integer.parseInt(l);
		while (c-->0)
		{		
			l = br.readLine();
			String[] nm = l.split(" ");
			int m = Integer.parseInt(nm[0]);
			int n = Integer.parseInt(nm[1]);
			printPrimes(m,n);
			System.out.println();
		}
	}
	
	private static void printPrimes(int m, long n)
	{
		for (; m<=n; m++)
		{
			if (isPrime(m)) System.out.println(m);
		}
	}
	
	private static boolean isPrime(int p)
	{
		if (p<=1) return false;
		int n = (int)Math.sqrt((double)p);
		for (int i=2; i<=n; i++)
			if (p%i == 0) return false;
		return true;
	}
}
