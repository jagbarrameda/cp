import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

/**
 * Created by Jose on 2017-02-24.
 */
public class Amazon323 {

    public static void main(String[] args) {
//        mainMaxSubarray();
        mainMaxSubarrayNonConsecutive();
    }


    public static void mainMaxSubarray() {
        int[] n = {1, 2, 3, -2, 3, -4, 5, -6};
        System.out.println(maxSumSubarray(n));
    }

    public static void mainMaxSubarrayNonConsecutive() {
        int[] n = {-1, 2, 3, -2, 3, -4, 5, -6};
        System.out.println(maxSumSubarrayNonConsecutive(n));
    }

    public static void mainM323_1(String[] args) {
        int[] n = {1, 2, 3, 2, 3, 4, 5, 6};
        int k = 5;
        m323_1(n, k);
    }

    public static void m323_1(int[] n, int k) {
        for (int i = 0; i < n.length; i++) {
            System.out.println(different(n, i, i + k));
        }
    }

    public static int different(int[] n, int start, int end) {
        end = (end < n.length) ? end : n.length;
        int different = end - start;
        for (int i = start; i < end - 1; i++) {
            for (int j = i + 1; j < end; j++) {
                if (n[i] == n[j]) {
                    different--;
                    break;
                }
            }
        }
        return different;
    }

    public static int maxSumSubarray(int[] n) {
        int currentMax = n[0];
        int max = currentMax;
        for (int i = 1; i < n.length; i++) {
            currentMax += n[i];
            if (currentMax <= 0) {
                currentMax = 0;
            }
            if (currentMax > max) {
                max = currentMax;
            }
        }
        return max;
    }

    public static int maxSumSubarrayNonConsecutive(int[] n) {
        // no two numbers may be consecutive
        // solved by dynamic programming
        // sumWithout[i] holds the maximum findSum from 0 to i where i is not selected
        int[] sumWithout = new int[n.length];
        // sumWith[i] holds the maximum findSum from 0 to i where i is selected
        int[] sumWith = new int[n.length];

        // base case is an array with only one element, i.e. e = 0
        // we should ignore it if negative and more elements or not?
        sumWith[0] = n[0];
        sumWithout[0] = 0;

        // case for e+1 is two cases:
        // a) with n[e]
        // b) without n[e]
        // i.e. f(e+1) = max ( f(e), f(e) + n[e+1])
        for (int i = 0; i < n.length - 1; i++) {
            // case a)
            sumWith[i+1] = sumWithout[i] + n[i+1];
            // case b)
            sumWithout[i+1] = Math.max(sumWith[i], sumWithout[i]);
        }


        System.out.print("n[i]: ");
        for (int i = 0; i < n.length; i++) {
            System.out.print(" " + n[i]);
        }
        System.out.println();

        System.out.print("Sum with [i]: ");
        for (int i = 0; i < n.length; i++) {
            System.out.print(" " + sumWith[i]);
        }
        System.out.println();

        System.out.print("Sum without [i]: ");
        for (int i = 0; i < n.length; i++) {
            System.out.print(" " + sumWithout[i]);
        }
        System.out.println();

        return Math.max(sumWith[n.length - 1], sumWithout[n.length - 1]);
    }
}
