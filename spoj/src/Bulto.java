/**
 * Created by Jose on 2017-03-01.
 */
public class Bulto {
    public static void main(String[] args) {
        int i = 11;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(~i));
        System.out.println(Integer.toBinaryString(i + ~i));
        System.out.println(Integer.toBinaryString(i + ~i + 1));
        System.out.println(Integer.toBinaryString(i << 1));
        System.out.println(Integer.toBinaryString(i << 2));
        System.out.println(Integer.toBinaryString(i >> 1));
        System.out.println(Integer.toBinaryString(i >> 2));
        System.out.println(Integer.toBinaryString(i & 1));
        System.out.println(Integer.toBinaryString(i & 2));
        System.out.println(Integer.toBinaryString(-i));
        System.out.println(Integer.toBinaryString(i & -i));

        i = 20;
        System.out.println();
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(-i));
        System.out.println(Integer.toBinaryString((i & (-i))));
        System.out.println(Integer.toBinaryString(i + (i & (-i))));
        System.out.println(i);
        System.out.println((-i));
        System.out.println(((i & (-i))));
        System.out.println((i + (i & (-i))));
    }
}
