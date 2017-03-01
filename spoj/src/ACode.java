import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Jose on 2017-02-28.
 */
public class ACode {
    public static void main(String[] args) throws IOException {
//        test();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        while (!s.equals("0")) {
            System.out.println(decodings(s));
            s = bf.readLine();
        }
    }

    public static int decodings(String encryption) {
        // we solve the problem from the back of the string, e.g. 1234 is solved as "1" + "234" and "12" + "34"
        // decodings[i] is the solution for the string up to i characters from the back, i.e. encryption.subString(length - 1)
        // decodings[n] =
        // . n = 1 -> 1
        // . n = 2 -> if (encryption[1]
        int[] decodings = new int[encryption.length()];

        // for the single character case:
        // the last character not zero
        if (encryption.charAt(encryption.length() - 1) != '0')
            decodings[encryption.length() - 1] = 1;

        // for the subproblems with at least two characters
        for (int i = encryption.length() - 2; i >= 0; i--) {

            // the first character not zero
            if (encryption.charAt(i) != '0')
                decodings[i] = decodings[i + 1];

            // the first character is one
            if (encryption.charAt(i) == '1') {
                // if string is length 3 or more
                if (i <= decodings.length - 3)
                    decodings[i] += decodings[i + 2];
                else
                    decodings[i]++;
            }

            // the first character is two
            if (encryption.charAt(i) == '2') {
                // if string is length 3 or more
                if (i <= decodings.length - 3) {
                    int nextDigit = java.lang.Character.getNumericValue(encryption.charAt(i + 1));
                    if (nextDigit <= 7)
                        decodings[i] += decodings[i + 2];
                } else
                    decodings[i]++;
            }
        }

//        System.out.print(encryption + ": ");
//        for (int i : decodings) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        return decodings[0];
    }

//    public static void test() {
//        String[] sa = {"25114", "1111111111", "3333333333", "1", "10", "11", "120"};
//        for (String s : sa) {
//            System.out.println(decodings(s));
//        }
//    }
}
