import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class m8CMPLS {
    public static void main(String[] args) throws Exception {
//        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new File("m8cmpls.txt"));
        int t = scanner.nextInt();
        while (t-- > 0) {
            /**
             * number of elements input, i.e. a_1, ..., a_s
             */
            int s = scanner.nextInt();
            /**
             * number of additional terms to create
             * i.e. a_{s+1}, ..., a{s+c}
             */
            int c = scanner.nextInt();
            /**
             * elements
             */
            int[] a = new int[s];

            // fill first column with a_0, ..., a_s
            for (int i = 0; i < s; i++) {
                a[i] = scanner.nextInt();
            }
//            System.out.print("L: ");
//            solveInterpolationProblemByLagrange(s, c, a);
//            System.out.println();
//            System.out.print("N: ");
            solveInterpolationProblemByNewton(s, c, a);
            if (t > 0) System.out.println();
        }
    }

    /**
     * Solves one interpolation problem given in the scanner using Lagrange method
     */
    public static void solveInterpolationProblemByLagrange(int s, int c, int[] a) {
        for (int i = 1; i <= c; i++) {
            System.out.print(evalLagrange(a, s, s + i));
            if (i < c) System.out.print(" ");
        }
    }

    /**
     * Interpolate by lagrange method.
     * However, note that "the Newton form of the interpolating polynomial is much better suited"
     * (Elementary numerical analysis by Conte et de Boor, p40)
     *
     * @param y
     * @param s
     * @param x
     * @return
     */
    public static int evalLagrange(int[] y, int s, int x) {
        /* Lagrange method */
        double L = 1;
        double r = 0;
        for (int i = 1; i <= s; i++) {
            L = 1;
            for (int j = 1; j <= s; j++) {
                if (j != i) {
                    L = L * (x - j) / (i - j);
                }
            }
            r += L * y[i - 1];
        }
        return (int) Math.round(r);
    }


    /**
     * Solves one interpolation problem given in the scanner using Newton method
     */
    public static void solveInterpolationProblemByNewton(int s, int c, int[] x) {
        /**
         * matrix of forward differences, i.e.:
         * 1. a[row][0] = a_row
         * 1. a[row][col] = a[row+1][col-1] - a[row][col-1]
         * <p>
         * see Newton interpolation when x_{i+1} - x_{i} = 1
         */
        int[][] a = new int[s + c][s];

        // fill first column with a_0, ..., a_s
        for (int i = 0; i < s; i++) {
            a[i][0] = x[i];
        }

        // fill matrix
        for (int col = 1; col < s; col++) {
            for (int row = 0; row < s - col; row++) {
                a[row][col] = a[row + 1][col - 1] - a[row][col - 1];
            }
        }
//        printArray(a);
        // compute and output the next c elements of the sequence, i.e. x_i, i \in [s+1, s+c]
        for (int i = s; i < s + c; i++) {
            int row = i - s + 1;
            a[row][s - 1] = a[row - 1][s - 1]; // set the last column
            row++;
            for (int col = s - 2; col >= 0; col--) {
                a[row][col] = a[row - 1][col] + a[row - 1][col + 1];
                row++;
            }
//            printArray(a);
            if (i > s) System.out.print(" ");
            System.out.print(a[i][0]);
        }
    }

    static void printArray(int[][] a){
        System.out.println();
        for (int row = 0; row < a.length; row++) {
            System.out.println(Arrays.toString(a[row]));
        }
    }
}