import java.io.BufferedReader;
import java.io.InputStreamReader;

class m1
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String c = br.readLine();
		while (c.compareTo("42")!=0)
		{
			System.out.println(c);
			c = br.readLine();
		}
	}
}
