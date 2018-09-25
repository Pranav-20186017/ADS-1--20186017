import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    Solution() {
        //unused.
    }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = Integer.parseInt(s.nextLine());
        Percolation p = new Percolation(size);
        while(s.hasNext()) {
            p.open(s.nextInt(),s.nextInt());
        }
        System.out.println(p.percolates());
    }
}