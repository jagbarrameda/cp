import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Jose on 2017-02-28.
 */
public class aba12c {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(r.readLine());
        String line ;
        String a[];
        int[] prices;

        while (c > 0) {
            c --;
            line = r.readLine();
            a = line.split(" ");
            int k = Integer.parseInt(a[1]);
            a = r.readLine().split(" ");
            // k and a .length should be equal
            prices = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                prices[i] = Integer.parseInt(a[i]);
            }
            System.out.println(minMoneyRecursive(prices, k));
        }
    }

    /**
     * Iterative version
     *
     * @param prices
     * @param k
     * @return
     */
    public static int minMoneyIterative(int[] prices, int k) {
        // prices has k elements, prices[0] is the price for 1 kg bag, etc.
        if (k == 0) return 0;
        // minPrice[k] is the minimum price for k
        // minPrice[k] = min_i{minPrice[k-i] + prices[i]}
        // i.e. the min price for k kgs is the minimum price of k-i kgs, plus the price of i kg packet, for all i.
        int[] minPrice = new int[k + 1];
        minPrice[0] = 0;
        for (int i = 1; i < minPrice.length; i++) {
            minPrice[i] = -1;
        }

        for (int i = 1; i <= k; i++) {
            // i is the problem instance we are solving for in the loop
            for (int j = 1; j <= i; j++) {
                // j-1 is the smaller problem instance we already know the answer of

                // i.e. if there is a j kg packet, and there is a solution for problem k-j kg
                if (prices[j - 1] != -1 && minPrice[k - j] != -1) {
                    // if nothing found yet, or if it is better to choose j to build k
                    if (minPrice[i] == -1 || prices[j - 1] + minPrice[k - j] < minPrice[k]) {
                        minPrice[i] = prices[j - 1] + minPrice[k - j];
                    }
                }
            }
        }

        return minPrice[k];
    }

    /**
     * Recursive DP version
     *
     * @param prices
     * @param k
     * @return
     */
    public static int minMoneyRecursive(int[] prices, int k) {
        int[] minPrice = new int[k + 1];
        minPrice[0] = 0;
        for (int i = 1; i < minPrice.length; i++) {
            minPrice[i] = -1;
        }
        return minMoneyAux(prices, k, minPrice);
    }

    public static int minMoneyAux(int[] prices, int k, int[] minPrice) {
        if (k == 0) return 0;
        if (k < 0) return -1;
        if (minPrice[k] != -1) {
            return minPrice[k];
        }
        for (int i = 1; i <= prices.length; i++) {
            if (prices[i - 1] != -1) {
                // solve the subproblem
                int subProblemCost = minMoneyAux(prices, k - i, minPrice);
                if (subProblemCost != -1) {
                    if (minPrice[k] == -1 || minPrice[k] > subProblemCost + prices[i - 1]) {
                        minPrice[k] = subProblemCost + prices[i - 1];
                    }
                }
            }
        }
        return minPrice[k];
    }

    public static void test() {
        int[] prices = {-1, -1, 4, 5, -1};
        int k = 5;
        System.out.println(minMoneyIterative(prices, k));
        System.out.println(minMoneyRecursive(prices, k));
        prices = new int[]{1, 2, 3, 4, 5};
        k = 5;
        System.out.println(minMoneyIterative(prices, k));
        System.out.println(minMoneyRecursive(prices, k));
        prices = new int[]{-1};
        k = 1;
        System.out.println(minMoneyIterative(prices, k));
        System.out.println(minMoneyRecursive(prices, k));
        prices = new int[]{-1};
        k = 1;
        System.out.println(minMoneyIterative(prices, k));
        System.out.println(minMoneyRecursive(prices, k));
    }
}

