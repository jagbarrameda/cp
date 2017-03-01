import java.util.Scanner;

class m1099
{
public static void main(String[] args)
{
int a = 1, b = 0,c = 0;
Scanner in = new Scanner(System.in);
while (a != 0)
{
a = in.nextInt();
if (a == 0) break;
b = in.nextInt();
c = in.nextInt();

a *= a;
b *= b;
c *= c;


int a1 = Math.max(Math.max(a,b), Math.max(b,c));
int a3 = Math.min(Math.min(a,b), Math.min(b,c));
int a2;

if (a != a1 && a != a3) a2 = a;
else if (b != a1 && b != a3) a2 = b;
else a2 = c;

if (a1 == a2 + a3) System.out.println("right");
else System.out.println("wrong");
}
}
}