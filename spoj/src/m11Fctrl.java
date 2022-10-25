import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class m11Fctrl {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
//        Scanner scanner = new Scanner(new File("m11.txt"));
        int tests = scanner.nextInt();
        while (tests-- > 0) {
            System.out.println(nZeros(scanner.nextInt()));
        }
    }

    static int nZeros(int n) {
        int d = n / 5;
        int r = d;
        while (d > 0) {
            d = d / 5;
            r += d;
        }
        return r;
    }
}
