import java.io.BufferedReader;
import java.io.InputStreamReader;

class m1306
{
public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line =br.readLine();
        int n = Integer.parseInt(line);
        int num = 0;
        int length;
        
        while(n-->0)
        {
            line = br.readLine();
            length = line.length();
            if (length>1)
            {
                line = line.substring(length-2, length);
            }
            num = Integer.parseInt(line);
            if (num % 4 == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}