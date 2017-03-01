import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * Created by jgonz045 on 30/10/14.
 */
class m17 {
    public static void main(String[] args) throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.setTimeZone(new SimpleTimeZone(0, "GMT"));
        sdf.applyPattern("E MMM dd HH:mm:ss yyyy");

//        Date d1970 = new Date(0);
//        System.out.println(sdf.format(d1970));
//
//        Date dt = sdf.parse("Sun Jun 13 16:20:39 2004");
//        System.out.print(sdf.format(dt) + " must be ");
//        long d1 = dt.getTime()/1000 % 4000000007l;
//        System.out.println(d1);
//        d1 *= d1;
//        d1 = d1 % 4000000007l;
//        System.out.println("f(x) = " + d1);

        // ## JE TAIME ##

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        long r = Long.parseLong(line);
        long l = 0;
//        for (long i = (long)Math.sqrt(4000000007l); true; i++)
//        {
//            l = i*i;
//            System.out.println(l);
//            if ((l - r) % 4000000007l == 0) break;
//        }
        long a = 1, b = -4000000007l, c = r;


        //long D = b*b-4*a*c;

        long bpos = Math.abs(b);
        System.out.println(bpos+2*Math.sqrt(a*c));
        System.out.println(Math.sqrt(bpos+2*Math.sqrt(a*c)));
        System.out.println(Math.sqrt(bpos-2*Math.sqrt(a*c)));

        double D = Math.sqrt(bpos+2*Math.sqrt(a*c))*Math.sqrt(bpos-2*Math.sqrt(a*c));

        System.out.println("D = " + D);
        System.out.println("sqrt(D) = "+Math.sqrt(D));

        double x1 = (-b + Math.sqrt(D)) / 2* a;
        double x2 = (-b - Math.sqrt(D)) / 2* a;
        System.out.println(x1);
        System.out.println(x2);

        l = r;
        long k = 0;
        while (!isSquare(l)) {
            l+= 4000000007l;
            k ++;
        }
        System.out.println("x = " + (long)Math.sqrt(l));
        System.out.println("k = " + k);
        Date d = new Date((long)Math.sqrt(l)*1000);
        System.out.println(sdf.format(d));
    }

    private static boolean isSquare(long l) {
        long k = (long) Math.sqrt(l);
        return k*k == l ;
    }

    private static long encrypt(long dateseconds)
    {
        long d1 = dateseconds % 4000000007l;
        d1 *= d1;
        d1 = d1 % 4000000007l;
        return d1;
    }
}
