import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * main function.
     * Time Complexity: O(N).
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        while (scan.hasNext()) {
            int cutoff = Integer.parseInt(scan.nextLine());
            String line = scan.nextLine();

            if (line.equals("")) {
                System.out.println("[]");
            } else {
                Comparable[] array = line.split(" ");
                sort(array, 0, array.length - 1, cutoff);
                System.out.println(Arrays.toString(array));
            }

        }
    }
    /**
     * Insertion Sort.
     * Time Complexity :
     * Best : O(N)
     * Average : O(N^2)
     * Worst : O(N^2)
     *
     * @param      array  The array
     * @param      low    The low
     * @param      high   The high
     */
    public static void insertionSort(final Comparable[] array,
                                     final int low, final int high) {
        System.out.println("insertionSort called");
        int n = high + 1;
        for (int i = low + 1; i < n; ++i) {
            Comparable key = array[i];
            int j = i - 1;
            while (j >= low && (array[j].compareTo(key)) > 0) {
                Comparable temp = array[j + 1];
                array[j + 1] = array[j];
                array[j] = temp;
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
    /**
     * sort function.
     *
     * @param      array   The array
     * @param      low     The low
     * @param      high    The high
     * @param      cutoff  The cutoff
     */
    public static void sort(final Comparable[] array, final int low,
                            final int high, final int cutoff) {
        if (high - low < cutoff) {
            insertionSort(array, low, high);
            return;
        }
        int partition = quickSort(array, low, high, cutoff);
        sort(array, low, partition - 1, cutoff);
        sort(array, partition + 1, high, cutoff);
    }
    /**
     * partition function.
     * Time COmplexity : O(N^2).
     *
     * @param      array   The array
     * @param      low     The low
     * @param      high    The high
     * @param      cutoff  The cutoff
     *
     * @return     { description_of_the_return_value }
     */
    public static int quickSort(final Comparable[] array,
                                final int low, final int high,
                                final int cutoff) {
        Comparable pivot = array[low];
        int p1 = low;
        int p2 = high;
        while (true) {
            while (p2 >= low && array[p2].compareTo(pivot) > 0) {
                p2--;
            }
            while (p1 <= high && array[p1].compareTo(pivot) <= 0) {
                p1++;
            }
            if (p2 < p1) {
                p1--;
                break;
            }
            Comparable temp = array[p1];
            array[p1] = array[p2];
            array[p2] = temp;
            p1++;
            p2--;
        }
        array[low] = array[p1];
        array[p1] = pivot;
        System.out.println(Arrays.toString(array));
        return p1;
    }
}
