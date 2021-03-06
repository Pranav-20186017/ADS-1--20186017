import java.util.Scanner;
/**
 * Class for taxicab.
 */
class Taxicab implements Comparable<Taxicab> {
    /**
     * { variables i & j }.
     */
    private int i, j;
    /**
     * { variable for sum }.
     */
    private long sum;
    /**
     * { gets i }.
     *
     * @return     { description_of_the_return_value }
     */
    int geti() {
        return i;
    }
    /**
     * { gets j }.
     *
     * @return     { description_of_the_return_value }
     */
    int getj() {
        return j;
    }
    /**
     * { Gets the sum }.
     *
     * @return     The sum.
     */
    long getSum() {
        return sum;
    }
    /**
     * Constructs the object.
     *
     * @param      i1     { parameter_description }
     * @param      j1     { parameter_description }
     */
    Taxicab(final int i1, final int j1) {
        this.sum = (long) i1 * i1 * i1 + (long) j1 * j1 * j1;
        this.i = i1;
        this.j = j1;
    }
    /**
     * { compares the sum value and returns the greatest }.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Taxicab that) {
        if (this.sum < that.sum) {
            return -1;
        } else if (this.sum > that.sum) {
            return 1;
        }
        return 0;
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = 1000;
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            MinPQ<Taxicab> pq = new MinPQ<Taxicab>();
            for (int i = 1; i <= n; i++) {
                pq.insert(new Taxicab(i, i));
            }
            int pair = 1;
            Taxicab previous = new Taxicab(0, 0);
            int pairCount = 0;
            while (!pq.isEmpty()) {
                Taxicab current = pq.delMin();
                if (previous.getSum() == current.getSum()) {
                    pair++;
                    if (pair == b) {
                        pairCount = pairCount + 1;
                    }
                    if (pairCount == a) {
                        System.out.println(previous.getSum());
                        break;
                    }
                } else {
                    pair = 1;
                }
                previous = current;
                if (current.getj() < n) {
                    pq.insert(new Taxicab(current.geti(), current.getj() + 1));
                }
            }
        }
    }
}
