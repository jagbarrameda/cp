import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AdaGameRecursive {
    // winner[n][m][p] = true means that ada wins the game with n,m when player p's plays first.
    // p = 0 is ada, and p = 1 is vinit
    // performance improved by having this variable global
    static boolean[][][] adaWins = new boolean[10000][101][2];
    static boolean[][][] computed = new boolean[10000][101][2];

    static int origN;

    public static void main(String[] args) throws Exception {
//        test();
//        if (1 == 1) return;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(bf.readLine());
        String[] input;
        int n, m;
        while (tests > 0) {
            input = bf.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            System.out.println(winnerRecursive(n, m));
            tests--;
        }
    }

    public static String winnerRecursive(int n, int m) {
        // init computed
        for (int nn = 0; nn < 10000; nn++) {
            for (int mm = 0; mm <= m; mm++) {
                computed[nn][mm][0] = computed[nn][mm][1] = false;
            }
        }

        int p = 0; // ada plays
        origN = n;
        winnerAux(n, m, p);
        return adaWins[n][m][p] ? "Ada" : "Vinit";
    }

    public static void winnerAux(int n, int m, int p) {
        // stop condition
        if (computed[n][m][p]) {
//            System.out.println(String.format("cached for n=%s m=%s p=%s, winner: %s", n, m, p, (adaWins[n][m][p] ? "Ada" : "Vinit")));
            return;
        }

        // base case
        if (m == 0) {
            adaWins[n][m][0] = adaWins[n][m][1] = n > origN;
            computed[n][m][0] = computed[n][m][1] = true;
            return;
        }

//        System.out.println(String.format("solving for n=%s m=%s p=%s", n, m, p));

        // solve
        int[] nns = getNs(n);
        int otherp = (p + 1) % 2;
        for (int i = 0; i < 4; i++) {
            winnerAux(nns[i], m - 1, otherp);
            if (p == 0) {
                if (adaWins[nns[i]][m - 1][otherp]) {
                    // no need to keep looking, p=0 wins this branch
                    adaWins[n][m][p] = true;
                    break;
                }
                adaWins[n][m][p] = false;
            } else {
                if (!adaWins[nns[i]][m - 1][otherp]) {
                    // no need to keep looking, p=1 wins this branch
                    adaWins[n][m][p] = false;
                    break;
                }
                adaWins[n][m][p] = true;
            }
        }

        computed[n][m][p] = true;

//        System.out.println(String.format("Computed for n=%s m=%s p=%s, winner: %s", n, m, p, (adaWins[n][m][p] ? "Ada" : "Vinit")));
    }

    /**
     * gets all 4 possible number from n.
     *
     * @param n
     * @return
     */
    public static int[] getNs(int n) {
        int[] nns = new int[4];
        int orign = n;
        // n = a*1000 + b*100 + c*10 +d
        int a, b, c, d;
        a = n / 1000;
        n %= 1000;
        b = n / 100;
        n %= 100;
        c = n / 10;
        d = n % 10;
        nns[0] = ((a + 1) % 10) * 1000 + b * 100 + c * 10 + d;
        nns[1] = ((b + 1) % 10) * 100 + a * 1000 + c * 10 + d;
        nns[2] = ((c + 1) % 10) * 10 + a * 1000 + b * 100 + d;
        nns[3] = ((d + 1) % 10) * 1 + a * 1000 + b * 100 + c * 10;

//        System.out.print(orign + ": ");
//        for (int i = 0; i < 4; i++) {
//            System.out.print(nns[i] + ", ");
//        }
//        System.out.println();
//
//        try {
//            System.in.read();
//        } catch (Exception e) {
//        }

        return nns;
    }

    public static void test() {
        int n, m;
        n = 0;
        m = 0;
        System.out.println(winnerRecursive(n, m));
        n = 5566;
        m = 3;
        System.out.println(winnerRecursive(n, m));
        n = 3333;
        m = 10;
        System.out.println(winnerRecursive(n, m));
        n = 9999;
        m = 9;
        System.out.println(winnerRecursive(n, m));
        n = 1234;
        m = 30;
        System.out.println(winnerRecursive(n, m));

//        if (1 == 1) return;

        long t = System.currentTimeMillis();
        for (int i = 0; i < 200; i++) {
            n = (int) (Math.random() * 10000);
            n %= 10000;
            m = (int) (Math.random() * 100);
            System.out.println(winnerRecursive(n, m));
        }
        t = System.currentTimeMillis() - t;
        System.out.println("Elapased time (ms): " + t);
    }
}
