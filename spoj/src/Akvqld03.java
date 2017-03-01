/**
 * Created by Jose on 2017-03-01.
 */
public class Akvqld03 {

    public static void main(String[] args) {
        try {
            int n = readInt();
            int todo;
            TreeNode tn = new TreeNode(1, n);
            int q = readInt();
            int op1, op2;
            while (q > 0) {
                todo = System.in.read();
                op1 = readInt();
                op2 = readInt();
                if (todo == ('f')) {
                    System.out.println(tn.findSum(op1, op2));
                } else {
                    tn.add(op1, op2);
//                    System.out.println();
                }
                q--;
            }
        } catch (Exception e) {
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

    public static class TreeNode {
        int sum = 0;
        TreeNode left, right;
        int min, midpoint, max;

        public TreeNode(int min, int max) {
            this.min = min;
            this.max = max;
            sum = 0;
            if (min == max) {
                // leaf
                return;
            }

            midpoint = min + (max - min) / 2;
            left = new TreeNode(min, midpoint);
            right = new TreeNode(midpoint + 1, max);
        }

        public int findSum(int a, int b) {
//            System.out.print("f");
            if (b < min || a > max) return 0;
            if (a <= min && b >= max) return sum;
            return ((a <= midpoint && left != null) ? left.findSum(a, b) : 0) +
                    ((b >= midpoint + 1 && right != null) ? right.findSum(a, b) : 0);
        }

        public void add(int p, int f) {
//            System.out.print("a");
            if (p < min || p > max) return;
            sum += f;
            if (p <= midpoint) {
                if (left != null) left.add(p, f);
            } else {
                if (right != null) right.add(p, f);
            }
        }
    }
}
