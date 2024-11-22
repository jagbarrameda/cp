using System.Diagnostics;

class ModSpeedTest
{
public static void Main(string[]args)
{
int n = 100000000;
int a = 0;
Stopwatch sw = new Stopwatch();
sw.Start();
for (int i=0; i <n; i++)
{
	a+=i%2;
}
sw.Stop();
//System.Console.WriteLine("a: "+a);
System.Console.WriteLine("i%2: "+sw.ElapsedTicks);

a=0;
sw.Restart();
for (int i=0; i <n; i++)
{
	a+=(i&1);
}
sw.Stop();
//System.Console.WriteLine("a: "+a);
System.Console.WriteLine("i&1: "+sw.ElapsedTicks);
System.Console.WriteLine();

bool b = false;
sw.Start();
for (int i=0; i <n; i++)
{
	b=((i%2)==0);
}
sw.Stop();
//System.Console.WriteLine("b: "+b);
System.Console.WriteLine("((i%2)==0): "+sw.ElapsedTicks);

b = false;
sw.Restart();
for (int i=0; i <n; i++)
{
	b=((i&1)==0);
}
sw.Stop();
//System.Console.WriteLine("b: "+b);
System.Console.WriteLine("((i&1)==0): "+sw.ElapsedTicks);
System.Console.WriteLine();

a=0;
sw.Restart();
for (int i=0; i <n; i++)
{
	a+=i*2;
}
sw.Stop();
//System.Console.WriteLine("a: "+a);
System.Console.WriteLine("i*2: "+sw.ElapsedTicks);

a=0;
sw.Restart();
for (int i=0; i <n; i++)
{
	a+=i<<1;
}
sw.Stop();
//System.Console.WriteLine("a: "+a);
System.Console.WriteLine("i<<1: "+sw.ElapsedTicks);

}
}