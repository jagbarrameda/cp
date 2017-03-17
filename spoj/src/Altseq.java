import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Jose on 2017-03-17.
 */
public class Altseq {
    static int nElem = 0;
    static int[] seq = new int[5000];
    static int[] seqMaxLength = new int[5000]; //  seqMaxLength[idx]: max length of seq[0:idx]
    static int[] seqPrevious = new int[5000];

    public static void main(String[] args) throws Exception {
//        seq = new int[]{1, 2, -2, -3, 5, -7, -8, 10};
//        nElem = seq.length;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nElem = Integer.parseInt(br.readLine());
        int idx = 0;
        String[] a = br.readLine().split(" ");
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() > 0) {
                seq[idx] = Integer.parseInt(a[i]);
                idx++;
            }
        }
        System.out.print(maxAltSeqLength(seq, nElem));
//        System.out.println(Arrays.toString(getMaxSeq(nElem - 1)));
    }

    public static int maxAltSeqLength(int[] seq, int nElem) {
        seqMaxLength[0] = 1;
        seqPrevious[0] = -1;

        for (int i = 1; i < nElem; i++) {
            if (seq[i] < 0) {
                for (int j = i - 1; j >= 0; j--) {
                    if (seqMaxLength[i] < seqMaxLength[j] + 1 && seq[j] > 0 && Math.abs(seq[i]) > Math.abs(seq[j])) {
                        seqMaxLength[i] = seqMaxLength[j] + 1;
                        seqPrevious[i] = j;
                    }
                }
            } else if (seq[i] > 0) { // no need the if but left for clarity
                for (int j = i - 1; j >= 0; j--) {
                    if (seqMaxLength[i] < seqMaxLength[j] + 1 && seq[j] < 0 && Math.abs(seq[i]) > Math.abs(seq[j])) {
                        seqMaxLength[i] = seqMaxLength[j] + 1;
                        seqPrevious[i] = j;
                    }
                }
            }
            if (seqMaxLength[i] == 0) {
                seqMaxLength[i] = 1;
                seqPrevious[i] = -1;
            }
        }
        int max = 0;
        for (int i = nElem - 1; i >= 0; i--) {
            if (max < seqMaxLength[i]) max = seqMaxLength[i];
        }
        return max;
    }

    /**
     * Gets the alt seq. with max length up in seq[0:lastIdx] inclusive
     *
     * @param lastIdx
     * @return
     */
    public static int[] getMaxSeq(int lastIdx) {
        int idx = lastIdx;
        int maxSeqLength = seqMaxLength[idx];
        int[] maxSeq = new int[maxSeqLength];
        for (int i = maxSeqLength - 1; i >= 0; i--) {
            maxSeq[i] = seq[idx];
            idx = seqPrevious[idx];
        }
        return maxSeq;
    }
}
