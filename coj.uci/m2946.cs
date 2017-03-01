class m2946
{
public static void Main(string[] args)
{
int n = int.Parse(System.Console.ReadLine());
int i = 0;
while(n-->0)
{
	i = int.Parse(System.Console.ReadLine());
	if ((i&1)==1) System.Console.WriteLine(i<<1);
	else
	{
	while(i>0 && (i%2==0)) i/=2;
	System.Console.WriteLine(i);
	}
}
}
}