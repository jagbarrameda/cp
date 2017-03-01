import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Timer;

/**
 * Created by Jose on 2017-02-28.
 */
public class AdaGameIterative {

    static boolean adaplaysandwins = false;
    static boolean vinitplaysandwins = false;

    // winner[n][m][p] = true means that ada wins the game with n,m when player p's plays first.
    // p = 0 is ada, and p = 1 is vinit
    // performance improved by having this variable global
    static boolean[][][] adaWins = new boolean[10000][101][2];
    static int[] nns = new int[4];

    public static void main(String[] args) throws Exception {
        test();
        if (1 == 1) return;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(bf.readLine());
        String[] input;
        int n, m;
        while (tests > 0) {
            input = bf.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            System.out.println(winner(n, m));
            tests--;
        }
    }

    public static String winner(int n, int m) {
        if (m == 0) {
            return "Vinit";
        }

        // init base cases, i.e., when m = 0, and for all nn and p
        int mm = 0;
        for (int nn = 0; nn < 10000; nn++) {
            adaWins[nn][mm][0] = adaWins[nn][mm][1] = nn > n;
        }

        // for m > 0
        for (mm = 1; mm <= m; mm++) {
            // for each n
            for (int nn = 0; nn < 10000; nn++) {
                getNs(nn);
                adaplaysandwins = vinitplaysandwins = false;
                for (int i = 0; i < 4; i++) {
                    // when ada plays, if ada can win, ada chooses that move
                    adaplaysandwins = adaplaysandwins || (adaWins[nns[i]][mm - 1][1]);
                    // when vinit plays, if vinit can win, vinit chooses that move
                    vinitplaysandwins = vinitplaysandwins || (!adaWins[nns[i]][mm - 1][0]);
                }
                adaWins[nn][mm][0] = adaplaysandwins;
                adaWins[nn][mm][1] = !vinitplaysandwins;
            }
        }

        return adaWins[n][m][0] ? "Ada" : "Vinit";
    }

    /**
     * gets all 4 possible number from n.
     *
     * @param n
     * @return
     */
    public static int[] getNs(int n) {
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

        long t = System.currentTimeMillis();
        for (int i = 0; i < 200; i++) {
            n = (int) (Math.random() * 10000);
            n %= 10000;
            m = (int) (Math.random() * 100);
            System.out.println(winner(n, m));
        }
        t = System.currentTimeMillis() - t;
        System.out.println("Elapased time (ms): " + t);
        n = 5566;
        m = 3;
        System.out.println(winner(n, m));
        n = 3333;
        m = 10;
        System.out.println(winner(n, m));
        n = 9999;
        m = 9;
        System.out.println(winner(n, m));
        n = 1234;
        m = 30;
        System.out.println(winner(n, m));
    }
}
