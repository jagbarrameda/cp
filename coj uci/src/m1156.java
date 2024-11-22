import java.io.BufferedReader;
import java.io.InputStreamReader;

class m1156{
public static void main(String[] args) throws Exception
{
	BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
	String line = re.readLine();
	String s = line.split(" ")[0];	
	while (s.compareTo("42")!=0)
	{
	System.out.println(s);
	line = re.readLine();
	s = line.split(" ")[0];	
	}
}
}
