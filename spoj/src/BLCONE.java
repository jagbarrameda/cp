/**
 * Created by Jose on 2017-03-01.
 */
public class BLCONE {
    static double a, b, c;
    static double R, H;

    public static void main(String[] args) {
        int n = readInt();
        while (n > 0) {
            R = readInt();
            H = readInt();
            updateCoefficients();
            System.out.println(String.format("%.6f", newtonApprox()));
            n--;
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

    public static double newtonApprox() {
        double h = H / 2, h1 = 0, temp;
        while (Math.abs(h - h1) > 1e-6) {// && h > 0 && h < H) {
            h1 = h - f(h) / fprime(h);
            temp = h;
            h = h1;
            h1 = temp;
        }
        return h > H ? H : (h < 0 ? 0 : h);
    }

    public static double f(double h) {
        return a * h * h * h + b * h * h - c;
    }

    public static double fprime(double h) {
        return 3 * a * h * h + 2 * b * h;
    }

    public static void updateCoefficients() {
        a = R;
        double L = Math.sqrt(R * R + H * H);
        b = 3 * L;
        c = 6 * L * H * H;
    }
}
