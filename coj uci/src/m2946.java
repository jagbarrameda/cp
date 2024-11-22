import java.io.BufferedReader;
import java.io.InputStreamReader;

class m2946 {
    static int[] b = new int[50000];
    static String newline = System.getProperty("line.separator");

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        int i;
        setVals();
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            line = br.readLine();
            i = Integer.parseInt(line);
            if ((i & 1) == 1) sb.append((i << 1)).append(newline);
            else sb.append(b[i]).append(newline);
        }
        System.out.println(sb.toString());
    }

    public static void setVals() {
        for (int i = 1; i < 50000; i += 2) {
            b[i] = i;
        }
        for (int i = 2; i < 50000; i += 2) {
            b[i] = b[i >> 1];
        }
    }

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int n = Integer.parseInt(line);
        int i;

        while (n-- > 0) {
            line = br.readLine();
            i = Integer.parseInt(line);
            if ((i & 1) == 1) i <<= 1;
            else {
                line = Integer.toString(i, 2);
                line = line.substring(0, line.lastIndexOf("1") + 1);
                i = Integer.parseInt(line, 2);
            }
            System.out.println(i);
        }
    }
}