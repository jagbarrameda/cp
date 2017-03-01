import java.io.BufferedReader;
import java.io.InputStreamReader;

class m1655{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line!=null && line != "")
        {
            int i = 0, p = line.indexOf(" ");
            int j = p +1;
            while (i < p && j < line.length())
            {
                if (line.charAt(i) == line.charAt(j)) i++;
                j++;
            }
            if (i == p) System.out.println("Yes");
            else if (j == line.length()) System.out.println("No");
            line = br.readLine();
        }
    }
}