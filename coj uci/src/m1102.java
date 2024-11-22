import java.io.BufferedReader;
import java.io.InputStreamReader;

class m1102{
public static void main(String[] args) throws Exception
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String line = br.readLine();	
	String s = "a multiple of 11.";
	int dif = 0, factor = 1;
	while(line.compareTo("0")!=0)
	{	
	dif = 0; factor = 1;
	for (int i=0; i< line.length(); i++)
	{
		dif += factor * Integer.parseInt(line.substring(i,i+1));		
		factor *= -1;
		//System.out.println("i:"+i+",dif:"+dif);	
	}	
	if (dif % 11 == 0) System.out.println(line+" is "+s);
	else System.out.println(line+" is not "+s);	
	line = br.readLine();
	}
}
}