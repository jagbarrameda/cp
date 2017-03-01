/**
 * Created by Jose on 2017-03-01.
 */
public class Anarc05b {
    static int[] values1 = new int[10000];
    static int[] values2 = new int[10000];
    static int n1, n2, i;

    public static void main(String[] args) {
        while (true) {
            n1 = readInt();
            if (n1 == 0) break;
            readValues1();
            n2 = readInt();
            readValues2();
            System.out.println(maxValue());
        }
    }

    public static void readValues1() {
        for (i = 0; i < n1; i++)
            values1[i] = readInt();
    }

    public static void readValues2() {
        for (i = 0; i < n2; i++)
            values2[i] = readInt();
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

    public static int maxValue() {
        int max1 = 0;
        int max2 = 0;

        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (values1[i] == values2[j]) {
                max1 += values1[i];
                max2 += values2[j];
                // join point, take max for both
                if (max1 > max2) {
                    max2 = max1;
                } else {
                    max1 = max2;
                }
                i++;
                j++;
            } else if (values1[i] < values2[j]) {
                // increment i
                max1 += values1[i];
                i++;
            } else {
                // increment j
                max2 += values2[j];
                j++;
            }
        }

        // at least one of the two sequences finished, we must finish the other one if not finished yet
        while (i < n1) {
            max1 += values1[i];
            i++;
        }
        while (j < n2) {
            max2 += values2[j];
            j++;
        }
        return max1 > max2 ? max1 : max2;
    }
}
