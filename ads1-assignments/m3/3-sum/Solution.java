import java.util.Scanner;
import java.util.Arrays;
/**SUM.**/
final class Solution {
    /**
     * solution.
     */
    private Solution() { }
    /**
     * @param args value
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = s.nextInt();
        }
        Arrays.sort(a);
        boolean c;
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int low = j + 1;
                int high = size - 1;
                c = search(low, high, a, -(a[i] + a[j]));
                if (c) {
                    count++;
                }

            }
        }
        System.out.println(count);
    }
    /**
     * @param l value
     * @param h value
     * @param b value
     * @param s value
     * @return count
     */
    public static boolean search(final int l, final int h,
        final int[] b, final int s) {
                    int middle = 0;
                    int count = 0;
                    int low = l;
                    int high = h;
                    int[] a = b;
                    int search = s;
                    while (low <= high) {
                    middle = (low + high) / 2;
                    if (search == a[middle]) {
                        return true;
                    } else if (a[middle] > search) {
                        high = middle - 1;
                    } else {
                        low = middle + 1;
                    }
                }
                return false;
            }
        }
