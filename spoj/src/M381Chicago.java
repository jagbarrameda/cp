import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class M381Chicago {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
//        Scanner s = new Scanner(new File("M381Chicago.txt"));
        while (solveUseCase(s)) ;
    }

    private static boolean solveUseCase(Scanner s) {
        byte n = s.nextByte();
        if (n == 0) return false;

        short m = s.nextShort();
        byte[][] prob = new byte[n][n];
        for (short i = 0; i < m; i++) {
            byte a = s.nextByte();
            byte b = s.nextByte();
            byte p = s.nextByte();
            prob[a - 1][b - 1] = p;
            prob[b - 1][a - 1] = p;
//            System.out.println(String.format("a=%d, b=%d, p=%d", a, b, p));
        }
        for (byte i = 0; i < prob.length; i++) {
            // we cannot get caught if we don't move
            prob[i][i] = 100;
//            System.out.println(Arrays.toString(prob[i]));
        }

        double[] safestPathValue = safestPathValue(prob);
        System.out.println(String.format("%.6f percent", safestPathValue[n - 1]));
//        System.out.println("Values: " + Arrays.toString(safestPathValue));
        return true;
    }

    /**
     * Returns the probability of not being caught
     * for the path from node 0 to length-1 with maximum probability of not being caught
     *
     * @param prob
     * @return
     */
    private static double[] safestPathValue(byte[][] prob) {
        byte startNode = 0;
//        byte endNode = (byte) (prob[0].length - 1);

        // number of intersections
        int nNodes = prob[0].length;

        short d = 1;

        // probPathDistanceD[index] has the best probability of not being caught
        // for any path of distance less or equal to d
        // from startNode to index
        double[] probPathDistanceD = new double[nNodes];
        for (int i = 0; i < nNodes; i++) {
            probPathDistanceD[i] = prob[startNode][i];
        }

//        System.out.println("d: " + d + ", probPathDistanceD: " + Arrays.toString(probPathDistanceD));

        // similar but for path of distance less or equal to d+1
        double[] probPathDistanceDPlus1 = new double[prob.length];

        // compute the best probability for all distances up to the maximum distance of n - 1
        for (d = 1; d < nNodes - 1; d++) {

            // start with paths up to distance d
            System.arraycopy(probPathDistanceD, 0, probPathDistanceDPlus1, 0, nNodes);

            // compute the best probability for each node for path of distance of d+1 or less
            for (int endNode = 0; endNode < nNodes; endNode++) {
                // compare the current best path with the path built from the best path of distance d
                // that finishes in intersection i, and going from prevLastNode to endNode,
                // this gives a path of distance d+1 or less
                for (int prevLastNode = 0; prevLastNode < nNodes; prevLastNode++) {
                    // compute the best probability for path [start,..,prevLastNode,endNode]
                    double currentProb = probPathDistanceDPlus1[endNode];
                    double newProb = probPathDistanceD[prevLastNode] / 100 * prob[prevLastNode][endNode];
                    probPathDistanceDPlus1[endNode] = Math.max(currentProb, newProb);
                }
            }

            // d is now d+1, thus update probPathDistanceD array
            System.arraycopy(probPathDistanceDPlus1, 0, probPathDistanceD, 0, nNodes);
//            System.out.println("d: " + (d + 1) + ", probPathDistanceD: " + Arrays.toString(probPathDistanceD));
        }

        return probPathDistanceD;
    }
}
//violet, penny
