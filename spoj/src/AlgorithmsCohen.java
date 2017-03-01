import java.util.Arrays;

/**
 * Algorithms from the Introduction to Algorithms book by Cohen
 * Created by Jose on 31/10/14.
 */
class AlgorithmsCohen {
    public static void main(String[] args) {
        int[] a = {5, 2, 2, 45, 45, 67, 53, 23, 32, 42, 1, 1};
        InsertionSort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {5, 2, 2, 45, 45, 67, 53, 23, 32, 42, 1, 1};
        mergeSort(b, 0, b.length);
        System.out.println(Arrays.toString(a));
    }

    /**
     * Insertion sort, sorts in place
     *
     * @param a Array to sort
     */
    public static void InsertionSort(int[] a) {
        int temp;
        for (int j = 1; j < a.length; j++) {
            temp = a[j];
            int i;
            for (i = j - 1; i >= 0 && a[i] > temp; i--) {
                a[i + 1] = a[i];
            }
            a[i + 1] = temp;
        }
    }

    private static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        int i, j;
        for (i = 0; i < n1; i++) L[i] = a[p + i - 1];
        for (i = 0; i < n2; i++) R[i] = a[q + i];
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        i = 0;
        j = 0;
        for (int k = p; k < r; k++)
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i = i + 1;
            } else {
                a[k] = R[j];
                j = j + 1;
            }
    }

    public static void mergeSort(int[]a, int p, int r)
    {
        if (p<r)
        {
            int q = (p+r)/2;
            mergeSort(a, p, q);
            mergeSort(a, q+1, r);
            merge(a, p, q, r);
        }
    }

}
