import java.io.BufferedReader;
import java.io.InputStreamReader;

class m8 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        int t = Integer.parseInt(line);
        int s, c;
        String[] sc;
        int[] y = new int[100];
        while (t-- > 0) {
            line = bf.readLine();
            sc = line.split(" ");
            s = Integer.parseInt(sc[0]);
            c = Integer.parseInt(sc[1]);
            line = bf.readLine();
            sc = line.split(" ");
            for (int i = 0; i < s; i++) {
                y[i] = Integer.parseInt(sc[i]);
            }
            for (int i = 1; i <= c; i++) {
                System.out.print(eval(y, s, s + i));
                if (i < c) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int eval(int[] y, int s, int x) {
        /* Lagrange method */
        double L = 1;
        double r = 0;
        for (double i = 1; i <= s; i++) {
            L = 1;
            for (double j = 1; j <= s; j++) {
                if (j != i) {
                    L = L * (x - j) / (i - j);
                }
            }
            r += L * y[ (int) i - 1];
        }
        return (int) Math.round(r);
    }
}