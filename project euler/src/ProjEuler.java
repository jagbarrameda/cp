import com.sun.org.apache.bcel.internal.generic.BIPUSH;

import java.math.BigInteger;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Barrameda on 19/10/2014.
 */
class ProjEuler {
    public static void main(String[]args)
    {
        System.out.println(m3());
    }
    public static long m2 ()
    {
        long result = 0;
        int f1 = 1, f2 = 2, ft = 0;
        while(f2 <= 4000000) {
            if (f2 % 2 == 0) result += f2;
            ft = f1;
            f1 = f2;
            f2 += ft;
        }
        return result;
    }

    /**
     * Largest prime factor
     * @return
     */
    public static long m3 ()
    {
        long n = 600851475143l;
        PriorityQueue<Long> factors = new PriorityQueue<Long>(1, Collections.reverseOrder());
        factors.add(n);
        boolean isPrime = false;
        while (!factors.isEmpty())
        {
            long current = factors.poll();
            isPrime = true;
            for (long i = 2; i <= Math.sqrt(current); i++) {
                if (current % i == 0)
                {
                    factors.add(current / i);
                    factors.add(i);
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) return current;
        }
        return factors.peek();
    }
}
