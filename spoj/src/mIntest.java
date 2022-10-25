import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class mIntest {
    public static void main(String[] args) throws IOException {
//        Scanner s = new Scanner(System.in);
//        Scanner s = new Scanner(new FileInputStream("mIntest.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("mIntest.txt")));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //s.nextInt();
        int k = Integer.parseInt(st.nextToken());//s.nextInt();
        int c = 0;

        while (n-- > 0) {
            int i = Integer.parseInt(br.readLine());//s.nextInt();
            if (i % k == 0) c++;
        }
        System.out.println(c);
    }
}
