import java.io.BufferedReader;
import java.io.InputStreamReader;

class m1059b
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = 0;
        String line = br.readLine();
        int i = Integer.parseInt(line);
        while(i!=0)
        {
            line = Integer.toString(i,2);
            p = line.length() - line.replace("1", "").length();
            System.out.println("The parity of "+Integer.toString(i,2)+" is "+p+" (mod 2).");
            line = br.readLine();
            i = Integer.parseInt(line);
        }
    }
}