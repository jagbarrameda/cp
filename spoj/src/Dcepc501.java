/**
 * Created by Jose on 2017-02-28.
 */
public class Dcepc501 {

    static int values[] = new int[100000];
    static int n;

    // maxValue[k] is the solution when considering only the elements k, k+1, ...
    // we use 3 more spaces, i.e. maxValue.length = values.length + 3,
    // so we don't have to consider special cases within the loop
    static long[] maxValue = new long[100000 + 3];

    static long val, max;

    public static void main(String[] args) {
//        test();
//        if (1 == 1) return;
        int t = readInt();
        while (t > 0) {
            n = readInt();
            readValues(n);
            System.out.println(maxValue(values, n));
            t--;
        }
    }

    public static void readValues(int n) {
        for (int i = 0; i < n; i++) {
            values[i] = readInt();
        }
    }

    private static int readInt() {
        try {
            int ret = 0;
            boolean dig = false;
            for (int c = 0; (c = System.in.read()) != -1; ) {
                if (c >= '0' && c <= '9') {
                    dig = true;
                    ret = ret * 10 + c - '0';
                } else if (dig) break;
            }
            return ret;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static long maxValue(int[] values, int n) {
        // interative as basically all subproblems are necessary

        // base cases
        maxValue[n - 1] = values[n - 1];
        if (n == 1) return maxValue[n - 1];
        maxValue[n - 2] = values[n - 1] + values[n - 2];
        if (n == 2) return maxValue[n - 2];
        maxValue[n - 3] = values[n - 1] + values[n - 2] + values[n - 3];
        if (n == 3) return maxValue[n - 3];

        // clean up the last maxValues
        maxValue[n] = 0;
        maxValue[n + 1] = 0;
        maxValue[n + 2] = 0;

        for (int k = n - 4; k >= 0; k--) {
            // choose 1, skip 1
            max = values[k] + maxValue[k + 2];
            // choose 2, skip 2
            val = values[k] + values[k + 1] + maxValue[k + 4];
            max = (max < val) ? val : max;
            // choose 3, skip 3
            val = values[k] + values[k + 1] + values[k + 2] + maxValue[k + 6];
            max = (max < val) ? val : max;
            maxValue[k] = max;
        }

        return maxValue[0];
    }

    public static void test() {
        int n;
        int[] values;
        n = 6;
        values = new int[]{10, 8, 7, 11, 15, 20};
        System.out.println(maxValue(values, n));
        n = 4;
        values = new int[]{5, 4, 3, 2};
        System.out.println(maxValue(values, n));

        n = 1;
        values = new int[]{(int) 1e6};
        System.out.println(maxValue(values, n));
        n = 2;
        values = new int[]{10, 8};
        System.out.println(maxValue(values, n));
        n = 3;
        values = new int[]{10, 8, 7};
        System.out.println(maxValue(values, n));

        int t = 10;

        long time = System.currentTimeMillis();
        values = new int[100000];
        while (t > 0) {
            // generate randomly
            n = (int) (Math.random() * 100000) + 1;
            for (int i = 0; i < n; i++) {
                values[i] = (int) (Math.random() * 1e6) + 1;
            }
            System.out.println((long) maxValue(values, n));
            t--;
        }
        time = System.currentTimeMillis() - time;
        System.out.println("Elapased time (ms): " + time);
    }
}
