import java.io.BufferedReader;
import java.io.InputStreamReader;

class m1047
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int c = Integer.parseInt(line);
        int i = 1, n=0;
        int y;
        int k;
        int[] r = new int[1001];
        int x = 2;
        r[1] = 3;
        r[2] = 5;
        
        while (c-->0)
        {
            line = br.readLine();
            n = Integer.parseInt(line);
            
            if (r[n] == 0)
            {
                while (r[++x]!=0);
                //System.out.println("x:"+x);
                while (x <= n)
                {
                    r[x] = r[x-1];
                    for (y = 1; y <= x/2; y++)
                    {
                        r[x] += coprime(x,y)? 4 : 0;
                    }
                    x++;
                }
                x--;
            }
            
            System.out.println(i+++" "+n+" "+r[n]);
        }
    }
    
    public static boolean coprime(int a, int b)
    {
        //System.out.print(a+","+b);
        int t = 0;
        while (b != 0)
        {
            t = b;
            b = a % b;
            a = t;
        }
        
        //System.out.println("mcd:"+a);
        return a == 1;
    }
}