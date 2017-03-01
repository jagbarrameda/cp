/**
 * Created by Jose on 2017-03-01.
 */
public class Akvqld03_Bit {

    public static void main(String[] args) {
        try {
            int n = readInt();
            int todo;
            int[] btree = new int[n+2];
            int q = readInt();
            int op1, op2;
            while (q > 0) {
                todo = System.in.read();
                op1 = readInt();
                op2 = readInt();
                if (todo == ('f')) {
                    System.out.println(BitTree.findSum(btree, op1, op2));
                } else {
                    BitTree.add(btree, n, op1, op2);
//                    System.out.println();
                }
                q--;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int readInt() {
        try {
            int ret = 0;
            boolean dig = false;
            boolean neg = false;
            for (int c = 0; (c = System.in.read()) != -1; ) {
                if (c == '-' && !dig) {
                    neg = true;
                } else if (c >= '0' && c <= '9') {
                    dig = true;
                    ret = ret * 10 + c - '0';
                } else if (dig) break;
            }
            return (neg) ? -ret : ret;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static class BitTree {

        public static int findSum(int[] btree, int a, int b) {
            return findSum(btree, b) - findSum(btree, a - 1);
        }

        public static int findSum(int[] btree, int a) {
            int sum = 0;
            int index = a + 1;
            while (index > 0) {
                sum += btree[index];
                index = index - (index & (-index));
            }
            return sum;
        }

        public static void add(int[] btree, int n, int p, int f) {
            int index = p + 1;
            while (index <= n) {
                btree[index] += f;
                index = index + (index & (-index));
            }
        }
    }
}
