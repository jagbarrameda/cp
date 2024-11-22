import java.io.BufferedReader;
import java.io.InputStreamReader;

class m2946 {
    static int[] b = new int[50000];
    static String newline = System.lineSeparator();

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
        System.out.println(sb);
    }

    public static void setVals() {
        for (int i = 1; i < 50000; i += 2) {
            b[i] = i;
        }
        for (int i = 2; i < 50000; i += 2) {
            b[i] = b[i >> 1];
        }
    }

}