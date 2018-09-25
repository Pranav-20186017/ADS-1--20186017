import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int size = Integer.parseInt(s.nextLine());
        Percolation p = new Percolation(size);
        while (s.hasNext()) {
            p.open(s.nextInt(), s.nextInt());
        }
        System.out.println(p.percolates());
    }
}