import java.io.BufferedReader;
import java.io.InputStreamReader;

class m1059
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = 0;
        String line = br.readLine();
        int i = Integer.parseInt(line);
        while(i!=0)
        {
            p = parity(i);
            System.out.println("The parity of "+Integer.toString(i,2)+" is "+p+" (mod 2).");
            line = br.readLine();
            i = Integer.parseInt(line);
        }
    }
    
    public static int parity(int i)
    {
        int parity = 0;
        while (i!=0)
        {
            if (i % 2 != 0) parity++;
            i >>= 1;
        }
        return parity;
    }
}