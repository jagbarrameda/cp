import java.util.Scanner;

class m1023 {
public static void main (String[] args)
{
	double total = 0;
	Scanner in = new Scanner(System.in);
	for (int i =0; i<12; i++) total += in.nextDouble();
	total/=12;
	total = Math.round(total * 100.0) / 100.0;
	System.out.println("$"+total);
}
}
