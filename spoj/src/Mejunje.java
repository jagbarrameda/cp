//import java.util.Arrays;
//
///**
// * Created by Jose on 03/11/14.
// */
//class Mejunje {
//    public static void main(String[] s) {
//        /*int[] a = {5};
//        int[] b = {5,7};
//        int[] c = {0, 1, 2, 50, 52, 75};
//        System.out.println(getMissingIntervals(a));
//        System.out.println(getMissingIntervals(b));
//        System.out.println(getMissingIntervals(c));*/
//
//        int[] coinDenominations = new int[]{3, 7, 11};
//        for (int n = 0; n <= 20; n++) {
//            System.out.println("" + n + ": " + Arrays.toString(getChange(n, coinDenominations)));
//        }
//    }
//
//    private static int countBits(int n) {
//        int c = 0;
//        for (c = 0; n != 0; ) {
//            if ((n & 1) == 1) {
//                c++;
//                n >>= 1;
//            }
//            while ((n & 1) == 0 && n != 0)
//                n >>= 1;
//        }
//        return c;
//    }
//
//    public static String getMissingIntervals(int[] a) {
//        String output = "";
//        if (a.length == 0) return "0-99";
//
//        if (a[0] == 1) {
//            output = "0,";
//        } else if (a[0] > 0) {
//            output = "0-" + (a[0] - 1) + ",";
//        }
//
//        for (int i = 1; i < a.length; i++) {
//            if (a[i] - a[i - 1] == 2) {
//                output += a[i] - 1 + ",";
//            } else if (a[i] - a[i - 1] > 2) {
//                output += "" + (a[i - 1] + 1) + "-" + (a[i] - 1) + ",";
//            }
//        }
//
//        if (a[a.length - 1] == 98) {
//            output += "99,";
//        } else if (a[a.length - 1] < 98) {
//            output += (a[a.length - 1] + 1) + "-99,";
//        }
//
//        return output.substring(0, output.length() - 1);
//    }
//
//
//    public static int[] getChange(int n, int[] coinsDenominations) {
//        //      numberOfCoins[n] is the result. numberOfCoins[a_i] is 1, numberOfCoins[0] is 0.
//        int[] numberOfCoins = new int[Math.max(
//                coinsDenominations[coinsDenominations.length - 1] + 1,
//                n + 1)];
//        int[] addedCoin = new int[numberOfCoins.length];
//
//        // initialize base cases
//        for (int i = 0; i < coinsDenominations.length; i++) {
//            numberOfCoins[coinsDenominations[i]] = 1;
//            addedCoin[coinsDenominations[i]] = coinsDenominations[i];
//        }
//
//        // recursive formulation
//        // f(n) =
//        //  1 if n=a_i
//        //  1 + f(n-a_i), s.t. a_i = min_{a_i}{f(n-a_i)}
//        for (int i = 1; i <= n; i++) {
//            if (numberOfCoins[i] > 0) continue;
//
//            int min = Integer.MAX_VALUE;
//            int coin = -1;
//            for (int j = 0; j < coinsDenominations.length; j++) {
//                int n1 = i - coinsDenominations[j];
//                if (n1 > 0 && numberOfCoins[n1] > 0) {
//                    if (min > numberOfCoins[n1] + 1) {
//                        min = numberOfCoins[n1] + 1;
//                        coin = coinsDenominations[j];
//                    }
//                }
//            }
//            if (min < Integer.MAX_VALUE) {
//                numberOfCoins[i] = min;
//                addedCoin[i] = coin;
//            }
//        }
//        // build the coins in reverse
//        int[] change = new int[numberOfCoins[n]];
//        for (int i = 0; i < change.length; i++) {
//            change[i] = addedCoin[n];
//            n -= addedCoin[n];
//        }
//
//        return change;
//    }
//}
