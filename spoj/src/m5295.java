import java.io.BufferedReader;
import java.io.InputStreamReader;

class m5295{
    public static void main(String[] args)  throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        int t = Integer.parseInt(line);
        int n, k;
        String[] a;
        numberAdjBits(100,100);
        while (t-- > 0) {
            line = bf.readLine();
            a = line.split(" ");
            n = Integer.parseInt(a[1]);
            k = Integer.parseInt(a[2]);
            System.out.println(String.format("%1s %2d", a[0], numberAdjBits(n, k)));
        }
    }

    static int[][] f0 = new int[101][101];  // f0[i][j] number of strings with i bits where last bit is 0 and that findSum j
    static int[][] f1 = new int[101][101];  // f1[i][j] number of strings with i bits where last bit is 1 and that findSum j
    static int[][] f = new int[101][101];      // f[i][j] number of strings with i bits that findSum j
    static int lastN = 0;
    /**
     *
     * @param n
     * @param k
     * @return
     */
    public static int numberAdjBits(int n, int k) {
        if (k>=n) return 0;
        if (n<=lastN) return f[n][k];

        if (lastN < 2) {
            f0[2][0] = 2;

            f1[1][0] = 1;
            f1[2][0] = 1;
            f1[2][1] = 1;

            f[1][0] = 2;
            f[2][0] = 3;
            f[2][1] = 1;

            lastN = 2;
        }

        if (n<3) return f[n][k];

        for (int i = lastN+1; i < n + 1; i++) {

            f0[i][0] = f[i - 1][0];
            f1[i][0] = f0[i - 1][0];
            f[i][0] = f0[i][0] + f1[i][0];

            for (int j = 1; j < i; j++) {
                f0[i][j] = f[i - 1][j];
                f1[i][j] = f0[i - 1][j] + f1[i - 1][j - 1];
                f[i][j] = f0[i][j] + f1[i][j];
            }
        }
        lastN = n;

        return f[n][k];
    }
}