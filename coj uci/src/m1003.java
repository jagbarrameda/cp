import java.util.Scanner;

public class m1003
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt() ;
		int[] votes = new int[1001];
		while (tests--> 0)
		{
			int n = in.nextInt();
			int m = in.nextInt();
			for (int j = 0; j <m; j++)
				for (int i = 0; i <n; i++)
				{
					votes[i] += in.nextInt();
				}
			int max = votes[0], maxi = 0;
			for (int i = 0; i < n; i++)
			{
				if (max < votes[i])
				{
					max = votes[i];
					maxi = i;
				}
				votes[i] = 0;
			}
			System.out.print(maxi+1);
			if (tests > 0) System.out.println();
		}
	}
}
