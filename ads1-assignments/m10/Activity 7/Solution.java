import java.util.Scanner;
/**
 * Class for factorial.
 */
class Factorial {
    /**
     * computes the factorial recursively.
     *
     * @param      n     { of type long}
     *
     * @return     { factorial of n }
     * 
     * Time Complexity - O(N).
     */
    public long getfactorial(long n) {
        if (n == 0) {
            return 1;
        }
        return n * getfactorial(n -1);
    }
}
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
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        long n = Long.parseLong(s.nextLine());
        Factorial factorial = new Factorial();
        System.out.println(factorial.getfactorial(n));
    }
}