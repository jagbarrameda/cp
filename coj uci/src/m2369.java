import java.io.BufferedReader;
import java.io.InputStreamReader;

class m2369{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        
        while (n-->0)
        {
            line = br.readLine();
            String[] sp = line.split(" ");
            long[] a = new long[] {
                Integer.parseInt(sp[0]),
                Integer.parseInt(sp[1]),
                Integer.parseInt(sp[2])
            };
            
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            long current = 0;
            
            int[][] perm = new int[][]{{0,1,2},{1,0,2},{2,0,1}};
            for (int i=0; i<3; i++)
            {
                current = a[perm[i][0]] * (a[perm[i][1]] + a[perm[i][2]]);
                max = Math.max(max, current);
                min = Math.min(min, current);
                
                current = a[perm[i][0]] + (a[perm[i][1]] * a[perm[i][2]]);
                max = Math.max(max, current);
                min = Math.min(min, current);
            }
            
            System.out.println(min+" "+max);
        }
    }
}