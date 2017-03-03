import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by Jose on 2017-03-03.
 */
public class Hmro {
    private static Hashtable<String, String> pesels = new Hashtable<String, String>();
    private static Hashtable<String, String> unitNames = new Hashtable<String, String>();

    public static void main(String[] args) {
        int s = readInt(), p;

        String ss;
        while (s > 0) {
            p = readInt();
            while (p > 0) {
                addPesel(readWord(), readWord());
                p--;
            }
            p = readInt();
            while (p > 0) {
                closeUnit(readWord(), readWord());
                p--;
            }
            consolidateUnits();
            p = readInt();
            while (p > 0) {
                ss = readWord();
                System.out.print(ss + " ");
                System.out.println(getUnit(ss));
                p--;
            }
            // read empty line
            try {
                System.in.read();
                System.out.println();
                pesels.clear();
                unitNames.clear();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            s--;
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

    private static String readWord() {
        try {
            String word = "";
            boolean reading = false;
            for (int c = 0; (c = System.in.read()) != -1; ) {
                if (c != '\r' && c != '\n' && c != '\t' && c != ' ') {
                    reading = true;
                    word += (char) c;
                } else if (reading) break;
            }
            return word;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void addPesel(String pesel, String unit) {
        pesels.put(pesel, unit);
        if (!unitNames.containsKey(unit)) unitNames.put(unit, unit);
    }

    public static void closeUnit(String unit, String newUnit) {
        unitNames.put(unit, newUnit);
    }

    public static String getUnit(String pesel) {
        // units closed must be consolidated, i.e. unitNames.get(unit) is never closed
        String unit = pesels.get(pesel);
        return unitNames.get(unit);
    }

    public static void consolidateUnits() {
        Enumeration<String> e = unitNames.keys();
        String unit, newUnit, finalUnit;
        while (e.hasMoreElements()) {
            newUnit = unit = e.nextElement();
            finalUnit = unitNames.get(newUnit);
            while (!newUnit.equals(finalUnit)) {
                newUnit = finalUnit;
                finalUnit = unitNames.get(newUnit);
            }
            unitNames.put(unit, finalUnit);
        }
    }
}
