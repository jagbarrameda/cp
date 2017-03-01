import java.io.BufferedReader;
import java.io.InputStreamReader;

class m1079{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line), nl = 0;
        int[] ns1 = new int[100];
        int[] ns2 = new int[100], temp;
        while (n-->0)
        {
            line = br.readLine();
            nl = Integer.parseInt(line);
            ns1 = new int[100];
            ns2 = new int[100];
            while(nl --> 0)
            {
                line = br.readLine();
                String[] row = line.split(" ");
                ns2[0] = ns1[0] + Integer.parseInt(row[0]);
                for (int j=1; j<row.length; j++){
                    ns2[j] = Math.max(ns1[j-1],ns1[j]) + Integer.parseInt(row[j]);
                }
                temp = ns2;
                ns2 = ns1;
                ns1 = temp;
            }
            int max = 0;
            for (int j=0; j<ns1.length; j++)
            {
                max = Math.max(max, ns1[j]);
            }
            System.out.println(max);
        }
    }
}